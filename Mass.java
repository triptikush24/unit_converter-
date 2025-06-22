import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mass extends JFrame {

    String[] units = {"Kilograms (kg.)", "Grams (g.)", "Milligrams (mg.)"};

    Container massmaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField massfromtext, masstotext;
    JComboBox massfromunit, masstounit;
    JButton masscalculate, massexit, massclear;

    float value;
    
    public Mass() {
        // Use system look and feel for modern appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel title = new JLabel("Mass Converter");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel fromPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        fromPanel.setOpaque(false);
        massfromtext = new JTextField(10);
        massfromtext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        massfromtext.setBackground(Color.WHITE);
        massfromtext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        massfromunit = new JComboBox(units);
        massfromunit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel fromLabel = new JLabel("From: ");
        fromLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        fromLabel.setForeground(Color.BLACK);
        fromPanel.add(fromLabel);
        fromPanel.add(massfromtext);
        fromPanel.add(massfromunit);
        mainPanel.add(fromPanel);

        JPanel toPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        toPanel.setOpaque(false);
        masstotext = new JTextField(10);
        masstotext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        masstotext.setBackground(new Color(230, 230, 240));
        masstotext.setEditable(false);
        masstotext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        masstounit = new JComboBox(units);
        masstounit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel toLabel = new JLabel("To: ");
        toLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        toLabel.setForeground(Color.BLACK);
        toPanel.add(toLabel);
        toPanel.add(masstotext);
        toPanel.add(masstounit);
        mainPanel.add(toPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        masscalculate = new JButton("Calculate Result");
        massclear     = new JButton("Clear");
        massexit      = new JButton("Exit");
        JButton[] buttons = {masscalculate, massclear, massexit};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
            btn.setBackground(new Color(52, 152, 219));
            btn.setForeground(Color.BLACK);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
            buttonPanel.add(btn);
        }
        mainPanel.add(buttonPanel);

        setContentPane(mainPanel);
        setSize(600, 300);
        setLocationRelativeTo(null);

        massclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                massfromtext.setText("");
                masstotext.setText("");
                massfromunit.setSelectedIndex(0);
                masstounit.setSelectedIndex(0);
            }
        });

        massexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        masscalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    value = Float.parseFloat(massfromtext.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Mass.this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (massfromunit.getSelectedIndex() == 0) {
                    if (masstounit.getSelectedIndex() == 0) {
                        masstotext.setText(String.valueOf(value));
                    }
                    if (masstounit.getSelectedIndex() == 1) {
                        masstotext.setText(String.valueOf(value * 1000));
                    }
                    if (masstounit.getSelectedIndex() == 2) {
                        masstotext.setText(String.valueOf(value * 1000000));
                    }
                }
                if (massfromunit.getSelectedIndex() == 1) {
                    if (masstounit.getSelectedIndex() == 0) {
                        masstotext.setText(String.valueOf(value / 1000));
                    }
                    if (masstounit.getSelectedIndex() == 1) {
                        masstotext.setText(String.valueOf(value));
                    }
                    if (masstounit.getSelectedIndex() == 2) {
                        masstotext.setText(String.valueOf(value * 1000));
                    }
                }
                if (massfromunit.getSelectedIndex() == 2) {
                    if (masstounit.getSelectedIndex() == 0) {
                        masstotext.setText(String.valueOf(value / 1000000));
                    }
                    if (masstounit.getSelectedIndex() == 1) {
                        masstotext.setText(String.valueOf(value / 1000));
                    }
                    if (masstounit.getSelectedIndex() == 2) {
                        masstotext.setText(String.valueOf(value));
                    }
                }
            }
        });
    }
}























