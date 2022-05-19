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

import net.osgg.DemoInvoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	Optional <Invoice> findById(Long id);
	
	void deleteById(Long id);
	
}
