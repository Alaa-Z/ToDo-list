import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this a To-Do list program that allows you to to save your daily tasks.
 * The application has a main interface related to the project which lead to
 * another project related to every task in the project where the user can insert and edit task
 * @author  Alaa Zaza
 * @version 1.0
 * @since   2020-09-21
 */
public class ToDo {
    /**
     * Array list of project
     */
    static ArrayList<Project> allProjects = new ArrayList<>();

    public static void main(String[] args){

        System.out.println("Welcome to ToDo list");
        allProjects = loadFromFile();
        runMainUI();
    }

    /**
     * The first user interface where the user can choose an option regarding the project
     */
    public static void runMainUI(){
        System.out.println("");
        System.out.println("Please pick an option:");
        System.out.println("(1) Show all projects");
        System.out.println("(2) Create project");
        System.out.println("(3) Edit project");
        System.out.println("(4) Save");
        chooseMainOption();
    }

    /**
     * The second user interface where the user can choose an option regarding the task into a specific project
     * @param project project selected by the user to edit
     */
    public static void runSecondUI(Project project){
        System.out.println("");
        System.out.println("(1) Show all tasks in project " + project.getProjectTitle());
        System.out.println("(2) Sort tasks by due date");
        System.out.println("(3) Add a new task");
        System.out.println("(4) Edit task (update, mark as done, remove)");
        System.out.println("(5) Go back");
        chooseProjectOption(project);

    }

    /**
     * The user can choose an option where he can see his previous projects,edit them
     * or add new project and save his changes. It will show him again the options in case he entered invalid number
     */
    public static void chooseMainOption(){
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();
        switch(options){
            case 1:
                showAllProjects();
                runMainUI();
                break;
            case 2:
                createProject();
                break;
            case 3:
                editProject();
                break;
            case 4:
                saveToFile();
                break;
            default:
                System.out.println("Invalid option: " + options + ", insert a valid option: ");
                chooseMainOption();
        }
    }

    /**
     * The user can see all his previous projects and by using index to calculate
     * all his previous inserted projects. It show him also an error message when he choose to see
     * non existing projects
     */
    public static void showAllProjects(){
        if (allProjects.size() == 0){
            System.out.println("You don't have any project");
        } else {
            for (int i = 0; i < allProjects.size(); i++){
                System.out.println("Project " + allProjects.get(i).getProjectId() + ": " + allProjects.get(i).getProjectTitle());
            }
        }
    }

    /**
     * The user can create project and give him a title then he either choose to go back to the first interface or continue
     * to edit his projects
     */
    public static void createProject(){
        System.out.println("Enter project title");
        Scanner sc = new Scanner(System.in);
        String projectTitle = sc.nextLine();
        Project project = new Project(projectTitle, allProjects.size()+1);
        allProjects.add(project);
        System.out.println("Project " + projectTitle + " has been created successfully");
        System.out.println("");

        System.out.println("(1) Edit project " + projectTitle);
        System.out.println("(2) Go back");
        int option = sc.nextInt();
        switch (option){
            case 1:
                runSecondUI(project);
                break;
            case 2:
                runMainUI();
                break;
            default:
                runMainUI();
        }
    }

    /**
     * After choosing edit project by entering a correct name. Based on the title of the project,a specific project
     * will be modifying
     */
    public static void editProject(){
        System.out.println("Enter the name of the project");
        Scanner sc = new Scanner(System.in);
        String projectTitle = sc.nextLine();
        int index = getProjectIndexByTitle(projectTitle);
        if(index < 0){
            System.out.println("Invalid project name");
            System.out.println("");
            runMainUI();
        } else {
            Project project = allProjects.get(index);
            runSecondUI(project);
        }

    }

