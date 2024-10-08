package main.java.CSE3241Project.models;

public class Warehouse {
    public String city, address, phone, managerName, warehouseID;
    public long storageCapacity, droneCapacity, droneQuantity;

    public Warehouse(String city, String address, String phone, String managerName,
    String warehouseID, long storageCapacity, long droneCapacity, long droneQuantity) {
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.managerName = managerName;
        this.warehouseID = warehouseID;
        this.storageCapacity = storageCapacity;
        this.droneCapacity = droneCapacity;
        this.droneQuantity = droneQuantity;
    }
}
