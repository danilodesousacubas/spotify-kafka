package br.com.itau.tudonovo.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.itau.tudonovo.domain.Customer;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {
	
	private static final String first = "first";
	private static final String last = "last";

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void shouldSaveOneCustomer() {
		createCutomer();
		createCutomer();
		assertEquals(2, customerRepository.findAll().size());
	}

	private Customer createCutomer() {
		Customer customer = new Customer();

		customer.setFirstName(first);
		customer.setLastName(last);

		return customerRepository.save(customer);
	}

}
