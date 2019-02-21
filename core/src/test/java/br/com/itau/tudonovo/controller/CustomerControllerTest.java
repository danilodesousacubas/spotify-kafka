package br.com.itau.tudonovo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.itau.tudonovo.Application;
import br.com.itau.tudonovo.domain.Customer;
import br.com.itau.tudonovo.repository.CustomerRepository;

@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CustomerControllerTest {

	private static final String LAST = "last";

	private static final String FIRST = "first";

	@InjectMocks
	private CustomerController customerController;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setup() {
		customerRepository.save(new Customer(FIRST, LAST));
	}

	@Test
	public void contexLoads() throws Exception {
		assertThat(customerController).isNotNull();
	}

	@Test
	public void shouldRegisterCustomer() throws Throwable {
		mockMvc.perform(get("/api/v1/customer").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(containsString(FIRST)));
	}
}