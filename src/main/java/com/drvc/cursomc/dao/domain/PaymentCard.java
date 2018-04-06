package com.drvc.cursomc.dao.domain;

import javax.persistence.Entity;

import com.drvc.cursomc.dao.domain.enums.PaymentState;

@Entity
public class PaymentCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer numberOfParcels;
	
	public PaymentCard() {}

	public PaymentCard(Integer id, PaymentState state, CustomerOrder order, Integer numberOfParcels) {
		super(id, state, order);
		this.numberOfParcels = numberOfParcels;		
	}

	public Integer getNumberOfParcels() {
		return numberOfParcels;
	}

	public void setNumberOfParcels(Integer numberOfParcels) {
		this.numberOfParcels = numberOfParcels;
	}
	
}
