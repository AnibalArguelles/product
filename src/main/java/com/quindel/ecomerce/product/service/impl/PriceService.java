package com.quindel.ecomerce.product.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quindel.ecomerce.product.dto.PriceDTO;
import com.quindel.ecomerce.product.model.Prices;
import com.quindel.ecomerce.product.repository.PriceRepository;
import com.quindel.ecomerce.product.service.IPriceService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceService implements IPriceService {

	/** Campo de priceRepository */
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public PriceDTO getPrice(String dateApplication, Integer productId, Integer stringId) throws ParseException {
		/** Define el formato de la fecha */
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		/** Fecha convertida a Date con el formato establecido */
		Date applicationDate = simpleDateFormat.parse(dateApplication);

		/** consulta del price en relacion a los parametros */
		Prices price = priceRepository.findOrderedBySeatNumberLimitedTo(applicationDate, productId, stringId);

		PriceDTO priceDTO = null;

		/** Validacion si encuentra registro en la bd */
		if (price != null) {
			log.info("Recupero valor de la BD " + price);
			/** Convierte a DTO la entidad obtenida */
			priceDTO = getPriceDTOFromPricesEntity(price);
		}
		return priceDTO;
	}

	/**
	 * Obtiene un DTO con la informaci&oacute;n requerida
	 * 
	 * @param prices Entidad a ser convertida a DTO
	 * @return DTO de la entidad
	 */
	private PriceDTO getPriceDTOFromPricesEntity(Prices prices) {
		return new PriceDTO(prices.getProductId(), prices.getBrandId(), prices.getCurr(), prices.getStartDate(),
				prices.getEndDate(), prices.getPrice());
	}
}
