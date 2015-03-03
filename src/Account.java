/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kalebstriplin
 */

import java.util.*;
                
public abstract class Account {
   
    public Account() {
        list = new ArrayList<Receipt>();
    }
    
  
    
    public void display_all() {
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while(it.hasNext()) {
            current = it.next();
            current.displayList();
        }
    }
    
    public abstract String getType();
    
    private List<Receipt> list;
    
}
