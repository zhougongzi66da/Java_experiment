package Experiment_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class test {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入文件路径:");
        Scanner reader=new Scanner(System.in);
        String filename=reader.next();
        BufferedReader bfr=new BufferedReader(new FileReader(filename));//字符缓冲输入流读文件
        StringBuilder context=new StringBuilder();
        String line;
        while ((line= bfr.readLine())!=null){
            context.append(line);
        }
/*      1.用单个空格替换HTML标签和非英文的字符
        2.将连续的空格替换为单个空格
        3.去除首尾空格
        4.将所有字符转为大写    */
        String ctx= context.toString().
                    replaceAll("<.+?>|[^a-zA-Z]"," ").
                    replaceAll(" {2,}"," ").
                    trim().toUpperCase();
        HashMap<String, Integer> map = new HashMap<>();
        String[] sArray= ctx.split(" ");
        for (String s:sArray){
            Integer num = map.get(s);
            if(num==null){ //哈希表中此单词不存在，添加
                map.put(s,1);
            }else {
                map.replace(s,++num); //哈希表中此单词存在，数量+1
            }
        }
        int length = sArray.length;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> res:entries){
            String key = res.getKey();
            Integer value = res.getValue();
            double d=1.0*value/length;
            System.out.println("单词"+key+"的词频是"+String.format("%.2f",d));
        }
    }
}
