package pucrs.progoo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Emprestimo implements Comparable<Emprestimo> {

	private Usuario usuario;
	private Livro livro;
	private LocalDate dataLimite;
	private LocalDate dataDevolucao;

	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataLimite) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataLimite = dataLimite;
		this.dataDevolucao = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public LocalDate getDataLimite() {
		return dataLimite;
	}
	
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	
	@Override
	public String toString() {	
		String dataLimiteStr = dataLimite.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
		String aux = String.format("%-30s -> %-20s - %s", livro.getTitulo(), usuario.getNome(), dataLimiteStr);
		if(dataDevolucao != null)
			aux += " ** ENTREGUE ***";
		return aux;
	}


	@Override
	public int compareTo(Emprestimo o) {
		return dataLimite.compareTo(dataLimite);
	}
}
