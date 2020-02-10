/*
Sterling Despanza
Project 2
9 February 2020
Automobile is the superclass to Hybrid and Electric. Calculates sales tax of automobile
 */
public class Automobile {
    private String make;
    private int purchasePrice;
    public Automobile(String make, int purchasePrice){
        this.make = make;
        this.purchasePrice = purchasePrice;
    }
    public double salesTax(int purchasePrice){
        double salesTax;
        salesTax = purchasePrice * .05;//equation to find sales tax
        return salesTax;
    }
    public String toString(){
        String stval;
        stval = "Make and Model: " + this.make + "\n" + "Sales Price: " + this.purchasePrice + "\n" + "Sales Tax: " + salesTax(this.purchasePrice) + "\n" ;
        return stval;
    }

}
