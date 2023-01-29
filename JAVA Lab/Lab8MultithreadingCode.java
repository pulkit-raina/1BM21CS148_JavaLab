public class Lab8MultithreadingCode {
    public static void main(String[] args) {
        BMS b = new BMS();
        CSE c = new CSE();
        b.start();
        c.start();
    }
}

class BMS extends Thread{
    public void run(){
        try{
            for(int i = 0; i<4000; i++) {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

class CSE extends Thread{
    public void run(){
        try {
            for(int i= 0; i<20000; i++) {
                System.out.println("CSE");
                Thread.sleep(2000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}