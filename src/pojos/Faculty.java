package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
	@Column(unique = true, name = "facultyID")
	private int facultyID;
	
	@OneToOne
	@JoinColumn(name = "accountID")
	private Account accounts;
	
	@OneToMany(targetEntity=Module.class, mappedBy="moduleID")
	private List<Module> modules = new ArrayList<>();

	public Faculty() {
		
	}

	public Faculty(int facultyID) {
		super();
		this.facultyID = facultyID;
	}

	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}
	
	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void addModule(Module mod) {
		modules.add(mod);
		mod.setFacultyID(this);
	}
	
	public void removeModule(Module mod) {
		modules.remove(mod);
		mod.setFacultyID(null); 
	}
	
	@Override
	public String toString() {
		return "Faculty [facultyID=" + facultyID + ", accounts=" + accounts + ", modules=" + modules + "]";
	}
}
	
