import java.util.Objects;

public class Course {
    private Name name;

    enum Name {
        Databases, Java1, JavaCore, JavaWeb, HTML, CSS, Linux, Git, Networks;
    }

    public Course(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

