import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class FilterAndSortStudents {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 70));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 60));

        // Filter students with marks > 75, sort by marks, and collect names
        List<String> topStudents = students.stream()
                .filter(student -> student.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks)) // Descending order
                .map(student -> student.name)
                .collect(Collectors.toList());

        // Display names of top students
        System.out.println("Top Students:");
        topStudents.forEach(System.out::println);
    }
}
