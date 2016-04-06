package pucrs.progoo;

public class Midia extends Obra
{
	private String autor;
	private float tamanhoEmDisco;
	
	
	
	public Midia(int codigo, String titulo, String editora, int ano, String autor, float tamanhoEmDisco) {
		super(codigo, titulo, editora, ano);
		this.tamanhoEmDisco = tamanhoEmDisco;
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public float getTamanhoEmDisco() {
		return tamanhoEmDisco;
	}
	public void setTamanhoEmDisco(float tamanhoEmDisco) {
		this.tamanhoEmDisco = tamanhoEmDisco;
	}
	
	
}
