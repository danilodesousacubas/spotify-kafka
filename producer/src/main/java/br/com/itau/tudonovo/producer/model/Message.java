package br.com.itau.tudonovo.producer.model;

public class Message {

	private String code;
	private String customer;
	
	
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}