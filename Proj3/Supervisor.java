/**
 * abstract class to define a supervisor
 * @author Sakin Kirti
 * @since 11/3/2021
 */
public abstract class Supervisor extends Worker {

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
     * default for salaried supervisors
     * will need overriding for hourly
     * @return the total earned
     */
    public double getAmountEarned() {
        return this.getBonus() + this.getSalary();
    }

    /**
     * method to adjust the pay of a worker
     * default for salaried supervisors
     * will need overriding for hourly
     * @param percent - the percentage increase/decrease of pay
     */
    public void adjustPay(double percent) {
        this.setSalary(this.getSalary() * (percent / 100));
    }

}