/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_5;

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
    
    public Item(Item anItem) {
        this.Name = anItem.Name;
        this.Price = anItem.Price;
        this.Quantity = anItem.Quantity;
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
    
    public String toString() {
        return Name + " P" + Price + " Q" + Quantity + "\n";
    }
    
    private Integer Quantity;
    private Integer Price;
    private String Name;
    
    //we should over ride the equals operator
}
