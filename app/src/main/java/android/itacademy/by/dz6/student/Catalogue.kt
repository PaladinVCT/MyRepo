package android.itacademy.by.dz6.student

import java.util.ArrayList
import javax.inject.Singleton

@Singleton
class Catalogue {
    val list = ArrayList<Student>()

    init {
        list.add(0, Student("Vasya", "Pupkin", "https://cdn4.iconfinder.com/data/icons/avatar-vol-13/512/9-512.png"))
        list.add(1, Student("Petya", "Jopkin", "http://www.auraapp.co/files/Management-333x1024.png"))
        list.add(2, Student("Sasa", "Saskin", "https://data.ac-illust.com/data/thumbnails/3c/3cf65da1a58935b4254f33d915a1bf72_w.jpeg"))
        list.add(3, Student("Dmitry", "Juravlev", "https://st.depositphotos.com/1734074/4662/v/950/depositphotos_46622623-stock-illustration-user-man-with-glasses-and.jpg"))
        list.add(4, Student("Igor", "Mihei", "http://sohocapitalmedan.com/images/sohocapitalmedan_06news/1501578764_user.jpg"))
        list.add(5, Student("Denis", "Yasev", "https://cache3.youla.io/files/images/780_780/5a/df/5adf9821e7696a597c75e052.jpg"))
        list.add(6, Student("Vadim", "Cvetkov", "http://genedu.msu.ac.th/time/meeting/img/110518_045603.png"))
        list.add(7, Student("Sergey", "Levchenko", "http://cdn.onlinewebfonts.com/svg/img_507367.png"))
        list.add(8, Student("Anton", "Yakunin", "https://pp.userapi.com/c824410/v824410211/17ddb8/pFcJaNZGurI.jpg"))
        list.add(9, Student("Semen", "Kuldoshin", "https://ya-webdesign.com/images/avatar-icon-png.png"))
        list.add(10, Student("Vova", "Gruzev", "http://borsalisesi.meb.k12.tr/meb_iys_dosyalar/07/19/969922/resimler/2017_10/07214942_bay_-_Kopya_-_Kopya_-_Kopya_-_Kopya.jpg"))
        list.add(11, Student("Grisha", "Shmelev", "https://cache3.youla.io/files/images/780_780/59/b3/59b3baf685e9d27e1f6752a2.jpg"))
    }

    companion object {
        val instance = Catalogue()
    }
}