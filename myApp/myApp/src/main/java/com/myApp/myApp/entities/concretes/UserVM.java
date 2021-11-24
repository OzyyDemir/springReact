package com.myApp.myApp.entities.concretes;

import lombok.Data;

@Data
public class UserVM {

    private String userFirstName;

    private String userName;

    private String image;



    public UserVM(User user){
        this.setUserName(user.getUserName());
        this.setImage(user.getuserImage());
        this.setUserFirstName(user.getUserFirstName());
    }

}
