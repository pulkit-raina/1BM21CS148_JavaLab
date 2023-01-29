import java.util.Scanner;

public class Lab1Quadratic {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        float a, b, c;
        try {
            while(true) {
                System.out.print("Enter the values of a, b, c! Enter letter to end: ");
                a = s.nextFloat();
                b = s.nextFloat();
                c = s.nextFloat();
                float d = b * b - 4 * a * c;
                if (d < 0) {
                    System.out.println("There are no real solutions!");
                } else if (d == 0) {
                    System.out.println("Solutions are real and equal to: " + (-b) / 2 * a);
                } else {
                    System.out.println("Solutions are unique and real!");
                    float e = -b / (2 * a);
                    float f = (float) Math.sqrt(d) / (2 * a);
                    System.out.println("Roots are " + (e + f) + " and " + (e - f));
                }
            }
        }
        catch(Exception e){
            System.out.println("Thanks! Code run successfully!");
        }
    }
}