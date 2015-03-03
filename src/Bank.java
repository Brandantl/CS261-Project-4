/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author kalebstriplin
 */

public class Bank {
    public Bank() {
        bankname = null;
    }
    
    public Bank(String name) {
        bankname = new String(name);
    }
    
    public String getBankname() {
        return bankname;
    }
    
    public void displayBanks() {
        Iterator<Account> it = myList.iterator();
        Account current;
        while(it.hasNext()) {
            current = it.next();
            current.toString();
        }
    }
    
    public void displayAccount(String account) {
        Iterator<Account> it = myList.iterator();
        Account current;
        while(it.hasNext()) {
            current = it.next();
            if(current.getType() == account) {
                current.display_all();
                return;
            }
        }
    }
    
    private String bankname;
    private List<Account> myList;
}
