package Employeee;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mark_Att_Emp implements ActionListener {
	
	 JFrame f;
    JLabel id15, id8, id1,id2,id3,id4;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b;
    Choice c2;
   
    Mark_Att_Emp(){
       
    	 f = new JFrame("Mark Attendance");
         f.setBackground(Color.white);
         f.setLayout(null);
         
         id15=new JLabel();
         id15.setBounds(0,0,500,600);
         id15.setLayout(null);
         
         ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employeee/icons/detail.jpg"));
         id15.setIcon(img);
         f.add(id15);
    	
        c2 = new Choice();
        c2.setBounds(250,120,170,50);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c2.add(rs.getString("emp_id"));    
            }
      
      
       }catch(Exception e){ }
       
        id8 = new JLabel("Mark Attendance");
        id8.setBounds(120,30,500,50);
        id8.setFont(new Font("serif",Font.BOLD,30));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Emp Id");
        id1.setBounds(100,100,100,50);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.black);
        id15.add(id1);
        
        
        id15.add(c2);
        
        id2 = new JLabel("Date");
        id2.setBounds(100,190,150,50);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id2.setForeground(Color.black);
        id15.add(id2);
       
        t1=new JTextField();//date
        t1.setBounds(250,200,150,30);
        id15.add(t1);
        
        id4 = new JLabel("In Time");
        id4.setBounds(90,290,150,50);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id4.setForeground(Color.black);
        id15.add(id4);
        
        t2=new JTextField();//in time
        t2.setBounds(250,300,150,30);
        id15.add(t2);
        
        
        id3 = new JLabel("Out Time");
        id3.setBounds(90,390,100,50);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id3.setForeground(Color.black);
        id15.add(id3);
        
        t3=new JTextField();// out time
        t3.setBounds(250,400,150,30);
        id15.add(t3);
        
        b=new JButton("Submit");
        b.setBounds(90,500,150,40);
        b.addActionListener(this);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBounds(250,500,150,40);
        b1.addActionListener(this);
        
        id15.add(b1);
        
        f.setVisible(true);
        f.setSize(500,600);
        f.setLocation(400,150);
       
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
    	String a = t1.getText();//date
        String bb = t2.getText();// intime
        String c = t3.getText();// outtime
        String id=c2.getSelectedItem();
        String qry = "insert into attendence values("+ id +",'"+a+"','"+bb+"','"+c+"')";
        
       
            try { 
            	  if(ae.getSource()==b){
        	  conn c1 = new conn();
              c1.s.executeUpdate(qry);
              JOptionPane.showMessageDialog(null,"Attendence confirmed");
              f.setVisible(false);
        	}
        }catch(Exception ee){
            ee.printStackTrace();
        }
            if(ae.getSource()==b1){
            	 f.setVisible(false);
                 new details();
            }
    }
    
    public static void main(String[] s){
    	new Mark_Att_Emp();
    }
}