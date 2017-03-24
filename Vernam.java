package main;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
 * <applet code="vernam" width=400 height 400></applet>
 */
//pkg15405
public class Vernam extends Applet implements ActionListener 
{

    TextField t1, t2;
    String msg = "";
    String key = "";
    String CT = "";
    String ERROR = "Key length Not Equal to Message Length! Re-Enter Key";
    Button Encrypt, Decrypt;
    char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public void init() {
        t1 = new TextField(20);
        t2 = new TextField(20);
        Encrypt = new Button("Encrypt");
        Decrypt = new Button("Decrypt");
        add(t1);
        add(t2);
        add(Encrypt);
        add(Decrypt);
        Encrypt.addActionListener(this);
        Decrypt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) 
    {

        String com1 = ae.getActionCommand();
        key = t2.getText();
        msg = t1.getText();
        
        if(key.length() == msg.length())
        {
        char[] text = new char[msg.length()];
        char[] text1 = new char[msg.length()];
        char[] text2 = new char[msg.length()];
        char[] k = new char[key.length()];
        k = key.toCharArray();
        
        text = msg.toCharArray();
        int j = 0;
            for (int i = 0; i < msg.length(); i++) 
            {

                if (j == key.length()) {
                    j = 0;
                }
                text1[i] = k[j];
                j++;
            }

        if (com1.equals("Encrypt")) 
        {
            int x = 0;
            char m = 'a';
            for (int i = 0; i < msg.length(); i++) 
            {
                x = ((text[i] + text1[i] - 2 * m) % 26);
                text2[i] = alpha[x];
            }
            CT = new String(text2);
            t1.setText(CT);
        }
        else if(com1.equals("Decrypt"))
        {
            int x = 0;
            char m = 'a';
            for (int i = 0; i < msg.length(); i++)
            {
                x = ((text[i] - text1[i] + 26) % 26);
                text2[i] = alpha[x];
            }
            CT = new String(text2);
        }
        repaint();
        }
        else
        {
            CT = ERROR;
            repaint();
        }
    }

    public void paint(Graphics g) {
        g.drawString("Encrypted Text: " + CT, 50, 100);
    }
}
