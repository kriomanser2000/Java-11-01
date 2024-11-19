package com.example.cardbmysql;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/filterCars")
public class CarFilterServlet extends HttpServlet
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String manufacturer = request.getParameter("manufacturer");
        String color = request.getParameter("color");
        String carType = request.getParameter("carType");
        double minEngineCapacity = Double.parseDouble(request.getParameter("minEngineCapacity"));
        double maxEngineCapacity = Double.parseDouble(request.getParameter("maxEngineCapacity"));
        List<Car> cars = null;
        try
        {
            if (manufacturer != null)
            {
                cars = carDAO.getCarsByManufacturer(manufacturer);
            }
            else if (color != null)
            {
                cars = carDAO.getCarsByColor(color);
            }
            else if (carType != null)
            {
                cars = carDAO.getCarsByType(carType);
            }
            else
            {
                cars = carDAO.getCarsByEngineCapacity(minEngineCapacity, maxEngineCapacity);
            }
            for (Car car : cars)
            {
                out.println("<p>" + car.getManufacturer() + " " + car.getModel() + "</p>");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
