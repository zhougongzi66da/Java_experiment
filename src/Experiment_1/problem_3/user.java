package Experiment_1.problem_3;

public class user {
    static String name;
    static int age;
    private int height;
    private int weight;
    static U u=new U();
    //初始化块
    {
        name="aaa";
        age=20;
        height=180;
        weight=80;
        System.out.println("初始化块:"+"name="+name+",age="+age+",height="+height+",weight="+weight);
    }

    //静态初始化块
    static {
        name="bbb";
        age=21;
        System.out.println("静态初始化块:"+"name="+name+",age="+age);
    }

    //构造函数初始化
    public user() {
        name="ccc";
        age=19;
        height=175;
        weight=75;
        System.out.println("构造函数初始化:"+"name="+name+",age="+age+",height="+height+",weight="+weight);
    }
}
