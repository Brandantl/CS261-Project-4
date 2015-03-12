package Project_5;

import java.util.*;
import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Users {
    
    private List<Account> accounts;
    private Account currAccount;
    //protected Bank myBank;
    private Scanner in;
    //private boolean hasAccount = false;

    public Users(Scanner in) {
        this.in = in;
        accounts = XMLLoader.ReadXML();
        currAccount = accounts.get(0);
    }

    /**
     *
     * @throws IOException
     */
    public void runMenu() throws IOException {
        String intro = "Welcome to $$ Quacken 1.42!!\n"
                + "This program allows you to manage records of credit, debit, wire transactions and loans!\n"
                + "\"a\" adds new accounts\n"
                + "\"s\" Selects an account\n"
                + "\"d\" Displays receipt(s)\n"
                + "\"z\" Displays accounts(s)\n"
                + "\"c\" creates new receipts\n"
                + "\"q\" Save & Quit";
        
        String cmdPrompt = "Please enter a command <a>dd a new account, <c>reate receipt, <s>earch accounts, <q>uit";
        
        char cmd = 's';
        System.out.println(intro);
        
        while (cmd != 'q') {
            System.out.println(cmdPrompt);
            cmd = getCmd();
            switch (cmd) {
                
                case 'a':
                    addAccount((ArrayList<Account>) accounts);
                    break;
                case 'c':
                    createReceipt();
                    break;
                case 's':
                    selectAccount();
                    // select account 
                    break;
                case 'd':
                    currAccount.display_all();
                    // display receipts
                    break;
                case 'z':
                    displayAccounts();
                    // display receipts
                    break;
                case 'q':
                    in.close();
                    try {
                        XMLLoader.writeXML(accounts);
                    } catch (TransformerException e) {
                    }
                    break;
                default:
                    System.out.println("Please provide a valid command.");
            }
        }
    }

    /**
     *
     * @return @throws IOException
     */
    public char getCmd() throws IOException {
        String cm = in.nextLine();
        char cmmnd = cm.charAt(0);
        return Character.toLowerCase(cmmnd);
    }

    /**
     *
     * @param accounts
     * @throws IOException
     */
    private void addAccount(ArrayList<Account> accounts) throws IOException {
        
        String type, accName, sayOne = "Please provide the type of account (debit, credit, wire, loan): ", sayTwo = "Please provide the account name";
        System.out.print(sayOne);
        type = in.nextLine();
        System.out.print(sayTwo);
        accName = in.nextLine();
        switch (type) {
            case "debit":
                String cardNum;
                int pin;
                System.out.print("Please provide a debit card number: ");
                cardNum = in.nextLine();
                System.out.print("Please provide the debit card pin number: ");
                pin = in.nextInt();
                Debit aDeb = new Debit(cardNum, pin);
                accounts.add(aDeb);
                break;
            case "credit":
                //String cardNum;
                System.out.print("Please provide a credit card number: ");
                cardNum = in.nextLine();
                Credit aCard = new Credit(cardNum);
                accounts.add(aCard);
                break;
            case "wire":
                String wNum;
                System.out.print("Please provide a wire transfer number: ");
                wNum = in.nextLine();
                Wire aWire = new Wire(wNum);
                accounts.add(aWire);
                break;
            case "loan":
                System.out.print("Balance: ");
                int balance = Integer.parseInt(in.nextLine());
                System.out.print("Bank: ");
                String bank = in.nextLine();
                System.out.print("Payment: ");
                int currPay = Integer.parseInt(in.nextLine());
                Loan aLoan = new Loan(balance, bank, currPay);
                accounts.add(aLoan);
                break;
            default:
                System.out.println("illegal command");
                break;
        }
        
    }

    /**
     * creates a new receipt no arguments, no return
     *
     */
    private void createReceipt() throws IOException {
        String storename;
        int total;
        System.out.print("Store: ");
        storename = in.nextLine();
        System.out.print("Total: ");
        total = Integer.parseInt(in.nextLine());
        
        Receipt thing = new Receipt();
        thing.setStorename(storename);
        thing.setTotal(total);
        char cmd = ' ';
        while (cmd != 'q') {
            Integer Quantity;
            Integer Price;
            String Name;
            System.out.print("Item Name: ");
            Name = in.nextLine();
            System.out.print("Item Quantity: ");
            Quantity = Integer.parseInt(in.nextLine());
            System.out.print("Item Price: ");;
            Price = Integer.parseInt(in.nextLine());
            Item itm = new Item(Quantity, Price, Name);
            thing.addItem(itm);
            System.out.print("Press 'q' to exit, press 'c' to continue.");;
            cmd = getCmd();
        }
        currAccount.addReceipt(thing);
    }

    /**
     * adds an item to a receipt and takes the current receipt as an argument
     * returns the receipt
     *
     */
    private Receipt addNitem(Receipt aReceipt) throws IOException {
        int quant = 0, price = 0;
        char cmd = 'i';
        String item, sayOne = "Please provide the item name: ", sayTwo = "Please provide the number of items:", sayThree = "Please provide the item price: ", sayFour = "Would you like to create another item record?<y>es/<q>uit";
        while (cmd != 'q') {
            System.out.print(sayOne);
            item = in.nextLine();
            System.out.print(sayTwo);
            quant = in.nextInt();
            System.out.print(sayThree);
            price = in.nextInt();
            Item aItem = new Item(quant, price, item);
            aReceipt.addItem(aItem);
            System.out.println(sayFour);
            cmd = getCmd();
            
            if (cmd == 'y') {
                addNitem(aReceipt);
            }
        }
        return aReceipt;
    }
    
    private void displayAccounts() {
        Iterator<Account> it = accounts.iterator();
        Account current;
        while (it.hasNext()) {
            current = it.next();
            System.out.println(current.getType());
        }
    }
    
    private boolean selectAccount() {
        System.out.println("What account would you like to work with? ");
        displayAccounts();
        String account = in.nextLine();
        Iterator<Account> it = accounts.iterator();
        Account current;
        while (it.hasNext()) {
            current = it.next();
            if (current.getType().toLowerCase().equals(account.toLowerCase())) {
                currAccount = current;
                return true;
            }
        }
        return false;
    }
    /**
     * incomplete search function, actually I think there are some problems with
     * functions I created also because I was unclear about class design.
     *
     * private boolean search(){ String accName, sayOne = "Please provide the
     * account name: "; accName = in.nextLine(); Iterator<Account> it =
     * accounts.iterator(); while(it.hasNext()){ Account curr = it.next();
     * if(curr.) }
     *
     *
     * }
     */
    
}
