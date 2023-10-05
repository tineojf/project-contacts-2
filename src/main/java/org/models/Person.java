package org.models;

public class Person {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String country;
    private String birthday;

    public Person() {
    }

    public Person(String name, String lastname, String email, String phone, String country, String birthday) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return lastname + ", " + name + " - " + phone;
    }
}
