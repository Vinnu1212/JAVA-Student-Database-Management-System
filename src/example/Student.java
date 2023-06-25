package example;

public class Student {
	String id;
	String name;
	static int count=101;
	public Student(String name) {
		this.id="JSP"+count;
		this.name = name;
		count++;
	}

	public static void main(String[] args) {
		Student e1=new Student("tom");
		System.out.println("student id of "+e1.name+" is "+e1.id);
		Student e2=new Student("tom");
		System.out.println("student id of "+e2.name+" is "+e2.id);
		Student e3=new Student("tom");
		System.out.println("student id of "+e3.name+" is "+e3.id);

	}

}
