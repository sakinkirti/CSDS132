/* Sakin Kirti (sak207)
 * represents the Account class which is a general account */
public class Account {
  
  // account Number variable
  private final String accountNum;
  // current balance variable
  private double currentBal;
  // balance limit for the account
  private int balanceLim;
  
  /* constructor that creates the class and then initializes the vars */
  public Account(String accNum, int balLim) {
    this.accountNum = accNum;
    this.balanceLim = balLim;
  }
  
  /* returns accountNum */
  public String getAccountNum() {
    return this.accountNum;
  }
  
  /* returns currentBal */
  public double getCurrentBal() {
    return this.currentBal;
  }
  
  /* returns balanceLim */
  public int getBalanceLim() {
    return this.balanceLim;
  }  
  
  /* sets the balanceLim value */
  public void setBalanceLim(int balanceLim) {
    this.balanceLim = balanceLim;
  }
  
  /* method to charge the student */
  public void charge(double c) {
    this.currentBal = this.getCurrentBal() + c;
  }
  
  /* method to credit the student */
  public void credit(double c) {
    this.currentBal = this.getCurrentBal() - c;
  }
  
}