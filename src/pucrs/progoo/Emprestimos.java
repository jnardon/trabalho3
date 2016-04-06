package pucrs.progoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Emprestimos {

	private ArrayList<Emprestimo> emprestimos;

	public Emprestimos() {
		emprestimos = new ArrayList<>();
	}
	
	public void ordenaData() {
		Collections.sort(emprestimos);
	}
	
	public Emprestimo get(int index) {
		return this.emprestimos.get(index);
	}
	
	public void criar(Usuario usuario, Livro livro, LocalDate dataLimite)
	{
		Emprestimo emp = new Emprestimo(usuario,livro,dataLimite);
		emprestimos.add(emp);
	}
	
	public void delete(Emprestimo emp){
		emprestimos.remove(emp);
	}
	
	public void listarTodos() {
		for(Emprestimo emp: emprestimos)
			System.out.println(emp);
	}
	
	public void setEmprestimos(ArrayList<Emprestimo> emprestimos){
		this.emprestimos = emprestimos;
	}
	
	public String listarEstados(){
		int codigo = 0;
		String aux = "";
		for (Emprestimo emp: emprestimos) {
			LocalDate hoje = LocalDate.now();
			String status = "";
			if(emp.getDataLimite().isBefore(hoje)){
				status = "em dia";
			}else{
				status = "atrasado";
			}
					
			aux = aux + "\n" + codigo + " - " + emp.getLivro().getTitulo() + " - " +  status;
			codigo++;
		}
		return aux;
	}
	
	public ArrayList<Emprestimo> buscarPorUsuario(Usuario usu)
	{
		ArrayList<Emprestimo> result = new ArrayList<>();
		for(Emprestimo emp: emprestimos)
			if(emp.getUsuario().getCodigo().equals(usu.getCodigo()))
				result.add(emp);
		return result;
	}
}
