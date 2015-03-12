/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_5;

import java.util.*;
/**
 *
 * @author kalebstriplin
 */
public abstract class Account {
    
    protected List <Receipt> list;
    protected String type;

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
    
    public String getType() {
        return type;
    }
    
    public void addReceipt(Receipt o) {
        list.add(new Receipt(o));
    }

    public List<Receipt> getList() {
        return list;
    }
    
    public abstract int total(); //needs this too function to calculate the total of the receipt
    
    public abstract Item search(String name); //when you check if the item is empty check item.name not item
    
}
