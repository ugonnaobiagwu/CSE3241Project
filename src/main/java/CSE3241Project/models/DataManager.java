package main.java.CSE3241Project.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;

public class DataManager {

private static String DATABASE = "ProjectDatabase.db";
	
	public static Connection dbConnection = null;
	
	private static PreparedStatement ps;
	

    public static void dbInit() {
        String connectionString = "jdbc:sqlite:" + DATABASE;
        dbConnection = null; 
        try {
        	dbConnection = DriverManager.getConnection(connectionString);
            if (dbConnection != null) {
                DatabaseMetaData metadata = dbConnection.getMetaData();
                System.out.println("The driver name is " + metadata.getDriverName());
                System.out.println("The connection to the database was successful.");
            } else {
            	System.out.println("Database connection failed, but did not throw an error.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong in database connection.");
        }
        
        try {
        	ps = dbConnection.prepareStatement("INSERT INTO Manufacturer (Manufacturer_ID, Manufacturer_Name)"
        			+ "VALUES (ThisisanID, ThisAName)");
        	ps.execute();
        } catch (SQLException e) {
        	 System.out.println(e.getMessage());
        }
    }
    
    public static void dbQuery(Connection dbConnection, PreparedStatement stmnt) {
    	try {
        	ResultSet rs = stmnt.executeQuery();
        	ResultSetMetaData rsmd = rs.getMetaData();
        	int columnCount = rsmd.getColumnCount();
        	for (int i = 1; i <= columnCount; i++) {
        		String value = rsmd.getColumnName(i);
        		System.out.print(value);
        		if (i < columnCount) System.out.print(",  ");
        	}
			System.out.print("\n");
        	while (rs.next()) {
        		for (int i = 1; i <= columnCount; i++) {
        			String columnValue = rs.getString(i);
            		System.out.print(columnValue);
            		if (i < columnCount) System.out.print(",  ");
        		}
    			System.out.print("\n");
        	}
        	rs.close();
        	stmnt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    

    public DataManager() {
//        this.allRentableEquipment = new ArrayList<RentableEquipment>();
//        this.allMembers = new ArrayList<Member>();
//        this.allWarehouses = new ArrayList<Warehouse>();
    }

    public static void addRentableEquipment(Scanner in) {
        System.out.println("Please enter serial number");
        String itemSerialNumber = in.nextLine();

        System.out.println("Please enter location");
        String location = in.nextLine();
        
        System.out.println("Please enter model");
        String model = in.nextLine();

        System.out.println("Please enter status");
        String status = in.nextLine();


        System.out.println("Please enter warehouseID");
        String warehouseID = in.nextLine();

        System.out.println("Please enter review history");
        String reviewHistory = in.nextLine();
        
        System.out.println("Please enter order history");
        String orderHistory = in.nextLine();

        System.out.println("Please enter warranty expiration date in YYYY-MM-DD format");
        String warrantyExpirationDate = in.nextLine();
        
        System.out.println("Please enter year");
        int year = Integer.parseInt(in.nextLine());
        
        System.out.println("Please enter stock");
        int stock = Integer.parseInt(in.nextLine());
        
        RentableEquipment equipment = new RentableEquipment(itemSerialNumber, model, status, location, warehouseID, reviewHistory, 
        		orderHistory, warrantyExpirationDate, year, stock);
        
        String sql = "INSERT INTO Rentable_Equipment_Item (Item_Serial_No, Status, Location, "
        		+ "Review_History, Order_History, Warranty_Expiration_Date, Year, Stock, Warehouse_ID, Model)"
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
        	 ps = dbConnection.prepareStatement(sql);
        	 ps.setString(1, equipment.Item_Serial_No);
        	 ps.setString(2, equipment.Status);
        	 ps.setString(3, equipment.Location);
        	 ps.setString(4, equipment.Review_History);
        	 ps.setString(5, equipment.Order_History);
        	 ps.setString(6, equipment.Warranty_Expiration_Date);
        	 ps.setString(7, "" + equipment.Year);
        	 ps.setString(8, "" + equipment.Stock);
        	 ps.setString(9, equipment.Warehouse_ID);
        	 ps.setString(10, equipment.Model);
        	 ps.execute();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        
        
        

//        this.allRentableEquipment.add(new RentableEquipment(itemSerialNumber, name, model, status, manufacturerID, location, weight, 
//        warehouseID, length, width, height, itemSize, 
//        cost, profitPerItem));
        
    }

//    public void addToWarehouses(Scanner in) {
//        System.out.println("Please enter city");
//        String city = in.nextLine();
//
//        System.out.println("Please enter address");
//        String address = in.nextLine();
//
//        System.out.println("Please enter phone");
//        String phone = in.nextLine();
//
//        System.out.println("Please enter manager name");
//        String managerName = in.nextLine();
//
//        System.out.println("Please enter manager warehouseID");
//        String warehouseID = in.nextLine();
//
//        System.out.println("Please enter manager storageCapacity");
//        int storageCapacity = Integer.parseInt(in.nextLine());
//
//        System.out.println("Please enter manager droneCapacity");
//        int droneCapacity = Integer.parseInt(in.nextLine());
//
//        System.out.println("Please enter manager droneQuantity");
//        int droneQuantity = Integer.parseInt(in.nextLine());
//
//      
//    }
//
//    public void addToMembers(Scanner in) {
//        System.out.println("Please enter name");
//        String name = in.nextLine();
//
//        System.out.println("Please enter address");
//        String address = in.nextLine();
//
//        System.out.println("Please enter memberID");
//        String memberID = in.nextLine();
//
//        System.out.println("Please enter accountHistory");
//        String accountHistory = in.nextLine();
//
//        System.out.println("Please enter phone");
//        String phone = in.nextLine();
//
//        System.out.println("Please enter startDate");
//        String startDate = in.nextLine();
//
//        System.out.println("Please enter email");
//        String email = in.nextLine();
//
//        System.out.println("Please enter distance from warehouse");
//        long distanceFromWarehouse = in.nextLong();
//
//        this.allMembers.add(new Member(name, address, memberID, accountHistory, phone, email, startDate, distanceFromWarehouse));
//    }
//
//    public void deleteFromWarehouses(String id) {
//        Warehouse deletingObj = null;
//
//        for (Warehouse x : this.allWarehouses) {
//            if (x.warehouseID.equals(id)) {
//                deletingObj = x;
//            }
//        }
//
//        if (this.allWarehouses.contains(deletingObj)) {
//            this.allWarehouses.remove(deletingObj);
//        }
//
//        System.out.println("Deleted Warehouse with ID: " + id);
//
//    }
//
//    public void deleteFromMembers(String id) {
//        Member deletingObj = null;
//
//        for (Member x : this.allMembers) {
//            if (x.memberID.equals(id)) {
//                deletingObj = x;
//            }
//        }
//
//        if (this.allMembers.contains(deletingObj)) {
//            this.allMembers.remove(deletingObj);
//        }
//
//        System.out.println("Deleted Member with ID: " + id);
//
//    }
//
//    public void deleteFromRentableEquipment(String itemSerialNumber) {
//        RentableEquipment deletingObj = null;
//
//        for (RentableEquipment x : this.allRentableEquipment) {
//            if (x.itemSerialNumber.equals(itemSerialNumber)) {
//                deletingObj = x;
//            }
//        }
//
//        if (this.allRentableEquipment.contains(deletingObj)) {
//            this.allRentableEquipment.remove(deletingObj);
//        }
//
//        System.out.println("Deleted Item with Serial No.: " + itemSerialNumber);
//
//    }
//
//    public void searchForSpecificWarehouse(String warehouseID) {
//        Warehouse specificWarehouse = null;
//
//        for (Warehouse x : this.allWarehouses) {
//            if (x.warehouseID.equals(warehouseID)) {
//                specificWarehouse = x;
//            }
//        }
//
//        if (this.allWarehouses.contains(specificWarehouse)) {
//            System.out.println("For Warehouse" + warehouseID + ": ");
//            System.out.println();
//            System.out.println("City: " + specificWarehouse.city);
//            System.out.println("Address: " + specificWarehouse.address);
//            System.out.println("Phone: " + specificWarehouse.phone);
//            System.out.println("Manager Name: " + specificWarehouse.managerName);
//            System.out.println("Warehouse: " + specificWarehouse.warehouseID);
//            System.out.println("Storage Capacity: " + specificWarehouse.storageCapacity);
//            System.out.println("Drone Capacity: " + specificWarehouse.droneCapacity);
//            System.out.println("Drone Quantity: " + specificWarehouse.droneQuantity);
//        } else {
//            System.out.println("Could not find warehouse with ID: " + warehouseID);
//        }
//    }
//
//    public void searchForSpecificMember(String memberID) {
//        Member specificMember = null;
//
//        for (Member x : this.allMembers) {
//            if (x.memberID.equals(memberID)) {
//                specificMember = x;
//            }
//        }
//
//        if (this.allMembers.contains(specificMember)) {
//            System.out.println("For Member" + memberID + ": ");
//            System.out.println();
//            System.out.println("Name: " + specificMember.name);
//            System.out.println("Address: " + specificMember.address);
//            System.out.println("Member ID: " + specificMember.memberID);
//            System.out.println("Account History: " + specificMember.accountHistory);
//            System.out.println("Phone: " + specificMember.phone);
//            System.out.println("Start Date: " + specificMember.startDate);
//            System.out.println("Email: " + specificMember.email);
//            System.out.println("Distance From Warehouse: " + specificMember.distanceFromWarehouse);
//        } else {
//            System.out.println("Could not find member with ID: " + memberID);
//        }
//    }
//
//    public void searchForSpecificRentableEquipment(String itemSerialNumber) {
//        RentableEquipment specificRentableEquipment = null;
//
//        for (RentableEquipment x : this.allRentableEquipment) {
//            if (x.itemSerialNumber.equals(itemSerialNumber)) {
//                specificRentableEquipment = x;
//            }
//        }
//
//        if (this.allRentableEquipment.contains(specificRentableEquipment)) {
//            System.out.println("For Rentable Equipment" + itemSerialNumber + ": ");
//            System.out.println();
//            System.out.println("Serial Number: " + specificRentableEquipment.itemSerialNumber);
//            System.out.println("Name: " + specificRentableEquipment.name);
//            System.out.println("Model: " + specificRentableEquipment.model);
//            System.out.println("Status: " + specificRentableEquipment.status);
//            System.out.println("Manufacturer ID: " + specificRentableEquipment.manufacturerID);
//            System.out.println("Location: " + specificRentableEquipment.location);
//            System.out.println("Weight: " + specificRentableEquipment.weight);
//            System.out.println("Warehouse ID: " + specificRentableEquipment.warehouseID);
//            System.out.println("Length: " + specificRentableEquipment.length);
//            System.out.println("Width: " + specificRentableEquipment.width);
//            System.out.println("Height: " + specificRentableEquipment.height);
//            System.out.println("Item Size: " + specificRentableEquipment.itemSize);
//            System.out.println("Cost: " + specificRentableEquipment.cost);
//            System.out.println("Profit Per Item: " + specificRentableEquipment.profitPerItem);
//        } else {
//            System.out.println("Could not find equipment with SERIAL NUMBER: " + itemSerialNumber);
//        }
//    }
}

