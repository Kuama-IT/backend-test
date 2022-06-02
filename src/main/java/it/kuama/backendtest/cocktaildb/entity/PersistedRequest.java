package it.kuama.backendtest.cocktaildb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

/**
 * 
 *	Persisted Object representing a request for this application
 *@author Pietro
 */

@Entity
@Table(name = "REQUEST_DATA")
public class PersistedRequest {
	
	public PersistedRequest(String request_name, String response_body) {
		super();
		this.request_name = request_name;
		this.response_body = response_body;
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	@Column(name = "REQUEST_DATE", nullable = false, updatable = false)
	@CreationTimestamp
	protected Date request_date;
	
	@Column(name = "REQUEST_NAME")
	protected String request_name;
	
	@Column(name = "RESPONSE_BODY")
	@Lob
	protected String response_body;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public String getRequest_name() {
		return request_name;
	}

	public void setRequest_name(String request_name) {
		this.request_name = request_name;
	}

	public String getResponse_body() {
		return response_body;
	}
	public void setResponse_body(String response_body) {
		this.response_body = response_body;
	}
	
}
