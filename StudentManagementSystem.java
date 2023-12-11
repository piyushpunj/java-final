import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String studentID;
    private String name;
    private int age;
    private List<String> courses;

    public Student(String studentID, String name, int age) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Courses: " + courses);
        System.out.println();
    }

    // Setter method to update age
    public void setAge(int age) {
        this.age = age;
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding sample students
        Student student1 = new Student("M001", "Piyush", 19);
        student1.addCourse("Math");
        student1.addCourse("Physics");
        students.add(student1);

        Student student2 = new Student("M002", "Alex", 30);
        student2.addCourse("Computer Science");
        students.add(student2);

        Student student3 = new Student("M003", "Scott", 29);
        student3.addCourse("Accounts");
        students.add(student3);

        // Displaying all student details using streams
        students.forEach(Student::displayDetails);

        // Finding and displaying students enrolled in a specific course using streams
        String specificCourse = "Computer Science";
        List<Student> studentsInSpecificCourse = students.stream()
                .filter(student -> student.getCourses().contains(specificCourse))
                .collect(Collectors.toList());
        System.out.println("Students enrolled in '" + specificCourse + "':");
        studentsInSpecificCourse.forEach(Student::displayDetails);

        // Updating the age of a specific student using streams
        String studentIDToUpdate = "S002";
        int newAge = 23;
        students.stream()
                .filter(student -> student.getStudentID().equals(studentIDToUpdate))
                .forEach(student -> student.setAge(newAge));

        // Calculating and displaying the average age of all students using streams
        double averageAge = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Average age of all students: " + averageAge);
    }
}
