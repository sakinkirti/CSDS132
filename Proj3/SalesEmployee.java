public class SalesEmployee extends Employee {

    // field to store the salary
    private double salary;
    // filed to store the commission
    private double commission;
    // field to store the number of sales
    private int numSales;

    /**
     * constructor for SalesSupervisor
     * @param firstname
     * @param lastname
     * @param number
     * @param salary
     * @param commission
     */
    public SalesEmployee(String firstname, String lastname, String number, double salary, double commission) {
        this.setName(firstname, lastname);
        this.setNumber(number);
        this.salary = salary;
        this.commission = commission;
    }

    /**
     * method to get the salary
     * @return double salary of the supervisor
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * method to set the salary
     * @param s - double, the new salary
     */
    public void setSalary(double s) {
        this.salary = s;
    }

    /**
     * method to get the commission
     * @return the commission percentage
     */
    public double getCommission() {
        return this.commission;
    }

    /**
     * method to set the commission
     * @param c
     */
    public void setCommission(double c) {
        this.commission = commission;
    }

    /**
     * method to get the number of sales
     * @return numSales
     */
    public int getNumSales() {
        return this.numSales;
    }

    /**
     * method to set the number of sales
     * @param num
     */
    public void setNumSales(int num) {
        this.numSales = num;
    }

    /**
     * method to get the total amount earned for sales supervisor
     * Overrides the getAmountEarned method in Supervisor
     * @return totalAmount
     */
    @Override
    public double getAmountEarned() {
        return this.getSalary() + (this.getNumSales() * this.getCommission()) + this.getBonus();
    }

    /**
     * method to adjust the commission by a percentage
     * @param percent
     */
    public void adjustPay(double percent) {
        this.setCommission(this.getCommission() * (percent / 100));
    }

}
