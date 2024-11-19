package com.example.cardbmysql;

public class Car
{
    private int id;
    private String manufacturer;
    private String model;
    private int year;
    private String color;
    private double engineCapacity;
    private String carType;
    public Car() {}
    public Car(int id, String manufacturer, String model, double engineCapacity, int yearOfManufacture, String color, String carType)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.year = yearOfManufacture;
        this.color = color;
        this.carType = carType;
    }
    public int getId() { return id; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public double getEngineCapacity() { return engineCapacity; }
    public String getCarType() { return carType; }
    public void setId(int id) { this.id = id; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setColor(String color) { this.color = color; }
    public void setEngineCapacity(double engineCapacity) { this.engineCapacity = engineCapacity; }
    public void setCarType(String carType) { this.carType = carType; }
    @Override
    public String toString()
    {
        return manufacturer + " " + model + " (" + year + "), " + color + ", " + engineCapacity + "L, " + carType;
    }
}
