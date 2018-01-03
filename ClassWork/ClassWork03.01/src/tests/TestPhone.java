package tests;
import by.it_academy.App;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestPhone extends Assert {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();// для проверки ожидаемых исключений

    @Test
    public void testPhoneNumber1(){
        boolean rezult = App.checkPhoneNumber("+375259717199");
        assertTrue(rezult);
    }
    @Test
    public void testPhoneNumber2(){
        boolean rezult = App.checkPhoneNumber("+375338432310");
        assertTrue(rezult);
    }
    @Test
    public void testPhoneNumber3(){
        boolean rezult = App.checkPhoneNumber("+375459812656");
        assertFalse(rezult);
    }
    @Test
    public void testPhoneNumber4(){  //Проверка на ожидаемые исключения
        expectedException.expect(NullPointerException.class);
        App.checkPhoneNumber(null);

    }
}
