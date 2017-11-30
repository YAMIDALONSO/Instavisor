package persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import models.InstaManager;
import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonManager {

    private static final String BIOGRAPHY = "biography";
    private static final String FOLLOWS = "follows";
    private static final String USERNAME = "username";
    private static final String FOLLOWED_BY = "followed_by";
    private static final String MEDIA = "media";
    private static final String USER = "user";
    private static final String PATH = "instagram.json";
    private static final String COUNT = "count";
    private static final String PROFILE_PIC_URL = "profile_pic_url";
    private static final String NODES = "nodes";

    public ArrayList<User> readfile() throws FileNotFoundException, IOException, ParseException {
        ArrayList<User> users = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(PATH));
        JSONObject user = (JSONObject) root.get(USER);
        JSONObject media = (JSONObject) user.get(MEDIA);
        JSONObject followedBy = (JSONObject) user.get(FOLLOWED_BY);
        JSONObject follows = (JSONObject) user.get(FOLLOWS);
        users.add(InstaManager.createUser((String) user.get(USERNAME), (String) user.get(PROFILE_PIC_URL), (int) ((long) media.get(COUNT)), (int) ((long) followedBy.get(COUNT)), (int) ((long) follows.get(COUNT)), getLastImages(media), (String) user.get(BIOGRAPHY)));
        return users;
    }

    private ArrayList<String> getLastImages(JSONObject media) {
        ArrayList<String> images = new ArrayList<>();
        JSONArray nodes = (JSONArray) media.get(NODES);
        for (int i = 0; i < nodes.size(); i++) {
            JSONObject displaySrc = (JSONObject) nodes.get(i);
            images.add((String) displaySrc.get("display_src"));
        }
        return images;
    }
}