package by.it_academy.task3.tests;

import by.it_academy.task3.entity.ATM;
import by.it_academy.task3.entity.ConcreteATM;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangeTest extends Assert { // ConcreteAtm/change
    ATM atm;
    @Before
    public void before(){
        atm = new ConcreteATM("BPS", "IBM");
    }
    @Test
    public void testChange(){
        assertTrue(atm.change(150, false));
    }
    @Test
    public void testChange1(){
        assertTrue(atm.change(160, false));
    }
    @Test
    public void testChange2(){
        assertTrue(atm.change(1780, false));
    }
    @Test
    public void testChange3(){
        assertTrue(atm.change(160, false));
    }
    @Test
    public void testChange4(){
        assertTrue(atm.change(1940, false));
    }
    @Test
    public void testChange5(){
        assertTrue(atm.change(80, false));
    }

    @Test
    public void testChange6(){
        assertFalse(atm.change(10, false));
    }
    @Test
    public void testChange7(){
        assertFalse(atm.change(1155, false));
    }
    @Test
    public void testChange8(){
        assertFalse(atm.change(1599, false));
    }
    @Test
    public void testChange9(){
        assertFalse(atm.change(111, false));
    }
    @Test
    public void testChange10(){
        assertFalse(atm.change(155, false));
    }

@After
    public void after(){
    atm = null;
}
}
