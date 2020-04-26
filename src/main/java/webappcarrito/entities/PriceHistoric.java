package webappcarrito.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "priceHistoric")
public class PriceHistoric implements Serializable{
	
	private static final long serialVersionUID = -5492175428682378917L;
	
	private Integer priceHistoricID;
	private Integer productID;
	private String productName;
	private BigDecimal price;
	private Date registerDate;
	private String productCode;
	private Products product;
	
	public PriceHistoric() {
		
	}	
	
	public PriceHistoric(String productName, BigDecimal price, Date registerDate, String productCode) {
		super();
		this.productName = productName;
		this.price = price;
		this.registerDate = registerDate;
		this.productCode = productCode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PriceHistoricID", unique = true, nullable = false, insertable = false, updatable = false)
	public Integer getPriceHistoricID() {
		return priceHistoricID;
	}
	public void setPriceHistoricID(Integer priceHistoricID) {
		this.priceHistoricID = priceHistoricID;
	}

	@JoinColumn(name = "ProductID", nullable = false, insertable = false, updatable = false)
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	@Column(name = "ProductName", nullable = false, columnDefinition = "varchar(30)")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "Price", nullable = true)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "RegisterDate", nullable = false, columnDefinition = "date")
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "ProductCode", nullable = false, columnDefinition = "char(10)")
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@ManyToOne
	@JoinColumn(name = "ProductID")
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "PriceHistoric [priceHistoricID=" + priceHistoricID + ", productID=" + productID + ", productName="
				+ productName + ", price=" + price + ", registerDate=" + registerDate + ", productCode=" + productCode
				+ "]";
	}
	
}
