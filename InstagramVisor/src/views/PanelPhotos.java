package views;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPhotos extends JPanel {

    public PanelPhotos(ArrayList<Icon> photos) {
        setLayout(new GridLayout(3, 3, 20, 20));
        if (photos != null) {
            for (Icon photo : photos) {
                add(new JLabel(photo));
            }
        }else{
        add(new JLabel("No Hay fotos para mostrar"));
        }
    }
}