package com.example.testcontainer;

import com.example.testcontainer.model.Dummy;
import com.example.testcontainer.repository.DummyRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test-container")
class TestcontainerApplicationTests {

	@Autowired
	private DummyRepository dummyRepository;

	@Container
	static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:11.6");

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgres::getJdbcUrl);
		registry.add("spring.datasource.username", postgres::getUsername);
		registry.add("spring.datasource.password", postgres::getPassword);
	}

	@BeforeAll
	static void beforeAll() {
		postgres.start();
	}

	@AfterAll
	static void afterAll() {
		postgres.stop();
	}

	@Test
	void testRepository() {
		Dummy dummy = new Dummy();
		dummy.setText("test");

		Dummy persistedDummy = this.dummyRepository.save(dummy);

		assertNotNull(persistedDummy.getId());
		assertEquals(dummy.getText(), persistedDummy.getText());
	}

}
