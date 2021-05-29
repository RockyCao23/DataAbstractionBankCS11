import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTests {
    Customer test;
    Deposit testD;
    Withdraw testW;

    @Before
    public void setUp(){
        test = new Customer("John", 123, 100, 50);
        testD = new Deposit(100, new Date(), "Checking");
        testW = new Withdraw(100, new Date(), "Checking");
    }

    @Test
    public void testDepositToString(){
        String expected = "Deposit of: $" + 100.0 + " Date:" + new Date() + " into account: Checking";
        assertEquals(testD.toString(), expected);
    }
    @Test
    public void testWithdrawToString(){
        String expected = "Withdraw of: $" + 100.0 + " Date:" + new Date() + " into account: Checking";
        assertEquals(testW.toString(), expected);
    }
    @Test
    public void testDeposit(){
        assertEquals(test.getDeposits().size(), 0);
        test.deposit(10, new Date(), "Checking");
        assertEquals(test.getDeposits().size(), 1);


    }
    @Test
    public void testWithdraw(){
        assertEquals(test.getWithdraws().size(), 0);
        test.withdraw(100, new Date(), "Saving");
        assertEquals(test.getWithdraws().size(), 1);
    }


}
