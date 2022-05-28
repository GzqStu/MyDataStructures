package com.gao.cn.array;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/27 15:31
 */
public class Student {

    private String name;
    private Integer age;
    private Double  score;

    public Student(String name,Integer age,Double score){
        this.name = name;
        this.age =age;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s,age: %s,score: %s)\n",name,age,score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        Student a = new Student("张三",32,64d);
        Student b = new Student("李四",54,88d);
        Student c = new Student("王五",21,99d);
        Student d = new Student("赵六",25,77d);
        arr.addLast(a);
        arr.addLast(b);
        arr.addLast(c);
        arr.addLast(d);
        arr.addLast(a);
        arr.addLast(a);
        arr.addLast(a);
        arr.addLast(a);
        arr.addLast(a);
        arr.addLast(a);
        arr.addLast(b);
        arr.addLast(b);
        arr.addLast(b);
        arr.addLast(c);
        System.out.println(arr);
        arr.removeElements(a);
        System.out.println(arr);
        arr.removeElements(b);
        System.out.println(arr);
    }
}
