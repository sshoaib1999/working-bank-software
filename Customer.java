/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class Customer {
    private String FirstName;
    private String Surname;
    private IAddress HomeAddress;
    private String DOB;
    private String CustomerSince;
    private String Filename;
    public ArrayList<Account> Accounts;
    
    public Customer() {
        Filename = "Customer.txt";
        this.HomeAddress = new IAddress();
        this.Accounts = new ArrayList<>();
        try {
            ReadFromFile();
        } catch (ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean CheckDOB(String DOB)  {
        boolean CheckFormat;
        if (DOB.matches("01/01/1900")) {
            CheckFormat = true;
        } else {
            CheckFormat = false;
        }
        return CheckFormat;
    }
    
    public void DisplayCustomerDetails(JTextArea src) {
        src.append("First Name: " + FirstName + "\n");
        src.append("Surname: " + Surname + "\n");
        src.append("Date of Birth: " + DOB + "\n");
        src.append("Customer Since: " + CustomerSince + "\n");
        src.append("Name: " + HomeAddress.getName() + "\n");
        src.append("House Number: " + HomeAddress.getHouseNo() + "\n");
        src.append("Street: " + HomeAddress.getStreet() + "\n");
        src.append("House Name: " + HomeAddress.getHouseName() + "\n");
        src.append("Area: " + HomeAddress.getArea() + "\n");
        src.append("Post Code: " + HomeAddress.getPostCode() + "\n");
        src.append("Town: " + HomeAddress.getTown() + "\n");
        src.append("Country: " + HomeAddress.getCountry() + "\n");
        src.append("\n");
    }
    
    public IAddress getHomeAddress () {
        return this.HomeAddress;
    }
    
    public String getFirstName(){
        return FirstName;
    }
    
    public void setFirstName(String strFirstName){
        this.FirstName = strFirstName;
    }
    
    public String getSurname(){
        return Surname;
    }
    
    public void setSurname(String strSurname){
        this.Surname = strSurname;
    }
    
    public String getDOB(){
        return DOB;
    }
    
    public void setDOB(String Customer_DOB){
        this.DOB = Customer_DOB;
    }
    
    public void setCustomerSince(String CustomerSince) {
        this.CustomerSince = CustomerSince;
    }
    
    public String getCustomerSince() {
        return this.CustomerSince;
    }
    
    public void setHouseName(String HouseName) {
        HomeAddress.setHouseName(HouseName);
    }
    
    public void setName(String Name){
        HomeAddress.setName(Name);
    }
    
    public void setHouseNo(int HouseNo){
        HomeAddress.setHouseNo(HouseNo);
    }
    
    public void setStreet(String Street){
        HomeAddress.setStreet(Street);
    }
    
    public void setArea(String Area){
        HomeAddress.setArea(Area);
    }
    
    public void setPostCode(String PostCode){
        HomeAddress.setPostCode(PostCode);
    }
    
    public void setTown(String Town){
        HomeAddress.setTown(Town);
    }
    
    public void setCountry(String Country){
        HomeAddress.setCountry(Country);
    }
    
    public void Edit(String firstname, String surname, String dob, String customersince, String name, String street, int houseno, 
                    String housename, String area, String postcode, String town, String country) {
        this.FirstName = firstname;
        this.Surname = surname;
        this.DOB = dob;
        this.CustomerSince = customersince;
        HomeAddress.setName(name);
        HomeAddress.setHouseNo(houseno);
        HomeAddress.setHouseName(housename);
        HomeAddress.setStreet(street);
        HomeAddress.setArea(area);
        HomeAddress.setPostCode(postcode);
        HomeAddress.setTown(town);
        HomeAddress.setCountry(country);
    }
    
    public void PrintToFile() throws IOException{
        FileWriter writer;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            writer = new FileWriter(Filename, false);
            writer.write(FirstName + System.getProperty("line.separator"));
            writer.write(Surname + System.getProperty("line.separator"));
            writer.write(DOB + System.getProperty("line.separator"));
            writer.write(CustomerSince + System.getProperty("line.separator"));
            writer.write(HomeAddress.getName() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getStreet() + System.getProperty("line.separator"));
            writer.write(Integer.toString(HomeAddress.getHouseNo()) + System.getProperty("line.separator"));
            writer.write(HomeAddress.getHouseName() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getArea() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getPostCode() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getTown() + System.getProperty("line.separator"));
            writer.write(HomeAddress.getCountry() + System.getProperty("line.separator"));
            writer.flush();
            writer.close();
            writer = null;
        }
        catch (IOException ioe){}
    }
    
    public void ReadFromFile() throws ParseException {
        int i = 0;
        String record;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            record = new String();
            while ((record = bin.readLine()) != null) {
                i++;
                if (i == 1) {
                    FirstName = record;
                } else if (i == 2) {
                    Surname = record;
                } else if (i == 3) {
                    DOB = record;
                } else if (i == 4) {
                    CustomerSince = record;
                } else if (i == 5) {
                    HomeAddress.setName(record);
                } else if (i == 6) {
                    HomeAddress.setStreet(record);
                } else if (i == 7) {
                    HomeAddress.setHouseNo(Integer.parseInt(record));
                } else if (i == 8) {
                    HomeAddress.setHouseName(record);
                } else if (i == 9) {
                    HomeAddress.setArea(record);
                } else if (i == 10) {
                    HomeAddress.setPostCode(record);
                } else if (i == 11) {
                    HomeAddress.setTown(record);
                } else if (i == 12) {
                    HomeAddress.setCountry(record);
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }
    
    public void DisplayFoundCustomersDetails(Customer SearchCustomer, JTextArea src) {
        src.append("First Name: " + SearchCustomer.FirstName + "\n");
        src.append("Surname: " + SearchCustomer.Surname + "\n");       
        src.append("Date of Birth: " +  SearchCustomer.DOB + "\n");
        src.append("CustomerSince: " +  SearchCustomer.CustomerSince + "\n");
        src.append("House Name: " + SearchCustomer.HomeAddress.getHouseName() + "\n");
        src.append("Name: " + SearchCustomer.HomeAddress.getName() + "\n");
        src.append("House No: " + SearchCustomer.HomeAddress.getHouseNo() + "\n");
        src.append("Street: " + SearchCustomer.HomeAddress.getStreet() + "\n");
        src.append("Area: " + SearchCustomer.HomeAddress.getArea() + "\n");
        src.append("Post Code: " + SearchCustomer.HomeAddress.getPostCode() + "\n");
        src.append("Town: " + SearchCustomer.HomeAddress.getTown() + "\n");
        src.append("Country: " + SearchCustomer.HomeAddress.getCountry() + "\n");
        src.append("\n");
    }
    
    public String ArrayListtoString() {
        StringBuilder result = new StringBuilder();
        result.append(FirstName + "," 
                + Surname + "," 
                + DOB + ","  
                + CustomerSince + ","
                + HomeAddress.getName() + "," 
                + HomeAddress.getHouseNo() + "," 
                + HomeAddress.getStreet() + ","
                + HomeAddress.getHouseName() + ","
                + HomeAddress.getArea() + "," 
                + HomeAddress.getPostCode() + "," 
                + HomeAddress.getTown() + "," 
                + HomeAddress.getCountry() + "\n");
        return result.toString();
    }
    
    public void AddAccount(Account newAccount){
        Accounts.add(newAccount);
    }
    
    public void ReadAccounts() throws ParseException {
        String read;
        FileReader reader;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            reader = new FileReader("Account.txt");
            BufferedReader bin = new BufferedReader(reader);
            read = new String();
            while ((read = bin.readLine()) != null) {
                
                if ((this.getFirstName().equals(read.split(",")[0])) && (this.getSurname().equals(read.split(",")[1]))) {
                    if ((read.split(",")[2]).equals("Current Account")) {
                    CurrentAccount accountHolder = new CurrentAccount(this);
                    accountHolder.create(read.split(",")[3], Integer.parseInt(read.split(",")[4]), Double.parseDouble(read.split(",")[5]), read.split(",")[6], Double.parseDouble(read.split(",")[7]), formatter.parse(read.split(",")[8]), read.split(",")[2]);
                    Accounts.add(accountHolder);
                    }
                    if ((read.split(",")[2]).equals("ISA Account")) {
                    ISAAccount accountHolder = new ISAAccount(this);
                    accountHolder.create(read.split(",")[3], Integer.parseInt(read.split(",")[4]), Double.parseDouble(read.split(",")[5]), read.split(",")[6], Double.parseDouble(read.split(",")[7]), formatter.parse(read.split(",")[8]), read.split(",")[2]);
                    Accounts.add(accountHolder);
                    }
                    if ((read.split(",")[2]).equals("Saving Account")) {
                    SavingAccount accountHolder = new SavingAccount(this);
                    accountHolder.create(read.split(",")[3], Integer.parseInt(read.split(",")[4]), Double.parseDouble(read.split(",")[5]), read.split(",")[6], Double.parseDouble(read.split(",")[7]), formatter.parse(read.split(",")[8]), read.split(",")[2]);
                    Accounts.add(accountHolder);
                    }
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }
    
    public void DisplayAccounts(JTextArea src) {
        for (int i=0; i < Accounts.size(); i++) {
            Accounts.get(i).Display(src);
        }
    }
    
    public void clearAccounts() {
            Accounts.clear();    
    }
    
    public void RemoveAccount(String strFirstName, String strLastName, int accountno) {
        for (int i = 0; i < Accounts.size(); i++) {
            if (Accounts.get(i).getaccountno() == accountno) {
                Accounts.remove(i);
            }
        }
    }
    
    public void FindAccount(int accountno) throws ParseException {
        String read;
        FileReader reader;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            reader = new FileReader("Account.txt");
            BufferedReader bin = new BufferedReader(reader);
            read = new String();
            while ((read = bin.readLine()) != null) {
                
                if ((this.getFirstName().equals(read.split(",")[0])) && (this.getSurname().equals(read.split(",")[1]))) {
                    if (Integer.parseInt(read.split(",")[4]) == accountno) {
                    if ((read.split(",")[2]).equals("Current Account")) {
                    CurrentAccount accountHolder = new CurrentAccount(this);
                    accountHolder.setAccountType(read.split(",")[2]);
                    accountHolder.setsortcode(read.split(",")[3]);
                    accountHolder.setaccountno(Integer.parseInt(read.split(",")[4]));
                    accountHolder.setBalance(Double.parseDouble(read.split(",")[5]));
                    accountHolder.setnameofBank(read.split(",")[6]);
                    accountHolder.setRate(Double.parseDouble(read.split(",")[7]));
                    accountHolder.setLastReportedDate(formatter.parse(read.split(",")[8]));
                    Accounts.add(accountHolder);
                    }
                    if ((read.split(",")[2]).equals("ISA Account")) {
                    ISAAccount accountHolder = new ISAAccount(this);
                    accountHolder.setAccountType(read.split(",")[2]);
                    accountHolder.setsortcode(read.split(",")[3]);
                    accountHolder.setaccountno(Integer.parseInt(read.split(",")[4]));
                    accountHolder.setBalance(Double.parseDouble(read.split(",")[5]));
                    accountHolder.setnameofBank(read.split(",")[6]);
                    accountHolder.setRate(Double.parseDouble(read.split(",")[7]));
                    accountHolder.setLastReportedDate(formatter.parse(read.split(",")[8]));
                    Accounts.add(accountHolder);
                    }
                    if ((read.split(",")[2]).equals("Saving Account")) {
                    SavingAccount accountHolder = new SavingAccount(this);
                    accountHolder.setAccountType(read.split(",")[2]);
                    accountHolder.setsortcode(read.split(",")[3]);
                    accountHolder.setaccountno(Integer.parseInt(read.split(",")[4]));
                    accountHolder.setBalance(Double.parseDouble(read.split(",")[5]));
                    accountHolder.setnameofBank(read.split(",")[6]);
                    accountHolder.setRate(Double.parseDouble(read.split(",")[7]));
                    accountHolder.setLastReportedDate(formatter.parse(read.split(",")[8]));
                    Accounts.add(accountHolder);
                    }
                    } else {
                    }
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }
    
    public void EditBalance(double balance, int accountno) throws ParseException {
        String line;
        String Content;
        String read;
        FileReader reader;
        try {
            reader = new FileReader("Account.txt");
            BufferedReader bin = new BufferedReader(reader);
            line = new String();
            Content = new String();
            try {
                
                while ((read = bin.readLine()) != null) {
                    if (Integer.valueOf(read.split(",")[4]) == accountno) {
                        line = read.replace(read.split(",")[5], String.valueOf(balance));
                        Content = (Content + line + "\n");
                    } else {
                        Content = (Content + read + "\n");
                    }
                }
                FileWriter writer = new FileWriter("Account.txt");
                writer.write(Content);
                writer.close();
                reader.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EditLastReportedDate(Date lastreporteddate, int accountno) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String LastReportedDate = formatter.format(lastreporteddate);
        String line;
        String Content;
        String read;
        FileReader reader;
        try {
            reader = new FileReader("Account.txt");
            BufferedReader bin = new BufferedReader(reader);
            line = new String();
            Content = new String();
            try {
                
                while ((read = bin.readLine()) != null) {
                    if (Integer.valueOf(read.split(",")[4]) == accountno) {
                        line = read.replace(read.split(",")[8], LastReportedDate);
                        Content = (Content + line + "\n");
                    } else {
                        Content = (Content + read + "\n");
                    }
                }
                FileWriter writer = new FileWriter("Account.txt");
                writer.write(Content);
                writer.close();
                reader.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double getBalance(int accountno) throws ParseException {
        double balance=100;
        String read;
        FileReader reader;
        try {
            reader = new FileReader("Account.txt");
            BufferedReader bin = new BufferedReader(reader);
            read = new String();
            while ((read = bin.readLine()) != null) {
                if ((this.getFirstName().equals(read.split(",")[0])) && (this.getSurname().equals(read.split(",")[1]))) {
                    if (Integer.parseInt(read.split(",")[4]) == accountno) {
                        balance = Double.valueOf(read.split(",")[5]);
                    }
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
        return balance;
    }
    
    public String getAccountType(int accountno) {
        String accountType = "";
        String read;
        FileReader reader;
        try {
            reader = new FileReader("Account.txt");
            BufferedReader bin = new BufferedReader(reader);
            read = new String();
            while ((read = bin.readLine()) != null) {
                if ((this.getFirstName().equals(read.split(",")[0])) && (this.getSurname().equals(read.split(",")[1]))) {
                    if (Integer.parseInt(read.split(",")[4]) == accountno) {
                        accountType = read.split(",")[2];
                    }
                }
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
        return accountType;
    }
}