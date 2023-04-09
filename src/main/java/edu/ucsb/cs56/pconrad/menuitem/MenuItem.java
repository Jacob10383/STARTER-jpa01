package edu.ucsb.cs56.pconrad.menuitem;
import java.math.BigDecimal;

public class MenuItem {

    private String name;
    private int priceInCents;
    private String category;

    public String getName() {
        return this.name;
    }


    public int getPriceInCents() {
        return this.priceInCents;
    }



    /**
     * Custom exception thrown when getPrice is called with a width
     * that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException {
    }


    public MenuItem(String name, int priceInCents, String category) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.category = category;
    }

  

    /**
     * Returns the price, formatted as a string with a $.
     * For example "$0.99", "$10.99", or "$3.50"
     */

     public String getPrice() {
        long priceInCents = getPriceInCents();
        long dollars = priceInCents / 100;
        long cents = priceInCents % 100;
        return String.format("$%d.%02d", dollars, cents);
    }
    

/**
 * Returns the price, formatted as a string with a $,
 * right justified in a field with the specified width.
 * For example "$0.99", "$10.99", or "$3.50".
 * <p>
 * If the width is too small, throws TooNarrowException
 *
 * @param width width of returned string
 */

 public String getPrice(int width) throws TooNarrowException {
    String s = String.format("$%1$,.2f", (double) priceInCents / 100);
    if (s.length() > width) {
        throw new TooNarrowException();
    }
    return String.format("%1$" + width + "s", s);
}

public String  getCategory(){
    return this.category;
}
    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */


    @Override
    public String toString() {
        return name+","+priceInCents+","+category;
    }

}
