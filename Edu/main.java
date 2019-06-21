package Edu;

import java.awt.*;
import java.awt.event.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}
}

class MainFrame implements ActionListener {
	MenuBar mb1;
	Menu menuStu,menuCourse;
	MenuItem insert1,view1,insert2,view2;
	Frame f1;
	
	MainFrame(){
		f1= new Frame("��ѧ����ϵͳ");
		mb1 = new MenuBar();
		menuStu = new Menu("ѧ��");
		menuCourse = new Menu("�γ�");
		insert1 = new MenuItem("¼��");
		insert2 = new MenuItem("¼��");
		view1 = new MenuItem("���");
		view2 = new MenuItem("���");
		menuStu.add(insert1);
		menuStu.add(view1);
		menuCourse.add(insert2);
		menuCourse.add(view2);
		mb1.add(menuStu);
		mb1.add(menuCourse);
		
		insert1.addActionListener(this);
		insert2.addActionListener(this);
		view1.addActionListener(this);
		view2.addActionListener(this);
		f1.setMenuBar(mb1);
		f1.addWindowListener(new HandleWin());
		f1.setBounds(200, 200, 400, 200);
		f1.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==insert1) {
			new StuAdd();
		}
		if(e.getSource()==view1) {
			new StuView();
		}
		if(e.getSource()==insert2) {
			new CouAdd();
		}
		if(e.getSource()==view2) {
			new CouView();
		}
	}

	class HandleWin extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			f1.dispose();
			System.exit(0);
		}
	}
}