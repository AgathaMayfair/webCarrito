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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products implements Serializable{

	private static final long serialVersionUID = -5622483290095719032L;
	
	private Integer productID;
	private String productName;
	private String description;
	private String brand;
	private String provider;
	private BigDecimal price;
	private Integer availableQuantity;
	private Integer sellQuantity;
	private Date registerDate;
	private String productCode;
	private Set<PriceHistoric> pricehistorics = new HashSet<>();
	
	public Products() {
		
	}
	
	public Products(String productName, String description, String brand, String provider, BigDecimal price,
			Integer availableQuantity, Integer sellQuantity, Date registerDate, String productCode) {
		super();
		this.productName = productName;
		this.description = description;
		this.brand = brand;
		this.provider = provider;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.sellQuantity = sellQuantity;
		this.registerDate = registerDate;
		this.productCode = productCode;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID", unique = true, nullable = false, insertable = false, updatable = false)
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

	@Column(name = "Description", nullable = false, columnDefinition = "varchar(300)")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Brand", nullable = false, columnDefinition = "varchar(50)")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "Provider", nullable = false, columnDefinition = "varchar(50)")
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column(name = "Price", nullable = true)
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "AvailableQuantity", nullable = false)
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Column(name = "SellQuantity", nullable = false)
	public Integer getSellQuantity() {
		return sellQuantity;
	}
	public void setSellQuantity(Integer sellQuantity) {
		this.sellQuantity = sellQuantity;
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

	@OneToMany(mappedBy = "product")
	public Set<PriceHistoric> getPricehistorics() {
		return pricehistorics;
	}
	public void setPricehistorics(Set<PriceHistoric> pricehistorics) {
		this.pricehistorics = pricehistorics;
	}
	
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", brand=" + brand + ", provider=" + provider + ", price=" + price + ", availableQuantity="
				+ availableQuantity + ", sellQuantity=" + sellQuantity + ", registerDate=" + registerDate
				+ ", productCode=" + productCode + "]";
	}

}
