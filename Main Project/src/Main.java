import javax.swing.*;
import java.awt.*;

public class Main {
    public static JFrame form;

    public static void main(String[] args) {
        ini();
    }

    public static void ini() {
        Main_form ttt = new Main_form(1280, 720);
        form = new JFrame("untilted");
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setResizable(false);
        form.setSize(1294, 757);
        form.add(ttt.core_panel);
        form.setVisible(true);
    }
}
