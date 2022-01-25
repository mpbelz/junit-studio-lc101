package test;

import org.junit.Test;

import static main.BalancedBrackets.hasBalancedBrackets;
import static org.junit.Assert.*;

public class BalancedBracketsTest {

    @Test
    public void emptyString(){
        assertEquals(hasBalancedBrackets(""), false);
    }

    @Test
    public void oneChar(){
        assertFalse(hasBalancedBrackets("["));
        assertEquals(hasBalancedBrackets("["), false);
    }

    @Test
    public void noBrackets(){
        assertEquals(hasBalancedBrackets("test"), false);
    }

    @Test
    public void encasingBrackets(){
        assertEquals(hasBalancedBrackets("[launchcode]"), true);
    }

    @Test
    public void nestedBrackets(){
        assertEquals(hasBalancedBrackets("[launch[code]]"), true);
    }

    @Test
    public void twiceNestedBrackets(){
        assertEquals(hasBalancedBrackets("launch[[co][de]]"), true);
    }

    @Test
    public void combinationNestedBrackets(){
        assertEquals(hasBalancedBrackets("[lau[ch][[code]]]"), true);
    }

    @Test
    public void oppositeBrackets(){
        assertEquals(hasBalancedBrackets("launch][code"), false);
    }

    @Test
    public void unclosedBracket(){
        assertEquals(hasBalancedBrackets("[launch][code"), false);
    }

    @Test
    public void unopenedNestedBracket(){
        assertEquals(hasBalancedBrackets("launch][co]][de]"), false);
    }

    @Test
    public void unevenUnopenedNestedBracket(){
        assertEquals(hasBalancedBrackets("launch][co]][de]["), false);
    }

    @Test
    public void unclosedNestedBracket(){
        assertEquals(hasBalancedBrackets("[launch[co][[de]]"), false);
    }
    @Test
    public void unevenUnclosedNestedBracket(){
        assertEquals(hasBalancedBrackets("][launch[co][[de]]"), false);
    }

}