package Employeee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class details  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6;

    details(){
        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employeee\\icons\\detail.jpg"));
        l1.setIcon(i1);
        f.add(l1);

        l2 = new JLabel("EMPLOYEE DETAILS");
        l2.setBounds(130,20,500,150);
        l2.setFont(new Font("serif",Font.BOLD,40));
        l2.setForeground(Color.blue);
        l1.add(l2);

        b1=new JButton("Add");
        b1.setBounds(210,160,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("View");
        b2.setBounds(320,160,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(210,220,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(320,220,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        b5=new JButton("Mark Att.");
        b5.setBounds(210,280,100,40);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.addActionListener(this);
        l1.add(b5);

        b6=new JButton("Show Att.");
        b6.setBounds(320,280,100,40);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.addActionListener(this);
        l1.add(b6);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Employee();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new View_Employee();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove_Employee();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new Search_Employee();
        }
        if(ae.getSource()==b5){
            f.setVisible(false);
            new Mark_Att_Emp();
        }
        if(ae.getSource()==b6){
            f.setVisible(false);
            new Show_Att_Emp();
        }
        
    }

    public static void main(String[] arg){
        details d = new details();
    }
}
