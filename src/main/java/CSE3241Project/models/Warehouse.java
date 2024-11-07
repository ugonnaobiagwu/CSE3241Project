package main.java.CSE3241Project.models;

public class Warehouse {
    public String Warehouse_ID, City, Warehouse_Address, Warehouse_Phone, Manager_Name, Packaging;
    public int Storage_Capacity, Drone_Capacity, Drone_Quantity;

    public Warehouse(String city, String address, String phone, String managerName,
    String warehouseID, String packaging, int storageCapacity, int droneCapacity, int droneQuantity) {
    	this.City = city;
    	this.Warehouse_Address = address;
        this.Warehouse_Phone = phone;
        this.Manager_Name = managerName;
        this.Warehouse_ID = warehouseID;
        this.Packaging = packaging;
        this.Storage_Capacity = storageCapacity;
        this.Drone_Capacity = droneCapacity;
        this.Drone_Quantity = droneQuantity;
        		

    }
}
