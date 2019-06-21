package Info;

public class Course {
		private String coursenumber;
		private String coursename;
		private String period;
		private String credit;
		
		public Course(String s1,String s2,String s3,String s4){
			coursenumber = s1;coursename = s2;
			period = s3;credit = s4;
		}
		
		public  String getCoursenumber() {
			return coursenumber;
		}
		
		public  String getCoursename() {
			return coursename;
		}
		
		public  String getPeriod() {
			return period;
		}
		
		public String getCredit() {
			return credit;
		}
}
