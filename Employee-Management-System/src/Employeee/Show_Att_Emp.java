package Employeee;

import java.sql.*;
import java.text.*;

import javax.swing.*;
import java.awt.event.*;

public class Show_Att_Emp extends JFrame {
	
    
    JTable j1;
    JButton b1;
    JLabel id;
    String h[]={"EMP ID","Date","IN TIME","OUT TIME"};
    String d[][]=new String[15][4];
    long hor[] = new long[15];
    int i=0,j=0,leave=0;
    
    Show_Att_Emp(){
        super("Show Employees Attendence");
        setSize(800,300);
        setLocation(450,150);

        try{
        	conn c1=new conn();
            String q="select * from attendence";
            ResultSet rs = c1.s.executeQuery(q);
            
          
            while(rs.next()){
            	
                d[i][0]=rs.getString("emp_id");
                d[i][1]=rs.getString("date");
                d[i][2]=rs.getString("intime");
                d[i][3]=rs.getString("outtime");
                
                i++;
            }
         
            String qry2="SELECT ABS(TIMESTAMPDIFF(HOUR,intime,outtime)) as Hour from attendence;";
         
        	
        	  ResultSet rsa = c1.s.executeQuery(qry2);
        	  while(rsa.next()) {
        	  String r= rsa.getString("Hour");
        	  int a=Integer.parseInt(r);
        	  if(a<9)
        		  leave++;
        	  }
        	  //System.out.print(leave);

        
            
            j1=new JTable(d,h);
            this.setVisible(true);
            
            id = new JLabel("leave:"+leave);
            add(id);

        }catch(Exception e){
        	e.printStackTrace();
        }
        
        b1=new JButton("Leave =" + leave);
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
//        b1.addActionListener(this);
//    
//    }
//    public void actionPerformed(ActionEvent ae){
//        try{
//        	 JOptionPane.showMessageDialog(null,"printed successfully");
//             this.setVisible(false);
////             details d= new details();
//        }catch(Exception e){}
   }
    
    public static void main(String[] args){
        new Show_Att_Emp().setVisible(true);
    }
}