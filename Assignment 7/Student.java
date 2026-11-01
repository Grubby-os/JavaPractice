/* This class defines the student object. The this keyword is used since parameters have
the same names. GPA is not stores since it can be calculated on an accessor method. It
also contains class invariants to prevent bad numbers from being used. */

public class Student {
    private String name;
    private Double totalPoints;
    private int numCourses;

    public Student(String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.totalPoints = 0.0;
        this.numCourses = 0;
    }

    public void addCourse(double gradePoints) {
        if (gradePoints < 0 || gradePoints > 4){
            throw new IllegalArgumentException();
        }
        this.totalPoints += gradePoints;
        this.numCourses += 1;
    }

    public String getName() {
        return this.name;
    }

    public double getGPA() {
        return this.totalPoints/numCourses;
    }

    public String toString() {
        return "Student[" + name + ", " + totalPoints + ", " + numCourses + "]";
    }
}
