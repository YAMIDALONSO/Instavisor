package views;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import models.User;

public class InstaWindow extends JFrame {

    private static final String TITLE = "InstagramSearch";
    private static final String ICON = "/data/Icon.jpg";
    private static final String DEFAULT_PIC = "/data/profile.png";
    private static final String DESCRIPTION = "No hay descripcion";
    private static final String FOLLOWING = " seguidos";
    private static final String FOLLOWERS = " seguidores";
    private static final String PUBLICATIONS = " publicaciones";
    private static final String NAME = "Nombre";

    private MenuBarInsta menuBarInsta;
    private JLabel jlNick;
    private JLabel jlImage;
    private JLabel publications;
    private JLabel followers;
    private JLabel following;
    private JLabel description;

    private PanelPhotos panelPhotos;

    public InstaWindow(ActionListener controller) {
        setTitle(TITLE);
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        setLayout(new GridLayout(3, 3));

        menuBarInsta = new MenuBarInsta(controller);
        setJMenuBar(menuBarInsta);

        jlNick = new JLabel(NAME);
        add(jlNick);

        jlImage = new JLabel(new ImageIcon(getClass().getResource(DEFAULT_PIC)));
        add(jlImage);

        publications = new JLabel(0 + PUBLICATIONS);
        add(publications);

        followers = new JLabel(0 + FOLLOWERS);
        add(followers);

        following = new JLabel(0 + FOLLOWING);
        add(following);

        description = new JLabel(DESCRIPTION);
        add(description);

        setVisible(true);
    }

    public void refreshWindow(User user, ArrayList<Icon> photos, Icon image) {
        jlNick.setText(user.getNick());
        description.setText(user.getDesccription());
        publications.setText(user.getPublicationsNumber() + PUBLICATIONS);
        followers.setText(user.getFollowers() + FOLLOWERS);
        following.setText(user.getFollowing() + FOLLOWING);
        jlImage.setIcon(image);
        panelPhotos = new PanelPhotos(photos);
        add(panelPhotos);
    }
}