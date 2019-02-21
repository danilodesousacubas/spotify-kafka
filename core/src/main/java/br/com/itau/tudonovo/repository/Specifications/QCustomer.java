package br.com.itau.tudonovo.repository.Specifications;

import org.springframework.data.jpa.domain.Specification;

import br.com.itau.tudonovo.common.QEntity;
import br.com.itau.tudonovo.domain.Customer;


public class QCustomer {

	public static Specification<Customer> statusEquals(Boolean status) {
		return QEntity.equals("status", status);
	}
	
	public static Specification<Customer> contain(String term) {
		return QEntity.equals("firstName", term);
	}
	
	public static Specification<Customer> registrationEquals(String registration) {
		return QEntity.equals("registration", registration);
	}
}
