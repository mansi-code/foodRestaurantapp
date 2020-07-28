package com.example.myapplication;

public class user {
    String id;
    private String Name=null;
    private String Phone=null;
    private String Location=null;
    private String About=null;

    public user() {
    }

    public user( String name, String phone, String location, String about) {
        //this.id=id;
        this.Name = name;
        this.Phone = phone;
        this.Location = location;
        this.About = about;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }
   // public String getId() {
        //return id;
   // }
}
