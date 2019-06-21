package Edu;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class StuAdd extends JFrame {
    //private static final long serialVersionUID = -1928970409928880648L;
     
    JLabel jlnumber = new JLabel("学号：");
    JLabel jlname = new JLabel("姓名：");
    JLabel jlsex = new JLabel("性别：");
    JLabel jlbirthday = new JLabel("出生日期：");
    JLabel jladdress = new JLabel("籍贯：");
    JLabel jldepartment = new JLabel("专业：");
    JLabel jlphone = new JLabel("电话号码：");
     
    JTextField jtnumber = new JTextField("",10);
    JTextField jtname = new JTextField("",10);
    JTextField jtbirthday = new JTextField("",10);
    JTextField jtaddress = new JTextField("",10);
    JTextField jtdepartment = new JTextField("",10);
    JTextField jtphone = new JTextField("",10);
    
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox man,woman;
    
    JButton buttonadd;
     
    public StuAdd() {
    	man = new Checkbox("男",true,cbg);
        woman = new Checkbox("女",false,cbg);
        buttonadd= new JButton("添加");
        buttonadd.setPreferredSize(new Dimension(150,30));
        
         
        buttonadd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                Connection conn = null;
                Statement stat = null;
                PreparedStatement ps=null;
                String sql = "INSERT INTO student(number,name,sex,birthday,"
                		+ "address,department,phone) "
                        + "values(?,?,?,?,?,?,?)";
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
                    
                    String temp;
                    if(man.getState())
                    	temp = "男";
                    else
                    	temp = "女";
                    
                    ps.setString(1,jtnumber.getText());
                    ps.setString(2,jtname.getText());
                    ps.setString(3,temp);
                    ps.setString(4,jtbirthday.getText());
                    ps.setString(5,jtaddress.getText());
                    ps.setString(6,jtdepartment.getText());
                    ps.setString(7,jtphone.getText());
 
                    ps.executeUpdate();
                     
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
                jtnumber.setText("");
                jtname.setText("");
                jtbirthday.setText("");
                jtaddress.setText("");
                jtdepartment.setText("");
                jtphone.setText("");
            }
            } 
                );
         
        this.setTitle("添加学生信息");
        this.setLayout(null);
 
        jlnumber.setBounds(100, 20, 80, 30);
        jtnumber.setBounds(170, 20, 100, 30);
        jlname.setBounds(100, 60, 80, 30);
        jtname.setBounds(170, 60, 100, 30);
        jlsex.setBounds(100, 100, 60, 30);
        man.setBounds(170,100, 30, 30);woman.setBounds(220,100,30,30);  
        jlbirthday.setBounds(100, 140, 80, 30);
        jtbirthday.setBounds(170, 140, 100, 30);
        jladdress.setBounds(100, 180, 80, 30);
        jtaddress.setBounds(170, 180, 100, 30);
        jldepartment.setBounds(100, 220, 80, 30);
        jtdepartment.setBounds(170, 220, 100, 30);
        jlphone.setBounds(100, 260, 80, 30);
        jtphone.setBounds(170, 260, 100, 30);
        buttonadd.setBounds(130,310,120,30);

        this.add(jlnumber);this.add(jtnumber);
        this.add(jlname);this.add(jtname);
        this.add(jlsex);this.add(man);add(woman);
        this.add(jlbirthday);this.add(jtbirthday);
        this.add(jladdress);this.add(jtaddress);
        this.add(jldepartment);this.add(jtdepartment);
        this.add(jlphone);this.add(jtphone);
        this.add(buttonadd);
        this.setLocation(400,300);
        this.setSize(400,420);
        this.setVisible(true);
         
    }

}
