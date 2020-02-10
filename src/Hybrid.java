/*
Sterling Despanza
Project 2
9 February 2020
Subclass of Automobile.java used for Hybrid vehicle sales tax
 */
public class Hybrid extends Automobile{
    private int mpg;//miles per gallon
    public Hybrid(String make, int purchasePrice, int mpg){
        super(make, purchasePrice);
        this.mpg = mpg;
    }

    @Override
    public double salesTax(int purchasePrice) {
        double salesTax = super.salesTax(purchasePrice);
        if(this.mpg < 40){
            salesTax = salesTax - 100;
        }
        else{
            int difference = this.mpg - 40;
            salesTax = salesTax - 100 - difference * 2;
        }
        return salesTax;
    }

    @Override
    public String toString() {
        return super.toString()  + "Hybrid Vehicle" + "\n" + "Miles Per Gallon: " + this.mpg + "\n";
    }
}
