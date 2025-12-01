package ie.atu;

public class BankAccount
{
    private String accNo;
    private String name;
    private double balance;

    public BankAccount(String accNo, String name, double balance)
    {
        if (balance <= 0) {
            throw new IllegalArgumentException("Opening balance must be greater than 0.");
        }
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public BankAccount()
    {
    }

    public String getAccNo()
    {
        return accNo;
    }

    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return balance;
    }

    private void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double deposit(double depositAmount)
    {
        if (depositAmount <= 0.00) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }
        setBalance(getBalance() + depositAmount);
        return getBalance();
    }

    public double withdraw(double withdrawAmount)
    {
        if  (withdrawAmount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0.");
        }
        else if  (getBalance() < withdrawAmount) {
            throw new IllegalArgumentException("Withdrawal amount exceeds current balance. Overdraw facility not "
                    + "authorized");
        }
        else {
            setBalance(getBalance() - withdrawAmount);
            return getBalance();
        }
    }
}
