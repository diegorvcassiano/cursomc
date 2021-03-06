package com.drvc.cursomc.dao.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.drvc.cursomc.dao.domain.enums.PaymentState;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentBill extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date paymentDate;
	
	
	public PaymentBill() {
		
	}


	public PaymentBill(Integer id, PaymentState state, CustomerOrder order, Date dueDate, Date paymentDate) {
		super(id, state, order);	
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}
