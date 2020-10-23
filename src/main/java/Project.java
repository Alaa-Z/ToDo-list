import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Represents the project when the user create a project with specific title, id and a specific tasks represented by
 * array list of type Task
 */

public class Project implements Serializable {
    /**
     * Array list of type Task
     */
    private ArrayList<Task> allTasks = new ArrayList<>();
    /** Project id to distinguish between projects
     */
    private int projectId;
    /**
     * Represent the project title
     */
    private String projectTitle;

    public Project(){

    }

    /**
     * Constructor to initialize a project
     * @param projectTitle the title of the project
     * @param projectId the id of the project
     */

    public Project(String projectTitle, int projectId) {
        this.projectTitle = projectTitle;
        this.projectId = projectId;
    }

    /**
     * Get the id value of project
     * @return projectId as integer
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Set the id value of project
     * @param projectId the id of the project
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * Get the title of project as string
     * @return project title
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * Set the title of project
     * @param projectTitle the title of the project
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * Show all task in the list of tasks in case it exists and using index to calculate
     * all inserted tasks
     */
    public void showTasks() {
        if (allTasks.size() == 0) {
            System.out.println("You don't have any task in this project! Please add a task");
        } else {

            System.out.println("Project " + projectId + ": " + projectTitle);
            int index = 0;
            for (Task t : allTasks) {
                index++;
                System.out.println("Task " + index + ": " + t.getTitle() + "  " + t.getDate() + " ");
            }
        }
    }

    /**
     * Add the tasks into the array list of tasks
     * @param task the inserted task
     */
    public void addTask(Task task) {
        this.allTasks.add(task);
    }

    /**
     * Getting the index of task using the title
     * @param title title of the task
     * @return int to make sure that the task exist or -1 if it is not
     */

    public int getTaskIndexByTitle(String title) {
        for (int i = 0; i < allTasks.size(); i++) {

            if (allTasks.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get all the tasks from the array list
     * @return allTasks
     */
    public ArrayList<Task> getAllTasks(){
        return allTasks;
    }

    /**
     * To sort the task inside the task array list by due date
     */
    public void sortByDate(){
        Collections.sort(allTasks);
    }

}