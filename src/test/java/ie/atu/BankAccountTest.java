package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest
{
    BankAccount account;

    @BeforeEach
    public void setUp()
    {
        account = new BankAccount("ACC12345", "Jeff", 100);
    }

    @Test
    void constructor_InitDefault_Success()
    {
        account = new BankAccount();
        assertEquals("", account.getAccNo());
        assertEquals("", account.getName());
        assertEquals(0, account.getBalance());
    }

    @Test
    void constructor_InitValidInput_Success()
    {
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

    @Test
    void deposit_PositiveAmount_IncreasedBalance()
    {
        assertEquals(100.01, account.deposit(0.01));
        assertEquals(101.01, account.deposit(1.00));
        assertEquals(201.01, account.deposit(100));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -200})
    void deposit_NegativeAmount_ThrowsException(double illegalAmount)
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(illegalAmount));
        assertEquals("Deposit amount must be greater than 0.", ex.getMessage());
    }

    @Test
    void withdraw_PositiveAmount_ReducedBalance() {
        assertEquals(99.99, account.withdraw(0.01));
        assertEquals(98.99, account.withdraw(1.00));
        assertEquals(88.99, account.withdraw(10.00));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -200})
    void withdraw_NegativeAmount_ThrowsException(double illegalAmount) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(illegalAmount));
        assertEquals("Withdraw amount must be greater than 0.", ex.getMessage());
    }

    @Test
    void withdraw_OverdrawnAmount_ThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> account.withdraw(110));
        assertEquals("Withdrawal amount exceeds current balance. Overdraw facility not authorized",
                ex.getMessage());
    }
}