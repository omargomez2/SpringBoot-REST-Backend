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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class InvoiceController {
	@Autowired
	InvoiceService service;
	
	@GetMapping("/invoice")
	public ResponseEntity<List<Invoice>> getAll() {
		List<Invoice> list = service.getAll();
		return new ResponseEntity<List<Invoice>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/invoice/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Invoice entity = service.findById(id);
		return new ResponseEntity<Invoice>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/invoice")
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
		service.createInvoice(invoice);
		return new ResponseEntity<Invoice>(invoice, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/invoice")
	public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice) throws RecordNotFoundException{
		service.updateInvoice(invoice);
		return new ResponseEntity<Invoice>(invoice, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/invoice/{id}")
	public HttpStatus deleteInvoiceById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteInvoiceById(id);
		return HttpStatus.OK;
	}
}				
