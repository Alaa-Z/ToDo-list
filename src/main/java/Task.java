import java.time.DateTimeException;
import java.time.LocalDate;



public class Task {

    private String title;
    private LocalDate date;
    private boolean status;

    public Task(String t,  LocalDate d){
        title = t;
        date = d;
        status = false;
    }

    public String getTitle(){return title;}

    public void setTitle(String t){this.title = t;}

    public String getDate(){return date.toString();}

    public void setDate(LocalDate d) throws DateTimeException {
        //throw DataTimeException if the date is past
        if(d.compareTo(LocalDate.now())>0){
            throw new DateTimeException("You've entered invalid date");

        }
    } //{this.date=d;}

    public boolean getStatus(){return status;}

    public void markAsDone(){this.status = true;}


}
