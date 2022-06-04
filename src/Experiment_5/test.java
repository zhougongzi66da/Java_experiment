package Experiment_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test {
    static float[][] A = new float[][]{
            {1, 0},
            {0, 2},
            {3, 5}
    };

    static float[][] B = new float[][]{
            {1, 0, 3},
            {0, 2, 4},
    };

    static int A_r = A.length;//A的行数
    static int A_c = A[0].length;//A的列数
    static int B_r = B.length;//B的行数
    static int B_c = B[0].length;//B的列数
    static int sum = A_r * B_c;//C矩阵元素的个数
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        if (A_c != B_r) {
            System.out.println("不符合矩阵运算法则，退出程序");
            return;
        }
        float[][] C = new float[A_r][B_c];
        //1、 创建CountDownLatch 对象，设定需要计数的子线程数目
        int P = 5;
        CountDownLatch latch = new CountDownLatch(P);
        System.out.println(P + "个子线程开始执行");
        for (int i = 0; i < P; i++) {
            new Thread(() -> {
                while (sum > 0) {
                    int index = -1;
                    try {
                        lock.lock();
                        //分配位置
                        if (sum > 0) {
                            index = sum;
                            sum--;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                    if (index != -1) {
                        //计算所分配位置对应的横纵坐标
                        int x = (index - 1) / B_c;
                        int y = (index - 1) % B_c;
                        float res = 0;
                        for (int k = 0; k < A_c; k++) {
                            res += A[x][k] * B[k][y];
                        }
                        C[x][y] = res;
                    }
                }
                //2、子线程执行完毕，计数减1
                latch.countDown();
            }).start();
        }
        System.out.println("等待子线程执行完毕...");
        //3、当前线程挂起等待
        latch.await();
        System.out.println("子线程执行完毕,输出矩阵计算结果");
        for (int i=0;i<C.length;i++) {
            for (int j=0;j<C[0].length;j++)
                System.out.print(C[i][j]+"  ");
            System.out.println();
        }
    }
}
