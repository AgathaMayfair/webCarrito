package webappcarrito.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -5515154736480337757L;
	
	private Integer UserID;
	private Integer RoleID;
	private String name;
	private String surname;
	private String ci;
	private String phone;
	private String address;
	private String mail;
	private String password;
	private Role role;
	private Set<HeaderFacturation> headerFacturations = new HashSet<>();
	
	public User() {
		
	}
	
	public User(String name, String surname, String ci, String phone, String address,
			String mail, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.ci = ci;
		this.phone = phone;
		this.address = address;
		this.mail = mail;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID", unique = true, nullable = false, insertable = false, updatable = false)
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}

	@Column(name = "RoleID", nullable = false, insertable = false, updatable = false)
	public Integer getRoleID() {
		return RoleID;
	}
	public void setRoleID(Integer roleID) {
		RoleID = roleID;
	}

	@Column(name = "Name", nullable = false, columnDefinition = "varchar(30)")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Surname", nullable = false, columnDefinition = "varchar(30)")
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "CI", nullable = false, columnDefinition = "varchar(30)")
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}

	@Column(name = "Phone", nullable = true, columnDefinition = "varchar(30)")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Address", nullable = false, columnDefinition = "varchar(100)")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Mail", nullable = false, columnDefinition = "varchar(30)")
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "Password", nullable = false, columnDefinition = "varchar(30)")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleID")
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "user")
	public Set<HeaderFacturation> getHeaderFacturations() {
		return headerFacturations;
	}
	public void setHeaderFacturations(Set<HeaderFacturation> headerFacturations) {
		this.headerFacturations = headerFacturations;
	}
	
	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", RoleID=" + RoleID + ", name=" + name + ", surname=" + surname + ", ci="
				+ ci + ", phone=" + phone + ", address=" + address + ", mail=" + mail + ", password=" + password + "]";
	}

}
