package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Student")
public class Student {
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @NotNull
	    @Column(unique = true,name = "StudentID")
		private int studentID;
	    
	    @NotNull
	    @OneToOne
	    @JoinColumn(name = "accountID")
		private Account accountID;
	    
	    @NotNull
	    @ManyToOne
	    @JoinColumn(name= "classID")
		private Class clas;
	    
	    @Column(name = "message")
	    private String message;
	    
	    @Column(name = "active")
	    private String active;
	    
	    @NotNull
	    @OneToMany(targetEntity=Exam.class, mappedBy="examID")
	    private List<Exam> exams = new ArrayList<>();
	    
		public Student() {
		}

		public Student(int studentID, Account accountID, Class clas, String active) {
			super();
			this.studentID = studentID;
			this.accountID = accountID;
			this.clas = clas;
			this.active = active;
		}

		public int getStudentID() {
			return studentID;
		}

		public void setStudentID(int studentID) {
			this.studentID = studentID;
		}

		public Account getAccountID() {
			return accountID;
		}

		public void setAccountID(Account accountID) {
			this.accountID = accountID;
		}

		public Class getClas() {
			return clas;
		}

		public void setClas(Class clas) {
			this.clas = clas;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getActive() {
			return active;
		}

		public void setActive(String active) {
			this.active = active;
		}

		public List<Exam> getExams() {
			return exams;
		}

		public void setExams(List<Exam> exams) {
			this.exams = exams;
		}
	    
		public void addExam(Exam exam) {
			exams.add(exam);
			exam.setStudentID(this);
		}
		
		public void removeExam(Exam exam) {
			exams.add(exam);
			exam.setStudentID(null);
		}

		@Override
		public String toString() {
			return "Student [studentID=" + studentID + ", accountID=" + accountID + ", clas=" + clas + ", message="
					+ message + ", active=" + active + ", exams=" + exams + "]";
		}
	    
				
}