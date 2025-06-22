import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Volume extends JFrame {

    String[] units = {"Kilolitres (kl.)", "Litres (l.)", "Millilitres (ml.)"};

    Container volumemaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField volumefromtext, volumetotext;
    JComboBox volumefromunit, volumetounit;
    JButton volumecalculate, volumeexit, volumeclear;

    float value;

    public Volume() {
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

        JLabel title = new JLabel("Volume Converter");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel fromPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        fromPanel.setOpaque(false);
        volumefromtext = new JTextField(10);
        volumefromtext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        volumefromtext.setBackground(Color.WHITE);
        volumefromtext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        volumefromunit = new JComboBox(units);
        volumefromunit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel fromLabel = new JLabel("From: ");
        fromLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        fromLabel.setForeground(Color.BLACK);
        fromPanel.add(fromLabel);
        fromPanel.add(volumefromtext);
        fromPanel.add(volumefromunit);
        mainPanel.add(fromPanel);

        JPanel toPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        toPanel.setOpaque(false);
        volumetotext = new JTextField(10);
        volumetotext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        volumetotext.setBackground(new Color(230, 230, 240));
        volumetotext.setEditable(false);
        volumetotext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        volumetounit = new JComboBox(units);
        volumetounit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel toLabel = new JLabel("To: ");
        toLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        toLabel.setForeground(Color.BLACK);
        toPanel.add(toLabel);
        toPanel.add(volumetotext);
        toPanel.add(volumetounit);
        mainPanel.add(toPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        volumecalculate = new JButton("Calculate Result");
        volumeclear     = new JButton("Clear");
        volumeexit      = new JButton("Exit");
        JButton[] buttons = {volumecalculate, volumeclear, volumeexit};
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

        volumeclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volumefromtext.setText("");
                volumetotext.setText("");
                volumefromunit.setSelectedIndex(0);
                volumetounit.setSelectedIndex(0);
            }
        });

        volumeexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        volumecalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    value = Float.parseFloat(volumefromtext.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Volume.this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (volumefromunit.getSelectedIndex() == 0) {
                    if (volumetounit.getSelectedIndex() == 0) {
                        volumetotext.setText(String.valueOf(value));
                    }
                    if (volumetounit.getSelectedIndex() == 1) {
                        volumetotext.setText(String.valueOf(value * 1000));
                    }
                    if (volumetounit.getSelectedIndex() == 2) {
                        volumetotext.setText(String.valueOf(value * 1000000));
                    }
                }
                if (volumefromunit.getSelectedIndex() == 1) {
                    if (volumetounit.getSelectedIndex() == 0) {
                        volumetotext.setText(String.valueOf(value / 1000));
                    }
                    if (volumetounit.getSelectedIndex() == 1) {
                        volumetotext.setText(String.valueOf(value));
                    }
                    if (volumetounit.getSelectedIndex() == 2) {
                        volumetotext.setText(String.valueOf(value * 1000));
                    }
                }
                if (volumefromunit.getSelectedIndex() == 2) {
                    if (volumetounit.getSelectedIndex() == 0) {
                        volumetotext.setText(String.valueOf(value / 1000000));
                    }
                    if (volumetounit.getSelectedIndex() == 1) {
                        volumetotext.setText(String.valueOf(value / 1000));
                    }
                    if (volumetounit.getSelectedIndex() == 2) {
                        volumetotext.setText(String.valueOf(value));
                    }
                }
            }
        });
    }
}



















