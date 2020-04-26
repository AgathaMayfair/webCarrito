package webappcarrito.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facturationLines")
public class FacturationLines implements Serializable{

	private static final long serialVersionUID = -376878405023030226L;

	private Integer facturationLinesID;
	private Integer headerFacturationID;
	private String productName;
	private String brand;
	private BigDecimal price;
	private String productCode;
	private HeaderFacturation headerFacturation;
	
	public FacturationLines() {
		
	}
	
	public FacturationLines(String productName, String brand, BigDecimal price, String productCode) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.price = price;
		this.productCode = productCode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FacturationLinesID", unique = true, nullable = false, insertable = false, updatable = false)
	public Integer getFacturationLinesID() {
		return facturationLinesID;
	}
	public void setFacturationLinesID(Integer facturationLinesID) {
		this.facturationLinesID = facturationLinesID;
	}

	@Column(name = "HeaderFacturationID", nullable = false, insertable = false, updatable = false)
	public Integer getHeaderFacturationID() {
		return headerFacturationID;
	}
	public void setHeaderFacturationID(Integer headerFacturationID) {
		this.headerFacturationID = headerFacturationID;
	}

	@Column(name = "ProductName", nullable = false, columnDefinition = "varchar(30)")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "Brand", nullable = false, columnDefinition = "varchar(50)")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "Price", nullable = true)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "ProductCode", nullable = false, columnDefinition = "char(10)")
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	@ManyToOne
	@JoinColumn(name = "HeaderFacturationID")
	public HeaderFacturation getHeaderFacturation() {
		return headerFacturation;
	}
	public void setHeaderFacturation(HeaderFacturation headerFacturation) {
		this.headerFacturation = headerFacturation;
	}

	@Override
	public String toString() {
		return "FacturationLines [facturationLinesID=" + facturationLinesID + ", headerFacturationID="
				+ headerFacturationID + ", productName=" + productName + ", brand=" + brand + ", price=" + price
				+ ", productCode=" + productCode + "]";
	}
	
}
