package Experiment_1.problem_4;

public class C extends B{
    public String name="类C";
    @Override
    public void show() {
        System.out.println("C的show()方法，对象类型"+this.getClass());
    }
    public String getName() {
        return name;
    }
}
