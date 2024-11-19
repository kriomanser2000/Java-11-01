package com.example.cardbmysql;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UpdateCarServlet extends HttpServlet
{
    private CarDAO carDAO;
    @Override
    public void init()
    {
        carDAO = new CarDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String manufacturer = request.getParameter("manufacturer");
        String model = request.getParameter("model");
        double engineCapacity = Double.parseDouble(request.getParameter("engineCapacity"));
        int yearOfManufacture = Integer.parseInt(request.getParameter("yearOfManufacture"));
        String color = request.getParameter("color");
        String carType = request.getParameter("carType");
        Car car = new Car(id, manufacturer, model, engineCapacity, yearOfManufacture, color, carType);
        try
        {
            carDAO.updateCar(car);
            response.sendRedirect("cars.jsp");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
