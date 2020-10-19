import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/** this a To-Do list program that allows you to to save your tasks and
 * choose a project for that task to belong to.
 * @author  Alaa Zaza
 * @version 1.0
 * @since   2020-09-21
 */

public class ToDo {
    static ArrayList<Project> allProjects = new ArrayList<>();
    public static void main(String[] args){
        System.out.println("Welcome to ToDo list");
        runMainUI();
    }

    public static void runMainUI(){
        System.out.println("Please pick an option:");
        System.out.println("(1) Show all projects");
        System.out.println("(2) Create project");
        System.out.println("(3) Edit project");
        System.out.println("(4) Close and save");
        chooseMainOption();
    }

    public static void runSecondUI(Project project){
        System.out.println("(1) Show all tasks in project");
        System.out.println("(2) Add a new task");
        System.out.println("(3) Edit task (update, mark as done, remove)");
        chooseProjectOption(project);

    }

    public static void chooseMainOption(){
        Scanner sc1 = new Scanner(System.in);
        int options = sc1.nextInt();
        switch(options){
            case 1:
                showAllProjects();
                break;
            case 2:
                createProject();
                runMainUI();
                break;
            case 3:
                editProject();
                break;
            case 4:
                closeAndSave();
                break;

            default:
                System.out.println("Invalid option: " + options + ", insert a valid option: ");
                chooseMainOption();

        }
    }

    public static void showAllProjects(){
        if (allProjects.size() == 0){
            System.out.println("You don't have any project");
        } else {
            for (int i = 0; i < allProjects.size(); i++){
                System.out.println("Project " + allProjects.get(i).getProjectId() + ": " + allProjects.get(i).getProjectTitle());
            }
        }
        runMainUI();
    }

    public static void createProject(){
        System.out.println("Enter project title");
        Scanner sc = new Scanner(System.in);
        String projectTitle = sc.nextLine();
        Project project = new Project(projectTitle, allProjects.size());
        allProjects.add(project);

        System.out.println("(1) Return to main menu");
        System.out.println("(2) Edit project");
        int option = sc.nextInt();
        switch (option){
            case 1:
                runMainUI();
                break;
            case 2:
                runSecondUI(project);
                break;
        }
    }

    public static void editProject(){
        System.out.println("Enter the name of the project");
        Scanner sc = new Scanner(System.in);
        String projectTitle = sc.nextLine();
        int index = getProjectIndexByTitle(projectTitle);
        Project project = allProjects.get(index);
        runSecondUI(project);


    }
    public static int getProjectIndexByTitle(String title) {
        for (int i = 0; i < allProjects.size(); i++) {

            if (allProjects.get(i).getProjectTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public static void closeAndSave(){

    }
    public static void chooseProjectOption(Project project){
        Scanner sc1 = new Scanner(System.in);
        int options = sc1.nextInt();
        switch (options){
            case 1:
                project.showTasks();
                break;
            case 2:
                Task task = createTask();
                project.addTask(task);
                break;
            case 3:
                project.editTasks();
                break;
        }
    }

    public static Task createTask(){

        System.out.println("Enter the task title");
        Scanner sc = new Scanner(System.in);
        String taskTitle = sc.nextLine();

        System.out.println("Enter the task due date in format (dd-MM-yyyy)");
        String taskDateString = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate taskDate = LocalDate.parse(taskDateString, formatter);

        Task task = new Task(taskTitle, taskDate);
        return task;
    }

   /* public static void editTasks(){
        // update
        // mark as done
        // remove

        int option = 3;
        switch (option){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }


    }*/

}

