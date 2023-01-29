import java.util.Scanner;

public class Lab3BookForm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.print("Enter number of books: ");
        n = s.nextInt();
        Book b[] = new Book[n];
        for(int i = 0; i<n; i++){
            s.nextLine();
            System.out.print("Enter name of object " + (i+1) + " : ");
            String name = s.nextLine();
            System.out.print("Enter author of object " + (i+1) + " : ");
            String author = s.nextLine();
            System.out.print("Enter price of object " + (i+1) + " : ");
            int price = s.nextInt();
            System.out.print("Enter number of pages of object " + (i+1) + " : ");
            int num_pages = s.nextInt();
            b[i] = new Book(name, author, price, num_pages);
        }
        int choice;
        System.out.print("Enter\n1. Display Details of a book 2. Exit: ");
        do{
            choice = s.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter book whose details you need: ");
                    int j = s.nextInt();
                    if(j>n)
                        System.out.println("BOOK DOESN'T EXIST");
                    else
                        b[j-1].toString(0);
            }

        }while(choice!=2);
    }
}

class Book{
    String name, author;
    int price, num_pages;
    Book(String name, String author, int price, int num_pages){
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }
    void setName(String name){
        this.name = name;
    }
    void setAuthor(String author){
        this.author = author;
    }
    void setPrice(int price){
        this.price = price;
    }
    void setNum_pages(int num_pages){
        this.num_pages = num_pages;
    }

    String getName(){
        return name;
    }
    String getAuthor(){
        return author;
    }
    int price(){
        return price;
    }
    int num_pages(){
        return num_pages;
    }

    void toString(int n){
        System.out.println("Name of book: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price is: " + price);
        System.out.println("Num Pages is: " + num_pages);
    }
}