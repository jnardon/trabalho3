package pucrs.progoo;

import java.util.ArrayList;
import java.util.Collections;

public class Cadastro {

	private ArrayList<Usuario> usuarios;

	public Cadastro() {
		usuarios = new ArrayList<>();
	}
	
	public void ordenaNome() {
		Collections.sort(usuarios);
	}
	
	public boolean cadastrar(String codigo, String nome, String cpf) {
		Usuario usu = buscarCodigo(codigo);
		if(usu != null)
			return false;
		usuarios.add(new Usuario(codigo,nome,cpf));
		return true;
	}
	
	public Usuario buscarCodigo(String codigo) {
		for(Usuario usu: usuarios)
			if(usu.getCodigo().equals(codigo))
				return usu;
		return null;
	}

	public Usuario buscarNome(String nome) {
		for(Usuario usu: usuarios)
			if(usu.getNome().equals(nome))
				return usu;
		return null;
	}
	
	public void listarTodos() {
		for(Usuario usu: usuarios)
		    System.out.println(usu);				   
	}
}
