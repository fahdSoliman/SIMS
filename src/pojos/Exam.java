package pojos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "exam")
public class Exam {
	
		@Id
		@NotNull
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(unique = true,name = "examID")
		private int examID;		 	//Primary Key
		
		@ManyToOne
		@JoinColumn(name = "studentID")
		private Student studentID;
		
		@NotNull
		@OneToMany(targetEntity=Marks.class, mappedBy="markID")
		private List<Marks> marks = new ArrayList<>();  
		
		@NotNull
		@Column(name = "examDate")
		private LocalDate examDate;

		public Exam() {
			
		}
		
		public Exam(int examID, Student studentID, LocalDate examDate) {
			super();
			this.examID = examID;
			this.studentID = studentID;
			this.examDate = examDate;
		}

		public int getExamID() {
			return examID;
		}

		public void setExamID(int examID) {
			this.examID = examID;
		}

		public Student getStudentID() {
			return studentID;
		}

		public void setStudentID(Student studentID) {
			this.studentID = studentID;
		}

		public List<Marks> getMarksID() {
			return marks;
		}

		public void setMarksID(List<Marks> marksID) {
			this.marks = marksID;
		}

		public LocalDate getExamDate() {
			return examDate;
		}

		public void setExamDate(LocalDate examDate) {
			this.examDate = examDate;
		}
		
		public void addMark(Marks mark) {
			marks.add(mark);
			mark.setExamID(this);
		}
		public void removeMark(Marks mark) {
			marks.remove(mark);
			mark.setExamID(null);
		}

		@Override
		public String toString() {
			return "Exam [examID=" + examID + ", studentID=" + studentID + ", marksID=" + marks + ", examDate="
					+ examDate + "]";
		}
		
		
		
}
