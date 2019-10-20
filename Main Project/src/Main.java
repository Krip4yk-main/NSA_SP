import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static int w = 1280, h = 720;

    public static JFrame form;
    public static JPanel corePanel;
    public static JPanel sidebar, active;
    public static JPanel home, categories, library, activity, projects, settings;
    public static int act = 0;
    private static CategoriesElements categoriesElements[];

    public static Dimension size, size_active, size_sidebar;

    public static void main(String[] args) {
        size = new Dimension(w, h);
        size_sidebar = new Dimension(260, h);
        size_active = new Dimension(w-260, h);
        {
            System.out.println("run setForm...");
            setForm();
            System.out.println("run setSidebar...");
            setSidebar();
            System.out.println("run setActive...");
            setActive();
            System.out.println("run setPanels...");
            setCorePanel();
        }

        {
            System.out.println("Create sideBarElements...");
            int n_sb = 10;
            SideBarElements sideBarElements[] = new SideBarElements[n_sb];
            sideBarElements[0] = new SideBarElements(0, "Home", "data\\1.png");
            sideBarElements[1] = new SideBarElements(1, "Categories", "data\\2.png");
            sideBarElements[2] = new SideBarElements(2, "Library", "data\\3.png");
            sideBarElements[3] = new SideBarElements(3, "Activity", "data\\4.png");
            sideBarElements[4] = new SideBarElements(4, "Projects", "data\\5.png");
            sideBarElements[5] = new SideBarElements(5);
            sideBarElements[6] = new SideBarElements(6);
            sideBarElements[7] = new SideBarElements(7);
            sideBarElements[8] = new SideBarElements(8);
            sideBarElements[9] = new SideBarElements(9, "Settings", "data\\9.png");

            for (int i = 0; i < n_sb; i++) {
                int finalI = i;
                sideBarElements[i].panel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        for (int i = 0; i < n_sb; i++) {
                            sideBarElements[i].panel.setBackground(Color.gray);
                        }
                        sideBarElements[finalI].panel.setBackground(Color.red);

                        click_sidebar(e, finalI);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }

            System.out.println("Add sideBarElements...");
            for (int i = 0; i < n_sb; i++) {
                sidebar.add(sideBarElements[i].panel);
            }
        } // sidebar elements

        {
            setHome();
        } // home

        {
            setCategories();

            int n_c = 10;
            categoriesElements = new CategoriesElements[n_c];
            categoriesElements[0] = new CategoriesElements(0, "History");
            categoriesElements[1] = new CategoriesElements(1, "Tech");
            categoriesElements[2] = new CategoriesElements(2, "Technology");
            categoriesElements[3] = new CategoriesElements(3, "Guides");
            categoriesElements[4] = new CategoriesElements(4, "Patents");
            categoriesElements[5] = new CategoriesElements(5, "Patterns");
            categoriesElements[6] = new CategoriesElements(6, "Famous People");
            categoriesElements[7] = new CategoriesElements(7, "Theoretic");
            categoriesElements[8] = new CategoriesElements(8, "Research");
            categoriesElements[9] = new CategoriesElements(9, "Other");

            for (int i = 0; i < n_c; i++) {
                int finalI = i;
                categoriesElements[i].panel.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        click_categories(e, finalI);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }

            categoriesElements[0].addCategPanel("Title");
            categoriesElements[0].addCategPanel("Title");
            categoriesElements[0].addCategPanel("Title");
            categoriesElements[0].addCategPanel("Title");

            categoriesElements[1].addCategPanel("Title");
            categoriesElements[1].addCategPanel("Title");
            categoriesElements[1].addCategPanel("Title");

            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");
            categoriesElements[2].addCategPanel("Title");


            for (int i = 0; i < n_c; i++) {
                categories.add(categoriesElements[i].panel);
            }
            for (int i = 0; i < n_c; i++) {
                categories.add(categoriesElements[i].mainPanel);
            }
        } // catefories

        {
            setLibrary();
        } // library

        {
            setActivity();
        } // activity

        {
            setProjects();
        } // projects

        {
            setSettings();
        } // settings

        active.add(home);
        active.add(categories);
        active.add(library);
        active.add(activity);
        active.add(projects);
        active.add(settings);
        {
            System.out.println("Add panels|elements...");
            corePanel.add(sidebar);
            corePanel.add(active);
            form.add(corePanel);
            corePanel.updateUI();
            System.out.println("Done.");
        }
    }

    public static void setForm() {
        form = new JFrame("untilted");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setResizable(false);
        form.setSize(1294, 757);
        form.setVisible(true);
    }
    private static void setCorePanel() {
        corePanel = new JPanel();
        corePanel.setLayout(null);
        corePanel.setSize(size);
        corePanel.setLocation(0, 0);
    }
    private static void setSidebar() {
        sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setSize(size_sidebar);
        sidebar.setLocation(0, 0);
        sidebar.setBackground(Color.blue);
    }
    private static void setActive() {
        active = new JPanel();
        active.setLayout(null);
        active.setSize(size_active);
        active.setLocation(260, 0);
        active.setBackground(Color.yellow);
    }
    private static void setHome() {
        home = new JPanel();
        home.setVisible(true);
        home.setSize(size_active);
        home.setLocation(0, 0);
        home.setLayout(null);
    }
    private static void setCategories() {
        categories = new JPanel();
        categories.setVisible(false);
        categories.setSize(size_active);
        categories.setLocation(0, 0);
        categories.setLayout(null);
    }
    private static void setLibrary() {
        library = new JPanel();
        library.setVisible(false);
        library.setSize(size_active);
        library.setLocation(0, 0);
        library.setLayout(null);
    }
    private static void setActivity() {
        activity = new JPanel();
        activity.setVisible(false);
        activity.setSize(size_active);
        activity.setLocation(0, 0);
        activity.setLayout(null);
    }
    private static void setProjects() {
        projects = new JPanel();
        projects.setVisible(false);
        projects.setSize(size_active);
        projects.setLocation(0, 0);
        projects.setLayout(null);
    }
    private static void setSettings() {
        settings = new JPanel();
        settings.setVisible(false);
        settings.setSize(size_active);
        settings.setLocation(0, 0);
        settings.setLayout(null);
    }
    private static void click_sidebar(MouseEvent me, int index) {
        if (act == index) return;
        closeAct(act);
        act = index;
        switch (index) {
            case 0: {
                home.setVisible(true);
                break;
            }
            case 1: {
                categories.setVisible(true);
                break;
            }
            case 2: {
                library.setVisible(true);
                break;
            }
            case 3: {
                activity.setVisible(true);
                break;
            }
            case 4: {
                projects.setVisible(true);
                break;
            }
            case 5: {
                home.setVisible(true);
                act = index;
                break;
            }
            case 6: {
                home.setVisible(true);
                act = index;
                break;
            }
            case 7: {
                home.setVisible(true);
                act = index;
                break;
            }
            case 8: {
                home.setVisible(true);
                act = index;
                break;
            }
            case 9: {
                settings.setVisible(true);
                break;
            }
            default: {
                System.out.println("(click_sidebar) Out of range...");
            }
        }
    }
    private static void closeAct(int index) {
        switch (index) {
            case 0: {
                home.setVisible(false);
                break;
            }
            case 1: {
                categories.setVisible(false);
                break;
            }
            case 2: {
                library.setVisible(false);
                break;
            }
            case 3: {
                activity.setVisible(false);
                break;
            }
            case 4: {
                projects.setVisible(false);
                break;
            }
            case 5: {
                home.setVisible(false);
                break;
            }
            case 6: {
                home.setVisible(false);
                break;
            }
            case 7: {
                home.setVisible(false);
                break;
            }
            case 8: {
                home.setVisible(false);
                break;
            }
            case 9: {
                settings.setVisible(false);
                break;
            }
        }
    }
    private static void click_categories(MouseEvent me, int index) {
        categoriesElements[index].showCategories();
    }
}
class SideBarElements {
    public JPanel panel;
    public int index; //[0..9]
    public Dimension size;
    public Point location;
    public JLabel text;
    public JLabel image;
    public BufferedImage b_image = null;

