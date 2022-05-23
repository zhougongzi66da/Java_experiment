package Experiment_1.problem_4;

public class B extends A{
    public String name="类B";
    @Override
    public void show() {
        System.out.println("B的show()方法，对象类型："+this.getClass());
    }
    public String getName() {
        return name;
    }
}
