package android.itacademy.by.dz6.student;

public class Student {
    private String firstName;
    private String lastName;
    private String textUrl;
    private int Id;

    public Student(String firstName, String lastName, String textUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.textUrl = textUrl;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    public String getTextUrl() {
        return textUrl;
    }
}
