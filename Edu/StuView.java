package Edu;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import Info.Stu;
import javax.swing.*;

public class StuView extends JFrame implements ActionListener{
	ArrayList<Stu> stulist = new ArrayList<Stu>();
	
	JLabel jlnumber = new JLabel("ѧ�ţ�");
    JLabel jlname = new JLabel("������");
    JLabel jlsex = new JLabel("�Ա�");
    JLabel jlbirthday = new JLabel("�������ڣ�");
    JLabel jladdress = new JLabel("���᣺");
    JLabel jldepartment = new JLabel("רҵ��");
    JLabel jlphone = new JLabel("�绰���룺");
    
    JLabel jlnumber1 = new JLabel("");
    JLabel jlname1 = new JLabel("");
    JLabel jlsex1 = new JLabel("");
    JLabel jlbirthday1 = new JLabel("");
    JLabel jladdress1 = new JLabel("");
    JLabel jldepartment1 = new JLabel("");
    JLabel jlphone1 = new JLabel("");
    
    JButton last = new JButton("��һ��");
    JButton next = new JButton("��һ��");
    
    int series=0;  //�����ѧ�����к�

    StuView(){	    
    		this.setTitle("���ѧ����Ϣ");
    		this.setLayout(null);
    	    last.addActionListener(this);
    	    next.addActionListener(this);
    	    
    	    jlnumber.setBounds(100, 20, 80, 30);
            jlnumber1.setBounds(170, 20, 100, 30);
            jlname.setBounds(100, 60, 80, 30);
            jlname1.setBounds(170, 60, 100, 30);
            jlsex.setBounds(100, 100, 60, 30);
            jlsex1.setBounds(170,100,600,30); 
            jlbirthday.setBounds(100, 140, 80, 30);
            jlbirthday1.setBounds(170, 140, 100, 30);
            jladdress.setBounds(100, 180, 80, 30);
            jladdress1.setBounds(170, 180, 100, 30);
            jldepartment.setBounds(100, 220, 80, 30);
            jldepartment1.setBounds(170, 220, 100, 30);
            jlphone.setBounds(100, 260, 80, 30);
            jlphone1.setBounds(170, 260, 100, 30);
            last.setBounds(100,310,100,30);
            next.setBounds(220,310,100,30);
    	    
    	    add(jlnumber);add(jlnumber1);add(jlname);add(jlname1);
    	    add(jlsex);add(jlsex1);add(jlbirthday);add(jlbirthday1);
    	    add(jladdress);add(jladdress1);add(jldepartment);add(jldepartment1);
    	    add(jlphone);add(jlphone1);add(last);add(next);

    	    this.setLocation(400,300);
            this.setSize(400,420);
            this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
		
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        PreparedStatement ps=null;
        String sql = "SELECT * FROM student";
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
                            
            stat=conn.createStatement();
            res=stat.executeQuery(sql);
            
            stulist.clear();
            while (res.next())
            {
            	stulist.add(new Stu(res.getString("number"),res.getString("name"),
            			res.getString("sex"),res.getString("birthday"),res.getString("address"),
            			res.getString("department"),res.getString("phone")));
            }
            
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
        
        int totalnumber = stulist.size();
        if(e.getSource()==last) {
        	if(series>=2&&series<=totalnumber+1) {
            	series--;
        		Stu temp;
        		temp = stulist.get(series-1);
        		jlnumber1.setText(temp.getNumber()); 
        		jlname1.setText(temp.getName()); 
        		jlsex1.setText(temp.getSex()); 
        		jlbirthday1.setText(temp.getBirthday()); 
        		jladdress1.setText(temp.getAddress()); 
        		jldepartment1.setText(temp.getDepartment()); 
        		jlphone1.setText(temp.getPhone()); 
        	}
        }
        
        if(e.getSource()==next) {
        	if(series>=0&&series<=totalnumber-1) {
            	series++;
        		Stu temp;
        		temp = stulist.get(series-1);
        		jlnumber1.setText(temp.getNumber()); 
        		jlname1.setText(temp.getName()); 
        		jlsex1.setText(temp.getSex()); 
        		jlbirthday1.setText(temp.getBirthday()); 
        		jladdress1.setText(temp.getAddress()); 
        		jldepartment1.setText(temp.getDepartment()); 
        		jlphone1.setText(temp.getPhone()); 
        	}
        }
    }
}
