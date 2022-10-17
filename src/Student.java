import java.util.List;

public class Student {
    private String name;
    private int age;

   public List<Course> courses;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(String name, int age, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getAllCourses() {
            return courses;
    }

}
