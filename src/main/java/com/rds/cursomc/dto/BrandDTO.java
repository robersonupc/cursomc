package com.rds.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rds.cursomc.domain.Brand;

public class BrandDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 80, message = "O tamanho deve ser entre 4 e 80 caracteres")
	private String name;

	@Length(max = 450, message = "O tamanho deve ter no máximo 450 caracteres")
	private String description;

	public BrandDTO() {
	}

	public BrandDTO(Brand obj) {

		id = obj.getId();
		name = obj.getName();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
