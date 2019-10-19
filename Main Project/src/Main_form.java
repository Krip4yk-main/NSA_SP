import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main_form {
    public JPanel core_panel;
    private JPanel menu, sidebar, active;
    private JScrollPane scrollPane;

    public static int w = 1280, h = 720;
    public Dimension size, size_board, size_active;

    public Main_form() {
        ini();

        int n = 100, n_len = 0;
        ListElement element[] = new ListElement[n];
        ListElementContent elementContent[] = new ListElementContent[n];
        for (int i = 0; i < 20; i++, n_len++) {
            element[i] = new ListElement(i, "Lorem ipsum", new Dimension(size_active.width-17, 74));
            elementContent[i] = new ListElementContent(size_active, "Title", "lorem ipsum dolem");
        }
        {
            for (int i = 0; i < n_len; i++) {
                active.add(element[i].panel);
            }
            scrollPane.setViewportView(active);

            core_panel.add(menu);
            core_panel.add(sidebar);
            core_panel.add(scrollPane);
        }//add
    }

    private void ini() {
        {
            core_panel = new JPanel();
            menu = new JPanel();
            sidebar = new JPanel();
            active = new JPanel();
            scrollPane = new JScrollPane(active);
        }// = new
        {
            core_panel.setLayout(null);
            menu.setLayout(null);
            sidebar.setLayout(null);
            active.setLayout(null);
        }//panel layout
        {
            size = new Dimension(w, h);
            size_board = new Dimension(280, 74);
            size_active = new Dimension(size.width - size_board.width, size.height - size_board.height);
        }//dimension sizes
        {
            core_panel.setSize(size);
            menu.setSize(size.width, size_board.height);
            sidebar.setSize(size_board.width, size.height);
            active.setSize(size_active);
            scrollPane.setSize(size_active);
        }//setSize
        {
            core_panel.setLocation(0, 0);
            menu.setLocation(0, 0);
            sidebar.setLocation(0, size_board.height);
            active.setLocation(size_board.width, size_board.height);
            scrollPane.setLocation(size_board.width, size_board.height);
        }//setLocation
        {
            core_panel.setBackground(Color.black);
            menu.setBackground(Color.red);
            sidebar.setBackground(Color.blue);
            active.setBackground(Color.green);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        }//properties
        {
        }//add
    }
}
class ListElement {
    public JPanel panel;
    private JLabel label;

    public int index; // [0..n]
    public Dimension size;

    public ListElement(int index, String text, Dimension size) {
        this.size = size;

        this.index = index;

        panel = new JPanel();
        label = new JLabel(text);

        panel.setLayout(null);

        panel.setSize(size);
        label.setSize(size.width/10*8, size.height/10*8);

        panel.setLocation(getLocation());
        label.setLocation(size.width/10, size.height/10);

        panel.setBackground(new Color(0, index*10, 0));

        panel.add(label);
    }
    private Point getLocation() {
        int x = 0;
        int y = (index * size.height);
        Point value = new Point(x, y);
        return value;
    }
} //contains literals
class ListElementContent {
    public JPanel panel;

    ListElementContent(Dimension size, String title, String text) {
        panel = new JPanel();

        panel.setSize(size);
        panel.setLocation(0, 0);
    }
}