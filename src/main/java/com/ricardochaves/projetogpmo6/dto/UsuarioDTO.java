package com.ricardochaves.projetogpmo6.dto;

import java.io.Serializable;

import com.ricardochaves.projetogpmo6.domain.Usuario;

//Classe DTO para trafegar dados do usuário, porém sem mostrar a senha e email
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
