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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role implements Serializable{

	private static final long serialVersionUID = -1828772690395055496L;

	private Integer roleID;
	private String nameOfRole;
	private String code;
	private String description;
	private Set<User> users = new HashSet<>();
	
	public Role() {
		
	}
	
	public Role(String nameOfRole, String code, String description) {
		super();
		this.nameOfRole = nameOfRole;
		this.code = code;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleID", unique = true, nullable = false, insertable = false, updatable = false)
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	@Column(name = "NameOfRole", nullable = false, columnDefinition = "varchar(30)")
	public String getNameOfRole() {
		return nameOfRole;
	}
	public void setNameOfRole(String nameOfRole) {
		this.nameOfRole = nameOfRole;
	}

	@Column(name = "Code", nullable = false, unique = true, columnDefinition = "char(3)")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "Description", nullable = true, columnDefinition = "varchar(250)")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", nameOfRole=" + nameOfRole + ", code=" + code + ", description="
				+ description + "]";
	}



}
