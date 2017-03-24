/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author buser
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SimpleColumnar extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b1;
    JRadioButton r1, r2;
    ButtonGroup g1;
    JPanel p1, p2, p3, p4;
    Container c;
    String s1, s2;
    int k = 0, col = 0;
    char[][] ans, trans,change;

    SimpleColumnar() {
        c = getContentPane();
        t1 = new JTextField(20);
        t2 = new JTextField(6);
        t3 = new JTextField(25);
        
        b1 = new JButton("Encrypt");

        r1 = new JRadioButton("Encrypt");
        r2 = new JRadioButton("Decrypt");

        g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);

        p1 = new JPanel();

        p1.add(new JLabel("Enter the Message : "), BorderLayout.EAST);
        p1.add(t1, BorderLayout.WEST);

        p2 = new JPanel();

        p2.add(new JLabel("Enter the Key : "), BorderLayout.EAST);
        p2.add(t2, BorderLayout.WEST);

        p3 = new JPanel();

        p3.add(new JLabel("Action : "), BorderLayout.EAST);
        p3.add(r1, BorderLayout.CENTER);
        p3.add(r2, BorderLayout.WEST);

        p4 = new JPanel();

        p4.add(new JLabel("Cipher Text : "), BorderLayout.EAST);
        p4.add(t3, BorderLayout.WEST);

        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
        c.add(p3, BorderLayout.LINE_END);
        c.add(p4, BorderLayout.SOUTH);

        r1.addActionListener(this);
        //r2.addActionListener(this);

        b1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        s1 = t1.getText();

        for (int i = 2; i < 11; i++) {
            if ((s1.length() % (i / 2)) == 0) {
                k = (i / 2);
            }
        }

        col = s1.length() / k;

        ans = new char[k][col];
        trans = new char[k][col];
        change= new char[col][k];
        int inc = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = s1.charAt(inc);
                inc++;

            }
        }

        // t2.setText("range : 0-"+(col-1));
        int key = Integer.parseInt(t2.getText());
        
        for(int i=0;i<k;i++)
        {
         key = Integer.parseInt(t2.getText());
         for(int j=0;j<col;j++)
         {
            int get = key%10;
            trans[i][j]=ans[i][get];
            key = key/10;
        }
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < col; j++) {
                change[j][i]=trans[i][j];
                
            }
        }
        
       char[] main = new char[s1.length()];
       int iget = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < k; j++) {
                main[iget] = change[i][j];
                iget++;
            }
        }
        String u = new String(main);

        t3.setText(u);
    }

    public static void main(String[] args) {
        SimpleColumnar p = new SimpleColumnar();
        p.setVisible(true);
        p.setDefaultCloseOperation(3);
        p.setSize(400, 400);
    }
}
