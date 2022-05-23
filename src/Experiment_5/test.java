package Experiment_5;

public class test {
    public static void main(String[] args) {
        float[][]A=new float[][]{
            {1,0},
            {0,2},
            {3,0}
        };

        float[][]B=new float[][]{
                {1,0,3},
                {0,2,4},
        };

        Calculate calculate=new Calculate(A,B);
        Thread t1= new Thread(calculate, "线程1");
        Thread t2= new Thread(calculate, "线程2");
        Thread t3= new Thread(calculate, "线程3");
        Thread t4= new Thread(calculate, "线程4");
        Thread t5= new Thread(calculate, "线程5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();



    }
}
