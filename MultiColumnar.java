package main;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class MultiColumnar extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b1;
    JPanel p1, p2, p3, p4;
    Container c;
    String s1, s2;
    int k = 0, col = 0;
    char[][] ans, trans,change;

    MultiColumnar() {
        c = getContentPane();
        t1 = new JTextField(25);
        t2 = new JTextField(6);
        t3 = new JTextField(25);
        
        b1 = new JButton("Encrypt");

        p1 = new JPanel();
        p1.add(new JLabel("Enter the Message : "), BorderLayout.WEST);
        p1.add(t1, BorderLayout.EAST);

        p2 = new JPanel();
        p2.add(new JLabel("Enter the Key : "), BorderLayout.WEST);
        p2.add(t2, BorderLayout.EAST);

        p3 = new JPanel();
        p3.add(new JLabel("Cipher Text : "), BorderLayout.EAST);
        p3.add(t3, BorderLayout.WEST);
        
        p4 = new JPanel();
        p4.add(p3,BorderLayout.WEST);
        p4.add(b1,BorderLayout.EAST);

 
        c.add(p1, BorderLayout.NORTH);
        c.add(p2, BorderLayout.CENTER);
        c.add(p4,BorderLayout.SOUTH);
        
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

      //  t2.setText("range : 0-"+(col-1));
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
        t1.setText(u);
    }

    public static void main(String[] args) {
        MultiColumnar p = new MultiColumnar();
        p.setVisible(true);
        p.setDefaultCloseOperation(3);
        p.setSize(500, 150);
        p.setLocationRelativeTo(null); 
        p.setResizable(false);
    }
}
