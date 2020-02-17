package pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "institute")
public class Institute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(unique = true,name = "instituteID")
	private int instituteID;
	
	@NotNull
	@Column(name = "instituteName")
	@NotEmpty(message="Name must be supplied")
	private String instituteName;
	
	@NotNull
	@Column(name = "scope")
	@NotEmpty(message="Name must be supplied")
	private String scope;
	
	@NotNull
	@Column(name = "aboutUs")
	@NotEmpty(message="Name must be supplied")
	private String aboutUs;
	
	@NotNull
	@Column(name = "contactUs")
	@NotEmpty(message="Name must be supplied")
	private String contactUs;
	
	@OneToMany(targetEntity=Room.class, mappedBy="ins",cascade=CascadeType.ALL)
	private List<Room> rooms = new ArrayList<>();
	
	@OneToMany(targetEntity=Diploma.class, mappedBy="insID",cascade=CascadeType.ALL)
	private List<Diploma> diplomas = new ArrayList<>();
	
	public Institute() {
	}
	
	
	public Institute(int instituteID, String instituteName, String scope, String aboutUs, String contactUs) {
		super();
		this.instituteID = instituteID;
		this.instituteName = instituteName;
		this.scope = scope;
		this.aboutUs = aboutUs;
		this.contactUs = contactUs;
	}


	public int getInstituteID() {
		return instituteID;
	}


	public void setInstituteID(int instituteID) {
		this.instituteID = instituteID;
	}


	public String getInstituteName() {
		return instituteName;
	}


	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getAboutUs() {
		return aboutUs;
	}


	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}


	public String getContactUs() {
		return contactUs;
	}


	public void setContactUs(String contactUs) {
		this.contactUs = contactUs;
	}


	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public void AddRoom(Room room) {
		rooms.add(room);
		room.setIns(this);
	}
	public void RemoveRoom(Room room) {
		rooms.remove(room);
		room.setIns(null);
	}
	
	public List<Diploma> getDiplomas() {
		return diplomas;
	}
	
	public void setDiplomas(List<Diploma> diplomas) {
		this.diplomas = diplomas;
	}

	public void addDiploma(Diploma dip) {
		diplomas.add(dip);
		dip.setInsID(this);
	}
	public void removeDiploma(Diploma dip) {
		diplomas.remove(dip);
		dip.setInsID(null); 
	}
	
	@Override
	public String toString() {
		return "Institute [instituteID=" + instituteID + ", instituteName=" + instituteName + ", scope=" + scope
				+ ", aboutUs=" + aboutUs + ", contactUs=" + contactUs + ", rooms=" + rooms + "]";
	}

	
	
}
