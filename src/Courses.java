import java.util.*;


public class Courses {
	private HashMap<Integer, Grades> courses;
	private Grades grades = new Grades();
	
	
	public Courses(Grades gradeList) {
		courses = new HashMap<>();
		grades = gradeList;
	}
	
	public void addCreditHr(Integer creditHr) {
		if (creditHr < 0 && creditHr > 10) {
			System.out.println("Invalid input");
		} else {
			courses.put(creditHr, grades);
			System.out.println(courses);
		}
	}
	
}
