package br.com.itau.tudonovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.itau.tudonovo.domain.Customer;
import br.com.itau.tudonovo.repository.filter.CustomerFilter;
import br.com.itau.tudonovo.service.CustomerService;
import io.swagger.annotations.Api;
import javassist.NotFoundException;

@RestController
@RequestMapping("api/v1")
@Api(value = "customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer")
	public Page<Customer> findByCustomerFilter(final CustomerFilter filter, final Pageable pageable) throws NotFoundException {
		Page<Customer> customers = customerService.findAll(filter, pageable);

		if (customers.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("{customerfilter=%s}", filter.toString()));
		}

		return customerService.findAll(filter, pageable);
	}
}