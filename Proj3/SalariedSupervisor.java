/**
 * class to define a salaried supervisor
 * @author Sakin Kirti
 * @since 11/03/21
 */
public class SalariedSupervisor extends Supervisor {

    // field to store the salary
    private double salary;

    /**
     * constructor for SalariedSupervisor
     * @param firstName - string
     * @param lastName - string
     * @param number - String
     * @param salary - double
     */
    public SalariedSupervisor(String firstName, String lastName, String number, double salary) {
        this.setName(firstName, lastName);
        this.setNumber(number);
        this.setSalary(salary);
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

}
