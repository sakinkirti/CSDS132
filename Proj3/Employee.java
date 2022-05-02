/**
 * abstract class to dictate the employees
 * @author Sakin Kirti
 * @since 11/3/2021
 */
public abstract class Employee extends Worker {

    /** method to get the salary
     * will be different for different supervisors
     * @return salary
     */
    public abstract double getSalary();

    /** method to get the salary
     * will be different for different supervisors
     * @return salary
     */
    public abstract void setSalary(double s);

    /**
     * method to get the amount earned
     * will be different for hourly and salaried workers
     * The default is for regular salaried workers
     * @return the total earned
     */
    public double getAmountEarned() {
        return this.getBonus() + this.getSalary();
    }

    /**
     * method to adjust the pay of a worker
     * will be different for hourly and salaried workers
     * default is for regular salaried workers
     * @param percent - the percentage increase/decrease of pay
     */
    public void adjustPay(double percent) {
        this.setSalary(this.getSalary() * (percent / 100));
    }

}
