package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="diploma")
public class Diploma {

		@Id
		@NotNull	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(unique = true,name = "diplomaID")
		private int diplomaID;               //Primary Key
		
		@ManyToOne
		@JoinColumn(name = "ins_id")
		private Institute insID;
	    
	    @NotNull 
		@Column(name = "diplomaName",unique=true)
	    @Length(min = 5,max = 15, message = "The field must contain 5 to 15 chars")
		private String diplomaName;
	    
	    @OneToOne(mappedBy = "accountID")
	    @JoinColumn(name = "coordinatorID")
	    private Coordinator coor;
	    
	    @NotNull
		@Column(name = "passMark")
		private int passmark;
	    
	    @NotNull
		@Column(name = "totalMark")
	    private int totalMark;
	    
	    @NotNull
		@Column(name = "duration")
	    private int duration;
	    
	    @OneToMany(targetEntity=Room.class, mappedBy="ins",cascade=CascadeType.ALL)
	    private List<Class> classes = new ArrayList<>();;
	    
	    @OneToMany(targetEntity=Module.class, mappedBy="diplomaID",cascade=CascadeType.ALL)
	    private List<Module> modules = new ArrayList<>();
	    
		public Diploma() {
		}

		



		public Diploma(int diplomaID, Institute insID, String diplomaName, Coordinator coor, int passmark,
				int totalMark, int duration, List<Class> classes, List<Module> modules) {
			super();
			this.diplomaID = diplomaID;
			this.insID = insID;
			this.diplomaName = diplomaName;
			this.coor = coor;
			this.passmark = passmark;
			this.totalMark = totalMark;
			this.duration = duration;
			this.classes = classes;
			this.modules = modules;
		}





		public int getDiplomaID() {
			return diplomaID;
		}

		public void setDiplomaID(int diplomaID) {
			this.diplomaID = diplomaID;
		}

		public Institute getInsID() {
			return insID;
		}

		public void setInsID(Institute insID) {
			this.insID = insID;
		}

		public Coordinator getCoor() {
			return coor;
		}

		public void setCoor(Coordinator coor) {
			this.coor = coor;
		}

		public String getDiplomaName() {
			return diplomaName;
		}

		public void setDiplomaName(String diplomaName) {
			this.diplomaName = diplomaName;
		}

		public int getPassmark() {
			return passmark;
		}

		public void setPassmark(int passmark) {
			this.passmark = passmark;
		}

		public int getTotalMark() {
			return totalMark;
		}

		public void setTotalMark(int totalMark) {
			this.totalMark = totalMark;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public List<Class> getClasses() {
			return classes;
		}

		public void setClasses(List<Class> classes) {
			this.classes = classes;
		}

		public List<Module> getModules() {
			return modules;
		}

		public void setModules(List<Module> modules) {
			this.modules = modules;
		}
		//-----------------------------------
		public void addClass(Class clas) {
			classes.add(clas);
			clas.setDiplomaID(this);
		}
		
		public void removeClass(Class clas) {
			classes.remove(clas);
			clas.setDiplomaID(null);
		}
		
		public void addModule(Module mod) {
			modules.add(mod);
			mod.setDiplomaID(this);
		}
	    
		public void removeModule(Module mod) {
			modules.remove(mod);
			mod.setDiplomaID(null);
		}
		//----------------------------------





		@Override
		public String toString() {
			return "Diploma [diplomaID=" + diplomaID + ", insID=" + insID + ", diplomaName=" + diplomaName + ", coor="
					+ coor + ", passmark=" + passmark + ", totalMark=" + totalMark + ", duration=" + duration
					+ ", classes=" + classes + ", modules=" + modules + "]";
		}

	
		
		
}
