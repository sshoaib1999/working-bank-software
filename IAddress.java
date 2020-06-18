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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class IAddress {
    private String name;
    private String street;
    private Integer house_no;
    private String house_name;
    private String area;
    private String post_code;
    private String town;
    private String country;
    
    public IAddress()
    {
        Edit("", "", 0, "", "", "", "", "");
    }
    
    public IAddress(String name, String street, Integer house_no, String house_name,
            String area, String post_code, String town, String country)
    {
        this.name = name;
        this.street = street;
        this.house_no = house_no;
        this.house_name = house_name;
        this.area = area;
        this.post_code = post_code;
        this.town = town;
        this.country = country;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getStreet() {
        return this.street;
    }
    
    public Integer getHouseNo() {
        return this.house_no;
    }
    
    public String getHouseName() {
        return this.house_name;
    }
    
    public String getArea() {
        return this.area;
    }
    
    public String getPostCode() {
        return this.post_code;
    }
    
    public String getTown() {
        return this.town;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public void setHouseNo(int HouseNo) {
        this.house_no = HouseNo;
    }
    
    public void setHouseName(String HouseName) {
        this.house_name = HouseName;
    }
    
    public void setArea(String Area) {
        this.area = Area;
    }
    
    public void setPostCode(String PostCode) {
        this.post_code = PostCode;
    }
    
    public void setTown(String Town) {
        this.town = Town;
    }
    
    public void setCountry(String Country) {
        this.country = Country;
    }
    
    public void Display(javax.swing.JTextField jnameTextField, javax.swing.JTextField jstreetTextField, javax.swing.JTextField jhouseNumberTextField, javax.swing.JTextField jhouseNameTextField
            , javax.swing.JTextField jareaTextField, javax.swing.JTextField jpostCodeTextField, javax.swing.JTextField jtownTextField, javax.swing.JTextField jcountryTextField){
        this.name = jnameTextField.getText();
        this.street = jstreetTextField.getText();
        this.house_no = Integer.parseInt(jhouseNumberTextField.getText());
        this.house_name = jhouseNameTextField.getText();
        this.area = jareaTextField.getText();
        this.post_code = jpostCodeTextField.getText();
        this.town = jtownTextField.getText();
        this.country = jcountryTextField.getText();
    }
    
    public void Display(JTextArea src) {
        src.append("Name: "+ name + "\n"+
        "Street: " + street + "\n" +
        "House Number is: " + house_no + "\n" +
        "House Name is: " + house_name + "\n" +
        "Area is: " + area + "\n" +
        "Post Code is: " + post_code + "\n" +
        "Town is: " + town + "\n" +
        "Country is: " + country + "\n");
    }
    
    public void Edit(String name, String street, Integer house_no, 
            String house_name, String area, String post_code, String town,
            String country) {
        this.name = name;
        this.street = street;
        this.house_no = house_no;
        this.house_name = house_name;
        this.area = area;
        this.post_code = post_code;
        this.town = town;
        this.country = country;
    }
    
    public void Edit(IAddress src) {
        this.Edit(src.getName(), src.getStreet(), src.getHouseNo(), src.getHouseName(), src.getArea(), src.getPostCode(), src.getTown(), src.getCountry());
    }
    
    public String toString() {
        return (name + "," + street + "," + house_no + "," + house_name + "," + area + "," +
                    post_code + "," + town + "," + country);
    }
    
    public void LoadFromFile(FileReader areader) {
         BufferedReader br = new BufferedReader(areader);
        try {
            String line = br.readLine();
            String [] address = line.split(",");
            Edit(address[0], address[1], Integer.parseInt(address[2]), address[3], address[4], address[5], address[6], address[7]);
        } catch (IOException ex) {
            Logger.getLogger(IAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SaveToFile() {
        try {
            FileWriter fw = new FileWriter(new File("address.txt"), false);
            fw.write(toString());
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(IAddress.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}