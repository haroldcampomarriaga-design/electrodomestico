package com.uniremington.electrodomesticos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.uniremington.electrodomesticos.model.dao.ClienteDAO;
import com.uniremington.electrodomesticos.model.vo.ClienteVO;

@SpringBootTest
class ElectrodomesticosApplicationTests {

	@Autowired
	private ClienteDAO clienteDAO;

	@Test
	void contextLoads() {
	}

	@Test
	void inMemoryDaoSavesAndFindsClient() {
		ClienteVO cliente = new ClienteVO();
		cliente.setNumeroDocumento("test-123");

		ClienteVO saved = clienteDAO.save(cliente);

		assertTrue(saved.getIdCliente() != null);
		assertEquals("test-123", clienteDAO.findByNumeroDocumento("test-123")
				.orElseThrow().getNumeroDocumento());
	}

}
