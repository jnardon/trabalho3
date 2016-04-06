package pucrs.progoo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Acervo {

	private ArrayList<Livro> acervo;

	public Acervo() {
		acervo = new ArrayList<Livro>();
	}
	
	public void ordenaTitulo() {
//        Collections.sort(acervo);
//		acervo.sort( (Livro o1, Livro o2) -> o1.getTitulo().compareTo(o2.getTitulo()));
//		acervo.sort(Comparator.comparing(livro -> livro.getTitulo()));
		acervo.sort(Comparator.comparing(Livro::getTitulo).thenComparing(Livro::getAno));
    }
	
	public void ordenaCodigo() {
//        acervo.sort(Comparator.comparing((Livro livro) -> livro.getCodigo()).reversed());
        acervo.sort(Comparator.comparing(Livro::getCodigo).reversed());
    }
	
	public boolean cadastrarLivro(Livro novo) {
		// Verifica se o código do livro já está no acervo (ou seja, se o livro já existe)
		if(buscarPorCodigo(novo.getCodigo()) != null)
				return false;
		acervo.add(novo);
		return true;
	}
	
	public void listarTodos() {
		for(Livro livro: acervo)
			System.out.println(livro);
	}

	public Livro buscarPorCodigo(int codigo) {
		for(Livro livro: acervo)
			if(livro.getCodigo() == codigo)
				return livro;
		return null;
	}
	
	public Livro buscarPorTitulo(String titulo) {
		for(Livro livro: acervo)
			if(livro.getTitulo().equals(titulo))
				return livro;
		return null;
	}
	
	public ArrayList<Livro> buscarPorAutor(String autor) {
		ArrayList<Livro> novo = new ArrayList<>();
		for(Livro livro: acervo)
			if(livro.getAutor().equals(autor))
				novo.add(livro);
		return novo;	
	}
}