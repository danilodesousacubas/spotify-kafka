package br.com.itau.tudonovo.domain;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.itau.tudonovo.common.ZonedConverter;

@Entity
@Table(name = "quota")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quota {

	@Id
	@SequenceGenerator(name = "seq_quota", sequenceName = "seq_quota", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_quota")

	@Column(name = "issue_date")
	@Convert(converter = ZonedConverter.class)
	private ZonedDateTime issueDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Notification> pendencies = new HashSet<Notification>();

	public ZonedDateTime getIssueDate() {
		return issueDate;
	}

	public Set<Notification> getPendencies() {
		return pendencies;
	}

	public void setPendencies(Set<Notification> pendencies) {
		this.pendencies = pendencies;
	}

	public void setIssueDate(ZonedDateTime issueDate) {
		this.issueDate = issueDate;
	}
}
