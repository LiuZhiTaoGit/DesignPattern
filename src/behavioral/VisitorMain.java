package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuzt
 * @date: 2024/4/17 - 04 - 17 - 16:11
 * @description: behavioral  参观者模式
 * @version: 1.0
 */
public class VisitorMain {
    public static void main(String[] args) {
        PersonStructure personStructure = new PersonStructure();
        Visitor1 visitor1 = new Visitor1();
        System.out.println("访问者1的访问记录");
        personStructure.Accept(visitor1);


        Visitor2 visitor2 = new Visitor2();
        System.out.println("访问者2的访问记录");
        personStructure.Accept(visitor2);


    }
}


interface Visitor{ //访问的人
    public void visitStudent(Student student);//访问学生
    public void visitTeacher(Teacher teacher);//访问老师

}

class Visitor1 implements Visitor{//访问者1
    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者1访问学生："+student.name);

    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者1访问老师" + teacher.name);


    }

}

class Visitor2 implements Visitor{//访问者2
    @Override
    public void visitStudent(Student student) {
        System.out.println("访问者2访问学生" + student.name);

    }

    @Override
    public void visitTeacher(Teacher teacher) {
        System.out.println("访问者2访问老师" + teacher.name);
    }

}


class PersonStructure{
    private List<Person> personList = new ArrayList<Person>();
    public PersonStructure(){
        personList.add(new Student("章1"));
        personList.add(new Student("章2"));
        personList.add(new Student("章3"));

        personList.add((new Teacher("shi1")));
        personList.add((new Teacher("shi2")));
        personList.add((new Teacher("shi3")));

    }

    public void Accept(Visitor visitor){
        for (Person person : personList) {
            person.Accept(visitor);
        }
    }
}


abstract class Person{
    public String name;
    public abstract void Accept(Visitor visitor);

}

class Student extends Person{
    public Student(String name){
        this.name = name;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitStudent(this);
    }
}

class Teacher extends  Person{
    public Teacher(String name){
        this.name = name;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitTeacher(this);

    }
}


