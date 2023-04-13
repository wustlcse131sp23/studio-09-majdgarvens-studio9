package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions
	private final Map<String, Student> db;

	public UniversityDatabase() {
		this.db = new HashMap<String,Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		db.put(accountName, student);
	}

	public int getStudentCount() {
		return db.size();
	}

	public String lookupFullName(String accountName) {
		if (db.get(accountName) ==(null)) {
			return null;
		}
		return db.get(accountName).getFullName();
	}

	public double getTotalBearBucks() {
		double total = 0;
		for (String accountName : db.keySet()) {
			total += db.get(accountName).getBearBucksBalance();
		}
		return total;
	}
}
