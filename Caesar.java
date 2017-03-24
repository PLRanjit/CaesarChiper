package main;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Caesar extends Applet implements ActionListener {

    TextField t1, t2;
    String msg = " ";
    String key = " ";
    String ans = "";
    Button Encrypt;

    public void init() {
        t1 = new TextField(10);
        t2 = new TextField(10);
        Encrypt = new Button("Encrypt");
        add(t1);
        add(t2);
        add(Encrypt);
        Encrypt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        msg = t1.getText();
        key = t2.getText();
        char[] text = new char[msg.length()];
        char[] k = new char[key.length()];
        k = key.toCharArray();
        text =msg.toCharArray();

        int j = 0;
        for (int i = 0; i < msg.length(); i++) {
            text[i] = k[j];
               j++;
            if (j == key.length() - 1) {
                j = 0;
            }
         
        }
        ans = new String(text);
        repaint();
    }

    public void paint(Graphics g) {
        g.drawString("Encrypted text: " + ans, 150, 150);
    }
}
