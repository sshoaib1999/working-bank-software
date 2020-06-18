/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Date;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class SavingAccount extends Account{
    private double withdrawlimit;
    
    public SavingAccount(Customer c) {
        super(c);
        withdrawlimit = 200;
    }
    
    @Override
    public void Display(JTextArea AccDetails) {
        super.Display(AccDetails);
        AccDetails.append("Withdraw Limit: " + withdrawlimit + "\n" + "\n" );
    }
    
    @Override
    public void create(String Csortcode, int Caccountno, double CBalance, String CnameofBank, double CRate, Date CAccountStartDate, String AccountType){
        super.create(Csortcode, Caccountno, CBalance, CnameofBank, CRate, CAccountStartDate, AccountType);
        withdrawlimit = 200;
    }
    @Override
    public void saveToFile(Customer c, String accountType) {
        super.saveToFile(c, accountType);
    }
    
    /*public double Deposit(double balance, double Amt){
        Balance = balance + Amt;
        return Balance;
    }
    
    public double Withdraw(double balance, double Amt){
        Balance = balance;
        if (Amt <= withdrawlimit){
            if (balance > Amt) {
                Balance -= Amt;
                NoOfTransactions++;
            }
        }
        return Balance;
    }*/
    
    @Override
    public double deposit(double balance, double Amt) {
        Balance = balance + Amt;
        NoOfTransactions++;
        return Balance;
    }

    @Override
    public double withdraw(double balance, double Amt) {
        Balance = balance - Amt;
        NoOfTransactions++;
        return Balance;
    }
    
    @Override
    public void EndOfMonth(Date DateofTransaction, JTextArea AccDetails){
            long NoOfDays = (DateofTransaction.getTime() - AccountStartDate.getTime()) / (1000*60*60*24);
            if (NoOfDays >= 31){
                Balance = Balance * Rate;
                NoOfTransactions++;
                EndOfMonthTransactions(AccDetails);
            }
    }
    
    public void setSortCode(String sortcode) {
        super.setsortcode(sortcode);
    }
    
    public void setAccountNo(int accountno) {
        super.setaccountno(accountno);
    }
    
    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }
    
    public void setNameOfBank(String nameofbank) {
        super.setnameofBank(nameofbank);
    }
    
    @Override
    public void setRate(double rate) {
        super.setRate(rate);
    }
    
    @Override
    public void setLastReportedDate(Date lastreporteddate) {
        super.setLastReportedDate(lastreporteddate);
    }
}