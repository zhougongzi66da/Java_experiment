package Experiment_4;

public class test {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1= new Thread(ticket, "售票点1");
        Thread t2= new Thread(ticket, "售票点2");
        Thread t3= new Thread(ticket, "售票点3");
        Thread t4= new Thread(ticket, "售票点4");
        Thread t5= new Thread(ticket, "售票点5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
