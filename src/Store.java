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

public class Store {
    
    public Store() {
        storeName = null;
        list = new ArrayList<Item>();
    }
    
    public Store(String name) {
        storeName = name; 
        list = new ArrayList<Item>();
    }
    
    public String getStoreName() {
        return storeName;
    }
    
    public void setStoreName(String name) {
        storeName = name;
    }
    
    public void addItem(Item anItem) {
        list.add(anItem);
    }
    
    
    public void displayList() {
        Iterator<Item> it = list.iterator();
        Item current;
        while(it.hasNext()) {
            current = it.next();
            System.out.println(current.toString());
        }
    }
    
    public String toString() {
        return storeName;
    }
    
    private String storeName;
    private List<Item> list;
}
