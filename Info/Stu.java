package Info;

public class Stu {
		private String number;
		private String name;
		private String sex;
		private String birthday;
		private String address;
		private String department;
		private String phone;
		
		public Stu(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
			number = s1;name = s2;
			sex = s3;birthday = s4;
			address = s5;department = s6; phone = s7;
		}
		
		public  String getNumber() {
			return number;
		}
		
		public  String getName() {
			return name;
		}
		
		public  String getSex() {
			return sex;
		}
		
		public  String getBirthday() {
			return birthday;
		}
		
		public  String getAddress() {
			return address;
		}
		
		public  String getDepartment() {
			return department;
		}
		
		public  String getPhone() {
			return phone;
		}
}
