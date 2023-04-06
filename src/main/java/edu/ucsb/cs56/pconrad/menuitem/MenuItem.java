package edu.ucsb.cs56.pconrad.menuitem;

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
        return "$"+priceInCents/100+"."+priceInCents%100;
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

    public String getPrice(int width) {
        String s="$"+priceInCents/100+"."+priceInCents%100;;
        if (s.length()>width)
            {throw new TooNarrowException();}
        return s;
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */


    public String  getCategory(){
        return "stub";
    }

    @Override
    public String toString() {
        return "stub";
    }

}
