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
public class Wire extends Account {
    
    public Wire(Wire card) {
        this.accountNum = card.accountNum;
        this.type = card.type;
        this.list.addAll(card.list);
    }
    
    public Wire(String number) {
        accountNum = number;
        list = new ArrayList<Receipt>();
        type = "Wire";
    }


    @Override
    public List<Receipt> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }
@Override
    public String getType() {
        return super.getType(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAccountNum() {
        return accountNum;
    }
    private String accountNum;
    
    public void addItem(String number, int ammount) {
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while(it.hasNext()) {
            current = it.next();
            if(current.getStorename() == number) {
                current.addItem(new Item(1, ammount, "transfer to " + number));
                return;
            }
        }
        list.add(new Receipt(number));
        addItem(number, ammount);
    }
    
    public int total() {
        int total = 0;
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while(it.hasNext()) {
            current = it.next();
            total = total + current.getTotal();
        }
        return total;
    }
    
    public Item search(String name) {
        Item stuff = null;
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while(it.hasNext()) {
            current = it.next();
            if(current.search(name) != null) {
                stuff = current.search(name);
                return stuff;
            }
        }
        return stuff;
    }
    
    public String toString() {
        return type + " " + accountNum + "\n";
    }
}
