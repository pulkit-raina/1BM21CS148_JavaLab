import java.util.Scanner;

public class Lab6DivisionInterface {
    public static void main(String[] args) {
        Division d = new Trial();
        d.division();
    }
}

interface Division{
    Scanner s = new Scanner(System.in);
    int a = 45;
    void division();
}

class Trial implements Division{
    int num1, num2;
    public void division(){
        try{
            System.out.print("Enter num1: ");
            num1 = s.nextInt();
            System.out.print("Enter num2: ");
            num2 = s.nextInt();
        }
        catch(Exception e){
            try {
                throw new NumberFormatException();
            }
            catch(Exception f){
                System.out.println(f);
                System.exit(0);
            }
        }
        if(num2 == 0){
            try {
                throw new ArithmeticException();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("Result is: " + (float)num1/num2);
        }
    }
}