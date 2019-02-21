package br.com.itau.tudonovo.repository.filter;

import org.springframework.data.jpa.domain.Specification;

import br.com.itau.tudonovo.domain.Customer;
import br.com.itau.tudonovo.repository.Specifications.QCustomer;

public class CustomerFilter {

	private String term;
	private Boolean status;
	private String registration;

	public CustomerFilter(String term, Boolean status, String registration) {
		super();
		this.term = term;
		this.status = status;
		this.registration = registration;
	}

	public CustomerFilter() {
	}

	public Specification<Customer> build() {
		return Specification.where(QCustomer.statusEquals(status)).and(QCustomer.contain(term))
				.or(QCustomer.registrationEquals(registration));
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerFilter " + "[term=" + term + ", " + "status=" + status + ", " + "registration=" + registration
				+ ", build()=" + build() + ", getTerm()=" + getTerm() + ", getStatus()=" + getStatus()
				+ ", getRegistration()=" + getRegistration() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
