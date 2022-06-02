package Experiment_6;

import java.io.*;
import java.util.HashSet;

public class IPProcessImpl1 implements IPProcess {

    @Override
    public void process(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));

        HashSet<String> hs = new HashSet<>();

        String s;
        while ((s = br.readLine()) != null) hs.add(s);//读文件

        for (String str : hs) {
            bw.write(str);
            bw.newLine();
        }
        br.close();
        bw.close();
        long end = System.currentTimeMillis();
        System.out.println("方式一处理数据数据耗费了:" + (end - start) / 1000 + "秒");
    }
}
