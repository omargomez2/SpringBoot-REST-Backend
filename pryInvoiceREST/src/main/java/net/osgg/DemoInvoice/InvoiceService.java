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
import net.osgg.DemoInvoice.RecordNotFoundException;
import net.osgg.DemoInvoice.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

	@Autowired
	InvoiceRepository repo;

	public List<Invoice> getAll(){
		List<Invoice> invoiceList = repo.findAll();
		if(invoiceList.size() > 0) {
			return invoiceList;
		} else {
			return new ArrayList<Invoice>();
		}
	}
     		
	public Invoice findById(Long id) throws RecordNotFoundException{
		Optional<Invoice> invoice = repo.findById(id);
		if(invoice.isPresent()) {
			return invoice.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public Invoice createInvoice(Invoice invoice){
		return repo.save(invoice);
	}

	public Invoice updateInvoice(Invoice invoice) throws RecordNotFoundException {
		Optional<Invoice> invoiceTemp = repo.findById(invoice.getId());
	
		if(invoiceTemp.isPresent()){
			return repo.save(invoice);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deleteInvoiceById(Long id) throws RecordNotFoundException{
		Optional<Invoice> invoice = repo.findById(id);
		if(invoice.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
