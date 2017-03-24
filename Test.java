package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Test extends JFrame implements ActionListener {
    Container C;
    JTextField t1, t2;
    JPanel p1, p2, p3;
    JButton Encrypt;
    JLabel l1;
    String msg ="";
    String key="";
    String CT = "";
    char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    test()
    {   
        C =getContentPane();
        BorderLayout fl = new BorderLayout();
        setLayout(fl);
        JPanel p1, p2,p3;
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        l1 = new JLabel("");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        Encrypt = new JButton("Encrypt");       
        p1.add(t1, BorderLayout.WEST);
        p1.add(t2, BorderLayout.EAST);
        p2.add(Encrypt, BorderLayout.CENTER);
        p3.add(l1, BorderLayout.SOUTH);
        C.add(p1, BorderLayout.NORTH);
        C.add(p2, BorderLayout.CENTER);
        C.add(p3, BorderLayout.SOUTH);
        Encrypt.addActionListener(this);
       
    }
    public void actionPerformed(ActionEvent ae)
    {
        msg = t1.getText();
        key = t2.getText();
        char[] text = new char [msg.length()];
        char[] text1 = new char[msg.length()];
        char[] text2 = new char[msg.length()];
        char[] k = new char[key.length()];
        text = msg.toCharArray();
        k = key.toCharArray();
        int j=0;
        for(int i=0; i<msg.length();i++)
        {
            if(j==key.length())
            {
                j=0;
            }
            text1[i] = k[j];
            j++;
        }
        int x =0;
        char m = 'a';
        for(int i=0; i<msg.length();i++)
        {
            x = ((text[i]+text1[i]) -2*m)%26;
            text2[i] = alpha[x];
        }
        CT = new String(text2);
        l1.setText("Encrypted Text: "+ CT);
    }
    public static void main(String[] args)
    {
        test t = new test();
        t.setSize(400,150);
        t.setDefaultCloseOperation(3);
        t.setVisible(true);
    }
       
}
