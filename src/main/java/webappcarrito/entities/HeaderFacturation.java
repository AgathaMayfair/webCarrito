package webappcarrito.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "headerFacturation")
public class HeaderFacturation implements Serializable{
	
	private static final long serialVersionUID = -6138613735257736000L;
	
	private Integer headerFacturationID;
	private Integer userID;
	private Date date;
	private BigDecimal totalAmount;
	private Integer facturationNumber;
	private User user;
	private Set<FacturationLines> facturationLines = new HashSet<>();
	
	public HeaderFacturation() {
		
	}
	
	public HeaderFacturation(Date date, BigDecimal totalAmount, Integer facturationNumber) {
		super();
		this.date = date;
		this.totalAmount = totalAmount;
		this.facturationNumber = facturationNumber;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HeaderFacturationID", unique = true, nullable = false, insertable = false, updatable = false)
	public Integer getHeaderFacturationID() {
		return headerFacturationID;
	}
	public void setHeaderFacturationID(Integer headerFacturationID) {
		this.headerFacturationID = headerFacturationID;
	}

	@Column(name = "UserID", nullable = false,insertable = false, updatable = false)
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	@Column(name = "Date", nullable = false, columnDefinition = "date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "TotalAmount", nullable = false)
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "FacturationNumber", nullable = false)
	public Integer getFacturationNumber() {
		return facturationNumber;
	}
	public void setFacturationNumber(Integer facturationNumber) {
		this.facturationNumber = facturationNumber;
	}

	@ManyToOne
	@JoinColumn(name = "UserID")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "headerFacturation")
	public Set<FacturationLines> getFacturationLines() {
		return facturationLines;
	}
	public void setFacturationLines(Set<FacturationLines> facturationLines) {
		this.facturationLines = facturationLines;
	}
	
	@Override
	public String toString() {
		return "HeaderFacturation [headerFacturationID=" + headerFacturationID + ", userID=" + userID + ", date=" + date
				+ ", totalAmount=" + totalAmount + ", facturationNumber=" + facturationNumber + "]";
	}
	
}
