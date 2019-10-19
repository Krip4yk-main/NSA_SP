import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
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
            sideBarElements[0] = new SideBarElements(0, "Home", "data\\25694.png");
            sideBarElements[1] = new SideBarElements(1, "Categories", "data\\img_574467.png");
            sideBarElements[2] = new SideBarElements(2, "Library", "data\\115-512.png");
            sideBarElements[3] = new SideBarElements(3, "Activity", "data\\activity_execution_416666.png");
            sideBarElements[4] = new SideBarElements(4, "Projects", "data\\590-512.png");
            sideBarElements[5] = new SideBarElements(5);
            sideBarElements[6] = new SideBarElements(6);
            sideBarElements[7] = new SideBarElements(7);
            sideBarElements[8] = new SideBarElements(8);
            sideBarElements[9] = new SideBarElements(9, "Settings", "data\\setting-512.png");
            System.out.println("Add sideBarElements...");
            for (int i = 0; i < n_sb; i++) {
                sidebar.add(sideBarElements[i].panel);
            }
        }

        {
            setCategories();


            active.add(categories);
        } // catefories

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
        home.setSize(size_active);
        home.setLocation(0, 0);
    }
    private static void setCategories() {
        categories = new JPanel();
        categories.setVisible(false);
        categories.setSize(size_active);
        categories.setLocation(0, 0);
    }
    private static void setLibrary() {
        library = new JPanel();
        library.setVisible(false);
        library.setSize(size_active);
        library.setLocation(0, 0);
    }
    private static void setActivity() {
        activity = new JPanel();
        activity.setVisible(false);
        activity.setSize(size_active);
        activity.setLocation(0, 0);
    }
    private static void setProjects() {
        projects = new JPanel();
        projects.setVisible(false);
        projects.setSize(size_active);
        projects.setLocation(0, 0);
    }
    private static void setSettings() {
        settings = new JPanel();
        settings.setVisible(false);
        settings.setSize(size_active);
        settings.setLocation(0, 0);
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
        b_image = resize(b_image, 44, 44);

        image = new JLabel(new ImageIcon(b_image));

        image.setSize(44, 44);
        image.setLocation(14, 14);
        //image.setBounds(14, 14, 44, 44);

        text.setSize(188, 44);
        text.setLocation(72, 14);
        //text.setBounds(72, 14, 188, 44);

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
        panel.setBackground(Color.blue);
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }
}
class CategoriesElements {
    public JPanel panel;
    public JPanel contais;
    public JLabel title;
    public JLabel text;
    public int index;

    public CategoriesElements(int index, String title, String text, String img) {
        panel = new JPanel();
        contais = new JPanel();
        this.title = new JLabel(title);
        this.text = new JLabel(text);
        this.index = index;

    }
}