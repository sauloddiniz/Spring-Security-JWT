package com.sec.sec.repository;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long idPermissao;

	private String descricao;

	public Long getIdPermissao() {
		return idPermissao;
	}

	public void setIdPermissao(Long idPermissao) {
		this.idPermissao = idPermissao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Permissao() {}
	
	public Permissao(Long idPermissao, String descricao) {
		this.idPermissao = idPermissao;
		this.descricao = descricao;
	}
}
