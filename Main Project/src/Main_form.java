import javax.swing.*;
import java.awt.*;

public class Main_form {
    public JPanel core_panel;
    private JPanel menu, sidebar, active;

    public Dimension size, size_board, size_active;

    public Main_form(int w, int h) {
        {
            core_panel = new JPanel();
            menu = new JPanel();
            sidebar = new JPanel();
            active = new JPanel();
        }// = new
        {
            core_panel.setLayout(null);
            menu.setLayout(null);
            sidebar.setLayout(null);
            active.setLayout(null);
        }//panel layout
        {
            size = new Dimension(w, h);
            size_board = new Dimension(size.width / 10, size.height / 10);
            size_active = new Dimension(size.width - size_board.width, size.height - size_board.height);
        }//dimension sizes
        {
            core_panel.setSize(size);
            menu.setSize(size.width, size_board.height);
            sidebar.setSize(size_board.width, size.height);
            active.setSize(size_active);
        }//setSize
        {
            core_panel.setLocation(0, 0);
            menu.setLocation(0, 0);
            sidebar.setLocation(0, size_board.height);
            active.setLocation(size_board.width, size_board.height);
        }//setLocation
        {
            core_panel.setBackground(Color.black);
            menu.setBackground(Color.red);
            sidebar.setBackground(Color.blue);
            active.setBackground(Color.green);
        }//properties
        {
            core_panel.add(menu);
            core_panel.add(sidebar);
            core_panel.add(active);
        }//add
    }
}
class ListElement {
    private JPanel panel;
    public ListElement() {
        panel = new JPanel();
        panel.setLayout(null);
        //panel.setSize();
        //panel.setLocation();
    }
}