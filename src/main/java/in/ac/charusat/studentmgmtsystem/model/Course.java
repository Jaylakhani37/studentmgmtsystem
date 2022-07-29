package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
    private Long id;
    private String title;
    private String description;

    public Course(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Course() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }







    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

//    public Object getAddress() {
//    }
}