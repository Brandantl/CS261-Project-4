public class User
{
    private String name;

    private Banks banks;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Banks getBanks ()
    {
        return banks;
    }

    public void setBanks (Banks banks)
    {
        this.banks = banks;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", banks = "+banks+"]";
    }
}