/*
 * This source file was generated by the Gradle 'init' task
 */
package main.java.CSE3241Project;

import java.util.Scanner;

import main.java.CSE3241Project.models.DummyDataManager;

public class App {
    public static String getGreeting() {
        return "Hello World!";
    }
    

    public static void addRecords(Scanner in, DummyDataManager data) {
        NavigationMessages.selectRecordType();
        int userSelectionChoice = -1;
        userSelectionChoice = Integer.parseInt(in.nextLine());
        switch (userSelectionChoice) {
            case 1:
                data.addToWarehouses(in);
                break;
            case 2:
                data.addToMembers(in);
                break;
            case 3:
                data.addToRentableEquipment(in);
                break;
        }
    }

    public static void deleteRecords(Scanner in, DummyDataManager data) {
        NavigationMessages.selectRecordType();
        int userSelectionChoice = -1;
        userSelectionChoice = Integer.parseInt(in.nextLine());
        switch (userSelectionChoice) {
            case 1:
                String warehouseID = in.nextLine();
                System.out.println("Enter ID/SerialNo of Data to Delete");
                data.deleteFromWarehouses(warehouseID);
                break;
            case 2:
                String memberID = in.nextLine();
                System.out.println("Enter ID/SerialNo of Data to Delete");
                data.deleteFromMembers(memberID);
                break;
            case 3:
                String itemSerialNumber = in.nextLine();
                System.out.println("Enter ID/SerialNo of Data to Delete");
                data.deleteFromRentableEquipment(itemSerialNumber);
                break;
        }
    }

    public static void searchRecords(Scanner in, DummyDataManager data) {
        NavigationMessages.selectRecordType();
        int userSelectionChoice = -1;
        userSelectionChoice = Integer.parseInt(in.nextLine());

    }
    

    public static void main(String[] args) {
        int userSelectionChoice = -1;
        Scanner in = new Scanner(System.in);
        DummyDataManager data = new DummyDataManager();

        while (userSelectionChoice != 0) {
        NavigationMessages.welcomeNavigation();
        String input = in.nextLine();

        try {
            // Try to parse the input
            userSelectionChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Handle the case where input is not a valid number
            System.out.println("Invalid input. Please enter a number.");
            continue; // Continue the loop to re-prompt for input
        }

        switch (userSelectionChoice) {
            case 1:
                addRecords(in, data);
                userSelectionChoice = -1;
                break;
            
            case 2:
                deleteRecords(in, data);
                userSelectionChoice = -1;
                break;
            
            case 3:
                searchRecords(in, data);
                userSelectionChoice = -1;
                break;
            
            case 4: 
                System.out.println("Equipment Rented.");
                userSelectionChoice = -1;
                break;
            case 5: 
                System.out.println("Equipment Picked Up.");
                userSelectionChoice = -1;
                break;

            case 6: 
                System.out.println("Equipment Returned.");
                userSelectionChoice = -1;
                break;

            case 7: 
                System.out.println("Equipment Delivered.");
                userSelectionChoice = -1;
                break;

            default:
                break;
        }
    }

        in.close();
    }
}