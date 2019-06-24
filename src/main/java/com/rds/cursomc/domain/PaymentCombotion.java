package com.rds.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rds.cursomc.domain.enums.StatePayment;

@Entity
public class PaymentCombotion extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date datePayment;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateDue;
	
	public PaymentCombotion() {		
	}

	public PaymentCombotion(Integer id, StatePayment statePayment, Pedido pedido, Date datePayment, Date dateDue) {
		super(id, statePayment, pedido);
		this.datePayment = datePayment;
		this.dateDue = dateDue;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public Date getDateDue() {
		return dateDue;
	}

	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	
	
}
