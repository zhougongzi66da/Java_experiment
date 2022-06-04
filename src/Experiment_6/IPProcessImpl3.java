package Experiment_6;

import java.io.*;
import java.util.HashSet;

public class IPProcessImpl3 implements IPProcess {

    @Override
    public void process(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        RandomAccessFile readIn = new RandomAccessFile(in, "r");
        RandomAccessFile outPut = new RandomAccessFile(out, "rw");
        String s;//记录从readIn读取的字符串
        String temp;//记录outPut从输入文件中读取的字符串
        boolean repeat;//判断是否重复
        readIn.seek(0);   //readIn文件指针开始位置
        while ((s = readIn.readLine()) != null) {
            repeat = false;
            outPut.seek(0);//重置outPut文件指针开始位置
            //遍历outPut文件，在readIn文件中看是否有重复的字符串
            while ((temp = outPut.readLine()) != null) {
                if (s.equals(temp)) {
                    repeat = true;
                    break;
                }
            }
            //如果没有重复，将outPut文件指针置于文件末尾，写入字符串
            if (!repeat) {
                outPut.seek(outPut.length());
                outPut.writeBytes(s + "\n");
            }
        }
        readIn.close();
        outPut.close();
        long end = System.currentTimeMillis();
        System.out.println("方式三处理数据数据耗费了:" + (end - start) + "毫秒");
    }
}
