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

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
