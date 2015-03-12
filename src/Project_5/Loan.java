package Project_5;

import java.util.*;

public class Loan extends Account {

    private int balance;
    private String bank;
    private int currPay;
	//private float minPay;

    public Loan() {

        balance = 0;
        bank = null;
        currPay = 0;
        type = "Loan";
        list = new ArrayList<>();

    }

    public Loan(Loan aLoan) {
        this.balance = aLoan.balance;
        this.bank = aLoan.bank;
        this.currPay = aLoan.currPay;
        this.list.addAll(aLoan.list);
    }

    public Loan(int bal, String bank, int currPay) {
        setBalance(bal);
        setBank(bank);
        setCurrPay(currPay);
        list = new ArrayList<>();
        type = "loan";

    }
    

    public void setBalance(int bal) {
        balance = bal;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setCurrPay(int curr) {
        currPay = curr;
    }

    public void addItem(String bank, Item anItem) {
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while (it.hasNext()) {
            current = it.next();
            if (current.getStorename() == null ? bank == null : current.getStorename().equals(bank)) {
                current.addItem(new Item(anItem));
                return;
            }
        }
        list.add(new Receipt(bank));
        addItem(bank, anItem);
    }

    public String getBank() {
        return bank;
    }

    @Override
    public String getType() {
        return super.getType(); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public List<Receipt> getList() {
        return super.getList(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCurrPay() {
        return currPay;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public Item search(String name) {
        Item stuff = null;
        Iterator<Receipt> it = list.iterator();
        Receipt current;
        while (it.hasNext()) {
            current = it.next();
            if (current.search(name) != null) {
                stuff = current.search(name);
                return stuff;
            }
        }
        return stuff;
    }

    @Override
    public int total() {
        int total = 0;
        Iterator<Receipt> it = list.iterator();
        Receipt curr;
        while (it.hasNext()) {
            curr = it.next();
            total = total + curr.getTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        String lnOut = "\n bank maintaining loan: " + bank + "balance: " + balance
                + "\ncurrent monthly payment: " + currPay;
        return lnOut;
    }
}
