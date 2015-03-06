public class Bank
{
    private Accounts accounts;

    private Receipts recepts;

    private String name;

    public Accounts getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (Accounts accounts)
    {
        this.accounts = accounts;
    }

    public Receipts getRecepts ()
    {
        return recepts;
    }

    public void setRecepts (Receipts recepts)
    {
        this.recepts = recepts;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [accounts = "+accounts+", recepts = "+recepts+", name = "+name+"]";
    }
}