package Edu;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CouAdd extends JFrame{
    JLabel jlcounumber = new JLabel("�γ̺ţ�");
    JLabel jlcouname = new JLabel("�γ�����");
    JLabel jlperiod = new JLabel("ѧʱ��");
    JLabel jlcredit = new JLabel("ѧ�֣�");
     
    JTextField jtcounumber= new JTextField("",10);
    JTextField jtcouname = new JTextField("",10);
    JTextField jtperiod= new JTextField("",10);
    JTextField jtcredit = new JTextField("",10);
    
    JButton btnadd;
     
    public CouAdd() {
        btnadd= new JButton("���");
        btnadd.setPreferredSize(new Dimension(150,30));
        
        btnadd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection conn = null;
                Statement stat = null;
                PreparedStatement ps=null;
                String sql = "INSERT INTO course(coursenumber,coursename,period,credit)"
                        + "values(?,?,?,?)";
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("JBDC ���سɹ�!");
                }catch(Exception a){
                    System.out.println("JBDC ����!");
                    a.printStackTrace();
                }
                try{
                	String url = "jdbc:mysql://localhost:3306/javaStu?useUnicode=true&characterEncoding=utf-8"
                			+ "&useSSL=false&serverTimezone=UTC";
                    conn=DriverManager.getConnection(url,"root","123");
                    ps=conn.prepareStatement(sql);
                        
                    ps.setString(1,jtcounumber.getText());
                    ps.setString(2,jtcouname.getText());
                    ps.setString(3,jtperiod.getText());
                    ps.setString(4,jtcredit.getText());
 
                    ps.executeUpdate();
                     
                }catch (SQLException b){
                    b.printStackTrace();
                }finally{
                    try{
                        conn.close();
                        System.out.println("MySQL �رճɹ�");
                    }catch (SQLException c){
                        System.out.println("MySQL �ر�ʧ�� ");
                        c.printStackTrace();
                    }    
                }
                jtcounumber.setText("");
                jtcouname.setText("");
                jtperiod.setText("");
                jtcredit.setText("");
            }
            } 
                );
         
        this.setTitle("��ӿγ���Ϣ");
        this.setLayout(null);
 
        jlcounumber.setBounds(100, 30, 80, 30);
        jtcounumber.setBounds(170, 30, 100, 30);
        jlcouname.setBounds(100, 70, 80, 30);
        jtcouname.setBounds(170, 70, 100, 30);
        jlperiod.setBounds(100, 110, 80, 30);
        jtperiod.setBounds(170, 110, 100, 30);
        jlcredit.setBounds(100, 150, 80, 30);
        jtcredit.setBounds(170, 150, 100, 30);
        btnadd.setBounds(130,200,120,30);

        this.add(jlcounumber);this.add(jtcounumber);
        this.add(jlcouname);this.add(jtcouname);
        this.add(jlperiod);this.add(jtperiod);
        this.add(jlcredit);this.add(jtcredit);
        this.add(btnadd);
        this.setLocation(600,300);
        this.setSize(400,330);
        this.setVisible(true);       
    }
}
