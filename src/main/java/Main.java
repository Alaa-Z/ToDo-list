
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;


public class Main{

    ArrayList<Task> allTasks = new ArrayList<>();
    public static void main(String[] args){
                System.out.println("Welcome to ToDo list") ;
                System.out.println("You have X tasks to do and Y tasks are done");
                System.out.println("Please pick an option:");

                System.out.println("(1) to show Task List");
                System.out.println("(2) to Add a new task");
                System.out.println("(3) to edit task(Update, mark as done, remove)");
                System.out.println("(4) to save and quit");

                Scanner sc1 = new Scanner(System.in);
                int options= sc1.nextInt();
                    try {
                       switch(options) {
                           case 1:
                               System.out.println("To be defined");
                               break;
                           case 2:
                               System.out.println("Enter the task title");
                               Scanner sc2 = new Scanner(System.in);
                               String taskTitle = sc2.nextLine();

                               System.out.println("Enter the task due date");
                               sc2 = new Scanner(System.in);
                               String taskDate = sc2.nextLine(); // to be continued
                               break;
                           case 3:
                               System.out.println("To be defined");
                               break;
                           case 4:
                               System.out.println("To be defined");
                               break;
                          default:
                              System.out.print("Pleas pick a valid number");
                       }
                    }
                    catch (Exception e){
                        System.out.println("Something went wrong.");
                    }
                }




    }

