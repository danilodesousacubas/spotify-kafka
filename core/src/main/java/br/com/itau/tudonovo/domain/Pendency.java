package br.com.itau.tudonovo.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.itau.tudonovo.common.ZonedConverter;

@Entity
@Table(name = "pendency")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pendency {

	@Id
	@SequenceGenerator(name = "seq_pendency", sequenceName = "seq_pendency", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pendency")
	private Long id;

	@Column(name = "nota_fiscal")
	private String nf;

	@Column(name = "pendency_date")
	@Convert(converter = ZonedConverter.class)
	private ZonedDateTime pendencyDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNf() {
		return nf;
	}

	public void setNf(String nf) {
		this.nf = nf;
	}

	public ZonedDateTime getPendencyDate() {
		return pendencyDate;
	}

	public void setPendencyDate(ZonedDateTime pendencyDate) {
		this.pendencyDate = pendencyDate;
	}
}
