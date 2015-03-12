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
public class Receipt {

    public Receipt(Receipt aReceipt) {
        this.storename = aReceipt.storename;
        list = new ArrayList<Item>();
        this.list.addAll(aReceipt.list);
        this.total = aReceipt.total;
    }

    public Receipt() {
        storename = null;
        list = new ArrayList<Item>();
        total = 0;
    }

    public List<Item> getList() {
        return list;
    }

    public Receipt(String name) {
        storename = name;
        list = new ArrayList<Item>();
        total = 0;
    }

    public void displayList() {
        Iterator<Item> it = list.iterator();
        Item current;
        System.out.println("Store: " + storename);
        System.out.println("Total: " + total);
        while (it.hasNext()) {
            System.out.println("--- Item ---");
            current = it.next();
            System.out.println(current.toString());
        }
        System.out.println("================================");
    }

    public String getStorename() {
        return storename;
    }

    public int getTotal() {
        return total;
    }

    public Item search(String itemname) {
        Item stuff = null;
        Iterator<Item> it = list.iterator();
        Item current;
        while (it.hasNext()) {
            current = it.next();
            if (current.getName() == null ? itemname == null : current.getName().equals(itemname)) {
                stuff = current;
                return stuff;
            }
        }
        return stuff;
    }

    public void addItem(Item stuff) {
        list.add(stuff);
        total = total + stuff.getPrice();
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    private String storename;
    private int total;
    private List<Item> list;

}
