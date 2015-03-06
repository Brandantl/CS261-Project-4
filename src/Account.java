public class Account
{
    private String Interest_Rate;

    private String RoutingNum;

    private String Mimumium_Payment;

    private String Current_Payment;

    private String pin;

    private String cardnumber;

    private String type;

    private String Balance;

    public String getInterest_Rate ()
    {
        return Interest_Rate;
    }

    public void setInterest_Rate (String Interest_Rate)
    {
        this.Interest_Rate = Interest_Rate;
    }

    public String getRoutingNum ()
    {
        return RoutingNum;
    }

    public void setRoutingNum (String RoutingNum)
    {
        this.RoutingNum = RoutingNum;
    }

    public String getMimumium_Payment ()
    {
        return Mimumium_Payment;
    }

    public void setMimumium_Payment (String Mimumium_Payment)
    {
        this.Mimumium_Payment = Mimumium_Payment;
    }

    public String getCurrent_Payment ()
    {
        return Current_Payment;
    }

    public void setCurrent_Payment (String Current_Payment)
    {
        this.Current_Payment = Current_Payment;
    }

    public String getPin ()
    {
        return pin;
    }

    public void setPin (String pin)
    {
        this.pin = pin;
    }

    public String getCardnumber ()
    {
        return cardnumber;
    }

    public void setCardnumber (String cardnumber)
    {
        this.cardnumber = cardnumber;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getBalance ()
    {
        return Balance;
    }

    public void setBalance (String Balance)
    {
        this.Balance = Balance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Interest_Rate = "+Interest_Rate+", RoutingNum = "+RoutingNum+", Mimumium_Payment = "+Mimumium_Payment+", Current_Payment = "+Current_Payment+", pin = "+pin+", cardnumber = "+cardnumber+", type = "+type+", Balance = "+Balance+"]";
    }
}