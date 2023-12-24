package ru.gbhw;

import javax.persistence.*;


@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private double duration;

    public Course (int id, String title, double duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }
    public Course (String title, double duration) {
        this.title = title;
        this.duration = duration;
    }
    
    public Course () {

    }
    //getters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public double getDuration() {
        return duration;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    @Override
    public String toString() {
        return "Course : " + id + " Title: " + title + " duration: " + duration;
    }
}
