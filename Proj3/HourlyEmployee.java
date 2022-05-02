/**
 * a class to define the hourly employee
 * @author Sakin Kirti
 * @since 11/4/2021
 */
public class HourlyEmployee extends Employee {

    // field to store the hourly rate
    private double hourlyRate;
    // field to store the hours worked
    private double hoursWorked;

    /**
     * constructor for hourly employee
     * @param firstname
     * @param lastname
     * @param number
     * @param hourlyRate
     */
    public HourlyEmployee(String firstname, String lastname, String number, double hourlyRate) {
        this.setName(firstname, lastname);
        this.setNumber(number);
        this.hourlyRate = hourlyRate;
    }

    /**
     * method to get the hourly rate
     * @return the hourly rate
     */
    public double getHourlyRate() {
        return this.hourlyRate;
    }

    /**
     * method to set the hourly rate
     * @param rate
     */
    public void setHourlyRate(double rate) {
        this.hourlyRate = rate;
    }

    /**
     * method to get the hours worked
     * @return double hours worked
     */
    public double getHoursWorked() {
        return this.hoursWorked;
    }

    /**
     * method to set the hours worked
     * @param hours
     */
    public void setHoursWorked(double hours) {
        this.hoursWorked = hours;
    }

    /**
     * method to get the salary of the hourly worker
     * @return the amount earned so far
     */
    public double getSalary() {
        return this.getHourlyRate() * this.getHoursWorked();
    }

    /**
     * method to set the hourly rate - just by another metric.
     * this just calls the setHourlyRate method
     * @param rate
     */
    public void setSalary(double rate) {
        this.setHourlyRate(rate);
    }

}
