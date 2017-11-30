package views;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        menuBarInsta = new MenuBarInsta(controller);
        setJMenuBar(menuBarInsta);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.gridheight = 1;
        c.weighty = 0.01;
        for (int i = 0; i < 12; i++) {
            c.gridx = i;
            add(new JLabel(""), c);
        }

        c.gridy = 0;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridwidth = 3;

        jlImage = new JLabel(new ImageIcon(getClass().getResource(DEFAULT_PIC)));
        add(jlImage, c);

        c.gridy = 0;
        c.weighty = 0.1;
        c.gridx = 3;
        c.gridwidth = 3;

        jlNick = new JLabel(NAME);
        add(jlNick, c);

        c.gridy = 1;
        c.weighty = 0.1;
        c.gridx = 3;
        c.gridwidth = 2;

        publications = new JLabel(0 + PUBLICATIONS);
        add(publications, c);

        c.gridx = 5;

        followers = new JLabel(0 + FOLLOWERS);
        add(followers, c);

        c.gridx = 7;

        following = new JLabel(0 + FOLLOWING);
        add(following, c);

        c.gridx = 9;

        description = new JLabel(DESCRIPTION);
        add(description, c);

        c.gridy = 3;
        c.weighty = 1;
        c.gridx = 1;
        c.gridwidth = 9;

        JScrollPane jsp = new JScrollPane();
        panelPhotos = new PanelPhotos(null);
        jsp.setViewportView(panelPhotos);
        add(jsp, c);

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
