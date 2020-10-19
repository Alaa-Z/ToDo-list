import java.util.ArrayList;


public class Project {

    private static ArrayList<Task> allTasks;
    private int projectId;
    private String projectTitle;

    public Project(String projectTitle, int projectId) {
        this.projectTitle = projectTitle;
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public void showTasks() {
        if (this.allTasks.size() == 0) {
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

    public ArrayList<Task> getTasks() {
        return this.allTasks;
    }

    public void addTask(Task task) {
        allTasks.add(task);
    }

    public static void editTasks(){

    }

    public static int getTaskIndexByTitle(String title) {
        for (int i = 0; i < allTasks.size(); i++) {

            if (allTasks.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }
}
