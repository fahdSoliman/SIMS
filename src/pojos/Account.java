package pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account{

	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, name = "accountID")
	private int accountID;
	@NotNull
	@Column(name = "fullName")
	private String fullName;
	@NotNull
	@Column(name = "address")
	private String address;
	@NotNull
	@Column(name = "mobileNo")
	private String mobileNo;
	@NotNull
	@org.hibernate.validator.constraints.Email
	@Column(name = "email")
	private String email;
	@Column(unique = true, name = "userLogin")
	private String userLogin;
	@NotNull
	@Column(name = "password")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Blank or Invalid Password")
	private String password;
	@NotNull
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private Type type;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "regDate")
	private LocalDate regDate;
	
	public Account() {
		super();
	}

	public Account(int uID, String fullName, String address, String mobileNo, String email, String UserLogin,
			String password, pojos.Type type,Date regDate) {
		super();
		accountID = uID;
		this.fullName = fullName;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.userLogin = UserLogin;
		this.password = password;
		this.type = type;
		regDate = java.sql.Date.valueOf(LocalDate.now());
	}

	/*public Enum Type{
		FACULTY ,  STUDENT,  COORDINATOR , REGISTRATION  , ADMIN;
	}*/
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public LocalDate getRegDate() {
		return regDate;
	}
	
	public void setRegDate(LocalDate regDate) {
		

		this.regDate = regDate;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getUserLogin() {
		return userLogin;
	}
	
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", fullName=" + fullName + ", address=" + address + ", mobileNo="
				+ mobileNo + ", email=" + email + ", userLogin=" + userLogin + ", password=" + password + ", type="
				+ type + ", regDate=" + regDate + "]";
	}


}
