package pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "marks")
public class Marks {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(unique = true,name = "markID")
	private int markID;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "examID")
	private Exam examID;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "moduleID")
	private Module moduleID;	
	
	@Column(name = "markValue")
	private int markValue;

	public Marks(int markID, Exam examID, Student studentID, int markValue) {
		super();
		this.markID = markID;
		this.examID = examID;
		this.markValue = markValue;
	}

	public Marks() {
	
	}

	public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}

	public Exam getExamID() {
		return examID;
	}

	public void setExamID(Exam examID) {
		this.examID = examID;
	}
	
	public Module getModuleID() {
		return moduleID;
	}

	public void setModuleID(Module moduleID) {
		this.moduleID = moduleID;
	}

	public int getMarkValue() {
		return markValue;
	}

	public void setMarkValue(int markValue) {
		this.markValue = markValue;
	}

	@Override
	public String toString() {
		return "Marks [markID=" + markID + ", examID=" + examID + ", moduleID=" + moduleID + ", markValue=" + markValue
				+ "]";
	}
}
