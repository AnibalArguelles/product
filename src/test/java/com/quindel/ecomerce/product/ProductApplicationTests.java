package com.quindel.ecomerce.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.quindel.ecomerce.product.dto.PriceDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
class ProductApplicationTests {

	@Value(value = "${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testTen() throws Exception {
		String url = "http://localhost:"+ port + "/price?dateApplication=2020-06-14 10:00:00&productId=35455&brandId=1";
		PriceDTO dto =  this.restTemplate.getForObject(url, PriceDTO.class);
		log.info("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
		log.info("valor devuelto por el servicio " + dto);
		assertThat(dto).isNotNull();
	}

	@Test
	public void testSixteen() throws Exception {
		String url = "http://localhost:"+ port + "/price?dateApplication=2020-06-14 16:00:00&productId=35455&brandId=1";
		PriceDTO dto =  this.restTemplate.getForObject(url, PriceDTO.class);
		log.info("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
		log.info("valor devuelto por el servicio " + dto);
		assertThat(dto).isNotNull();
	}

	@Test
	public void testNineteen() throws Exception {
		String url = "http://localhost:"+ port + "/price?dateApplication=2020-06-14 21:00:00&productId=35455&brandId=1";
		PriceDTO dto =  this.restTemplate.getForObject(url, PriceDTO.class);
		log.info("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
		log.info("valor devuelto por el servicio " + dto);
		assertThat(dto).isNotNull();
	}

	@Test
	public void testTenFifteen() throws Exception {
		String url = "http://localhost:"+ port + "/price?dateApplication=2020-06-15 10:00:00&productId=35455&brandId=1";
		PriceDTO dto =  this.restTemplate.getForObject(url, PriceDTO.class);
		log.info("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)");
		log.info("valor devuelto por el servicio " + dto);
		assertThat(dto).isNotNull();
	}

	@Test
	public void testNinetenSixteen() throws Exception {
		String url = "http://localhost:"+ port + "/price?dateApplication=2020-06-16 21:00:00&productId=35455&brandId=1";
		PriceDTO dto =  this.restTemplate.getForObject(url, PriceDTO.class);
		log.info("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)");
		log.info("valor devuelto por el servicio " + dto);
		assertThat(dto).isNull();
	}

}
