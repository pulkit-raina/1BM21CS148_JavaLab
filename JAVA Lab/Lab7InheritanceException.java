import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Lab7InheritanceException {
    public static void main(String[] args) {
        Son s = new Son();
    }
}

class WrongAge extends Exception{
    public String toString() {
        return "Wrong Age";
    }
}

class Father{
    Scanner s = new Scanner(System.in);
    int age;
    Father(){
        System.out.print("Enter the age of father: ");
        try{
            age = s.nextInt();
            if(age<0)
                throw new WrongAge();
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}

class Son extends Father{
    int age_son;
    Son(){
        super();
        System.out.print("Enter the age of the son: ");
        age_son = s.nextInt();
        try{
            if(age_son>=age)
                throw new WrongAge();
            else
                System.out.println("Makes Sense!");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}