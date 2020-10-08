import java.util.Date;

public class Task {
    /* add project catag and due date */
    private String title;
    private Date date;
    private boolean status;


    // create a class constructor
    public Task(String t){
        title = t;
        status = false;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String t){
        this.title = t;
    }

    public boolean getStatus(){
        return status; 
    }

    public void setStatus(){
          status = true;
    }

}



