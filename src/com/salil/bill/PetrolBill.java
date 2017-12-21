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


    public static void main(String args[]){
        PetrolBill object = new PetrolBill();
        double priceList[]= {68.62,69.05,69.75,69.77,69.56,69.36 };
        for (double price : priceList )
            object.getLitres(price);
    }
}
