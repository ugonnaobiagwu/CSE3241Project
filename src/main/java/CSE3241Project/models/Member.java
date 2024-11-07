package main.java.CSE3241Project.models;


// Do all of these need to be init at the instantiation?
public class Member {
    public String Member_Name;
    public String Member_Address;
    public String Member_ID;
    public String Account_History; //what data type would this be?
    public String Start_Date;

    public Member(String name, String address, String memberID, String accountHistory, 
     String startDate) {
        this.Member_Name = name;
        this.Member_Address = address;
        this.Member_ID = memberID;
        this.Account_History = accountHistory;
        this.Start_Date = startDate;
    }
}