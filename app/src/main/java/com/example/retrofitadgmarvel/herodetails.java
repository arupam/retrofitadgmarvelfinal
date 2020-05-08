package com.example.retrofitadgmarvel;

public class herodetails {
    //"name":"Captain America",
    // "realname":"Steve Rogers",
    // "team":"Avengers",
    // "firstappearance":"1941",
    // "createdby":"Joe Simon",
    // "publisher":"Marvel Comics",
    // "imageurl":"",
    // "bio":"\r\n\t\tSteven Rogers was born in the Lower East Side of Manhattan, New York City, in 1925 to poor Irish immigrants, Sarah and Joseph Rogers.[54] Joseph died when Steve was a child, and Sarah died of pneumonia while Steve was a teen. By early 1940, before America's entry into World War II, Rogers is a tall, scrawny fine arts student specializing in illustration and a comic book writer and artist.\r\n\t\t"}


    private String name ;
    private String realname ;
    private String team ;
    private String firstappearance ;
    private String createdby ;
    private String publisher ;
    private String imageurl ;
    private String bio ;


    public herodetails(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}
