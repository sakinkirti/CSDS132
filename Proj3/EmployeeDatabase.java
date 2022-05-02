/**
 * class that creates the employee database and allows user to read and write users in/out
 * @author Sakin Kirti
 * @since 11/4/2021
 */
public class EmployeeDatabase {

    // field to store the database for workers
    LinkedList<Worker> database;

    /**
     * constructor for EmployeeDatabase
     */
    public EmployeeDatabase() {
        database = new LinkedList<Worker>();
    }

    /**
     * method to let the user add a new worker to the database
     * @param w - the worker to be added
     */
    public void add(Worker w) {
        database.addToFront(w);
    }

    /**
     * method to remove a user by several parameters
     * @param firstname
     * @param lastname
     * @param number
     */
    public LLNode<Worker> remove(String firstname, String lastname, String number) throws NoSuchEmployeeException {

        // if the database is empty, throw an exception
        if(database.isEmpty())
            throw new NoSuchEmployeeException();
        // otherwise, loop through the database to find the previous worker
        else{
            LLNode<Worker> nodePointer = database.getFirstNode();
            LLNode<Worker> prevNode = null;

            while(nodePointer != null) {
                if(nodePointer.getElement().getFirstName() == firstname && nodePointer.getElement().getLastName() == lastname && nodePointer.getElement().getNumber() == number) {
                    // if the previous node is null, you are at the beginning of the list. So, set the first node to the second node
                    if(prevNode == null)
                        database.setFirstNode(nodePointer.getNext());
                    // otherwise, you are not the first node, set the previous node's next to this node's next
                    else
                        prevNode.setNext(nodePointer.getNext());
                    // return the node pointer
                    return nodePointer;
                }
                prevNode = nodePointer;
                nodePointer = nodePointer.getNext();
            }
            // if loops through entire database and no employee found, throw exception
            throw new NoSuchEmployeeException();
        }

    }

    /**
     * method to find an employee of interest
     * @param firstname
     * @param lastname
     * @param number
     */
    public LLNode<Worker> find(String firstname, String lastname, String number) throws NoSuchEmployeeException {
        // if the database is empty, throw an exception
        if(database.isEmpty())
            throw new NoSuchEmployeeException();
        // otherwise, loop through the database to find the worker
        else{
            LLNode<Worker> nodePointer = database.getFirstNode();
            while(nodePointer != null) {
                if(nodePointer.getElement().getFirstName() == firstname && nodePointer.getElement().getLastName() == lastname && nodePointer.getElement().getNumber() == number)
                    return nodePointer;

                nodePointer = nodePointer.getNext();
            }
            // if loops through entire database and no employee found, throw exception
            throw new NoSuchEmployeeException();
        }
    }

