package Experiment_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculate implements Runnable{
    private float[][]A;
    private float[][]B;
    private float[][]C;
    public static Boolean flag;//判断两个矩阵能否进行计算
    private int A_r;//A的行数
    private int A_c;//A的列数
    private int B_r;//B的行数
    private int B_c;//B的列数
    private int sum;//所有元素个数
    private Lock lock=new ReentrantLock();

    public Calculate(float[][] a, float[][] b) {
        A = a;
        B = b;
        A_r=a.length;A_c=a[0].length;
        B_r=b.length;B_c=b[0].length;
        C=new float[A_r][B_c];
        sum=A_r*B_c;
    }

    @Override
    public void run() {
        while (sum>0){
            try {
                Thread.sleep(100);
                lock.lock();
                if (sum>0){
                    int i=(sum-1)/B_c;
                    int j=(sum-1)%B_c;
                    float res=0;
                    for(int k=0;k<A_c;k++){
                        res+= A[i][k]*B[k][j];
                    }
                    C[i][j]=res;
                    System.out.println(Thread.currentThread().getName()+"对C坐标("+i+","+j+")的计算结果是:"+res);
                    System.out.println("C的当前状态是：");
                    show();
                    System.out.println("----------------------------");
                    sum--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void show(){
        for (int i=0;i<C.length;i++) {
            for (int j=0;j<C[0].length;j++)
                System.out.print(C[i][j]+" ");
            System.out.println();
        }

    }

}



