package pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "rooms")
public class Room {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(unique = true, name = "roomID")
	private int roomID;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ins_id")
	private Institute ins;
	
	@NotNull
	@Column(name = "roomName", unique = true)
	@NotEmpty(message="Name must be supplied")
	private String roomName;
	
	@NotNull
	@Column(name = "roomSize")
	@Range(min=20, max=50, message= "range between 20 & 50")	
	private int roomSize;
	
	@NotNull
	@Column(name = "roomFloor")
	@NotEmpty(message="Floor must be supplied")
	private String roomFloor;
	
	
	
	public Room() {
		
	}



	public Room(int roomID, Institute ins, String roomName, int roomSize, String roomFloor) {
		super();
		this.roomID = roomID;
		this.ins = ins;
		this.roomName = roomName;
		this.roomSize = roomSize;
		this.roomFloor = roomFloor;
	}



	public int getRoomID() {
		return roomID;
	}



	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}



	public Institute getIns() {
		return ins;
	}



	public void setIns(Institute ins) {
		this.ins = ins;
	}



	public String getRoomName() {
		return roomName;
	}



	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}



	public int getRoomSize() {
		return roomSize;
	}



	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}



	public String getRoomFloor() {
		return roomFloor;
	}



	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}



	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", ins=" + ins + ", roomName=" + roomName + ", roomSize=" + roomSize
				+ ", roomFloor=" + roomFloor + "]";
	}


	
}
