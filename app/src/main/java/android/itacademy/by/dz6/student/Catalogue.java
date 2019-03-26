package android.itacademy.by.dz6.student;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private static final Catalogue instance = new Catalogue();
    private List<Student> list = new ArrayList<>();
    {
        list.add(0,new Student("Vasya","Pupkin","https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png"));
        list.add(1,new Student("Petya","Jopkin","http://www.auraapp.co/files/Management-333x1024.png"));
        list.add(2,new Student("Sasa","Saskin","https://data.ac-illust.com/data/thumbnails/3c/3cf65da1a58935b4254f33d915a1bf72_w.jpeg"));
        list.add(3,new Student("Dmitry","Juravlev","https://st.depositphotos.com/1734074/4662/v/950/depositphotos_46622623-stock-illustration-user-man-with-glasses-and.jpg"));
        list.add(4,new Student("Igor","Mihei","http://sohocapitalmedan.com/images/sohocapitalmedan_06news/1501578764_user.jpg"));
        list.add(5,new Student("Denis","Yasev","https://cache3.youla.io/files/images/780_780/5a/df/5adf9821e7696a597c75e052.jpg"));
        list.add(6,new Student("Vadim","Cvetkov","http://genedu.msu.ac.th/time/meeting/img/110518_045603.png"));
        list.add(7,new Student("Sergey","Levchenko","http://cdn.onlinewebfonts.com/svg/img_507367.png"));
        list.add(8,new Student("Anton","Yakunin","https://pp.userapi.com/c824410/v824410211/17ddb8/pFcJaNZGurI.jpg"));
        list.add(9,new Student("Semen","Kuldoshin","https://ya-webdesign.com/images/avatar-icon-png.png"));
        list.add(10,new Student("Vova","Gruzev","http://borsalisesi.meb.k12.tr/meb_iys_dosyalar/07/19/969922/resimler/2017_10/07214942_bay_-_Kopya_-_Kopya_-_Kopya_-_Kopya.jpg"));
        list.add(11,new Student("Grisha","Shmelev","https://cache3.youla.io/files/images/780_780/59/b3/59b3baf685e9d27e1f6752a2.jpg"));
    }
    public static Catalogue getInstance() {
        return instance;
    }

    private Catalogue() {
    }

    public void addStudent(Student student) {
        list.add(nextId(),student);
    }

    public void deleteStudent(int Id) {
        list.remove(Id);
    }

    public Student getStudent(int Id) {
        return list.get(Id);
    }

    public int countStudents(){
        return list.size();
    }

    public List<Student> getFullList(){
        return list;
    }

    public int nextId (){
       return list.size();
    }
}
