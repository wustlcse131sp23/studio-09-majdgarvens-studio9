package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.

public class Student {
	private String firstName;
	private String lastName;
	private int idNum;
	private int attemptedCredits;
	private int passingCredits;
	private double totalQualityPoints;
	private double bucksBalance;
	
	
	public Student(String firstName, String lastName, int idNum) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.idNum=idNum;
		this.attemptedCredits = 0;
		this.passingCredits=0;
		this.totalQualityPoints=0.0;
		this.bucksBalance = 0.0;
	}
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public String getLastName() {
		return this.lastName ;
	}
	public int getId() {
		return this.idNum;
	}
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits; 
	}
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	public double getTotalQualityPoints() {
		return this.totalQualityPoints;
	}
	public void submitGrade(double grade, int credits) {
		this.attemptedCredits += credits;
		if (grade >= 1.7) {
		this.totalQualityPoints += grade*credits;
		this.passingCredits += credits;
		}
		
		else {
		this.totalQualityPoints += grade*credits;
		}
	}
	public double calculateGradePointAverage() {
		if (this.attemptedCredits <= 0 || Double.isNaN(totalQualityPoints)) {
			return Double.NaN;
		}
		else {
		double GPA = (this.totalQualityPoints/this.attemptedCredits);
		return GPA;
		}	
	}
	public String getClassStanding() {
		if (this.passingCredits<30) {
			return "First Year";
		}
		if (this.passingCredits>=30 && this.passingCredits<60) {
			return "Sophomore";
		}
		if (this.passingCredits>=60 && this.passingCredits<90) {
			return "Junior";
		}
		if (this.passingCredits>=90) {
			return "Senior";
		}
		return "Not a Student";
	}
	public boolean isEligibleForPhiBetaKappa() {
		if (this.passingCredits>= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		}
		if (this.passingCredits >=75 && calculateGradePointAverage() >= 3.80) {
			return true;
		}
		return false;
	}
	public void depositBearBucks(double amount) {
		this.bucksBalance += amount;
	}
	public void deductBearBucks(double amount) {
		this.bucksBalance -= amount;
	}
	public double getBearBucksBalance() {
		return this.bucksBalance;
	}
	public double cashOutBearBucks() {
		double temp = this.bucksBalance;
		this.bucksBalance=0;
		if (temp <= 10) {
			return 0.0;
		}
		return (temp - 10);
	}
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String legacyLastName = lastName;
		if (isHyphenated == true) {
			legacyLastName = this.lastName + "-" + otherParent.getLastName();
		}
		Student legacy = new Student(firstName, legacyLastName, id);
		legacy.bucksBalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
		return legacy;
	}
	public String toString() {
		return firstName + " " + lastName + " " + idNum; 
	}
	
}
