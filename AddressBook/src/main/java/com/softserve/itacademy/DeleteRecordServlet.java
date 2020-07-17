package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addressbook/delete")
public class DeleteRecordServlet extends HttpServlet {
    private AddressBook addressBook;
    private String[] fullName;

    @Override
    public void init() throws ServletException {
        addressBook = addressBook.getInstance();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        fullName = request.getParameter("id").split(" ");
       addressBook.delete(fullName[0], fullName[1]);
       response.sendRedirect("/addressbook/allrecords");
    }

}
