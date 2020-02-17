package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;
import org.hibernate.validator.constraints.NotEmpty;




@Entity
@Table(name="VMessages")
public class VMessages{
	
	
	
	@Id
    @NotNull
    @Column(unique = true,name = "MessageID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 public int messageID;
	
	@NotNull
	@Column(name="Name")
	@NotEmpty(message="Name must be supplied.")
	public String name;
	
	@NotNull
	@Column(name="Email")
	@org.hibernate.validator.constraints.Email
	@NotEmpty(message="Email must be supplied.")
	public String email;
	
	@NotNull
	@Column(name="MobileNumber")
	@NotEmpty(message="Mobile number must be supplied.")
	public String mobileNumber;
	
	@NotNull
	@Column(name="Subject")
	@NotEmpty(message="Subject must be supplied.")
	@Length(max=20,message="The subject must contain less than or 20 characters only ")
	public String subject;
	
	@NotNull
	@Column(name="Details")
	@List({
	    @Length(min = 10, message = "The field must congtain at least 10 characters"),
	    @Length(max = 600, message = "The field must contain less than or  600 characters only")
	})
	public String details;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}


}
