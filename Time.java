import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Time extends JFrame {
    String[] units = {"Hours (hr.)", "Minutes (min.)", "Seconds (sec.)"};

    Container timemaincontainer, fromcontainer, tocontainer, calculatecontainer;
    JTextField timefromtext, timetotext;
    JComboBox timefromunit, timetounit;
    JButton timecalculate, timeexit, timeclear;

    float value;

    public Time() {
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

        JLabel title = new JLabel("Time Converter");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        mainPanel.add(title);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel fromPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        fromPanel.setOpaque(false);
        timefromtext = new JTextField(10);
        timefromtext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        timefromtext.setBackground(Color.WHITE);
        timefromtext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        timefromunit = new JComboBox(units);
        timefromunit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel fromLabel = new JLabel("From: ");
        fromLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        fromLabel.setForeground(Color.BLACK);
        fromPanel.add(fromLabel);
        fromPanel.add(timefromtext);
        fromPanel.add(timefromunit);
        mainPanel.add(fromPanel);

        JPanel toPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        toPanel.setOpaque(false);
        timetotext = new JTextField(10);
        timetotext.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        timetotext.setBackground(new Color(230, 230, 240));
        timetotext.setEditable(false);
        timetotext.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 220)),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        timetounit = new JComboBox(units);
        timetounit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel toLabel = new JLabel("To: ");
        toLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        toLabel.setForeground(Color.BLACK);
        toPanel.add(toLabel);
        toPanel.add(timetotext);
        toPanel.add(timetounit);
        mainPanel.add(toPanel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);
        timecalculate = new JButton("Calculate Result");
        timeclear     = new JButton("Clear");
        timeexit      = new JButton("Exit");
        JButton[] buttons = {timecalculate, timeclear, timeexit};
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

        timeclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timefromtext.setText("");
                timetotext.setText("");
                timefromunit.setSelectedIndex(0);
                timetounit.setSelectedIndex(0);
            }
        });

        timeexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        timecalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    value = Float.parseFloat(timefromtext.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Time.this, "Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (timefromunit.getSelectedIndex() == 0) {
                    if (timetounit.getSelectedIndex() == 0) {
                        timetotext.setText(String.valueOf(value));
                    }
                    if (timetounit.getSelectedIndex() == 1) {
                        timetotext.setText(String.valueOf(value * 60));
                    }
                    if (timetounit.getSelectedIndex() == 2) {
                        timetotext.setText(String.valueOf(value * 360));
                    }
                }
                if (timefromunit.getSelectedIndex() == 1) {
                    if (timetounit.getSelectedIndex() == 0) {
                        timetotext.setText(String.valueOf(value / 60));
                    }
                    if (timetounit.getSelectedIndex() == 1) {
                        timetotext.setText(String.valueOf(value));
                    }
                    if (timetounit.getSelectedIndex() == 2) {
                        timetotext.setText(String.valueOf(value * 60));
                    }
                }
                if (timefromunit.getSelectedIndex() == 2) {
                    if (timetounit.getSelectedIndex() == 0) {
                        timetotext.setText(String.valueOf(value / 360));
                    }
                    if (timetounit.getSelectedIndex() == 1) {
                        timetotext.setText(String.valueOf(value / 60));
                    }
                    if (timetounit.getSelectedIndex() == 2) {
                        timetotext.setText(String.valueOf(value));
                    }
                }
            }
        });
    }
}


