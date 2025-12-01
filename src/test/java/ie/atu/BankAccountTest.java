package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest
{
    BankAccount account;

    @BeforeEach
    public void setUp()
    {
        account = new BankAccount();
    }

    @Test
    void constructor_InitValidInput_Success()
    {
        account = new BankAccount("ACC12345", "Jeff", 100);
        assertEquals("ACC12345", account.getAccNo());
        assertEquals("Jeff", account.getName());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructor_InitNegativeBalance_ThrowsException()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new BankAccount("ACC12345",
                "Jeff", -100));
        assertEquals("Opening balance must be greater than 0.", ex.getMessage());
    }

}
