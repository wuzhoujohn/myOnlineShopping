package com.johnwu.onlineStoreFrontEnd.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.johnwu.onlineStoreBackEnd.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> claz) {
		
		return Product.class.equals(claz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		//whether file has been selected
		if(product.getFile() == null || product.getFile().getName().equals("")) {
			//for the file field, the error is going to be generated
			errors.rejectValue("file", null, "Please select an image file to upload");
			return;
		}
		
		//check the img file type	
		if(!(product.getFile().getContentType().equals("image/jpeg") ||
			 product.getFile().getContentType().equals("image/png") ||
			 product.getFile().getContentType().equals("image/gif"))) {
			
			errors.rejectValue("file", null, "Please use only image file for upload");
			return;
		}
	}

}
