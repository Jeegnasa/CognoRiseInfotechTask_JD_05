import java.util.ArrayList;
import java.util.Scanner;
//Task-05
class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void enrollStudent() {
        if (enrolled < capacity) {
            enrolled++;
        } else {
            System.out.println("Course is already full. Cannot enroll more students.");
        }
    }

    public void dropStudent() {
        if (enrolled > 0) {
            enrolled--;
        } else {
            System.out.println("No students enrolled in this course.");
        }
    }

    @Override
    public String toString() {
        return "Course: " + code + " - " + title + "\nDescription: " + description + "\nCapacity: " + capacity
                + "\nEnrolled: " + enrolled + "\n";
    }
}

class Student {
    private String id;
    private String name;
    private ArrayList<Course> courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void registerCourse(Course course) {
        courses.add(course);
        course.enrollStudent();
        System.out.println("Course " + course.getCode() + " - " + course.getTitle() + " registered successfully.");
    }

    public void dropCourse(Course course) {
        if (courses.remove(course)) {
            course.dropStudent();
            System.out.println("Course " + course.getCode() + " - " + course.getTitle() + " dropped successfully.");
        } else {
            System.out.println("You are not registered in this course.");
        }
    }

    public void displayRegisteredCourses() {
        if (courses.isEmpty()) {
            System.out.println("You are not registered in any courses.");
        } else {
            System.out.println("Registered courses:");
            for (Course course : courses) {
                System.out.println(course.getCode() + " - " + course.getTitle());
            }
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create some courses
        Course c1 = new Course("CSE101", "Introduction to Computer Science", "Basics of programming", 30);
        Course c2 = new Course("MAT101", "Calculus I", "Basic calculus concepts", 25);
        Course c3 = new Course("ENG101", "English Composition", "Writing and grammar", 35);

        // Create a student
        Student student = new Student("123", "John Doe");

        // Registering and dropping courses
        student.registerCourse(c1);
        student.registerCourse(c2);
        student.registerCourse(c3);
        student.dropCourse(c2);

        // Displaying registered courses
        student.displayRegisteredCourses();
    }
}
