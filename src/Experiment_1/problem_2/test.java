package Experiment_1.problem_2;

public class test {
    public static void main(String[] args) {
        int a, b, c;
        for (int i = 100; i < 1000; i++) {
            a = i % 10;
            b = i % 100 / 10;
            c = i / 100;
            if ((a * a * a) + (b * b * b) + (c * c * c) == i) {
                System.out.println(i);
            }
        }
    }
}
