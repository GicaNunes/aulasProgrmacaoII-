import java.awt.*;
import javax.Swing.*;

public class MinhaJanela extends JFrame {
    private final JButton b1 = new JButton("OK");
    private final JButton b2 = new JButton("Cancela");

    public MinhaJanela() throws HeadlessException {
        super("Apenas um teste");
        setLayout(new BorderLayout());
        setBounds(10, 10, 300, 200);
        JPanel jp = new JPanel(new FlowLayout());
        jp.add(b1);
        jp.add(b2);
        add(jp,"South");
    }

    public static void main(String[] args) {
        new MinhaJanela().setVisible(true);
    }
}