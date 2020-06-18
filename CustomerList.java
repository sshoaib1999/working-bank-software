/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class CustomerList {
    private String Filename;
    private ArrayList <Customer> Clients;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    
    public CustomerList() {
        Clients = new ArrayList<>();
        Filename = "CustomerList.txt";
    }
    
    public void Display(JTextArea src) {
        for (int i=0; i < Clients.size(); i++) {
            Clients.get(i).DisplayCustomerDetails(src);
        }
    }
    
    public void AddCustomer(Customer customer) {
        Clients.add(customer);
    }
    
    public void clear(){
        Clients.clear();
     } 
    
    public Customer CustomerSearch(Customer check, String SrcFirstName, String SrcSurname) {
        check.setFirstName(SrcFirstName);
        check.setSurname(SrcSurname);
        boolean found;
        found = false;
       
        Customer ClientLocated;
        ClientLocated = new Customer();
        if (Clients.size() == 0){
            ClientLocated = null;
        }
        else {
        for(int i = 0; i < Clients.size(); i++) {
            if(check.getFirstName().equals(Clients.get(i).getFirstName()) && check.getSurname().equals(Clients.get(i).getSurname())){
               ClientLocated = Clients.get(i);
               found = true;
            } 
            if (found == false)
                ClientLocated = null;
        }
        }
        return ClientLocated;
    }
    
    public void RemoveCustomer(String strFirstName, String strLastName) {
        for (int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getFirstName().equals(strFirstName) && Clients.get(i).getSurname().equals(strLastName)) {
                Clients.remove(i);
            }
        }
    }
    
    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(new File(Filename), false);
            for (Customer customer : Clients) {
                fw.write(customer.getFirstName() + ","
                        + customer.getSurname() + ","
                        + customer.getDOB() + "," 
                        + customer.getCustomerSince() + "," 
                        + customer.getHomeAddress().toString());
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReadCustomerList() throws ParseException {
        String read;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            read = new String();
            while ((read = bin.readLine()) != null) {
                Customer CurrentCustomer = new Customer();
                CurrentCustomer.setFirstName(read.split(",")[0]);
                CurrentCustomer.setSurname(read.split(",")[1]);                             
                CurrentCustomer.setDOB(read.split(",")[2]);
                CurrentCustomer.setCustomerSince(read.split(",")[3]);
                CurrentCustomer.setName(read.split(",")[4]);
                CurrentCustomer.setHouseNo(Integer.parseInt(read.split(",")[5]));
                CurrentCustomer.setStreet(read.split(",")[6]);
                CurrentCustomer.setHouseName(read.split(",")[7]);
                CurrentCustomer.setArea(read.split(",")[8]);
                CurrentCustomer.setPostCode(read.split(",")[9]);
                CurrentCustomer.setTown(read.split(",")[10]);
                CurrentCustomer.setCountry(read.split(",")[11]);
                Clients.add(CurrentCustomer);
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }
    
    public void PrintClientList() {
        FileWriter writer;

        try {
            writer = new FileWriter(Filename, false);
            for (int i = 0; i < Clients.size(); i++) {
                writer.write(Clients.get(i).ArrayListtoString());
            }
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {}
    }
    
    public boolean NameCheck(String Firstname, String Lastname){
        boolean namecheck = false;
        for (int i = 0; i < Clients.size(); i++){
            if (Firstname.equals(Clients.get(i).getFirstName()) && Lastname.equals(Clients.get(i).getSurname())){
                namecheck = true;
            }
        }
        return namecheck;
    }
}