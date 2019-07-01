package com.rds.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de E-mail...");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado com sucesso!");
		
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de E-mail HTML...");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado com sucesso!");
		
	}

//	@Override
//	public void sendNewPasswordEmail(Client client, String newPass) {
//		// TODO Auto-generated method stub
//		
//	}

}
