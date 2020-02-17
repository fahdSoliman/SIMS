package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "class")
public class Class {
	
	    @Id
	    @NotNull
	    @Column(unique = true,name = "classID")
		private int classID ;			
		
		@NotNull
		@ManyToOne  
		@JoinColumn(name = "diplomaID")
		private Diploma diplomaID;		
		
		@NotNull
		@Column(name = "className")
		@NotEmpty(message="Class name  must be provided")
		private String className;
		
		@NotNull
		@Column(name = "size")
		public int size;
		
		@OneToMany(mappedBy="studentID",targetEntity=Student.class)  
		List<Student> students=new ArrayList<Student>();

		public Class(int classID, Diploma diplomaID, String className, int size) {
			super();
			this.classID = classID;
			this.diplomaID = diplomaID;
			this.className = className;
			this.size = size;
		}

		public int getClassID() {
			return classID;
		}

		public void setClassID(int classID) {
			this.classID = classID;
		}

		public Diploma getDiplomaID() {
			return diplomaID;
		}

		public void setDiplomaID(Diploma diplomaID) {
			this.diplomaID = diplomaID;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}
		
		public void addStudent(Student stu) {
			students.add(stu);
			stu.setClas(this);
		}
		
		public void removeStudent(Student stu) {
			students.remove(stu);
			stu.setClas(null);
		}

		@Override
		public String toString() {
			return "Class [ClassID=" + classID + ", diplomaID=" + diplomaID + ", className=" + className + ", size="
					+ size + ", students=" + students + "]";
		}

		
		
}
