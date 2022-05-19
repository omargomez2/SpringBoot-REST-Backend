																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Wed May 18 19:02:37 ECT 2022
| 
 -------------------------------------------------------------------
																*/
package net.osgg.DemoInvoice;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;	
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;
import javax.persistence.Basic;
	
@Entity
@Table(name = "invoice_table")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	private Date dateInv;
	private String description;
	private Double amount;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDateInv() {
		return dateInv;
	}
	
	public void setDateInv(Date dateInv) {
		this.dateInv = dateInv;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
