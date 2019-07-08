package com.rds.cursomc.dto;

import java.io.Serializable;

import com.rds.cursomc.domain.State;

public class StateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String uf;
	
	public StateDTO() {
	}

	public StateDTO(State obj) {
		id = obj.getId();
		name = obj.getName();
		uf = obj.getUf();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
