package com.quindel.ecomerce.product.endpoint;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quindel.ecomerce.product.dto.PriceDTO;
import com.quindel.ecomerce.product.service.IPriceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductEndpoint {

	/** Campo de servicio */
	@Autowired
	IPriceService priceService;

	/**
	 * Operaci&oacute;n para devolver un precio mediante fecha, producto y cadena
	 * 
	 * @param dateApplication Fecha de aplicaci&oacute;n
	 * @param productId       Identificador de producto
	 * @param stringId        Identificador de cadena
	 * @return Response la informaci&oacute;n del PriceDTO
	 * @throws ParseException Excepci&oacute;n al convertir una fecha
	 */
	@GetMapping("/price")
	private PriceDTO getPrice(@RequestParam("dateApplication") String dateApplication,
			@RequestParam("productId") Integer productId, @RequestParam("brandId") Integer stringId)
			throws ParseException {
		log.info("Entro al endpoint con los siguientes parametros " + dateApplication + " " + productId + " " + stringId);

		return priceService.getPrice(dateApplication, productId, stringId);
	}
}
