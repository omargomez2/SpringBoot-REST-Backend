																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Wed May 18 19:02:38 ECT 2022
| 
 -------------------------------------------------------------------
																*/
package net.osgg.DemoInvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class DemoInvoiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoInvoiceApplication.class, args);
		System.out.println("Active resources for Invoice entity");
		System.out.println("GET");
		System.out.println("/api/v1/invoice");
		System.out.println("/api/v1/invoice/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/invoice");
		System.out.println("PUT");
		System.out.println("/api/v1/invoice");
		System.out.println("DELETE");
		System.out.println("/api/v1/invoice/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}
