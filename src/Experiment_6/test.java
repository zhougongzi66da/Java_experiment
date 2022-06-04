package Experiment_6;

import java.io.*;
import java.util.Random;

public class test {

    //文件路径自行更改
    static final String pathIn = "E:\\Java-program\\Java上机实验题目\\src\\Experiment_6\\ipv4.txt";
    static final String pathOut1 = "E:\\Java-program\\Java上机实验题目\\src\\Experiment_6\\pathOut1.txt";
    static final String pathOut2 = "E:\\Java-program\\Java上机实验题目\\src\\Experiment_6\\pathOut2.txt";
    static final String pathOut3 = "E:\\Java-program\\Java上机实验题目\\src\\Experiment_6\\pathOut3.txt";

    public static void main(String[] args) throws IOException {
        creatTxt(1000L);
        IPProcessImpl1 ipProcessImpl1 = new IPProcessImpl1();
        ipProcessImpl1.process(new File(pathIn), new File(pathOut1));
        IPProcessImpl2 ipProcessImpl2 = new IPProcessImpl2();
        ipProcessImpl2.process(new File(pathIn), new File(pathOut2));
        IPProcessImpl3 ipProcessImpl3 = new IPProcessImpl3();
        ipProcessImpl3.process(new File(pathIn), new File(pathOut3));
    }

    //生成 sum 个ipv4地址并写入文件,建议个数不要设的太大
    public static void creatTxt(long sum) throws IOException {
        //生成sum条ipv4地址，文件生成位置可以自行设置
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathIn));
        StringBuilder sb;
        Random ran = new Random();
        long start = System.currentTimeMillis();
        for (long i = 1L; i <= sum; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
/*              此处本应该是int a = ran.nextInt(255);
                但是为了能模拟出更多重复的情况，随机数取值范围设为5*/
                int a = ran.nextInt(5);
                sb.append(a).append(".");
            }
            int a = ran.nextInt(5);
            sb.append(a);
            bw.write(sb.toString());
            double d = 1.0 * i / sum;
            bw.newLine();
        }
        bw.close();
        long end = System.currentTimeMillis();
        System.out.println("生成1000条数据一共耗费了:" + (end - start) + "毫秒");
    }
}
