public class Banks
{
    private Bank bank;

    public Bank getBank ()
    {
        return bank;
    }

    public void setBank (Bank bank)
    {
        this.bank = bank;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [bank = "+bank+"]";
    }
}