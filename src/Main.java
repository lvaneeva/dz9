import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        List<Student> studentList = getList();
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        studentList.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .forEach(course -> {
                    System.out.println(course.getName());
                });
        //  .collect(Collectors.toList());

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        studentList.stream()
                .sorted((student1, student2) -> student2.getAllCourses().size() - student1.getAllCourses().size())
                .limit(3)
                // .collect(Collectors.toList());
                .forEach(student -> {
                    System.out.println(student.getName());
                });

        System.out.println("+++++++++++++++++++++++++++++++++++++++");

        Course paramCourse = new Course(Course.Name.JavaCore);
        studentList.stream()
                .filter(student -> student.getAllCourses().contains(paramCourse))
                //.collect(Collectors.toList());
                .forEach(student -> {
                    System.out.println(student.getName());
                });
        System.out.println();

    }

    private static List<Student> getList() {
        List<Student> persons = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random(20);
        Random randomPosition = new Random();

        for (int i = 0; i < 10; i++) {
            Random randomCourse = new Random(); //количество курсов у i-го студента
            List<Course> courses = new ArrayList<>();
            for (int j = 0; j < randomCourse.nextInt(4); j++) {
                courses.add(new Course(Course.Name.values()[randomPosition.nextInt(9)]));
            }
            Student person = new Student(faker.name().fullName(), random.nextInt(65), courses);
            persons.add(person);
        }
        return persons;
    }
}