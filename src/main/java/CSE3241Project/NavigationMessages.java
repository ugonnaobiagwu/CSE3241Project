package main.java.CSE3241Project;

public class NavigationMessages {
    public static void welcomeNavigation() {
        System.out.println("Welcome to the System. Please select an option below:");
        System.out.println();
        System.out.println();
        System.out.println("[1] Add Record");
        System.out.println("[2] Delete Record");
        System.out.println("[3] Search Records");
        System.out.println();
        System.out.println("[4] Rent Equipment");
        System.out.println("[5] Pickup Equipment");
        System.out.println("[6] Return Equipment");
        System.out.println("[7] Equipment Deliveries");
        System.out.println();
        System.out.println("[0] Quit.");
    }

    public static void selectRecordType() {
        System.out.println("Please select a Record to Navigate");
        System.out.println("[1] Warehouse");
        System.out.println("[2] Members");
        System.out.println("[3] Equipment");
    }
}