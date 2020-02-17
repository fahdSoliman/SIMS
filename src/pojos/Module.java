package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "module")
public class Module {
	
		@Id
		@NotNull
		@Column(unique = true,name = "moduleID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private int moduleID;		//Primary Key
	    @ManyToOne
	    @JoinColumn(name = "diplomaID")
	    private Diploma diplomaID;   // FK
	    
	    @ManyToOne  
	    @JoinColumn(name = "facultyID")
	    private Faculty facultyID;		//FK
	    
	    @NotNull
		@Column(name = "moduleName")
	    @NotEmpty(message="Course name must be supplied")
	    public String moduleName;
	    
	    @NotNull
		@Column(name = "passMark")
		public int passMark;
	    
	    @NotNull
		@Column(name = "failMark")
	    private int failMark;
	    
	    @OneToMany(targetEntity=Marks.class, mappedBy="markID")
	    private List<Marks> marks = new ArrayList<>();
	    
	    
		public Module(int moduleID, Diploma diplomaID, Faculty facultyID, String courseName, int passMark, int failMark,
				Exam examID) {
			super();
			this.moduleID = moduleID;
			this.diplomaID = diplomaID;
			this.facultyID = facultyID;
			this.moduleName = courseName;
			this.passMark = passMark;
			this.failMark = failMark;
		}
		
		public int getModuleID() {
			return moduleID;
		}

		public void setModuleID(int moduleID) {
			this.moduleID = moduleID;
		}

		public Diploma getDiplomaID() {
			return diplomaID;
		}

		public void setDiplomaID(Diploma diplomaID) {
			this.diplomaID = diplomaID;
		}

		public Faculty getFacultyID() {
			return facultyID;
		}

		public void setFacultyID(Faculty facultyID) {
			this.facultyID = facultyID;
		}

		public String getCourseName() {
			return moduleName;
		}

		public void setCourseName(String courseName) {
			this.moduleName = courseName;
		}

		public int getPassMark() {
			return passMark;
		}

		public void setPassMark(int passMark) {
			this.passMark = passMark;
		}

		public int getFailMark() {
			return failMark;
		}

		public void setFailMark(int failMark) {
			this.failMark = failMark;
		}

		public List<Marks> getMarks() {
			return marks;
		}

		public void setMarks(List<Marks> marks) {
			this.marks = marks;
		}
		
		public void addMark(Marks mark) {
			marks.add(mark);
			mark.setModuleID(this);
		}
		public void removeNark(Marks mark) {
			marks.add(mark);
			mark.setModuleID(null); 
		}
		
		@Override
		public String toString() {
			return "Module [ModuleID=" + moduleID + ", diplomaID=" + diplomaID + ", facultyID=" + facultyID
					+ ", courseName=" + moduleName + ", passMark=" + passMark + ", failMark=" + failMark + ", marks="
					+ marks + "]";
		}
	
}
