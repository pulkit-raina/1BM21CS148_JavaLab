import java.util.Scanner;

public class Lab2StudentForm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choice;
        Student s1 = new Student();
        System.out.print("Enter USN: ");
        s1.usn = s.nextInt();
        s.nextLine();
        System.out.print("Enter name: ");
        s1.name = s.nextLine();
        do{
            System.out.print("Enter\n1. Set Marks 2. Set Credits 3. Display SGPA 4. Display Details 5. Exit: ");
            choice = s.nextInt();
            switch(choice){
                case 1:
                    s1.setMarks();
                    break;
                case 2:
                    s1.setCredits();
                    break;
                case 3:
                    s1.sgpaCalc();
                    break;
                case 4:
                    s1.displayDetails();
                    break;
                default:
                    System.out.println("INCORRECT CHOICE!");
                    break;
            }
        }while(choice!=5);
    }
}

class Student {
    Scanner s = new Scanner(System.in);
    int usn;
    String name;
    int credits[] = new int[6];
    int marks[] = new int[6];
    int creditScore[] = new int[6];

    void setMarks() {
        for (int i = 1; i <= 6; i++){
            System.out.print("Enter marks of subject " + i + ": ");
            marks[i - 1] = s.nextInt();
        }
        System.out.println();
    }

    int[] getMarks() {
        return marks;
    }

    void setCredits() {
        for (int i = 1; i <= 6; i++){
            System.out.print("Enter credits of subject " + i + ": ");
            credits[i - 1] = s.nextInt();
        }
    }

    int[] getCredits() {
        return marks;
    }

    void setCreditScore(){
            for(int i = 0; i<6; i++) {
                if (marks[i] >= 90)
                    creditScore[i] = 10;
                else if (marks[i] >= 80)
                    creditScore[i] = 9;
                else if (marks[i] >= 70)
                    creditScore[i] = 8;
                else if (marks[i] >= 60)
                    creditScore[i] = 7;
                else if (marks[i] >= 50)
                    creditScore[i] = 6;
                else if (marks[i] >= 40)
                    creditScore[i] = 5;
                else
                    creditScore[i] = 0;
            }
    }

    void sgpaCalc(){
        this.setCreditScore();
        Float sgpa = 0f;
        int cred = 0;
        for(int i = 0; i<6; i++)
            cred = cred + credits[i];
        for(int i = 0; i<6; i++){
            sgpa = sgpa + credits[i]*creditScore[i];
        }
        System.out.println("SGPA is " + (Float)sgpa/cred);
    }

    void displayDetails(){
        System.out.println("Details of USN: " + usn);
        System.out.println(name);
        for(int i = 0; i<6; i++){
            System.out.println("Marks of subject " + (i+1)+ "is = " + marks[i]);
        }
        sgpaCalc();
    }
}