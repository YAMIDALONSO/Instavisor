package views;

import controllers.Events;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DialogSearch extends JDialog {
    
    private JTextField searchBox;
    private static final String SEARCH = "Buscar";
    private JButton jbSearch;
    
    public DialogSearch(JFrame frame, ActionListener controller) {
        super(frame, true);
        setTitle(SEARCH);
        setSize(500, 500);
        setLocationRelativeTo(frame);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        searchBox = new JTextField("UPTC");
        add(searchBox);
        
        jbSearch = new JButton(SEARCH);
        jbSearch.addActionListener(controller);
        jbSearch.setActionCommand(Events.SEARCH.toString());
        add(jbSearch);
    }

    public String getUser() {
        return searchBox.getText();
    }
}