package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import models.InstaManager;
import org.json.simple.parser.ParseException;
import persistence.JsonManager;
import persistence.XmlManager;
import views.DialogSearch;
import views.InstaWindow;

public class Controller implements ActionListener {

    private InstaManager instaManager;
    private DialogSearch dialogSearch;
    private InstaWindow instaWindow;
    private JsonManager jsonManager;
    private XmlManager xmlManager;

    public Controller() {
        jsonManager = new JsonManager();
        instaWindow = new InstaWindow(this);
        dialogSearch = new DialogSearch(instaWindow, this);
        xmlManager = new XmlManager();
        try {
            instaManager = new InstaManager(jsonManager.readfile());
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(instaWindow, "Archivo no encontrado");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())) {
            case SHOW_DIALOG_SEARCH:
                showDialogSearch();
                break;
            case SEARCH:
                search();
                break;
        }
    }

    private void showDialogSearch() {
        dialogSearch.setVisible(true);
    }

    private void search() {
        try {
            dialogSearch.setVisible(false);
            instaWindow.refreshWindow(instaManager.searchUser(dialogSearch.getUser()),
                    getPhotosFromWeb(instaManager.searchUser(dialogSearch.getUser()).getPhotos()),
                    xmlManager.getWebImage(instaManager.searchUser(dialogSearch.getUser()).getPhoto()));
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<Icon> getPhotosFromWeb(ArrayList<String> photos) throws IOException {
        ArrayList<Icon> images= new ArrayList<>();
        for (String photo : photos) {
            images.add(xmlManager.getWebImage(photo));
        }
        return images;
    }
}