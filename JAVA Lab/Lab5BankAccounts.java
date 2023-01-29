import java.util.Scanner;
public class Lab5BankAccounts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Curr_acct cur = new Curr_acct();
        Sav_acct sav = new Sav_acct();
        System.out.print("Enter your type of account\n'c' for current and 's' for savings and 'e' to exit: ");
        char t = s.next().charAt(0);
        int choice;
        if(t == 's') {
            System.out.print("Enter name and account number: ");
            s.nextLine();
            String name = s.nextLine();
            int acc_num = s.nextInt();
            sav.setAcc_num(acc_num);
            sav.setName(name);
            sav.setAcc_type("Savings");
            do {
                System.out.print("1.Deposit 2.Withdraw 3.Check Balance 4.Check Interest 5.Show Account Details 6.Exit: ");
                choice = s.nextInt();
                switch(choice){
                    case 1:
                        sav.deposit();
                        break;
                    case 2:
                        sav.withdrawal();
                        break;
                    case 3:
                        System.out.println("Balance is: " + sav.getBalance());
                        break;
                    case 4:
                        sav.calcInterest();
                        break;
                    case 5:
                        sav.display();
                        break;
                }
            } while (choice!=6);
        }
        else if(t == 'c'){
            System.out.print("Enter name and account number: ");
            s.nextLine();
            String name = s.nextLine();
            int acc_num = s.nextInt();
            cur.setAcc_num(acc_num);
            cur.setName(name);
            cur.setAcc_type("Current");
            do {
                System.out.print("1.Deposit 2.Withdraw 3.Check Balance 4.Show Account Details 5.Exit: ");
                choice = s.nextInt();
                switch(choice){
                    case 1:
                        cur.depositCurrent();
                        break;
                    case 2:
                        cur.withdrawal();
                        break;
                    case 3:
                        System.out.println("Balance is: " + cur.getBalance());
                        break;
                    case 4:
                        cur.display();
                        break;
                }
            } while (choice!=5);
        }
        else
            System.out.println("INCORRECT INPUT!");
    }
}

class Account{
    Scanner s = new Scanner(System.in);
    String name, acc_type;
    int acc_num;
    void setName(String name){
        this.name = name;
    }
    void setAcc_type(String type){
        this.acc_type = type;
    }
    void setAcc_num(int acc_num){
        this.acc_num = acc_num;
    }
}

class Curr_acct extends Account{
    float bal;
    int minChecker(){
        if(bal<1000) {
            System.out.println("Penalty of "+ (0.1)*bal + " imposed!");
            bal = bal - (float) 0.1 * bal;
            return 0;
        }
        else
            return 1;
    }

    void depositCurrent(){
        float dep;
        System.out.print("Enter amount to deposit: ");
        dep = s.nextFloat();
        bal = bal + dep;
    }

    float getBalance(){
        return bal;
    }

    void withdrawal(){
        float x;
        System.out.print("Enter amount to withdraw: ");
        x = s.nextFloat();
        if(minChecker() != 1 || bal<x) {
            System.out.println("WITHDRAWAL NOT ALLOWED!");
        }
        else{
            System.out.println("Withdrawal of " + x + " permitted!");
            bal = bal - x;
            System.out.println("New Balance is " + bal);
        }
    }

    void display(){
        System.out.println("Name is: " + name);
        System.out.println("Account type is: " + acc_type);
        System.out.println("Account number is: " + acc_num);
        System.out.println("Current balance is: " + getBalance());
    }
}

class Sav_acct extends Account{
    float bal;
    void deposit(){
        System.out.print("Enter amount to deposit: ");
        float dep = s.nextFloat();
        bal = bal + dep;
        System.out.println("New balance is " + bal);
    }
    void calcInterest(){
        System.out.print("Enter time in years and rate of interest: ");
        float t = s.nextFloat();
        float r = s.nextFloat();
        float in = bal*(float)Math.pow((1 + r/100), t);
        System.out.println("Account balance is: " + bal + " interest is: " + in);
        bal = bal + in;
    }
    float getBalance(){
        return bal;
    }
    void withdrawal(){
        float x;
        System.out.print("Enter the amount to withdraw: ");
        x = s.nextFloat();
        if(bal<x){
            System.out.println("WITHDRAWAL NOT ALLOWED!");
        }
        else{
            bal = bal-x;
            System.out.println("Balance is: " + bal);
        }
    }
    void display(){
        System.out.println("Name is: " + name);
        System.out.println("Account type is: " + acc_type);
        System.out.println("Account number is: " + acc_num);
        System.out.println("Current balance is: " + getBalance());
    }
}