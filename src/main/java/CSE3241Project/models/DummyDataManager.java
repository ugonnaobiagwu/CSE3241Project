package main.java.CSE3241Project.models;

import java.util.ArrayList;
import java.util.Scanner;

// Do all of these need to be init at the instantiation?
public class DummyDataManager { 
    public ArrayList<RentableEquipment> allRentableEquipment;
    public ArrayList<Warehouse> allWarehouses;
    public ArrayList<Member> allMembers;

    public DummyDataManager() {
        this.allRentableEquipment = new ArrayList<RentableEquipment>();
        this.allMembers = new ArrayList<Member>();
        this.allWarehouses = new ArrayList<Warehouse>();
    }

    public void addToRentableEquipment(Scanner in) {
        System.out.println("Please enter serial number");
        String itemSerialNumber = in.nextLine();

        System.out.println("Please enter name");
        String name = in.nextLine();

        System.out.println("Please enter model");
        String model = in.nextLine();

        System.out.println("Please enter status");
        String status = in.nextLine();

        System.out.println("Please enter manufacturerID");
        String manufacturerID = in.nextLine();

        System.out.println("Please enter location");
        String location = in.nextLine();

        System.out.println("Please enter weight");
        Double weight = in.nextDouble();

        System.out.println("Please enter warehouseID");
        String warehouseID = in.nextLine();

        System.out.println("Please enter length");
        Double length = in.nextDouble();

        System.out.println("Please enter width");
        Double width = in.nextDouble();

        System.out.println("Please enter height");
        Double height = in.nextDouble();

        System.out.println("Please enter itemSize");
        Double itemSize = in.nextDouble();

        System.out.println("Please enter cost");
        Double cost = in.nextDouble();

        System.out.println("Please enter profit per item");
        Double profitPerItem = in.nextDouble();

        this.allRentableEquipment.add(new RentableEquipment(itemSerialNumber, name, model, status, manufacturerID, location, weight, 
        warehouseID, length, width, height, itemSize, 
        cost, profitPerItem));
        
    }

    public void addToWarehouses(Scanner in) {
        System.out.println("Please enter city");
        String city = in.nextLine();

        System.out.println("Please enter address");
        String address = in.nextLine();

        System.out.println("Please enter phone");
        String phone = in.nextLine();

        System.out.println("Please enter manager name");
        String managerName = in.nextLine();

        System.out.println("Please enter manager warehouseID");
        String warehouseID = in.nextLine();

        System.out.println("Please enter manager storageCapacity");
        long storageCapacity = in.nextLong();

        System.out.println("Please enter manager droneCapacity");
        long droneCapacity = in.nextLong();

        System.out.println("Please enter manager droneQuantity");
        long droneQuantity = in.nextLong();

        this.allWarehouses.add(new Warehouse(city, address, phone, managerName, warehouseID, 
        storageCapacity, droneCapacity, droneQuantity));
    }

    public void addToMembers(Scanner in) {
        System.out.println("Please enter name");
        String name = in.nextLine();

        System.out.println("Please enter address");
        String address = in.nextLine();

        System.out.println("Please enter memberID");
        String memberID = in.nextLine();

        System.out.println("Please enter accountHistory");
        String accountHistory = in.nextLine();

        System.out.println("Please enter phone");
        String phone = in.nextLine();

        System.out.println("Please enter startDate");
        String startDate = in.nextLine();

        System.out.println("Please enter email");
        String email = in.nextLine();

        System.out.println("Please enter distance from warehouse");
        long distanceFromWarehouse = in.nextLong();

        this.allMembers.add(new Member(name, address, memberID, accountHistory, phone, email, startDate, distanceFromWarehouse));
    }

    public void deleteFromWarehouses(String id) {
        Warehouse deletingObj = null;

        for (Warehouse x : this.allWarehouses) {
            if (x.warehouseID.equals(id)) {
                deletingObj = x;
            }
        }

        if (this.allWarehouses.contains(deletingObj)) {
            this.allWarehouses.remove(deletingObj);
        }

        System.out.println("Deleted Warehouse with ID: " + id);

    }

    public void deleteFromMembers(String id) {
        Member deletingObj = null;

        for (Member x : this.allMembers) {
            if (x.memberID.equals(id)) {
                deletingObj = x;
            }
        }

        if (this.allMembers.contains(deletingObj)) {
            this.allMembers.remove(deletingObj);
        }

        System.out.println("Deleted Member with ID: " + id);

    }

    public void deleteFromRentableEquipment(String itemSerialNumber) {
        RentableEquipment deletingObj = null;

        for (RentableEquipment x : this.allRentableEquipment) {
            if (x.itemSerialNumber.equals(itemSerialNumber)) {
                deletingObj = x;
            }
        }

        if (this.allRentableEquipment.contains(deletingObj)) {
            this.allRentableEquipment.remove(deletingObj);
        }

        System.out.println("Deleted Item with Serial No.: " + itemSerialNumber);

    }
}