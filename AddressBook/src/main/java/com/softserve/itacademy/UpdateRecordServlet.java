package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addressbook/update")
public class UpdateRecordServlet extends HttpServlet {
    private AddressBook addressBook;
    private String[] fullName;

    @Override
    public void init() throws ServletException {
        addressBook = addressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         fullName = request.getParameter("id").split(" ");
        String address = addressBook.read(fullName[0], fullName[1]);
        String[] record = {fullName[0], fullName[1], address};
        request.setAttribute("record", record);

        request.getRequestDispatcher("/WEB-INF/update-record.jsp").forward(request, response);

}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");

     if (addressBook.update(fullName[0],fullName[1],address)) {
         response.sendRedirect("/addressbook/allrecords");
     }

    }


}
