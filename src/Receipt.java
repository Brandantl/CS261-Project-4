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
                
public class Receipt {
   
    public Receipt() {
        list = new ArrayList<Store>();
    }
    public void addItem(Item anItem) {
        Iterator<Store> it = list.iterator();
        Store current;
        boolean found = false;
        while(it.hasNext()) {
            current = it.next();
            if(current == anItem.getStore()) {
                current.addItem(anItem);
                found = true;
            }
        }
        if(!found) {
            list.add(anItem.getStore());
            addItem(anItem);
        }
    }
    public void removeItem() {
        
    }
    public boolean searchItem(Item anItem) {
        Iterator<Store> it = list.iterator();
        Store current;
        while(it.hasNext()) {
            current = it.next();
            if(current == anItem.getStore()) {
                return true;
            }
        }
        return false;
    }
    
    public void display_all() {
        Iterator<Store> it = list.iterator();
        Store current;
        while(it.hasNext()) {
            current = it.next();
            current.displayList();
        }
    }
    
    private List<Store> list;
    
}
