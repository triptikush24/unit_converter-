import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    public JFrame mainframe;
    public JButton length, mass, volume, time;

    public static void main(String[] args) {
        // Use system look and feel for modern appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Home();
    }
    public Home() {
        mainframe = new JFrame("Unit Converter Pro");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(500, 400);
        mainframe.setLocationRelativeTo(null); // Center on screen

        // Main panel with vertical layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Title label
        JLabel title = new JLabel("Unit Converter Pro");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(Color.BLACK);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 20, 20));
        buttonPanel.setOpaque(false);

        length = new JButton("Length Converter");
        mass = new JButton("Mass Converter");
        volume = new JButton("Volume Converter");
        time = new JButton("Time Converter");

        JButton[] buttons = {length, mass, volume, time};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btn.setBackground(new Color(52, 152, 219));
            btn.setForeground(Color.BLACK);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
            buttonPanel.add(btn);
        }

        mainPanel.add(buttonPanel);
        mainframe.setContentPane(mainPanel);

        length.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Length length = new Length();
                length.setSize(600, 300);
                length.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                length.setVisible(true);
                length.setTitle("Length Converter");
            }
        });

        mass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mass mass = new Mass();
                mass.setSize(600, 300);
                mass.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mass.setVisible(true);
                mass.setTitle("Mass Converter");
            }
        });

        volume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Volume volume = new Volume();
                volume.setSize(600, 300);
                volume.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                volume.setVisible(true);
                volume.setTitle("Volume Converter");
            }
        });

        time.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Time time = new Time();
                time.setSize(600, 300);
                time.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                time.setVisible(true);
                time.setTitle("Time Converter");
            }
        });

        mainframe.setVisible(true);
    }
}
