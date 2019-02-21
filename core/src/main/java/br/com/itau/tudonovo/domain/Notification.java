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
@Table(name = "notification")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

	@Id
	@SequenceGenerator(name = "seq_notification", sequenceName = "seq_notification", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_notification")
	private Long id;

	@Column(name = "send_date")
	@Convert(converter = ZonedConverter.class)
	private ZonedDateTime sendDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getSendDate() {
		return sendDate;
	}

	public void setSendDate(ZonedDateTime sendDate) {
		this.sendDate = sendDate;
	}

}