    /**
     * method to get the total amount earned from all workers
     * @return double of total amount earned
     */
    public double getPayrollAmount() {
        // if the database is empty, there are no workers to pay, so return 0
        if(database.isEmpty())
            return 0;
        // otherwise, loop through the database and add all the payroll amounts
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            double totalPayroll = 0;

            while(nodePointer != null) {
                totalPayroll += nodePointer.getElement().getAmountEarned();
                nodePointer = nodePointer.getNext();
            }
            return totalPayroll;
        }
    }

    /**
     * method to get the employee/supervisor with the largest earnings
     * @return Worker or null
     */
    public Worker getMaximumEarned() {
        // if the database is empty, there are no workers to pay, so return null
        if(database.isEmpty())
            return null;
        // otherwise, loop through the database and find the highest paid
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            Worker highestPaid = database.getFirstNode().getElement();

            while(nodePointer != null) {
                // check to see if the node pointer's element get's paid more - if so, change highestPaid to this element
                if(highestPaid.getAmountEarned() <= nodePointer.getElement().getAmountEarned())
                    highestPaid = nodePointer.getElement();

                nodePointer = nodePointer.getNext();
            }
            return highestPaid;
        }
    }

    /**
     * method to get the employee/supervisor with the lowest earnings
     * @return Worker or null
     */
    public Worker getMinimumEarned() {
        // if the database is empty, there are no workers to pay, so return null
        if(database.isEmpty())
            return null;
        // otherwise, loop through the database and find the highest paid
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            Worker lowestPaid = database.getFirstNode().getElement();

            while(nodePointer != null) {
                // check to see if the node pointer's element get's paid more - if so, change highestPaid to this element
                if(lowestPaid.getAmountEarned() >= nodePointer.getElement().getAmountEarned())
                    lowestPaid = nodePointer.getElement();

                nodePointer = nodePointer.getNext();
            }
            return lowestPaid;
        }
    }

    /**
     * method to get the salesperson with the highest number of sales
     * @return sales supervisor or sales employee
     */
    public Worker getMaxSales() {
        // if the database is empty, there are no workers to pay, so return null
        if(database.isEmpty())
            return null;
        // otherwise, loop through the database and find the salesperson with the highest number of sales
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            Worker mostSales = database.getFirstNode().getElement();

            while(nodePointer != null) {

                // check to make sure that both the mostSales and nodePointer point to salespeople
                if( (mostSales instanceof SalesEmployee || mostSales instanceof SalesSupervisor) &&
                    (nodePointer.getElement() instanceof SalesEmployee || nodePointer.getElement() instanceof SalesSupervisor) ) {

                    // check to see if the node pointer's element has more sales - if so, change mostSales to this element
                    if( (mostSales.getClass())(mostSales).getNumSales() <= (mostSales.getClass())(nodePointer.getElement()).getNumSales() ) {
                        mostSales = nodePointer.getElement();
                    }
                }

                // set node pointer to the next node
                nodePointer = nodePointer.getNext();
            }
            return mostSales;
        }
    }

    /**
     * method to get the salesperson with the least number of sales
     * @return sales supervisor or sales employee
     */
    public Worker getMinSales() {
        // if the database is empty, there are no workers to pay, so return null
        if(database.isEmpty())
            return null;
            // otherwise, loop through the database and find the salesperson with the highest number of sales
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            Worker minSales = database.getFirstNode().getElement();

            while(nodePointer != null) {

                // check to make sure that both the mostSales and nodePointer point to salespeople
                if( (minSales instanceof SalesEmployee || minSales instanceof SalesSupervisor) &&
                        (nodePointer.getElement() instanceof SalesEmployee || nodePointer.getElement() instanceof SalesSupervisor) ) {

                    // check to see if the node pointer's element has fewer sales - if so, change mostSales to this element
                    if((minSales.getClass())(minSales).getNumSales() >= (minSales.getClass())(nodePointer.getElement()).getNumSales())
                        minSales = nodePointer.getElement();
                }

                // set node pointer to the next node
                nodePointer = nodePointer.getNext();
            }
            return minSales;
        }
    }

    /**
     * method to get the salesperson with the highest number of hours worked
     * @return hourly employee or supervisor
     */
    public Worker getMaxHoursWorked() {
        // if the database is empty, there are no workers, so return null
        if(database.isEmpty())
            return null;
        // otherwise, loop through the database and find the hourly worker with the most hours
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            Worker mostHours = database.getFirstNode().getElement();

            while(nodePointer != null) {

                // check to make sure that both the mostSales and nodePointer point to salespeople
                if( (mostHours instanceof HourlyEmployee || mostHours instanceof HourlySupervisor) &&
                        (nodePointer.getElement() instanceof HourlyEmployee || nodePointer.getElement() instanceof HourlySupervisor) ) {

                    // check to see if the node pointer's element has more sales - if so, change mostSales to this element
                    if((mostHours.getClass())(mostHours).getHoursWorked() <= (mostHours.getClass())(nodePointer.getElement()).getHoursWorked1())
                        mostHours = nodePointer.getElement();
                }

                // set node pointer to the next node
                nodePointer = nodePointer.getNext();
            }
            return mostHours;
        }
    }

    /**
     * method to get the salesperson with the least number of hours worked
     * @return hourly employee or supervisor
     */
    public Worker getMinHoursWorked() {
        // if the database is empty, there are no workers, so return null
        if(database.isEmpty())
            return null;
        // otherwise, loop through the database and find the hourly worker with the least hours
        else {
            LLNode<Worker> nodePointer = database.getFirstNode();
            Worker leastHours = database.getFirstNode().getElement();

            while(nodePointer != null) {

                // check to make sure that both the mostSales and nodePointer point to salespeople
                if( (leastHours instanceof HourlyEmployee || leastHours instanceof HourlySupervisor) &&
                        (nodePointer.getElement() instanceof HourlyEmployee || nodePointer.getElement() instanceof HourlySupervisor) ) {

                    // check to see if the node pointer's element has more sales - if so, change mostSales to this element
                    if((leastHours.getClass())(leastHours).getHoursWorked() >= (leastHours.getClass())(nodePointer.getElement()).getHoursWorked1())
                        leastHours = nodePointer.getElement();
                }

                // set node pointer to the next node
                nodePointer = nodePointer.getNext();
            }
            return leastHours;
        }
    }

    /**
     * method that gets the supervisees of a supervisor object
     * @param s
     * @return an array of the workers that this supervisor oversees
     */
    public Worker[] getSupervisees(Supervisor s) {

        // loop through the database to find supervisors
        LLNode<Worker> nodePointer = database.getFirstNode();
        Worker[] supervisees = new Worker[0];
        Worker[] newSupervisees = null;

        while(nodePointer != null) {
            // check if the nodePointer's supervisor is the supervisor we are looking for
            if(nodePointer.getElement().getSupervisor() == s) {
                newSupervisees = new Worker[supervisees.length + 1];

                // iterate through the supervisees array to copy the elements
                int ind = 0;
                for(Worker worker : supervisees) {
                    newSupervisees[ind] = worker;
                    ind += 1;
                }
                // copy the new supervisee into the array
                newSupervisees[ind] = nodePointer.getElement();
                supervisees = newSupervisees;
            }
            // increment nodePointer
            nodePointer = nodePointer.getNext();
        }
        return newSupervisees;
    }

    /** ---------------------------------------------------------------------------------------------------------------
     * class that defines the exception thrown when an employee cannot be found
     */
    public class NoSuchEmployeeException extends Throwable {
        /**
         * constructor for the exception
         */
        public NoSuchEmployeeException() {
            super("No Worker with those credentials found");
        }
    }

}
