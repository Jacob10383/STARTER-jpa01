package edu.ucsb.cs56.pconrad.menuitem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MenuItemTest {

    private MenuItem smallPokeBowl;


    @Test
    public void test_getPrice() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice());
    }
    @Test
    public void test_getPrice_large() {
        smallPokeBowl = new MenuItem("HUGE Poke Bowl", 100049, "Poke Bowls");
        assertEquals("$1000.49", smallPokeBowl.getPrice());
    }

    @Test
    public void test_getPrice_10() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("    $10.49", smallPokeBowl.getPrice(10));
    }

    @Test
    public void test_getPrice_7() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals(" $10.49", smallPokeBowl.getPrice(7));
    }

    @Test
    public void test_getPrice_6() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("$10.49", smallPokeBowl.getPrice(6));
    }

    @Test
    public void test_getPrice_5() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
            smallPokeBowl.getPrice(5);
        });
    }

    @Test
    public void test_getPrice_0() {
        assertThrows(MenuItem.TooNarrowException.class, () -> {
            smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
            smallPokeBowl.getPrice(0);
        });
    }

    @Test
    public void test_toString() {
        smallPokeBowl = new MenuItem("Small Poke Bowl", 1049, "Poke Bowls");
        assertEquals("Small Poke Bowl,1049,Poke Bowls", smallPokeBowl.toString());
    }

}
