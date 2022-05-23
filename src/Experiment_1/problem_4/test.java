package Experiment_1.problem_4;

public class test {
    public static void main(String[] args) {
        A a1=new C();
        a1.show();
        System.out.println("静态绑定调用name成员："+a1.name);
        System.out.println("动态绑定调用name成员："+a1.getName());
        System.out.println("-------------------------------------");
        A a2=new B();
        a2.show();
        System.out.println("静态绑定调用name成员："+a2.name);
        System.out.println("动态绑定调用name成员："+a2.getName());
        System.out.println("-------------------------------------");
    }
}
