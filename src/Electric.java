/*
Sterling Despanza
Project 2
9 February 2020
Subclass of Automobile.java used for Electric vehicle sales tax
 */

public class Electric extends Automobile {
    private int weight;//weight as pounds

    public Electric(String make, int purchasePrice, int weight) {
        super(make, purchasePrice);
        this.weight = weight;
    }

    @Override
    public double salesTax(int purchasePrice) {
        double salesTax = super.salesTax(purchasePrice);

        if (this.weight < 3000){
            salesTax = salesTax - 200;
        }
        else{
            salesTax= salesTax - 150;
        }
        return salesTax;
    }

    @Override
    public String toString() {
        return super.toString() + "Electric Vehicle" + "\n" + "Weight: " + this.weight + "\n";
    }
}
