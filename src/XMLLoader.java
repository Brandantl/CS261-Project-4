/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_5;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author brandan
 */
public class XMLLoader {

    public static List<Account> ReadXML() {
        List<Account> accounts = new ArrayList<>();
        try {
            File fXmlFile = new File("main.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            // System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("account");

            // System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Account AccountTmp = null;
                Node nNode = nList.item(temp);

                //System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // Create Account
                    String AccountType = eElement.getAttribute("type");
                    switch (AccountType.toLowerCase()) {
                        case "credit": {
                            String cardnumber = eElement.getElementsByTagName("cardnumber").item(0).getTextContent();
                            AccountTmp = new Credit(cardnumber);
                            break;
                        }
                        case "debit": {
                            // Create Debit Account
                            String cardnumber = eElement.getElementsByTagName("cardnumber").item(0).getTextContent();
                            int pin = Integer.parseInt(eElement.getElementsByTagName("pin").item(0).getTextContent());
                            AccountTmp = new Debit(cardnumber, pin);
                            break;
                        }
                        case "wire":
                            String RoutingNum = eElement.getElementsByTagName("RoutingNum").item(0).getTextContent();
                            AccountTmp = new Wire(RoutingNum);
                            break;
                        case "loan":
                            Integer Balance = Integer.parseInt(eElement.getElementsByTagName("Balance").item(0).getTextContent());
                            String Bank = eElement.getElementsByTagName("bank").item(0).getTextContent();
                            Integer Current_Payment = Integer.parseInt(eElement.getElementsByTagName("Current_Payment").item(0).getTextContent());
                            AccountTmp = new Loan(Balance, Bank, Current_Payment);
                            break;
                    }
                    NodeList nList2 = eElement.getElementsByTagName("receipt");
                    int wtf = nList2.getLength();
                    for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
                        Node nNode2 = nList2.item(temp2);
                        // System.out.println("\nCurrent Element :" + nNode2.getNodeName());
                        if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                            eElement = (Element) nNode2;
                            Receipt ReceiptTmp = new Receipt();
                            ReceiptTmp.setStorename(eElement.getAttribute("store"));
                            ReceiptTmp.setTotal(Integer.parseInt(eElement.getAttribute("total")));

                            NodeList nList3 = eElement.getElementsByTagName("item");

                            for (int temp3 = 0; temp3 < nList3.getLength(); temp3++) {
                                Node nNode3 = nList3.item(temp3);
                                if (nNode3.getNodeType() == Node.ELEMENT_NODE) {
                                    eElement = (Element) nNode3;

                                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                                    int Price = Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent());
                                    int quantity = Integer.parseInt(eElement.getElementsByTagName("quantity").item(0).getTextContent());
                                    Item ItemTmp = new Item(quantity, Price, name);
                                    ReceiptTmp.addItem(ItemTmp);
                                }
                            }
                            AccountTmp.addReceipt(ReceiptTmp);
                        }
                        accounts.add(AccountTmp);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
        }
        return accounts;
    }

    public static void writeXML(List<Account> accounts) throws TransformerConfigurationException, TransformerException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("user");
            doc.appendChild(rootElement);

            Iterator<Account> it = accounts.iterator();
            Account current;
            while (it.hasNext()) {
                current = it.next();

                Element staff = doc.createElement("account");
                rootElement.appendChild(staff);

                // set attribute to account element
                Attr attr = doc.createAttribute("type");
                attr.setValue(current.getType());
                staff.setAttributeNode(attr);

                switch (current.getType().toLowerCase()) {
                    case "credit":
                        Element cc = doc.createElement("cardnumber");
                        cc.appendChild(doc.createTextNode(((Credit) current).getCardNumber()));
                        staff.appendChild(cc);
                        break;
                    case "debit":
                        Element creditcard = doc.createElement("cardnumber");
                        creditcard.appendChild(doc.createTextNode(((Debit) current).getCardNumber()));
                        staff.appendChild(creditcard);
                        Element pin = doc.createElement("pin");
                        pin.appendChild(doc.createTextNode(((Debit) current).getPIN()));
                        staff.appendChild(pin);
                        break;
                    case "wire":
                        Element routing = doc.createElement("RoutingNum");
                        routing.appendChild(doc.createTextNode(((Wire) current).getAccountNum()));
                        staff.appendChild(routing);
                        break;
                    case "loan":
                        Element Bal = doc.createElement("Balance");
                        Bal.appendChild(doc.createTextNode(Integer.toString(((Loan) current).getBalance())));
                        staff.appendChild(Bal);
                        Element Int_Rate = doc.createElement("bank");
                        Int_Rate.appendChild(doc.createTextNode(((Loan) current).getBank()));
                        staff.appendChild(Int_Rate);
                        Element C_Payment = doc.createElement("Current_Payment");
                        C_Payment.appendChild(doc.createTextNode(Integer.toString(((Loan) current).getCurrPay())));
                        staff.appendChild(C_Payment);
                        break;
                }

                List<Receipt> receipts = current.getList();
                Iterator<Receipt> its = receipts.iterator();
                Receipt current2;
                while (its.hasNext()) {
                    current2 = its.next();
                    Element recepit = doc.createElement("receipt");
                    rootElement.appendChild(recepit);

                    attr = doc.createAttribute("store");
                    attr.setValue(current2.getStorename());
                    recepit.setAttributeNode(attr);

                    attr = doc.createAttribute("total");
                    attr.setValue(Integer.toString(current2.getTotal()));
                    recepit.setAttributeNode(attr);

                    List<Item> Items = current2.getList();
                    Iterator<Item> its2 = Items.iterator();
                    Item current3;
                    while (its2.hasNext()) {
                        current3 = its2.next();
                        Element item = doc.createElement("item");
                        rootElement.appendChild(item);

                        Element firstname = doc.createElement("name");
                        firstname.appendChild(doc.createTextNode(current3.getName()));
                        item.appendChild(firstname);

                        Element lastname = doc.createElement("price");
                        lastname.appendChild(doc.createTextNode(Integer.toString(current3.getPrice())));
                        item.appendChild(lastname);

                        Element nickname = doc.createElement("quantity");
                        nickname.appendChild(doc.createTextNode(Integer.toString(current3.getQuantity())));
                        item.appendChild(nickname);
                        recepit.appendChild(item);
                    }
                    staff.appendChild(recepit);
                }
            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("main.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException pce) {
        }
    }
}
