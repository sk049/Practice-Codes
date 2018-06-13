package com.salil.bill;

/**
 * Created by Salil on 22/09/17.
 */
public class PetrolBill {

    static int AMOUNT = 2500;

    public void getLitres(double price){
        double litres = (1/price)*AMOUNT;
        System.out.println("Fuel In Litres : "+ litres);
    }


    /*26,2,9,14,19,23*/

    public static void main(String args[]){
        PetrolBill object = new PetrolBill();
        double priceList[]= {75.19,75.19,75.19,75.19,75.38,78.03};
        for (double price : priceList )
            object.getLitres(price);
    }
}
