package pucrs.progoo;

public class Livro extends Obra {

	private String autor;
	private int total;

	public Livro(int codigo, String titulo, String autor, String editora, int ano, int total) {
		super(codigo, titulo, editora, ano);
		this.autor = autor;
		this.total = total;
	}

	public Livro(int codigo, String titulo, String autor, String editora, int ano) {
		this(codigo,titulo,autor,editora,ano,1);
	}

	public String getAutor() {
		return autor;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		// Reuso do toString de Obra
		return super.toString()+" - "+autor+" ("+total+")";
		//return String.format("%03d: %-40s %-20s %-20s %-5d total: %3d",
//				codigo, titulo, autor, editora, ano, total);
	}

	@Override
	public boolean emprestar() {
		if(total > 0) {
            total--;
            return true;
        }
        return false;
	}

	@Override
	public boolean devolver() {
		total++;
		return true;
	}
}