    public SideBarElements(int index, String label, String img) {
        panel = new JPanel();
        this.index = index;
        size = new Dimension(260, 72);
        location = new Point(0, index*72);
        text = new JLabel(label);
        /*URL img_url = null;
        try {
            img_url = new URL(img);
            b_image = ImageIO.read(img_url);
        } catch (Exception e) {}*/
        try {
            b_image = ImageIO.read(new File(img));
        } catch (IOException e) {}

        image = new JLabel(new ImageIcon(b_image));

        image.setSize(44, 44);
        image.setLocation(14, 14);

        text.setSize(188, 44);
        text.setLocation(72, 14);
        text.setFont(new Font(Font.SERIF, 0, 21));

        panel.setSize(size);
        panel.setLocation(location);
        panel.setBackground(Color.gray);
        panel.setBorder(new LineBorder(Color.black));
        panel.setLayout(null);

        panel.add(image);
        panel.add(text);
    }

    public SideBarElements(int index) {
        panel = new JPanel();
        this.index = index;
        size = new Dimension(260, 72);
        location = new Point(0, index*72);

        panel.setSize(size);
        panel.setLocation(location);
        panel.setVisible(false);
    }
}

class CategoriesElements {
    public JPanel panel;
    public JPanel mainPanel;
    public JLabel title;
    public JLabel text;
    public int index;
    private boolean fatr = false;
    private CategoriesContains categoriesContains[];
    private int ind = 0;
    private JButton button;

    public CategoriesElements(int index, String title) {
        panel = new JPanel();
        this.title = new JLabel(title);
        this.index = index;
        mainPanel = new JPanel();
        categoriesContains = new CategoriesContains[16];
        button = new JButton("Back");

        button.setSize(12, 12);
        button.setLocation(0, 0);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCategories();
            }
        });

        mainPanel.setSize(1020, 720);
        mainPanel.setLocation(0, 0);
        mainPanel.setBackground(Color.orange);
        mainPanel.setVisible(false);

        this.title.setLocation(14, 14);
        this.title.setSize(996, 44);
        this.title.setFont(new Font(Font.SERIF, Font.PLAIN, 21));

        panel.setLayout(null);
        panel.setSize(1020, 72);
        panel.setLocation(0, index*72);
        panel.setBorder(new LineBorder(Color.black));

        panel.setBackground(Color.red);

        panel.add(this.title);

        mainPanel.add(button);
    }
    public void showCategories() {
        if (fatr) {
            fatr = false;
        } else {
            fatr = true;
        }
        mainPanel.setVisible(fatr);
    }
    public void addCategPanel(String title) {
        System.out.println(title);
        System.out.println(ind);
        categoriesContains[ind] = new CategoriesContains(ind, title);
        mainPanel.add(categoriesContains[ind].panel);
        ind++;
    }
}
class CategoriesContains {
    public JPanel panel;
    public JTextArea textArea;
    public int index;

    public CategoriesContains(int index, String title) {
        panel = new JPanel();
        textArea = new JTextArea();
        this.index = index;

        panel.setSize(156, 224);
        panel.setLocation(12+(index*12)+(index*156), 12 + ((index/6)*12) + ((index/6)*224));

        panel.setBackground(Color.darkGray);
    }
}