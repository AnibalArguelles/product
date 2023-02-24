package com.quindel.ecomerce.product.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

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
@Entity
@IdClass(PriceId.class)
public class Prices implements Serializable {

	private static final long serialVersionUID = -495619599305185379L;

	/** Campo para el id de producto */
	@Id
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	/** Campo para tarifa de precios aplicable */
	@Id
	@Column(name = "PRICE_LIST")
	private Integer priceList;

	/** Campo para la cadena del grupo */
	@Column(name = "BRAND_ID")
	private Integer brandId;

	/** Campo para fecha inicial en la que aplica el precio */
	@Column(name = "START_DATE")
	private Date startDate;

	/** Campo para fecha final en la que aplica el precio */
	@Column(name = "END_DATE")
	private Date endDate;

	/** Campo para desambiguar precios */
	@Column(name = "PRIORITY")
	private Integer priority;

	/** Campo para precio */
	@Column(name = "PRICE")
	private Double price;

	/** Campo para tipo de moneda */
	@Column(name = "CURR")
	private String curr;
}
