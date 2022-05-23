package Experiment_2.problem_2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class test {
    public static void main(String[] args) {
        int sum=0;
        String tmp;
        int i;
        Scanner sc=new Scanner(System.in);
        while (true) {
            tmp = sc.nextLine();
            try {
                i = parseInt(tmp);
            }catch (NumberFormatException e){
                try {
                    i=calculate(tmp);
                }catch (Exception c){
                    continue;
                }
            }
            if(i==999)
                break;
            else sum+=i;
        }
        System.out.println(sum);
    }

    public static int result(int opt1,int opt2,char sign){
        int res=0;
        switch (sign){
            case '+':
                res=opt1+opt2;
                break;
            case '-':
                res=opt1-opt2;
                break;
            case '*':
                res=opt1*opt2;
                break;
            case '/':
                res=opt1/opt2;
                break;
        }
        return res;
    }

    public static int calculate(String s){
        int n=s.length();
        HashMap<Character, Integer>grade=new HashMap<>();
        grade.put('(',4);
        grade.put('*',3);
        grade.put('/',3);
        grade.put('+',2);
        grade.put('-',2);
        grade.put(')',1);
        Deque<Integer>data = new LinkedList<>();
        Deque<Character>sign= new LinkedList<>();
        for (int i=0;i<n;i++){
            if (Character.isDigit(s.charAt(i))) {
                int num=0;
                while (i<n&&Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-48;
                    i++;
                }
                data.push(num);
            }
            if(i<n){
                if(sign.isEmpty()||grade.get(s.charAt(i))>grade.get(sign.peek()))
                    sign.push(s.charAt(i));
                else {
                    while (!sign.isEmpty()&&grade.get(s.charAt(i))<=grade.get(sign.peek())){
                        if(sign.peek().equals('('))
                            break;
                        Character sin = sign.pop();
                        Integer opt1 = data.pop();
                        Integer opt2=data.pop();
                        int result = result(opt2, opt1, sin);
                        data.push(result);
                    }
                    if(!(s.charAt(i) ==')'))
                        sign.push(s.charAt(i));
                    else sign.pop();
                }
            }
        }
        while (!sign.isEmpty()) {
            Character sin = sign.pop();
            Integer opt1 = data.pop();
            Integer opt2 = data.pop();
            int result = result(opt2, opt1, sin);
            data.push(result);
        }
        return data.pop();
    }
}
