public class Accounts
{
    private Account account;

    public Account getAccount ()
    {
        return account;
    }

    public void setAccount (Account account)
    {
        this.account = account;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [account = "+account+"]";
    }
}
	