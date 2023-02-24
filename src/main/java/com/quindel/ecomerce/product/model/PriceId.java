package com.quindel.ecomerce.product.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceId implements Serializable {

	private static final long serialVersionUID = 5761526155812302842L;

	/** Campo para el id de producto */
	private Integer productId;

	/** Campo para tarifa de precios aplicable */
	private Integer priceList;
}
