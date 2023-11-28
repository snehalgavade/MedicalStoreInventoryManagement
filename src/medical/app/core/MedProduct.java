package medical.app.core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MedProduct implements Serializable{
static int idCounter=0;
	private int id;
	private String name;
	private KeyIngredient keyIngredient;
	private LocalDate expiry;
	private int stock=0;
	private LocalDate stockUpdateDate;
	private LocalDate stockListingDate;
	private double price;
	
	//ctor
	public MedProduct( String name, KeyIngredient keyIngredient, LocalDate expiry, int stock, LocalDate stockUpdateDate,
			LocalDate stockListingDate, double price) {
		super();
		this.id = ++idCounter;
		this.name = name;
		this.keyIngredient=keyIngredient;
		this.expiry = expiry;
		this.stock = this.stock+stock;
		this.stockUpdateDate = stockUpdateDate;
		this.stockListingDate = stockListingDate;
		this.price = price;
	}
	
	
	

	public MedProduct(String name) {
		super();
		this.name = name;
	}

	public MedProduct(int id) {
		super();
		this.id = id;
	}

	//toString
	@Override
	public String toString() {
		return "\nMedProduct [id=" + id + ", name=" + name + ", keyIngredient=" + keyIngredient + ", expiry=" + expiry
				+ ", stock=" + stock + ", stockUpdateDate=" + stockUpdateDate + ", stockListingDate=" + stockListingDate
				+ ", price=" + price + "]";
	}
	
	
	//getters/setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public KeyIngredient getKeyIngredient() {
		return keyIngredient;
	}

	public void setKeyIngredient(KeyIngredient keyIngredient) {
		this.keyIngredient = keyIngredient;
	}

	public LocalDate getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public LocalDate getStockListingDate() {
		return stockListingDate;
	}

	public void setStockListingDate(LocalDate stockListingDate) {
		this.stockListingDate = stockListingDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedProduct other = (MedProduct) obj;
		return Objects.equals(name, other.name);
	}
	
}
