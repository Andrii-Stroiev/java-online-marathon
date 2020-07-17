package com.softserve.itacademy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addressbook/allrecords")
public class AllRecordsServlet extends HttpServlet {
    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = addressBook.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/all-records.jsp");
      if (request.getParameter("sort")!=null){
        addressBook.sortedBy(SortOrder.valueOf(request.getParameter("sort").toUpperCase()));}
      request.setAttribute("addressbook", addressBook);
      requestDispatcher.forward(request, response);
    }
}
