package com.myApp.myApp.entities.concretes;

import lombok.Data;

@Data
public class UserVM {

    private String userFirstName;

    private String username;

    private String image;



    public UserVM(User user){
        this.setUsername(user.getUsername());
        this.setImage(user.getuserImage());
        this.setUserFirstName(user.getUserFirstName());
    }

}
