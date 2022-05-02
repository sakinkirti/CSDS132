/**
 * a class to define the salaried employee
 * @author Sakin Kirti
 * @since 11/4/2021
 */
public class SalariedEmployee extends Employee {

    // field to hold the salary
    private double salary;

    /**
     * constructor for the salaried employee
     * @param firstName - string
     * @param lastName - string
     * @param number - string
     * @param salary - double
     */
    public SalariedEmployee(String firstName, String lastName, String number, double salary) {
        this.setName(firstName, lastName);
        this.setNumber(number);
        this.salary = salary;
    }

    /**
     * method to get the salary of the salaried employee
     * @return salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * method to set the salary of the salaried employee
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
