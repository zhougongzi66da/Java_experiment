package Experiment_2.problem_2;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class test {
    public static void main(String[] args) {
        int sum = 0;
        String tmp;
        int i;
        Scanner sc = new Scanner(System.in);
        while (true) {
            tmp = sc.nextLine();
            try {
                i = parseInt(tmp);
            } catch (NumberFormatException e) {
                try {
                    i = calculate(tmp);
                } catch (Exception c) {
                    continue;
                }
            }
            if (i == 999)
                break;
            else sum += i;
        }
        System.out.println(sum);
    }

    public static int result(int opt1, int opt2, char sign) {
        int res = 0;
        switch (sign) {
            case '+':
                res = opt1 + opt2;
                break;
            case '-':
                res = opt1 - opt2;
                break;
            case '*':
                res = opt1 * opt2;
                break;
            case '/':
                res = opt1 / opt2;
                break;
        }
        return res;
    }

    public static int calculate(String s) {
        int n = s.length();
        //将符号对应的优先级存入哈希表，方便后续判断优先级
        HashMap<Character, Integer> grade = new HashMap<>();
        grade.put('(', 4);
        grade.put('*', 3);
        grade.put('/', 3);
        grade.put('+', 2);
        grade.put('-', 2);
        grade.put(')', 1);
        //把Deque当作栈来用 data存储数，sign存储符号
        Deque<Integer> data = new LinkedList<>();
        Deque<Character> sign = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                //考虑到多位数字的情况
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - 48;
                    i++;
                }
                data.push(num);
            }
            if (i < n) {
                //当符号栈为空或者栈顶符号小于当前符号，直接入栈
                if (sign.isEmpty() || grade.get(s.charAt(i)) > grade.get(sign.peek()))
                    sign.push(s.charAt(i));
                else {
                    //当符号栈不为空并且栈顶符号大于当前符号，依次弹出栈中优先级高于或等于当前运算符的所有运算符
                    while (!sign.isEmpty() && grade.get(s.charAt(i)) <= grade.get(sign.peek())) {
                        //遇到左括号停止
                        if (sign.peek().equals('('))
                            break;
                        Character sin = sign.pop();
                        Integer opt1 = data.pop();
                        Integer opt2 = data.pop();
                        int result = result(opt2, opt1, sin);
                        data.push(result);
                    }
                    //如果当前运算符不是右括号，直接入栈
                    if (!(s.charAt(i) == ')'))
                        sign.push(s.charAt(i));
                        //当前运算符是右括号，不需要入栈，且需要把栈中剩余的左括号弹出
                    else sign.pop();
                }
            }
        }
        //如果符号栈不为空，则按照顺序依次处理剩余数据
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
