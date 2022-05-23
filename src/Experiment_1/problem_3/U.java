package Experiment_1.problem_3;

public class U {

    {
        System.out.println("U的初始化块");
    }

     static {
         System.out.println("U的静态初始化块");
     }

     public U (){
         System.out.println("U的构造函数初始化");
     }
}
