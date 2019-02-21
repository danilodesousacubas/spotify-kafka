package br.com.itau.tudonovo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.itau.tudonovo.domain.Customer;
import br.com.itau.tudonovo.interceptor.MetricFilter;
import br.com.itau.tudonovo.repository.CustomerRepository;
import br.com.itau.tudonovo.repository.filter.CustomerFilter;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MetricFilter.class);

	public Page<Customer> findAll(CustomerFilter filter, Pageable pageable) {
		LOGGER.info(String.format("{Customerfilter=%s}", filter.toString()));
		Page<Customer> page = customerRepository.findAll(filter.build(), pageable);
		return new PageImpl<>(page.getContent(), pageable, page.getTotalElements());
	}
}