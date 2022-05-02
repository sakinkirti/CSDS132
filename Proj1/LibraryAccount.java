/* Sakin Kirti (sak207)
 * represents a library account which extends the basic account */
public class LibraryAccount extends Account {
  
  /* create var to hold the book fine */
  private double bookFine;
  /* create var to hold the reserve fine */
  private double reserveFine;
  /* create var to hold the num of overdue books */
  private int numOverdueBooks;
  /* create var to hold num of overdue books in reserve */
  private int numOverdueReserve;
  
  /* constructor to set up the object */
  public LibraryAccount(String accountNum, int balanceLim, double bookFine, double reservedItemFine) {
    super(accountNum, balanceLim);
    
    this.bookFine = bookFine;
    this.reserveFine = reservedItemFine;
  }
  
  /* sets the book fine */
  public void setBookFine(double d) {
    this.bookFine = d;
  }
  
  /* gets the book fine */
  public double getBookFine() {
    return this.bookFine;
  }
  
  /* sets the reserve fine */
  public void setReserveFine(double d) {
    this.reserveFine = d;
  }
  
  /* gets the reserve fine */
  public double getReserveFine() {
    return this.reserveFine;
  }
  
  /* gets the number of overdue books */
  public int getNumberOverdueBooks() {
    return this.numOverdueBooks;
  }
  
  /* gets the number of overdue reserve */
  public int getNumberOverdueReserve() {
    return this.numOverdueReserve;
  }
  
  /* increases the number of overdue books when needed */
  public void incrementOverdueBooks() {
    numOverdueBooks = this.getNumberOverdueBooks() + 1;
  }
  
  /* decreases the number of overdue books when needed */
  public void decrementOverdueBooks() {
    numOverdueBooks = this.getNumberOverdueBooks() - 1;
  }
  
  /* increases the number of overude reserve books when needed */
  public void incrementOverdueReserve() {
    numOverdueReserve = this.getNumberOverdueReserve() + 1;
  }
  /* decreases the number of overdue reserve books when needed */
  public void decrementOverdueReserve() {
    numOverdueReserve = this.getNumberOverdueReserve() - 1;
  }
  
  /* checks to see if you can borrow a book */
  public boolean canBorrow() {
    if (this.getBookFine() + this.getReserveFine() <= super.getBalanceLim())
      return true;
    else
      return false;
  }
  
  /* readjusts the balance at the end of the day */
  public void endOfDay() {
    super.charge( (this.getNumberOverdueBooks() * this.getBookFine()) 
      + (this.getNumberOverdueReserve() * this.getReserveFine()) );
  }
  
}