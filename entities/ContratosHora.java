package entities;

import java.util.Date;

public class ContratosHora {
	
	private Date dataContrato;
	private Double valorPorHora;
	private Integer qtdHoras;
	
	public  ContratosHora() {
		
	}


	public ContratosHora(Date dataContrato, Double valorPorHora, Integer qtdHoras) {
		
		this.dataContrato = dataContrato;
		this.valorPorHora = valorPorHora;
		this.qtdHoras = qtdHoras;
	}


	public Date getDataContrato() {
		return dataContrato;
	}


	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}


	public Double getValorPorHora() {
		return valorPorHora;
	}


	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}


	public Integer getQtdHoras() {
		return qtdHoras;
	}


	public void setQtdHoras(Integer QtdHoras) {
		this.qtdHoras = QtdHoras;
	}

	public Double CalculaContrato() {
		
		return qtdHoras * valorPorHora ;
		
	}
	
}
