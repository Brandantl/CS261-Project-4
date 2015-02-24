/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brandan
 */
public class Main {
    
    //Item(int number, int price, String name, String desc, Store storeName, Type stuff)

    public static void main(String[] args) {
        Receipt stuff = new Receipt();
        stuff.addItem(new Item(1,13, "Toothpaste", "brush your teeth with it", new Store("Target"), Item.Type.credit));
        stuff.addItem(new Item(2,24, "WD40", "lubricant", new Store("Ace Hardware"), Item.Type.debit));
        stuff.addItem(new Item(3,35, "toilet paper", "wipe stuff", new Store("Target"), Item.Type.cash));
        stuff.addItem(new Item(4,46, "Shoes", "Wearing on your feet", new Store("Famous Footwear"), Item.Type.debit));
        stuff.addItem(new Item(5,57, "Dictionary", "looks up wordzzz", new Store("Bed Bath and Beyond"), Item.Type.credit));
        stuff.display_all();
    }
    
}
