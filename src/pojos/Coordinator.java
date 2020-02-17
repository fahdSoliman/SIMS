package pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "coordinator")
public class Coordinator {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(unique = true,name = "coordinatorID")
	private int coordinatorID;
	
	@OneToOne
	@JoinColumn(name = "accountID")
	private Account accountID;
	
	@OneToOne
	@JoinColumn(name = "diplomaID")
	private Diploma diplomaID;
	
	
	public Coordinator() {
		
	}

	public Coordinator(int coordinatorID, Account accountID, Diploma diplomaID) {
		super();
		this.coordinatorID = coordinatorID;
		this.accountID = accountID;
		this.diplomaID = diplomaID;
	}

	public int getCoordinatorID() {
		return coordinatorID;
	}


	public void setCoordinatorID(int coordinatorID) {
		this.coordinatorID = coordinatorID;
	}


	public Account getAccountID() {
		return accountID;
	}


	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}


	public Diploma getDiplomaID() {
		return diplomaID;
	}


	public void setDiplomaID(Diploma diplomaID) {
		this.diplomaID = diplomaID;
	}

	@Override
	public String toString() {
		return "Coordinator [coordinatorID=" + coordinatorID + ", accountID=" + accountID + ", diplomaID=" + diplomaID
				+ "]";
	}



}
