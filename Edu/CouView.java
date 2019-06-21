package Edu;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import Info.Course;
import javax.swing.*;

public class CouView extends JFrame implements ActionListener {
	ArrayList<Course> stulist = new ArrayList<Course>();
	
	JLabel jlcounumber = new JLabel("课程号：");
    JLabel jlcouname = new JLabel("课程名：");
    JLabel jlperiod = new JLabel("学时：");
    JLabel jlcredit = new JLabel("学分：");
    
    JLabel jlcounumber1 = new JLabel("");
    JLabel jlcouname1 = new JLabel("");
    JLabel jlperiod1 = new JLabel("");
    JLabel jlcredit1 = new JLabel("");
    
    JButton last = new JButton("上一个");
    JButton next = new JButton("下一个");
    
    int series=0;  //浏览的课程序列号

    CouView(){	    
    		this.setTitle("浏览课程信息");
    		this.setLayout(null);
    	    last.addActionListener(this);
    	    next.addActionListener(this);
    	    
    	    jlcounumber.setBounds(100, 30, 80, 30);
    	    jlcounumber1.setBounds(170, 30, 100, 30);
            jlcouname.setBounds(100, 70, 80, 30);
            jlcouname1.setBounds(170, 70, 100, 30);
            jlperiod.setBounds(100, 110, 80, 30);
            jlperiod1.setBounds(170, 110, 100, 30);
            jlcredit.setBounds(100, 150, 80, 30);
            jlcredit1.setBounds(170, 150, 100, 30);
            last.setBounds(100,200,100,30);
            next.setBounds(220,200,100,30);
    	    
    	    add(jlcounumber);add(jlcounumber1);
    	    add(jlcouname);add(jlcouname1);
    	    add(jlperiod);add(jlperiod1);add(jlcredit);add(jlcredit1);
    	    add(last);add(next);

    	    this.setLocation(800,500);
            this.setSize(400,330);
            this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
		
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        PreparedStatement ps=null;
        String sql = "SELECT * FROM course";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JBDC 加载成功!");
        }catch(Exception a){
            System.out.println("JBDC 狗带!");
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
            	
            	stulist.add(new Course(res.getString("coursenumber"),
            			res.getString("coursename"),
            			res.getString("period"),res.getString("credit")));
            }      
        }catch (SQLException b){
            b.printStackTrace();
        }finally{
            try{
                conn.close();
                System.out.println("MySQL 关闭成功");
            }catch (SQLException c){
                System.out.println("MySQL 关闭失败 ");
                c.printStackTrace();
            }    
        }
        
        int totalnumber = stulist.size();
        
        if(e.getSource()==last) {
        	if(series>=2&&series<=totalnumber+1) {
            	series--;
        		Course temp;
        		temp = stulist.get(series-1);
        		jlcounumber1.setText(temp.getCoursenumber()); 
        		jlcouname1.setText(temp.getCoursename()); 
        		jlperiod1.setText(temp.getPeriod()); 
        		jlcredit1.setText(temp.getCredit()); 
        	}
        }
        
        if(e.getSource()==next) {
        	if(series>=0&&series<=totalnumber-1) {
            	series++;
        		Course temp;
        		temp = stulist.get(series-1);
        		jlcounumber1.setText(temp.getCoursenumber()); 
        		jlcouname1.setText(temp.getCoursename()); 
        		jlperiod1.setText(temp.getPeriod()); 
        		jlcredit1.setText(temp.getCredit()); 
        	}
        }
    }
}

