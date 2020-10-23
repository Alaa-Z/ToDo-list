
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    @Test
    void setGetTitle_test() {
        Task task = new Task();
        String taskTitle  ="Task 1";
        task.setTitle(taskTitle);
        assertEquals(task.getTitle(), taskTitle);
    }

    @Test
    void setGetDateValid_test(){
        Task task = new Task();
        String taskDate = "2022-11-11";
        task.setDate(taskDate);
        assertEquals(task.getDate(), taskDate);
    }

    @Test
    void markAsDone_test(){
        Task task = new Task();
        assertEquals(task.getStatus(), false);
        task.markAsDone();
        assertEquals(task.getStatus(), true);
    }

    @Test
    void compareTo_test(){
        Task task1 = new Task();
        task1.setDate("2021-11-11");
        Task task2 = new Task();
        task2.setDate("2030-05-07");
        assertEquals(task1.compareTo(task2), -1);
    }

/* To be continue */
/*@Test
void getDateInvalid_test(){
    Task task = new Task();
    String taskDate = "11-11-2022";
    task.setDate(taskDate);
    assertNotEquals(task.getDate(), taskDate);
    Assertions.assertThrows()
}
*/
    /*@Test
    void getDateInvalid_test() {
        Task task = new Task();
        String taskDate = "11-11-2022";

        Exception exception = assertThrows(DateTimeException.class, () ->
                task.setDate(taskDate));
        assertEquals("You've entered invalid date", exception.getMessage());
    }
    */
}
