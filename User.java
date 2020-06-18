/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ee18ddg
 */
public class User {
    private String username;
    private String role;
    private String password;
    private String filename;
    
    public User(){
        this.filename = "login.txt";
        this.role = "Bank Employee";
    }
    
    public void setName(String name) {
        this.username = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getName() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getRole() {
        return this.role;
    }
    
    public boolean isUser(String checkName, String checkPassword){
        boolean isUser = false;
        setName(checkName);
        setPassword(checkPassword);
        
        String record1;
        String record2;
        FileReader reader;

        String line;
        
        try {
            reader = new FileReader(filename);

            BufferedReader bin = new BufferedReader(reader);

            record1 = new String();
            record2 = new String();
           

            while ((line = bin.readLine()) != null) {
                String[] record = line.split("\t");
                record1 = record[0];
                record2 = record[1];
                if ((getName().contentEquals(record1)) && (getPassword().contentEquals(record2)))
                    isUser = true;   
            }
            bin.close();
        } catch (IOException ioe) {
            isUser = false;
        }
        return isUser;
    }
    
    public boolean isRegistered(String checkName){
        boolean isRegistered = false;
        setName(checkName);
        String record1;
        String line;
        
        try {
            BufferedReader bin = new BufferedReader(new FileReader(filename));
            while ((line = bin.readLine()) != null) {
                String[] record = line.split("\t");
                record1 = record[0];
                if ((getName().contentEquals(record1)))
                    isRegistered = true;   
            }
            bin.close();
        } catch (IOException ioe) {
            isRegistered = false;
        }
        return isRegistered;
    }
    
    public boolean Register(String newName, String newPassword, String newRole) {
        boolean Register;
        setName(newName);
        setPassword(newPassword);
        setRole(newRole);
        FileWriter writer;
        try {
            writer = new FileWriter(filename, true);
            writer.write(getName()+"\t"+getPassword()+"\t"+getRole()+System.getProperty( "line.separator" ));
            Register = true;
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            Register=false;
        }
        return Register;
    }
    
    public String isManager(String checkName, String checkPassword){
        String isManager;
        setName(checkName);
        setPassword(checkPassword);
        isManager = new String();
        String record1, record2, record3, line;
        try {
            BufferedReader bin = new BufferedReader(new FileReader(filename));
            while ((line = bin.readLine()) != null) {
                String[] record = line.split("\t");
                record1 = record[0];
                record2 = record[1];
                record3 = record[2];
                
                if ((getName().contentEquals(record1)) && (getPassword().contentEquals(record2))) {
                   isManager = record3;
                }
            }
            bin.close();
        } catch (IOException ioe) {
            isManager = "";
        }
        return isManager;
    }
}