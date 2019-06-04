package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enuns.NivelTrabalhador;

public class Trabalhador {

	private String nomeTrabalhador;
	private NivelTrabalhador nivelTrabalhador;
	private Double salarioBase;
	private Departamento nomeDepartamento; // Associação
	private List<ContratosHora> Contratos = new ArrayList<>(); // Associação

	public Trabalhador() {

	}

	public Trabalhador(String nomeTrabalhador, NivelTrabalhador nivelTrabalhador, Double salarioBase,
			Departamento nomeDepartamento) {

		this.nomeTrabalhador = nomeTrabalhador;
		this.nivelTrabalhador = nivelTrabalhador;
		this.salarioBase = salarioBase;
		this.nomeDepartamento = nomeDepartamento;

	}

	public String getNomeTrabalhdor() {

		return nomeTrabalhador;
	}

	public void setNomeTrabalhador(String nomeTrabalhador) {

		this.nomeTrabalhador = nomeTrabalhador;
	}

	public NivelTrabalhador getNivelTrabalhador() {

		return nivelTrabalhador;

	}

	public void setNivelTrabalhador(NivelTrabalhador nivelTrabalhador) {

		this.nivelTrabalhador = nivelTrabalhador;

	}

	public Double getSalarioBase() {

		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public void setNomeDepartamento(Departamento nomeDepartamento) {

		this.nomeDepartamento = nomeDepartamento;
	}

	public Departamento getNomeDepartamento() {
		
		return this.nomeDepartamento;
	}
	
	// Esta parte substituiria a lista 
	
	/*public void setContratosHora(List<ContratosHora> Contratos) {
		
		this.Contratos = Contratos;
} */
	
	public List<ContratosHora> getContratos(){
		
		return this.Contratos;
	}
	
	// Metodo para adicionar contrato
	public void AddContrato(ContratosHora contrato) {
	
	Contratos.add(contrato);
}
	
	// Remove contrato
	
	public void  RemoveContrato(ContratosHora contrato) {
		
		Contratos.remove(contrato);
		
		
	}
	
	public double  Areceber(int Mes, int Ano) {
		
		double soma = salarioBase;
		
		Calendar cal = Calendar.getInstance();
		
		for (ContratosHora c : Contratos) {
			
			int c_mes = cal.get(Calendar.MONTH);
			int c_ano = cal.get(Calendar.YEAR);
			
			if (c_mes == Mes && c_ano == Ano) {
				
				soma += c.CalculaContrato();
			}
		}
		return soma;
	}
}