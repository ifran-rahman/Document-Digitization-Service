package com.example.documentdigitizationservice.Models;

public class Employee {
private String name;
private String userId;
private String email;
private String avatar;
private String role;

    public Employee(String name, String avatar, String role) {
        this.name = name;
       // this.userId = userId;
       // this.email = email;
        this.avatar = avatar;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public String getUserId() {
   //     return userId;
 //   }

//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

//    public String getEmail() {
//        return email;
//    }

   // public void setEmail(String email) {
     //   this.email = email;
   // }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

