package com.example.cardbmysql;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        CarDAO carDAO = new CarDAO();
        try
        {
            System.out.println("Виробник з найбільшою кількістю автомобілів:");
            System.out.println(carDAO.getManufacturerWithMostCars());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        try
        {
            System.out.println("Виробник з найменшою кількістю автомобілів:");
            System.out.println(carDAO.getManufacturerWithLeastCars());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        try
        {
            int year = 2019;
            System.out.println("Автомобілі " + year + " року:");
            carDAO.getCarsByYear(year).forEach(System.out::println);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        try
        {
            int startYear = 2015, endYear = 2020;
            System.out.println("Автомобілі з " + startYear + " по " + endYear + " роки:");
            carDAO.getCarsByYearRange(startYear, endYear).forEach(System.out::println);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
