package com.ricardochaves.projetogpmo6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.projetogpmo6.domain.Usuario;
import com.ricardochaves.projetogpmo6.repositories.UsuarioRepository;
import com.ricardochaves.projetogpmo6.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public List<Usuario> findAll(){
			return usuarioRepository.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! id: " + id
				+ ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		return usuarioRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}
	
	public Usuario updateSenha(Usuario obj) {
		Usuario newObj = usuarioService.findById(obj.getId()); //Nas versões novas do Spring substituir o usuarioRepository e findOne 
		updateData(newObj, obj);							   //por usuarioService e findById.
		return usuarioRepository.save(newObj);
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setSenha(obj.getSenha());
	}
	
	
	
}
