package models;

import java.util.ArrayList;

public class User {

    private String nick;
    private int publicationsNumber;
    private int followers;
    private int following;
    private ArrayList<String> photos;
    private String desccription;
    private String photo;

    public User(String nick, String photo, int publicationsNumber, int followers, int following, ArrayList<String> photos, String desccription) {
        this.nick = nick;
        this.publicationsNumber = publicationsNumber;
        this.followers = followers;
        this.following = following;
        this.photos = photos;
        this.desccription = desccription;
        this.photo = photo;
    }

    public String getNick() {
        return nick;
    }

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public String getDesccription() {
        return desccription;
    }

    public String getPhoto() {
        return photo;
    }
}