package com.example.loginregisterationapp.entity;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


import javax.persistence.*;

@Entity
@EnableEncryptableProperties
@Table(name = "USER_DATA")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private  String fullname;
    @Column(name = "Gender")
    private  String gender;
    @Column(name = "DOB")
    private  String dob;
    @Column(name = "Email")
    private String  email;
    @Column(name = "Password")
    private String  password;
    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
