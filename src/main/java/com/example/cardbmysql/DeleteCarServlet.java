package com.example.cardbmysql;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteCarServlet extends HttpServlet
{
    private CarDAO carDAO;
    @Override
    public void init()
    {
        carDAO = new CarDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        try
        {
            carDAO.deleteCar(id);
            response.sendRedirect("cars.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
