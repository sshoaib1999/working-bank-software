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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class BranchList {
    private String Filename;
    public ArrayList <Branch> BranchList;
    private BranchList SubDepartments;
    
    public BranchList(){
        Filename = "BranchList.txt";
        BranchList = new ArrayList<>();
        try {
            ReadBranchList();
        } catch (ParseException ex) {
            Logger.getLogger(BranchList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clear() {
        BranchList.clear();
    }
    
    public void AddBranch(Branch branch){
        BranchList.add(branch);
    }
    
    public void Display(JTextArea src) {
        for (int i = 0; i < BranchList.size(); i++)
            BranchList.get(i).Display(src);
    }
    
    public void PrintToFile(){
             try {
           FileWriter fw = new FileWriter(new File(Filename), true);
          for (Branch branch : BranchList) {
              fw.write( branch.getBranchAddress().toString() + ","
                        + branch.getWorkingHours() + ","
                        + branch.getSortCode() + ","
                        + branch.getManager() + "\n");
            }
           fw.close();
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ReadBranchList() throws ParseException {
        String read;
        FileReader reader;
        try {
            reader = new FileReader(Filename);
            BufferedReader bin = new BufferedReader(reader);
            read = new String();
            while ((read = bin.readLine()) != null) {
                Branch CurrentBranch = new Branch();
                CurrentBranch.setBranchName(read.split(",")[0]);
                CurrentBranch.setStreet(read.split(",")[1]);
                CurrentBranch.setHouseNo(Integer.parseInt(read.split(",")[2]));
                CurrentBranch.setHouseName(read.split(",")[3]);
                CurrentBranch.setArea(read.split(",")[4]);
                CurrentBranch.setPostCode(read.split(",")[5]);
                CurrentBranch.setTown(read.split(",")[6]);
                CurrentBranch.setCountry(read.split(",")[7]);
                CurrentBranch.setWorkingHours(read.split(",")[8]);
                CurrentBranch.setSortCode(read.split(",")[9]);
                CurrentBranch.setManager(read.split(",")[10]);
                BranchList.add(CurrentBranch);
            }
            bin.close();
            bin = null;
        } catch (IOException ioe) {
        }
    }
    
    public void PrintBranchesList() {
        FileWriter writer;

        try {
            writer = new FileWriter(Filename, false);
            for (int i = 0; i < BranchList.size(); i++) {
                writer.write(BranchList.get(i).BranchListView());
            }
            writer.flush();
            writer.close();
            writer = null;
        } catch (Exception ioe) {
        }
    }
}