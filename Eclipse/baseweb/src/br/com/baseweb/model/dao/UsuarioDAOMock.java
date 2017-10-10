package br.com.baseweb.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.baseweb.model.entity.Usuario;

public class UsuarioDAOMock {

	private List<Usuario> listaDeUsuario;
	public UsuarioDAOMock(){
		if(listaDeUsuario == null){
			listaDeUsuario = new ArrayList<Usuario>();
			Usuario u1 = new Usuario(1, "Fred", "fred@galo.com.br", "123456");
			Usuario u2 = new Usuario(2, "Jo", "jo@coringao.com.br", "123456");
			Usuario u3 = new Usuario(3, "dudu", "dudu@porco.com.br", "123456");
			Usuario u4 = new Usuario(4, "prato", "prato@spfc.com.br", "123456");
			listaDeUsuario.add(u1);
			listaDeUsuario.add(u2);
			listaDeUsuario.add(u3);
			listaDeUsuario.add(u4);			
		}
	}
	
	public List<Usuario> buscarTodos(){
		return listaDeUsuario;
	}
	
	public Usuario buscarUsuarioPorId(Integer id){
        for(Usuario usuario: listaDeUsuario){
        	if(usuario.getId().equals(id)){
        		return usuario;
        	}
        }
		return null;
	}
	
	public void removerUsuario(Usuario usuario){
      	listaDeUsuario.remove(usuario);
	}
	
	public void atualizarUsuario(Usuario usuarioEditado){
        for(Usuario usuario: listaDeUsuario){
        	if(usuario.getId().equals(usuarioEditado.getId())){
        		usuario.setEmail(usuarioEditado.getEmail());
        		usuario.setNome(usuarioEditado.getNome());
        		usuario.setSenha(usuarioEditado.getSenha());
        	}
        }
	}
	
	public void adicionarUsuario(Usuario usuarioParaInserir){
		int id=1;
        for(Usuario usuario: listaDeUsuario){
        	if(usuario.getId()>id){
        		id = usuario.getId();
        	}
        }
        usuarioParaInserir.setId(++id);
        listaDeUsuario.add(usuarioParaInserir);
	}
	
	public Usuario buscarUsuarioPorNomeESenha(String email, String senha){
        for(Usuario usuario: listaDeUsuario){
        	if(usuario.getEmail().equalsIgnoreCase(email) && usuario.getSenha().equals(senha)){
        		return usuario;
        	}
        }
		return null;
	}
	
}
