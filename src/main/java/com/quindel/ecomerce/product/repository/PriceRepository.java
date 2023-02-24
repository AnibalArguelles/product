package com.quindel.ecomerce.product.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.quindel.ecomerce.product.model.Prices;

@Repository
public class PriceRepository {

	/** Campo entityManager */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Obtiene el primer resultado de la fecha buscada entre start_date y end_date
	 * con el producto y cadena especificos
	 * 
	 * @param applicationDate Fecha de aplicaci&oacute;n
	 * @param productId       Identificador de producto
	 * @param brandId         Identificador de cadena
	 * @return La informaci&oacute;n de Prices
	 */
	public Prices findOrderedBySeatNumberLimitedTo(Date applicationDate, Integer productId, Integer brandId) {
		return entityManager.createQuery(
				"SELECT p FROM Prices p WHERE p.startDate >= :applicationDate and :applicationDate <= p.endDate and p.productId = :productId and brandId = :brandId order by p.startDate asc, p.priority desc",
				Prices.class).setParameter("applicationDate", applicationDate).setParameter("productId", productId)
				.setParameter("brandId", brandId).setMaxResults(1).getSingleResult();
	}
}
