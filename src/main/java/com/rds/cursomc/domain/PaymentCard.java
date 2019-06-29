package com.rds.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.rds.cursomc.domain.enums.StatePayment;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PaymentCard extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numberOfInstallments;
	
	public PaymentCard() {		
	}

	public PaymentCard(Integer id, StatePayment statePayment, Pedido pedido, Integer numberOfInstallments) {
		super(id, statePayment, pedido);
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	
	

}
