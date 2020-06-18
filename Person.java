/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Date;
/**
 *
 * @author user
 */
public class Person {
    private String first_name;
    private String last_name;
    private IAddress home_address;
    private Date dob;
    
    public Person()
    {
        this.first_name = "";
        this.last_name = "";
        this.home_address = new IAddress();
        this.dob = new Date(01/01/1900);
    }

    public boolean CheckDOB(Date givenDOB){
        boolean check;
        check = (givenDOB == dob);
        return check;
    }
}
