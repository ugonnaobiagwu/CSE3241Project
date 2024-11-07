package main.java.CSE3241Project.models;

public class RentableEquipment {
    public String Item_Serial_No, Status, Location, Review_History, Order_History, Warranty_Expiration_Date, Warehouse_ID, Model;

    public int Year, Stock;

    public RentableEquipment(String itemSerialNumber, String model, String status,
    String location, String warehouseID, String reviewHistory, String orderHistory, String warrantyExpirationDate, int year, int stock) {
        this.Item_Serial_No = itemSerialNumber;
        this.Model = model;
        this.Location = location;
        this.Status = status;
        this.Warehouse_ID = warehouseID;
        this.Review_History = reviewHistory;
        this.Order_History = orderHistory;
        this.Warranty_Expiration_Date = warrantyExpirationDate;
        this.Year = year;
        this.Stock = stock;
    }
    
}
