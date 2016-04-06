package pucrs.progoo;

public class Obra implements Emprestavel, Comparable<Obra> {

	private int codigo;
	private String titulo;
	private String editora;
	private int ano;
	
	public Obra(int codigo, String titulo, String editora, int ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditora() {
		return editora;
	}

	public int getAno() {
		return ano;
	}
	
	@Override
    public String toString() {
        return codigo + ": " + titulo + ", " + editora + " [" + ano + "]";
    }
	
	@Override
	public int compareTo(Obra o) {
		return titulo.compareTo(o.titulo);
	}

	@Override
	public boolean emprestar() {
		return false;
	}

	@Override
	public boolean devolver() {
		return false;
	}
}
