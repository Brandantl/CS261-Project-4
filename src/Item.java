/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kalebstriplin
 */


public class Item {
    
    public Item() {
        this.ItemNumber = 0;
        this.Price = 0;
        this.Name = null;
        this.Description = null;
        this.store = null;
        this.Transaction = null;
    }
    
    public Item(int number, int price, String name, String desc, Store storeName, Type stuff) {
        this.ItemNumber = number;
        this.Price = price;
        this.Name = name;
        this.Description = desc;
        this.store = storeName;
        this.Transaction = stuff;
    }

    /*Item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public int getItemNumber() {
        return this.ItemNumber;
    }
    public int getPrice() {
        return this.Price;
    }
    public String getName() {
        return this.Name;
    }
    public String getDescription() {
        return this.Description;
    }
    public Store getStore() {
        return this.store;
    }

    public Type getTransaction() {
        return Transaction;
    }
    public boolean compare(String aDesc) {
      if(Description.toLowerCase().contains(aDesc.toLowerCase())) 
          return true;
      else
        return false;
    }
    
    public String toString() {
        return ItemNumber.toString() + " " + Price.toString() + " " + Name + " " + Description + " " + store.toString() + " " + Transaction.toString() + "\n";
        
    }

    private Integer ItemNumber;
    private Integer Price;
    private String Name;
    private String Description;
    private Store store;
    private Type Transaction;
    public enum Type {debit, credit, cash};
}
