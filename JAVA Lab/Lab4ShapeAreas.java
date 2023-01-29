import java.util.Scanner;

public class Lab4ShapeAreas {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter for area of 1. Rectangle 2. Triangle 3. Circle 4. Exit: ");
        int choice;
        do{
            choice = s.nextInt();
            switch (choice){
                case 1:
                    Shape r = new Rectangle();
                    r.printArea();
                    break;
                case 2:
                    Shape t = new Triangle();
                    t.printArea();
                    break;
                case 3:
                    Shape c = new Circle();
                    c.printArea();
                    break;
            }
        }while(choice!=4);
    }
}

abstract class Shape{
    Scanner s = new Scanner(System.in);
    int i, j;
    abstract void printArea();
}

class Rectangle extends Shape{
    void printArea(){
        System.out.print("Enter dimensions of rectangle: ");
        i = s.nextInt();
        j = s.nextInt();
        System.out.println("Area is " + i*j);
    }
}

class Triangle extends Shape{
    void printArea(){
        System.out.print("Enter dimensions of Triangle: ");
        i = s.nextInt();
        j = s.nextInt();
        System.out.println("Area is " + (Float)(0.5f*i*j));
    }
}

class Circle extends Shape{
    void printArea(){
        System.out.print("Enter readius of Circle: ");
        i = s.nextInt();
        System.out.println("Area is " + (Math.PI*i*i));
    }
}