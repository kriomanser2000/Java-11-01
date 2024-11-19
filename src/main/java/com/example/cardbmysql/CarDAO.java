package com.example.cardbmysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO
{
    public void addCar(Car car) throws SQLException
    {
        String query = "INSERT INTO Cars (manufacturer, model, year, color, engine_capacity, car_type) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, car.getManufacturer());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setDouble(5, car.getEngineCapacity());
            preparedStatement.setString(6, car.getCarType());
            preparedStatement.executeUpdate();
        }
    }
    public void deleteCar(int id) throws SQLException
    {
        String query = "DELETE FROM Cars WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
    public void updateCar(Car car) throws SQLException
    {
        String query = "UPDATE Cars SET manufacturer = ?, model = ?, year = ?, color = ?, engine_capacity = ?, car_type = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, car.getManufacturer());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setDouble(5, car.getEngineCapacity());
            preparedStatement.setString(6, car.getCarType());
            preparedStatement.setInt(7, car.getId());
            preparedStatement.executeUpdate();
        }
    }
    public List<Car> getCarsByManufacturer(String manufacturer) throws SQLException
    {
        String query = "SELECT * FROM Cars WHERE manufacturer = ?";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, manufacturer);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    cars.add(mapResultSetToCar(resultSet));
                }
            }
        }
        return cars;
    }
    public List<Car> getCarsByColor(String color) throws SQLException
    {
        String query = "SELECT * FROM Cars WHERE color = ?";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, color);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    cars.add(mapResultSetToCar(resultSet));
                }
            }
        }
        return cars;
    }
    public List<Car> getCarsByType(String type) throws SQLException
    {
        String query = "SELECT * FROM Cars WHERE car_type = ?";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, type);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    cars.add(mapResultSetToCar(resultSet));
                }
            }
        }
        return cars;
    }
    public List<Car> getCarsByEngineCapacity(double minCapacity, double maxCapacity) throws SQLException
    {
        String query = "SELECT * FROM Cars WHERE engine_capacity BETWEEN ? AND ?";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setDouble(1, minCapacity);
            preparedStatement.setDouble(2, maxCapacity);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    cars.add(mapResultSetToCar(resultSet));
                }
            }
        }
        return cars;
    }
    public String getManufacturerWithMostCars() throws SQLException
    {
        String query = "SELECT manufacturer, COUNT(*) AS car_count FROM Cars GROUP BY manufacturer ORDER BY car_count DESC LIMIT 1";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            if (resultSet.next())
            {
                return resultSet.getString("manufacturer");
            }
        }
        return null;
    }
    public String getManufacturerWithLeastCars() throws SQLException
    {
        String query = "SELECT manufacturer, COUNT(*) AS car_count FROM Cars GROUP BY manufacturer ORDER BY car_count ASC LIMIT 1";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            if (resultSet.next())
            {
                return resultSet.getString("manufacturer");
            }
        }
        return null;
    }
    public List<Car> getCarsByYear(int year) throws SQLException
    {
        String query = "SELECT * FROM Cars WHERE year = ?";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setInt(1, year);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    cars.add(mapResultSetToCar(resultSet));
                }
            }
        }
        return cars;
    }
    public List<Car> getCarsByYearRange(int startYear, int endYear) throws SQLException
    {
        String query = "SELECT * FROM Cars WHERE year BETWEEN ? AND ?";
        List<Car> cars = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setInt(1, startYear);
            preparedStatement.setInt(2, endYear);
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    cars.add(mapResultSetToCar(resultSet));
                }
            }
        }
        return cars;
    }
    private Car mapResultSetToCar(ResultSet resultSet) throws SQLException
    {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setManufacturer(resultSet.getString("manufacturer"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));
        car.setColor(resultSet.getString("color"));
        car.setEngineCapacity(resultSet.getDouble("engine_capacity"));
        car.setCarType(resultSet.getString("car_type"));
        return car;
    }
}
