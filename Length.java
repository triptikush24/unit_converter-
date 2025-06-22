import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Length extends JFrame {

    String[] units = {"Kilometres (km.)", "Metres (m.)", "Centimetres (cm.)"};

    Container lengthmaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField lengthfromtext, lengthtotext;
    JComboBox lengthfromunit, lengthtounit;
    JButton lengthcalculate, lengthexit, lengthclear;

    float value;

    public Length () {
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

        JLabel title = new JLabel("Length Converter");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel fromPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        fromPanel.setOpaque(false);
        lengthfromtext = new JTextField(10);
        lengthfromtext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lengthfromtext.setBackground(Color.WHITE);
        lengthfromtext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        lengthfromunit = new JComboBox(units);
        lengthfromunit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel fromLabel = new JLabel("From: ");
        fromLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        fromLabel.setForeground(Color.BLACK);
        fromPanel.add(fromLabel);
        fromPanel.add(lengthfromtext);
        fromPanel.add(lengthfromunit);
        mainPanel.add(fromPanel);

        JPanel toPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        toPanel.setOpaque(false);
        lengthtotext = new JTextField(10);
        lengthtotext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lengthtotext.setBackground(new Color(230, 230, 240));
        lengthtotext.setEditable(false);
        lengthtotext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        lengthtounit = new JComboBox(units);
        lengthtounit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel toLabel = new JLabel("To: ");
        toLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        toLabel.setForeground(Color.BLACK);
        toPanel.add(toLabel);
        toPanel.add(lengthtotext);
        toPanel.add(lengthtounit);
        mainPanel.add(toPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        lengthcalculate = new JButton("Calculate Result");
        lengthclear     = new JButton("Clear");
        lengthexit      = new JButton("Exit");
        JButton[] buttons = {lengthcalculate, lengthclear, lengthexit};
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

        lengthclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lengthfromtext.setText("");
                lengthtotext.setText("");
                lengthfromunit.setSelectedIndex(0);
                lengthtounit.setSelectedIndex(0);
            }
        });

        lengthexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        lengthcalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    value = Float.parseFloat(lengthfromtext.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Length.this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (lengthfromunit.getSelectedIndex() == 0) {
                    if (lengthtounit.getSelectedIndex() == 0) {
                        lengthtotext.setText(String.valueOf(value));
                    }
                    if (lengthtounit.getSelectedIndex() == 1) {
                        lengthtotext.setText(String.valueOf(value * 1000));
                    }
                    if (lengthtounit.getSelectedIndex() == 2) {
                        lengthtotext.setText(String.valueOf(value * 100000));
                    }
                }
                if (lengthfromunit.getSelectedIndex() == 1) {
                    if (lengthtounit.getSelectedIndex() == 0) {
                        lengthtotext.setText(String.valueOf(value / 1000));
                    }
                    if (lengthtounit.getSelectedIndex() == 1) {
                        lengthtotext.setText(String.valueOf(value));
                    }
                    if (lengthtounit.getSelectedIndex() == 2) {
                        lengthtotext.setText(String.valueOf(value * 100));
                    }
                }
                if (lengthfromunit.getSelectedIndex() == 2) {
                    if (lengthtounit.getSelectedIndex() == 0) {
                        lengthtotext.setText(String.valueOf(value / 100000));
                    }
                    if (lengthtounit.getSelectedIndex() == 1) {
                        lengthtotext.setText(String.valueOf(value / 100));
                    }
                    if (lengthtounit.getSelectedIndex() == 2) {
                        lengthtotext.setText(String.valueOf(value));
                    }
                }
            }
        });
    }
}



















