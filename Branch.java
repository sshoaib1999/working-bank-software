/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class Branch {
    private IAddress theAddress;
    private String working_hours;
    private String sort_code;
    private String manager;
    private String Filename;
    
    public Branch()
    {
        
        this.theAddress = new IAddress();
        Filename = "Branch.txt";
        LoadFromFile();
    }
    
    public void Edit(IAddress src, String workingHours, String sort_code, String manager){
            theAddress.Edit(src);
            this.working_hours = workingHours;
            this.sort_code = sort_code;
            this.manager = manager;
    }
    
    public void Display(javax.swing.JTextField jnameTextField, javax.swing.JTextField jstreetTextField, javax.swing.JTextField jhouseNumberTextField, javax.swing.JTextField jhouseNameTextField
            , javax.swing.JTextField jareaTextField, javax.swing.JTextField jpostCodeTextField, javax.swing.JTextField jtownTextField, javax.swing.JTextField jcountryTextField, 
            javax.swing.JTextField jworkingHoursTextField, javax.swing.JTextField jsortCodeTextField, javax.swing.JTextField jTextField1){
        theAddress.Display(jnameTextField, jstreetTextField, jhouseNumberTextField, jhouseNameTextField, jareaTextField, jpostCodeTextField, jtownTextField, jcountryTextField);
        this.working_hours = jworkingHoursTextField.getText();
        this.sort_code = jsortCodeTextField.getText();
        this.manager = jTextField1.getText();
    }
    
    public void Display(JTextArea src){
        theAddress.Display(src);
        src.append("Working Hours: " + working_hours + "\n" +
                    "Sort Code: " + sort_code + "\n" +
                    "Manager: " + manager + "\n" + "\n");
    }
    
    public void SaveToFile(){
        theAddress.SaveToFile();
        try {
            FileWriter fw = new FileWriter(new File(Filename), false);
            fw.write(working_hours + "," + sort_code + "," + manager +"\n");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(IAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadFromFile(){
        try {
            theAddress.LoadFromFile(new FileReader(new File("address.txt")));
            BufferedReader br = new BufferedReader(new FileReader(Filename));
            String line = br.readLine(); 
            String[] tokens = line.split(",");
            this.working_hours = tokens[0];
            this.sort_code = tokens[1];
            this.manager = tokens[2];
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
             Logger.getLogger(Branch.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public IAddress getAddress(){
        return this.theAddress;
    }
    
    public String getWorkingHours() {
        return this.working_hours;
    }
    
    public String getSortCode() {
        return this.sort_code;
    }
    
    public String getManager() {
        return this.manager;
    }
    
    public String getBranchName() {
        return theAddress.getName();
    }
    
    public IAddress getBranchAddress() {
        return theAddress;
    }
    
    public void setManager(String manager) {
        this.manager = manager;
    }
    
    public void setSortCode(String sortcode) {
        this.sort_code = sortcode;
    }
    
    public void setWorkingHours(String workinghours) {
        this.working_hours = workinghours;
    }
    
    public void setBranchName(String branchname) {
        theAddress.setName(branchname);
    }
    
    public void setStreet(String street) {
        theAddress.setStreet(street);
    }
    
    public void setHouseNo(Integer houseno) {
        theAddress.setHouseNo(houseno);
    }
    
    public void setHouseName(String HouseName) {
        theAddress.setHouseName(HouseName);
    }
    
    public void setArea(String area) {
        theAddress.setArea(area);
    }
    
    public void setPostCode(String postcode) {
        theAddress.setPostCode(postcode);
    }
    
    public void setTown(String town) {
        theAddress.setTown(town);
    }
    
    public void setCountry(String country) {
        theAddress.setCountry(country);
    }
    
    public String BranchListView() {
        StringBuilder result = new StringBuilder();
        result.append(theAddress.toString()+ ","  + working_hours + "," + sort_code + "," + manager + "\n");
        return result.toString();
    }
}