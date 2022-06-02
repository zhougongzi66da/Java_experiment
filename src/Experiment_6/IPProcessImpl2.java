package Experiment_6;

import java.io.*;
import java.net.InetAddress;
import java.util.HashSet;

public class IPProcessImpl2 implements IPProcess {

    static final int Max_1G = 1024 * 1024 * 1024;

    @Override
    public void process(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        byte[] memory = new byte[Max_1G];//模拟1G内存
        int sum = 0;//记录不重复的ipv4地址个数;
        String s;
        while ((s = br.readLine()) != null) {
            String[] split = s.split("\\.");// “.”等特殊字符需要进行转义
            byte[] temp = new byte[4];
            for (int i = 0; i < 4; i++) { //将读入的字符串转化成四位的byte数组
                temp[i] = (byte) Integer.parseInt(split[i]);
            }

            //遍历memory,四位一组做比较
            boolean repeat = false;
            for (int i = 0; i < 4 * sum; i += 4) {
                int index = i;
                int repeat_num = 0;
                for (int j = 0; j < 4; j++) { //将读入的字符串转化成四位的byte数组
                    if (temp[j] == memory[index])
                        repeat_num++;
                    index++;
                }
                //如果一组四个都重复，说明字符串重复
                if (repeat_num == 4) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                int index = sum * 4;
                for (int i = 0; i < 4; i++) { //将读入的字符串转化成四位的byte数组
                    memory[index++] = temp[i];
                }
                sum++;//个数加一
            }
        }

        //将充当内存的数组memory内的信息写入文件
        for (int i = 0; i < sum * 4; i += 4) {
            byte[] temp = {memory[i], memory[i + 1], memory[i + 2], memory[i + 3]};
            //InetAddress.getByAddress 可以将四位的byte数组转化为字符串
            //比如数组[1,2,3,4]可以转化为字符串/1.2.3.4
            InetAddress byAddress = InetAddress.getByAddress(temp);
            bw.write(byAddress.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
        long end = System.currentTimeMillis();
        System.out.println("方式二处理数据数据耗费了:" + (end - start) / 1000 + "秒");
    }
}
