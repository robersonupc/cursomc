package com.rds.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.rds.cursomc.domain.PaymentCombotion;

@Service
public class CombotionService {
	
	public void preencherPagamentoComBoleto(PaymentCombotion pagto, Date instanteDoPedido) {
	
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDateDue(cal.getTime());
	}

}
