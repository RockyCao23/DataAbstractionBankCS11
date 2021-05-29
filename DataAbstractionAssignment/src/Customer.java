import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //Default Constructor
    Customer(){
        accountNumber = 0;
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "Mr. Default";

    }
    //Constructor with parameters
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance += checkDeposit;
        this.savingBalance += savingDeposit;

    }
    //Requires: amount, date, account
    //Effects: creates a new Deposit object, inserts that into deposits, returns amount
    //Modifies: updates account value
    public double deposit(double amt, Date date, String account){
        if (account.equals(CHECKING)){
            Deposit d = new Deposit(amt, date, CHECKING);
            checkBalance += amt;
            deposits.add(d);
            return amt;
        }else if (account.equals(SAVING)){
            Deposit d = new Deposit(amt, date, SAVING);
            savingBalance += amt;
            deposits.add(d);
            return amt;
        }

        return 0;
    }
    //Requires: amount, date, account
    //Effects: If balance after withdraw is not under Overdraft value, then creates a new
    //Withdraw object and inserts that into withdraws, returns amount,or returns 0 if under
    //Overdraft Value.
    //Modifies: Updates account values
    public double withdraw(double amt, Date date, String account){

        if (account.equals(CHECKING)){
            if (checkBalance - amt >= OVERDRAFT) {
                Withdraw w = new Withdraw(amt, date, CHECKING);
                checkBalance -= amt;
                withdraws.add(w);
                return amt;
            }
        }else if (account.equals(SAVING)){
            if (savingBalance - amt >= OVERDRAFT) {
                Withdraw w = new Withdraw(amt, date, SAVING);
                savingBalance -= amt;
                withdraws.add(w);
                return amt;
            }
        }

        return 0;
    }
    //Requires: amount, account
    //effects: checks type of account, and returns true if the amount withdrawn from account will be
    //overdraft, or returns false if it will not be an overdraft
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)){
            if (checkBalance - amt <=  OVERDRAFT){
                return true;
            }else {
                withdraw(amt, new Date(), account);
                return false;
            }
        }
        else if (account.equals(SAVING)){
            if (savingBalance - amt <= OVERDRAFT){
                return true;
            }else {
                withdraw(amt, new Date(), account);
                return false;//not an overdraft
            }
        }return false;
    }
    //do not modify
    //Effect: calls ToString method for each object in deposits
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    //Effect: calls ToString method for each object in withdraws
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }
    //Effect: returns deposits
    public ArrayList<Deposit> getDeposits(){
        return deposits;
    }
    //Effect: returns withdraws
    public ArrayList<Withdraw> getWithdraws(){
        return withdraws;
    }

    public static void main(String[] args) {

    }

}
