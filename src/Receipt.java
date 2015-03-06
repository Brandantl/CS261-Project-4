public class Receipt
{
    private String total;

    private String store;

    private Items items;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public String getStore ()
    {
        return store;
    }

    public void setStore (String store)
    {
        this.store = store;
    }

    public Items getItems ()
    {
        return items;
    }

    public void setItems (Items items)
    {
        this.items = items;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", store = "+store+", items = "+items+"]";
    }
}