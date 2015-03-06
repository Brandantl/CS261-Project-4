                 
public class Receipts
{
    private Receipt recept;

    public Receipt getRecept ()
    {
        return recept;
    }

    public void setRecept (Receipt recept)
    {
        this.recept = recept;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [recept = "+recept+"]";
    }
}
			
	