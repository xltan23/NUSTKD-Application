package sg.edu.nus.iss.TaekwondoData.models;

import java.util.UUID;

public class Student {
    private final String id;
    private String fullName;
    private String gender;
    private String email;
    private String phone;
    private String grade;
    private String type;
    private String competeBefore;
    
    
    public Student() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String fn, String g, String e, String p, String gr, String t, String cb) {
        this.id = id;
        this.fullName = fn;
        this.gender = g;
        this.email = e;
        this.phone = p;
        this.grade = gr;
        this.type = t;
        this.competeBefore = cb;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompeteBefore() {
        return competeBefore;
    }

    public void setCompeteBefore(String competeBefore) {
        this.competeBefore = competeBefore;
    }

    @Override
    public String toString() {
        return "Student [competeBefore=" + competeBefore + ", email=" + email + ", fullName=" + fullName + ", gender="
                + gender + ", grade=" + grade + ", id=" + id + ", phone=" + phone + ", type=" + type + "]";
    }

}
