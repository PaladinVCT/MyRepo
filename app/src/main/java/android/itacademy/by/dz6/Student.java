package android.itacademy.by.dz6;

public class Student {
    private String firstName;
    private String lastName;
    private String textUrl;

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

    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTextUrl() {
        return textUrl;
    }
}
