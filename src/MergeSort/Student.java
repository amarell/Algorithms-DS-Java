package MergeSort;

public class Student implements Comparable<Student> {
    String fullName;
    String department;
    double gpa;

    public Student(String fullName, String department, double gpa) {
        super();
        this.fullName = fullName;
        this.department = department;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return 0;
    }

}
