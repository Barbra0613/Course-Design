package automaticCourse;

import java.util.HashSet;
import java.util.Set;


public class Course {
    public Set<String> precourse = new HashSet<>();
    private int id;
    private String name;
    private int timesWeek;
    public boolean sin = true;//单周是否上课
    public boolean dou = true;//双周是否上课


    public Course() {
    }

    public Course(int id, String name, int timesWeek, boolean sin, boolean dou) {
        this.id = id;
        this.name = name;
        this.timesWeek = timesWeek;
        this.sin = sin;
        this.dou = dou;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimesWeek() {
        return timesWeek;
    }

    public void setTimesWeek(int timesWeek) {
        this.timesWeek = timesWeek;
    }
    
}
