/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public abstract class Account {
    protected String sortcode;
    protected int accountno;
    protected double Balance;
    protected String nameofBank;
    protected double Rate;
    protected Date LastReportedDate;
    protected boolean Joint;
    protected Date AccountStartDate;
    protected Customer CustomersAccount;
    protected int NoOfTransactions;
    private SimpleDateFormat formatter;
    private String lastreporteddate;
    private String AccountType;
        
    public Account(Customer c){
        sortcode = "";
        accountno = 0;
        Balance = 0;
        nameofBank = "";
        Rate = 1.2;
        LastReportedDate = new Date (01/01/2000);
        Date date = new Date();
        AccountStartDate = new Date();
        NoOfTransactions = 0;
    }
    
    public void Edit() {
    }
    
    public abstract void EndOfMonth(Date DateofTransaction, JTextArea AccDetails);
    
    public double deposit(double balance, double Amt) {
        Balance = balance + Amt;
        NoOfTransactions++;
        return Balance;
    }

    public double withdraw(double balance, double Amt) {
        Balance = balance - Amt;
        NoOfTransactions++;
        return Balance;
    }
    
    public String getsortcode(){
        return sortcode;
    }
    
    public void setsortcode(String strsortcode){
        sortcode = strsortcode;
    }
    
    public int getaccountno(){
        return accountno;
    }
    
    public void setaccountno(int intaccountno){
        accountno = intaccountno;
    }
    
    public double getBalance(){
        return Balance;
    }
    
    public void setBalance(double doubleBalance){
        Balance = doubleBalance;
    }
    
    public String getnameofBank(){
        return nameofBank;
    }
    
    public void setnameofBank(String strnameofBank){
        this.nameofBank = strnameofBank;
    }
    
    public double getRate(){
        return Rate;
    }
    
    public void setRate(double doubleRate){
        Rate = doubleRate;
    }
    
    public Date getLastReportedDate(){
        return LastReportedDate;
    }
    
    public void setLastReportedDate(Date DateofTransaction){
        LastReportedDate = DateofTransaction;
    }
    
    public void LastReportedDate(Date dateLastReportedDate) {
        LastReportedDate = dateLastReportedDate;
    }
    
    public void setAccountType(String accounttype) {
        this.AccountType = accounttype;
    }
    
    public String getAccountType() {
        return this.AccountType;
    }
    
    public void setAccountStartDate(Date AccountStartDate) {
        this.AccountStartDate = AccountStartDate;
    }
    
    public void create(String Csortcode, int Caccountno, double CBalance, String CnameofBank, double CRate, Date CAccountStartDate, String AccountType){
        setsortcode(Csortcode);
        setaccountno(Caccountno);
        setBalance(CBalance);
        setnameofBank(CnameofBank);
        setRate(CRate);
        setLastReportedDate(CAccountStartDate);
        setAccountType(AccountType);
    }
    
    public void Display(JTextArea src){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String lastreporteddate = formatter.format(LastReportedDate); 
        src.append("Account Type: " + AccountType + "\n"
                + "Name of Bank: " + nameofBank + "\n"
                + "Sort Code: " + sortcode + "\n" 
                + "Account Number: " + String.valueOf(accountno) + "\n"
                + "Balance: " + String.valueOf(Balance) + "\n"
                + "Rate: " + String.valueOf(Rate) + "\n"
                + "Last Reported Date: " +  lastreporteddate + "\n" + "\n"); 
    }
    
    public void saveToFile(Customer c, String AccountType) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        String lastreporteddate = formatter.format(LastReportedDate);  
        FileWriter fw;
        try {
            fw = new FileWriter("Account.txt", true);
            fw.write(c.getFirstName() + "," 
                    + c.getSurname() + ","
                    + AccountType + "," 
                    + sortcode + "," 
                    + accountno + "," 
                    + Balance + "," 
                    + nameofBank + "," 
                    + Rate + "," 
                    + lastreporteddate + "\n");
            fw.flush();
            fw.close();
            fw = null;
        } catch (IOException ioe) {
        }
    }
    
    public void printStatement() {
        FileWriter fw;
        try {
            fw = new FileWriter("AccountStatement.txt", true);
            fw.write(sortcode + "," 
                    + accountno + "," 
                    + Balance + "," 
                    + nameofBank + "," 
                    + LastReportedDate + "\n");
            fw.flush();
            fw.close();
            fw = null;
        } catch (IOException ioe) {
        }
    }
    
    public void calculateCharges() {
        Balance = Balance + (Balance * Rate);
    }
      
    protected void EndOfMonthTransactions(JTextArea AccDetails) {
        AccDetails.append("Transactions:" + NoOfTransactions + "\t Balance: " + Balance + "\t(" + this + ")");
        NoOfTransactions = 0;
    }
}