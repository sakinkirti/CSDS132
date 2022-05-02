/**
 * abstract class to dictate the rest of the workers
 * @author Sakin Kirti
 * @since 11/3/2021
 */
public abstract class Worker {

    // field to store the worker's first name
    private String firstName;
    // field to store the worker's last name
    private String lastName;
    // workerID number
    private String workerNumber;
    // field to store the bonus value
    private double bonus;
    // field to store the supervisor
    private Supervisor supervisor;

    /**
     * method to get the first name of the worker
     * @return string of first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * method to get the last name of the worker
     * @return string of the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * method to set the first and last name
     * @param first - String of first name
     * @param last - String of last name
     */
    public void setName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    /**
     * method to get the workerID number
     * @return String of the id number
     */
    public String getNumber() {
        return this.workerNumber;
    }

    /**
     * method to set the workerID number
     * @return String of the id number
     */
    public void setNumber(String n) {
        this.workerNumber = n;
    }

    /**
     * method to get the bonus of a worker
     * @return the value of the bonus
     */
    public double getBonus() {
        return this.bonus;
    }

    /**
     * method to set the bonus of a worker
     * @param b - the new bonus of the worker
     */
    public void setBonus(double b) {
        this.bonus = b;
    }

    /**
     * method to get the amount earned
     * will be different for hourly and salaried workers
     * @return the total earned
     */
    public abstract double getAmountEarned();

    /**
     * method to adjust the pay of a worker
     * will be different for hourly and salaried workers
     * @param percent - the percentage increase/decrease of pay
     */
    public abstract void adjustPay(double percent);

    /**
     * method to override toString method of Object
     * @return a string that returns the last name, first name, and type of worker
     */
    @Override
    public String toString() {
        // get the current type and save the right text
        String type = "";
        if(this instanceof SalariedEmployee)
            type = "Salaried Employee";
        else if(this instanceof HourlyEmployee)
            type = "Hourly Employee";
        else if(this instanceof SalesEmployee)
            type = "Sales Employee";
        else if(this instanceof SalariedSupervisor)
            type = "Salaried Supervisor";
        else if(this instanceof HourlySupervisor)
            type = "Hourly Supervisor";
        else if(this instanceof SalesSupervisor)
            type = "Sales Supervisor";

        return this.getNumber() + ": " + this.getLastName() + ", " + this.getFirstName() + ", " + type;
    }

    /**
     * method to override equals of Object
     * @param w - the worker that the method compares
     * @return whether the two workers are the same
     */
    public boolean equals(Worker w) {
        if(this.getNumber() == w.getNumber() && this.getFirstName() == w.getFirstName() && this.getLastName() == w.getLastName())
            return true;
        else
            return false;
    }

    /**
     * method to compare the names of employees
     * @param w - the worker that this is comapred to
     * @return negative/0/positive if it is before/exactly/after in alphabetical order
     */
    public int compareToByName(Worker w) {
        // create string for each of the names
        String thisName = this.getLastName() + this.getLastName();
        String wName = w.getLastName() + w.getFirstName();

        // get the minimum length of either name to loop through
        int length = Math.min(thisName.length(), wName.length());

        // loop through the shorter name to find alphabetical order
        for(int i = 0; i < length; i += 1) {
            if(thisName.charAt(i) < wName.charAt(i))
                return -1;
            else if(thisName.charAt(i) > wName.charAt(i))
                return 1;
        }
        return 0;
    }

    /**
     * method to compare the earnings of employees
     * @param w - the worker that earnings are compared to
     * @return negative/0/positive if this earns less/exactly/more than w
     */
    public int compareToByEarnings(Worker w){
        return (int)(this.getAmountEarned() + 0.5) - (int)(w.getAmountEarned() + 0.5);
    }

    /**
     * method to set the supervisor for a worker
     * @param s - the supervisor to set this' supervisor
     */
    public void setSupervisor(Supervisor s) {
        this.supervisor = s;
    }

    /**
     * method to get the supervisor of a worker
     * @return the supervisor of this worker
     */
    public Supervisor getSupervisor() {
        return this.supervisor;
    }

}
