package views;

import controllers.Events;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarInsta extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private static final String ADD_FILE = "Search Profile";
    private static final String FILE = "File";

    private JMenu menuFile;
    private JMenuItem itemShowAddFolder;

    public MenuBarInsta(ActionListener controller) {

        menuFile = new JMenu(FILE);

        itemShowAddFolder = new JMenuItem(ADD_FILE);
        itemShowAddFolder.addActionListener(controller);
        itemShowAddFolder.setActionCommand(Events.SHOW_DIALOG_SEARCH.toString());
        menuFile.add(itemShowAddFolder);

        add(menuFile);
    }
}