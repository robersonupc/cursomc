package com.rds.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.rds.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//void sendNewPasswordEmail(Client client, String newPass);
}
