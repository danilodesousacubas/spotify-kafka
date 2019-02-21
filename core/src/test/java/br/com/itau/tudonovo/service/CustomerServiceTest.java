package br.com.itau.tudonovo.service;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.itau.tudonovo.repository.CustomerRepository;
import br.com.itau.tudonovo.repository.filter.CustomerFilter;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerService customerService;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@SuppressWarnings("unchecked")
	@Test
	public void verify() {
		
		CustomerFilter filter = new CustomerFilter("term", Boolean.TRUE,"registration");

		Mockito.when(customerRepository.findAll(Mockito.any(Specification.class),Mockito.any(Pageable.class))).thenReturn(new PageImpl<>(new ArrayList<>()));
		
		customerService.findAll(filter, PageRequest.of(0,10));
		Mockito.verify(customerRepository).findAll(Mockito.any(Specification.class), Mockito.any(Pageable.class));
		
	}
	
}
