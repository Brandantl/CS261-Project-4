/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_5;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.xml.transform.TransformerException;

/**
 *
 * @author Brandan
 */
public class Main {

    public static void main(String[] args) throws IOException, TransformerException {
        // Load
        List<Account> bob = XMLLoader.ReadXML();
        
        // Save
        //XMLLoader.writeXML(bob);
        
        Users asdf = new Users(new Scanner(System.in));
        asdf.runMenu();
    }
}
