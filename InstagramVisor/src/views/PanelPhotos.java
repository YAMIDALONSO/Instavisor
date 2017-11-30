package views;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPhotos extends JPanel {

    private static final String DEFAULT_PIC = "/data/pic.png";

    public PanelPhotos(ArrayList<Icon> photos) {
        if (photos != null) {
            setLayout(new GridLayout(3, 3, 20, 20));
            for (Icon photo : photos) {
                add(new JLabel(photo));
            }
        } else {
            fill();
        }
    }

    private void fill() {
        setLayout(new GridLayout(3, 3, 20, 20));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Image iiNewSize = new ImageIcon(getClass().getResource(DEFAULT_PIC)).getImage();
                Image newPhoto = iiNewSize.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                add(new JLabel(new ImageIcon(newPhoto)));
            }
        }
        revalidate();
    }
}
