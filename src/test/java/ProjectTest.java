
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectTest {

    private Project p;

    @Test
    void getProjectId_test() {
        Project p = new Project("Project1", 1);
        assertEquals(1,p.getProjectId());
    }
    @Test
    void setProjectId_test(){
        Project p = new Project("Project1", 1);
        assertEquals(1,p.getProjectId());
        p.setProjectId(2);
        assertEquals(2,p.getProjectId());
    }

    @Test
    void addTask_test(){

        Task task1 = new Task();
        task1.setTitle("T1");
        task1.setDate("2021-11-11");

        Task task2 = new Task();
        task2.setTitle("T2");
        task2.setDate("2030-05-07");

        Project project = new Project();
        project.addTask(task1);
        project.addTask(task2);

        assertEquals(project.getAllTasks().get(0), task1);
        assertEquals(project.getAllTasks().get(1), task2);

    }







}