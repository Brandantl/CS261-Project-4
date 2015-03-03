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
        this.Quantity = 0;
        this.Price = 0;
        this.Name = null;
    }
    
    public Item(int number, int price, String name) {
        this.Quantity = number;
        this.Price = price;
        this.Name = name;
    }

    public int getQuantity() {
        return this.Quantity;
    }
    public int getPrice() {
        return this.Price;
    }
    public String getName() {
        return this.Name;
    }
    
    public boolean compare(String aName) {
      if(Name.toLowerCase().contains(aName.toLowerCase())) 
          return true;
      else
        return false;
    }
    
    public String toString() {
        return Quantity.toString() + " " + Price.toString() + " " + Name + "\n";
        
    }

    private Integer Quantity;
    private Integer Price;
    private String Name;
    public enum Type {debit, credit, cash};
}
