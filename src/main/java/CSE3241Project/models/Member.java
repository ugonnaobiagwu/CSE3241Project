package main.java.CSE3241Project.models;


// Do all of these need to be init at the instantiation?
public class Member {
    public String name;
    public String address;
    public String memberID;
    public String accountHistory; //what data type would this be?
    public String phone;
    public String email;
    public String startDate;
    public long distanceFromWarehouse;

    public Member(String name, String address, String memberID, String accountHistory, 
    String phone, String email, String startDate, long distanceFromWarehouse) {
        this.name = name;
        this.address = address;
        this.memberID = memberID;
        this.accountHistory = accountHistory;
        this.phone = phone;
        this.startDate = startDate;
        this.email = email;
        this.distanceFromWarehouse = distanceFromWarehouse;
    }
}