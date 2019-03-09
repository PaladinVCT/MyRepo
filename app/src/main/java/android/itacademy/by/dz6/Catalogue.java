package android.itacademy.by.dz6;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private static final Catalogue instance = new Catalogue();
    private List<Student> list = new ArrayList<>();
    {
        list.add(new Student("Vasya","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya2","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya3","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya4","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya5","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya6","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya7","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya8","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya9","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya10","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya11","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
        list.add(new Student("Vasya12","Kot","\"https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png\""));
    }
    public static Catalogue getInstance() {
        return instance;
    }

    private Catalogue() {
    }

    public void addStudent(Student student) {
        list.add(student);
    }

    public void deleteStudent(Student student) {
        list.remove(student);
    }

    public Student getStudent(int i) {
        return list.get(i);
    }

    public int countStudents(){
        return list.size();
    }
}
