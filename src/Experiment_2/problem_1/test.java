package Experiment_2.problem_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int sum = 0;
        int i;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                i = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                continue;
            }
            if (i == 999)
                break;
            else sum += i;
        }
        System.out.println(sum);
    }
}
