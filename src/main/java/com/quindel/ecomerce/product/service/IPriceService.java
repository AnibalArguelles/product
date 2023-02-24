package com.quindel.ecomerce.product.service;

import java.text.ParseException;

import com.quindel.ecomerce.product.dto.PriceDTO;

public interface IPriceService {

	/**
	 * Obtiene el precio mediante fecha de aplicaci&oacute;n pruducto y cadena
	 * 
	 * @param dateApplication 
	 * @param productId
	 * @param stringId
	 * @return
	 * @throws ParseException
	 */
	PriceDTO getPrice(String dateApplication, Integer productId, Integer stringId) throws ParseException;
}
