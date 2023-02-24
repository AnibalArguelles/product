package com.quindel.ecomerce.product.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PriceDTO {

	/** Campo para el id de producto */
	private Integer productId;

	/** Campo para la cadena del grupo */
	private Integer brandId;

	/** Campo para tipo de moneda */
	private String curr;

	/** Campo para fecha inicial en la que aplica el precio */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Mexico_City")
	private Date startDate;

	/** Campo para fecha final en la que aplica el precio */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Mexico_City")
	private Date endDate;

	/** Campo para precio */
	private Double price;
}
