package main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class RSA extends JFrame implements ActionListener {

    Container c;
    int d=0, e, p, q, n, i, count=0;
    boolean flag1, flag2;
    JTextField t1, t2;
    JLabel l1, l2, l3, l4;
    String ct, pt;
    JButton b1, b2;

    RSA() {
        c = getContentPane();
        setLayout(new FlowLayout());

        t1 = new JTextField(5);
        t2 = new JTextField(5);
        l1 = new JLabel("Enter P : ");
        l2 = new JLabel("Enter Q : ");
        b1 = new JButton("Verify");
        b2 = new JButton("Encrypt");
        l3 = new JLabel("");
        l4 = new JLabel("");
        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(t2);
        c.add(b1);
        c.add(b2);
        c.add(l3);
        c.add(l4);
        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        p = Integer.parseInt(t1.getText());
        q = Integer.parseInt(t2.getText());
        if (cmd.equals("Verify")) {
            for (i = 2; i <= (p / 2); i++) {
                if (p % i == 0) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
            }
            for (i = 2; i <= (q / 2); i++) {
                if (q % i == 0) {
                    flag2 = true;
                } else {
                    flag2 = false;
                }
            }
            if (flag1 == true || flag2 == true) {
                l3.setText("Numbers are not Prime. ");
            } else {
                l3.setText("Numbers are Prime. ");
            }

        }
        if (cmd.equals("Encrypt")) 
        {
            n = p * q;
            for (i = 2; i < n; i++) 
            {
                if ((i % ((p - 1) * q - 1)) == 1) 
                {
                    continue;
                } 
                else 
                {
                    e = i;
                }
            }
            l3.setText("E = " + e);
        while(count!=1)
        {
            count = (d*e)% ((p-1)*(q-1));
            d++;
        }
             l4.setText("D = " + d);
            
        }
    }

    public static void main(String[] args) {
        RSA r = new RSA();
        r.setDefaultCloseOperation(3);
        r.setSize(400, 400);
        r.setVisible(true);
    }
}
