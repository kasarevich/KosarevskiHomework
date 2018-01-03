package tests;

import by.it_academy.App;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCar extends Assert{
    App app;

    @Before
    public void before(){
        app = new App();
    }
    @After
    public void after(){
        app = null;
    }

    @Test
    public void testCarNumber1(){
        boolean rezult = App.checkCarNumber("2050 МР-7");
        assertTrue(rezult);
    }
    @Test
    public void testCarNumber2(){
        boolean rezult = App.checkCarNumber("2050 АС-1");
        assertTrue(rezult);
    }
    @Test
    public void testCarNumber3(){
        boolean rezult = App.checkCarNumber("20505 АС-1");
        assertFalse(rezult);
    }
    @Test
    public void testCarNumber4(){
        boolean rezult = App.checkCarNumber("20505 АС-8");
        assertFalse(rezult);
    }
}