    /**
     * Getting the index of project using the title
     * @param title of the project
     * @return int to make sure that the project exist or -1 if it is not
     */
    public static int getProjectIndexByTitle(String title) {
        for (int i = 0; i < allProjects.size(); i++) {

            if (allProjects.get(i).getProjectTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * By choosing a specific project, the user can se all the task inside the project,sort them by date, make new tasks,
     * edit an existing task, or go back to the first interface.It show him also an error message when he choose
     * invalid number and show him the option again
     * @param project the chosen project to be modified
     */
    public static void chooseProjectOption(Project project){
        Scanner sc1 = new Scanner(System.in);
        int options = sc1.nextInt();
        switch (options){
            case 1:
                project.showTasks();
                runSecondUI(project);
                break;
            case 2:
                project.sortByDate();
                runSecondUI(project);
                break;
            case 3:
                Task task = createTask();
                project.addTask(task);
                System.out.println("Task (" + task.getTitle() + ", " + task.getDate() + ") has been created successfully");
                runSecondUI(project);
                break;
            case 4:
                editTask(project);
                break;
            case 5:
                runMainUI();
                break;
            default:
                System.out.println("Invalid option: " + options + ", insert a valid option: ");
                chooseProjectOption(project);
        }
        runMainUI();
    }

    /**
     * By choosing create task, a new task will be added to the project
     * every task will have a title and a dead line given by the user
     * @return an object of type Task
     */
    public static Task createTask(){

        Task task = new Task();

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the task title");
        String taskTitle = sc1.nextLine();
        task.setTitle(taskTitle);

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the task due date in format (yyyy-MM-dd)");
        String taskDate = sc2.nextLine();
        task.setDate(taskDate);

        return task;
    }

    /**
     * After choosing edit task The user will be able to modify a task based on a correct name (Title or due date),
     * mark task as done or remove a task
     * @param project the chosen project to be modified
     */
    public static void editTask(Project project) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a task to edit");
        String taskTitle = sc.nextLine();
        int taskIndex = project.getTaskIndexByTitle(taskTitle);
        if (taskIndex < 0){
            System.out.println("Invalid Task name");
            System.out.println("");
            runSecondUI(project);
        }

        System.out.println("(1) Edit task title");
        System.out.println("(2) Edit task due date");
        System.out.println("(3) Show task status");
        System.out.println("(4) Mark task as done");
        System.out.println("(5) Remove task");
        System.out.println("(6) Go back");

        int options = sc.nextInt();

        switch (options) {
            case 1:
                System.out.println("Enter a new title");
                sc = new Scanner(System.in);
                String newTitle = sc.nextLine();
                project.getAllTasks().get(taskIndex).setTitle(newTitle);
                runSecondUI(project);
                break;
            case 2:
                System.out.println("Enter a new due date in the format (dd-MM-yyyy)");
                sc = new Scanner(System.in);
                String newDueDate = sc.nextLine();
                project.getAllTasks().get(taskIndex).setDate(newDueDate);
                runSecondUI(project);
                break;
            case 3:
                project.getAllTasks().get(taskIndex).showStatus();
                runSecondUI(project);
                break;
            case 4:
                project.getAllTasks().get(taskIndex).markAsDone();
                runSecondUI(project);
                break;
            case 5:
                project.getAllTasks().remove(taskIndex);
                runSecondUI(project);
                break;
            case 6:
                runSecondUI(project);
                break;
            default:
                System.out.println("Invalid option: " + options + ", insert a valid option: ");
        }
    }

    /**
     * Save the current project and their contents to an external file
     */
    public static void saveToFile(){

        try {
            FileOutputStream file = new FileOutputStream("todo.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            //output.writeObject(allProjects.get(0).getAllTasks().get(0).getTitle());
            output.writeObject(allProjects);
            output.close();
            file.close();
        }
        catch (Exception e){
            System.out.println("File not found " + e);
        }
    }

    /**
     * Read the saved project and their contents from the external file
     * @return an array list of the project
     */
    public static ArrayList<Project> loadFromFile(){
        ArrayList<Project> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream("todo.txt");
            ObjectInputStream stream = new ObjectInputStream(file);
            list = (ArrayList<Project>) stream.readObject();
            stream.close();
            file.close();
        }
        catch (Exception e){
            System.out.println("read proble" + e);
        }
        return list;
    }

}

