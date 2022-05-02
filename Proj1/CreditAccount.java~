/* Sakin Kirti (sak207)
 * represents a credit account that extends Account */
public class CreditAccount extends Account {
  
  /* interest rate for the account */
  private double interestRate;
  /* stores the monthly payment for the account */
  private double monthlyPayment;
  /* stores the amount paid this month */
  private double amountPaidThisMonth;
  
  /* constructor for CreditAccount which creates the credit account class/object */
  public CreditAccount(String an, double ir) {
    super(an, 0);
    
    this.interestRate = ir;
  }
  
  /* sets the new interest rate */
  public void setInterestRate(double r) {
    this.interestRate = r;
  }
  
  /* gets the interest rate */
  public double getInterestRate() {
    return this.interestRate;
  }
  
  /* gets the monthly payment */
  public double getMonthlyPayment() {
    return this.monthlyPayment;
  }
  
  /* gets the amount paid this month */
  public double getAmountPaidThisMonth() {
    return this.amountPaidThisMonth;
  }
  
  /* performs checks and assigns interest if necessary.
   * resets the monthly payment and account balance for the month */
  public void endOfMonth() {
    this.monthlyPayment = this.getCurrentBal();
    if(this.getAmountPaidThisMonth() < this.getMonthlyPayment())
      this.charge( (this.getInterestRate() * this.getCurrentBal()) / 12 );
    
    monthlyPayment = this.getCurrentBal();
    amountPaidThisMonth = 0;
  }
  
  /* overrides account's credit method and creates its own 
   * reduces the current balance and increases the amount paid this month */
  @Override
  public void credit(double c) {
    super.credit(c);
    this.amountPaidThisMonth = this.getAmountPaidThisMonth() + c;
  }
  
}