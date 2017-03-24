package main;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class ModCaesar extends Applet implements ActionListener {
    TextField t1, t2;
    Label l1, l2;
    int key;
    String msg = " ";
    String msg1 = " ";
    Button Encrypt; 
    Button Decrypt;
    public void init()
    {
        t1 = new TextField(10);
        t2 = new TextField(10);
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
        
        char alpha;
        key = Integer.parseInt(t2.getText());
        if (com1.equals("Encrypt")) {
        msg = t1.getText();
        char S2[] = msg.toCharArray();
        for(int i=0;i<msg.length();i++)
        {
            alpha=S2[i];
            alpha =(char)(alpha+key);
            if(alpha > 'z')
                alpha = (char)(alpha-26);
            if (alpha<'a')
                alpha=(char)(alpha+26);
            S2[i] =alpha;
        }
        msg1= new String(S2);
      }else if (com1.equals("Decrypt")) {
       
        char S2[] = msg1.toCharArray();
        
        for(int i=0;i<msg1.length();i++)
        {
            alpha=S2[i];
            alpha =(char)(alpha-key);
            if(alpha > 'z')
                alpha = (char)(alpha-26);
            if (alpha<'a')
                alpha=(char)(alpha+26);
            S2[i] =alpha;
        }
        msg1= new String(S2);     
      }
        repaint();
    }
     public void paint(Graphics g)
    {
        g.drawString("Encrypted text: "+msg1, 100, 150);
    }
    
}
