/* Sakin Kirti (sak207)
 * creates class to track student's finances, extends Account
 * uses a combination a library account and 2 credit accounts */
public class StudentAccount extends Account {
  
  /* students name */
  private String name;
  /* stores the student's address */
  private String address;
  /* creates a new library account for the student */
  private LibraryAccount libraryAccount;
  /* creates a new credit account for the student's tuition */
  private CreditAccount tuitionAccount;
  /* creates a new credit account for the student's dining */
  private CreditAccount diningAccount;
  /* refund amount for student */
  private double refund;
  
  /* constructor to create a student account */
  public StudentAccount(String an, String n) {
    super(an, 0);
    this.name = n;
  }
  
  /* sets the student's name */
  public void setName(String n) {
    this.name = n;
  }
  
  /* get's the student's name */
  public String getName() {
    return this.name;
  }
  
  /* set's the student's address */
  public void setAddress(String a) {
    this.address = a;
  }
  
  /* gets the student's address */
  public String getAddress() {
    return this.address;
  }
  
  /* creates the library account for the student */
  public void setLibraryAccount(LibraryAccount l) {
    this.libraryAccount = l;
  }
  
  /* returns the library account associated with the student */
  public LibraryAccount getLibraryAccount() {
    return this.libraryAccount;
  }
  
  /* creates the tuition account for the student */
  public void setTuitionAccount(CreditAccount t) {
    this.tuitionAccount = t;
  }
  
  /* returns the tuition account for the student */
  public CreditAccount getTuitionAccount() {
    return this.tuitionAccount;
  }
  
  /* creates the dining account for the student */
  public void setDiningAccount(CreditAccount d) {
    this.diningAccount = d;
  }
  
  /* returns the dining account for the student */
  public CreditAccount getDiningAccount() {
    return this.diningAccount;
  }
  
  /* new getBalance method that sums the balance of all 3 accounts */
  @Override
  public double getCurrentBal() {
    // creates a temporary variable to store the total current balance
    double currentBal = 0;
    
    // checks if each account exists and adds the current balance from each to the sum var
    if(libraryAccount instanceof LibraryAccount)
      currentBal = currentBal + libraryAccount.getCurrentBal();
    if(diningAccount instanceof CreditAccount)
      currentBal = currentBal + diningAccount.getCurrentBal();
    if(tuitionAccount instanceof CreditAccount)
      currentBal = currentBal + tuitionAccount.getCurrentBal();
    
    // reduces the current balance by the refund
    currentBal = currentBal - this.refund;
    
    return currentBal;
  }
  
  /* overrides the charge method of Account with a new charge method */
  @Override
  public void charge(double c) {
    c = c - this.refund;
    
    if(c > 0 && tuitionAccount instanceof CreditAccount)
      tuitionAccount.charge(c);
    else
      this.refund = this.refund - c;
  }
  
  /* overrides the credit method of Account with a new credit method */
  @Override
  public void credit(double d) {
    
    // if credited amount is negative, call the charge method with the credited value
    if(d <= 0) {
      charge(d);
      d = 0;
    }
    
    // checks if account exists and subtracts the right amount
    if(tuitionAccount instanceof CreditAccount) {
      if(d > tuitionAccount.getCurrentBal()) {
        d = d - tuitionAccount.getCurrentBal();
        tuitionAccount.credit(tuitionAccount.getCurrentBal());
      }
      else if(d <= tuitionAccount.getCurrentBal() && d > 0.0) {
        tuitionAccount.credit(d);
        d = 0.0;
      }
    }
    
    // checks if account exists and subtracts the right amount
    if(diningAccount instanceof CreditAccount) {
      if(d > diningAccount.getCurrentBal()) {
        d = d - diningAccount.getCurrentBal();
        diningAccount.credit(diningAccount.getCurrentBal());
      }
      else if(d <= diningAccount.getCurrentBal() && d > 0.0) {
        diningAccount.credit(d);
        d = 0.0;
      }
    }
    
    // checks if account exists and subtracts the right amount
    if(libraryAccount instanceof LibraryAccount) {
      if(d > libraryAccount.getCurrentBal()) {
        this.refund = this.refund + (d - libraryAccount.getCurrentBal());
        libraryAccount.credit(libraryAccount.getCurrentBal());
      }
      else if(d <= libraryAccount.getCurrentBal() && d > 0.0) {
        libraryAccount.credit(d);
      }
    }
    
  }
  
}