import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class КурсоваРабота {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("KST", 1, "A", "Ivan", 776655443, "ivan@adv.bg"));
		students.add(new Student("KST", 1, "A", "Petar", 665544332, "petar@abv.bg"));
		students.add(new Student("KST", 1, "B", "Georgi", 554433221, "georgi@abv.bg"));
		students.add(new Student("KST", 1, "A", "Dimitar", 443322112, "dimitar@abv.bg"));
		students.add(new Student("KST", 1, "B", "Kalin", 332211223, "kalin@abv.bg"));
		System.out.println("Student Name Sorting:");
		Collections.sort(students, new LexicographicComparator());
		for (Student st : students) {
			System.out.println(st);
		}
		System.out.println("Students from subgroup A:");
		students.stream().filter(s -> s.subgroup.equals("A")).forEach(s -> System.out.println(s));
	}
}

class LexicographicComparator implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		return a.name.compareToIgnoreCase(b.name);
	}
}

class Student {
	String specialty, subgroup, name, email;
	int group;
	long phone;

	public Student(String specialty, int group, String subgroup, String name, long phone, String email) {
		this.specialty = specialty;
		this.group = group;
		this.subgroup = subgroup;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return " Specialty: " + specialty + ", Group: " + group + ", Subgroup: " + subgroup + ", Name: " + name
				+ ", Phone: " + phone + " E-mial: " + email;
	}
}
