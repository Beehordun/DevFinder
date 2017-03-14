package com.example.biodun.lagosjavacoders;



/**
 * Created by Biodun on 3/8/2017.
 */

// A class to hold the needed Users' information
public class UserClass {
    private String userName;
    private String avatarUrl;
    private String htmlUrl;

    public UserClass(String userName,String avatarUrl,String htmlUrl)
    {
        this.userName=userName;
        this.avatarUrl=avatarUrl;
        this.htmlUrl=htmlUrl;

    }

    public String getUserName() {
        return userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
