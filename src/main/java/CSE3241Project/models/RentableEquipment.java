package main.java.CSE3241Project.models;

public class RentableEquipment {
    public String itemSerialNumber, name, model, status, manufacturerID, 
    location, reviewHistory, orderHistory, warehouseID;

    public double length, width, height, itemSize, cost, weight, profitPerItem;

    public RentableEquipment(String itemSerialNumber, String name, String model, String status, String manufacturerID, 
    String location, Double weight, String warehouseID, Double length, Double width, Double height, Double itemSize, Double cost, Double profitPerItem) {
        this.itemSerialNumber = itemSerialNumber; 
        this.name = name;
        this.model = model;
        this.status = status;
        this.manufacturerID = manufacturerID;
        this.location = location;
        this.weight = weight;
        this.warehouseID = warehouseID;
        this.length = length;
        this.width = width;
        this.height = height;
        this.itemSize = itemSize;
        this.cost = cost;
        this.profitPerItem = profitPerItem;
    }
    
}
