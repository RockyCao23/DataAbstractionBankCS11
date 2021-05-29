import java.util.Date;

public class Deposit {
    //Fields
    private double amount;
    private Date date;
    private String account;

    //Constructor with Parameters
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //Effect: Overrides toString method and print out this
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date:" + date + " into account: " + account;
    }
}
