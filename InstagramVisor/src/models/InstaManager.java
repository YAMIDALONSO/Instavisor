package models;

import java.util.ArrayList;

public class InstaManager {
    
    ArrayList<User> userlList;

    public InstaManager(ArrayList<User> userlList) {
        this.userlList = userlList;
    }
    
    public static User createUser(String nick, String photo, int publicationsNumber, int followers, int following, ArrayList<String> photos, String desccription){
        return new User(nick, photo, publicationsNumber, followers, following, photos, desccription);
    }

    public User searchUser(String user) {
        return userlList.get(0);
    }

    public ArrayList<User> getUserlList() {
        return userlList;
    }
}