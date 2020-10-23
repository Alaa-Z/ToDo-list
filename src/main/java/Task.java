import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Represents the tasks that enrolled in every project.
 * to create task with specific name, due date and status
 */

public class Task implements Comparable<Task>, Serializable {
    /**
     * The given title for the tasks.
     */
    private StringBuilder title = new StringBuilder();
    /**
     * The given dead line for the tasks.
     */
    private LocalDate date;
    /**
     * The initial state for every task
     */
    private boolean status = false;

    /**
     * Get the task title
     * @return title string representing the task title
     */
    public String getTitle(){
        return title.toString();
    }

    /**
     *  Set the task title
     * @param 'string' representing the task title
     */
    public void setTitle(String t){
        title.setLength(0);
        title.append(t);
    }

    /**
     * To show the status of the task
     */
    public void showStatus(){
        if (status == true)
            System.out.println("Task done!");
        else
            System.out.println("Task in progress!");
    }

    /**
     *  Get the task due date
     * @return taskDate Task' due date as string
     */
    public String getDate(){
        return date.toString();
    }

    /**
     * @param date String representing the due date
     * @throws DateTimeException if the entered date has passed
     */

    public void setDate(String date) throws DateTimeException {

        // Enter the date in this format only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate taskDate = LocalDate.parse(date, formatter);
        if(taskDate.compareTo(LocalDate.now()) < 0){
            throw new DateTimeException("You've entered invalid date");
        }
        else {
            this.date = taskDate;
        }
    }

    /**
     * To mark the task as done
     */
    public void markAsDone() {
        this.status = true;
    }

    public boolean getStatus(){
        return this.status;
    }

    /**
     * @param task to compare all the tasks due date by the earliest date
     * @return the earliest date after comparison
     */
    @Override
    public int compareTo(Task task) {

        return this.getDate().compareTo(task.getDate());
    }
}
