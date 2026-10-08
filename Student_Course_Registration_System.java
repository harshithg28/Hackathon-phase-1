import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    double calculateScholarship() {
        double fee = calculateFee();

        if (marks >= 85) {
            return fee * 0.20; // 20%
        } else if (marks >= 70 && marks <= 84) {
            return fee * 0.10; // 10%
        } else {
            return 0;
        }
    }

    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Display Details
    void displayDetails() {
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("Marks        : " + marks);

        System.out.println("\n----- Course Details -----");
        System.out.println("Course Name  : " + courseName);
        System.out.println("Credits      : " + courseCredits);

        System.out.println("\nEligibility  : " + checkEligibility());

        System.out.println("Total Fee    : Rs. " + calculateFee());
        System.out.println("Scholarship  : Rs. " + calculateScholarship());
        System.out.println("Final Fee    : Rs. " + calculateFinalFee());
    }
}
class Student_Course_Registration_System{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        Student s = new Student(name, roll, marks, course, credits);

        if (s.checkEligibility()) {
            s.displayDetails();

        } else {
            System.out.println("\nStudent is NOT eligible for course registration.");
        }

        sc.close();
    }
}