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
}
