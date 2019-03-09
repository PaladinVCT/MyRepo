package android.itacademy.by.cw6;

public class Student {
    private String name;
    private String urlImage;

    public Student(String name, String urlImage) {
        this.name = name;
        this.urlImage = urlImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }
}
