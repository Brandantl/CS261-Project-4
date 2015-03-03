/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kalebstriplin
 */
public class Debit extends Account {
    private String cardNumber;
    private Integer PIN;
    
    
    public String getType() {
        return "Debit";
    }
}
