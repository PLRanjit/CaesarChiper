package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Rail extends JFrame implements ActionListener {

    Container C;
    JTextField t1, t2;
    JPanel p1, p2, p3;
    JLabel l1, l2;
    JButton Encrypt, Decrypt;
    String msg = "";
    String CT = "";

    Rail() {
        C = getContentPane();
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        l1 = new JLabel("Plain Text: ");
        t1 = new JTextField(10);
        l2 = new JLabel("Cipher Text");
        t2 = new JTextField(10);
        Encrypt = new JButton("Encrypt");
        Decrypt = new JButton("Decrypt");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.add(l1, BorderLayout.WEST);
        p1.add(t1, BorderLayout.EAST);
        p2.add(l2, BorderLayout.WEST);
        p2.add(t2, BorderLayout.EAST);
        p3.add(Encrypt, BorderLayout.WEST);
        p3.add(Decrypt, BorderLayout.EAST);
        C.add(p1, BorderLayout.NORTH);
        C.add(p2, BorderLayout.CENTER);
        C.add(p3, BorderLayout.SOUTH);
        Encrypt.addActionListener(this);
        Decrypt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
            msg = t1.getText();
            char[] text = new char[msg.length()];
            char[] text1 = new char[msg.length()];
            char[] text2 = new char[msg.length()];
            text = msg.toCharArray();
            int j = 0;
        if (str.equals("Encrypt")) {    
           
            for (int i = 0; i < msg.length(); i = i + 2) {
                text1[j] = text[i];
                j++;
            }
            for (int i = 1; i < msg.length(); i = i + 2) {
                text1[j] = text[i];
                j++;
            }
            CT = new String(text1);
            t2.setText(CT);
            t1.setText(CT);
        }
        if (str.equals("Decrypt")){
            
              for (int i = 0; i < msg.length(); i = i + 2) {
                text1[i] = text[j];
                j++;
            }
            for (int i = 1; i < msg.length(); i = i + 2) {
                text1[i] = text[j];
                j++;
            }
            CT = new String(text1);
            t2.setText(CT);
        }
    }

    public static void main(String[] args) {
        Rail R = new Rail();
        R.setSize(400, 150);
        R.setDefaultCloseOperation(3);
        R.setVisible(true);
    }
}
