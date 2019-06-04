package aplicativo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratosHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enuns.NivelTrabalhador;

public class CadastraTrabalhadorContrato {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o departamento# ");
		String nomeDepartamento = sc.nextLine();

		System.out.print("Digite os dados do Trabalhador");
		System.out.println("=======================================");

		System.out.print("Nome# ");
		String nomeTrabalhador = sc.nextLine();

		System.out.print("Nivel# ");
		String nivelTrabalhador = sc.nextLine();

		System.out.print("Salario Base# ");
		double salarioBase = sc.nextDouble();

		// NivelTrabalhador.valueOf(nivelTrabalhador) converte a string para o tipo ENUN
		// Também instancia o departamento

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador),
				salarioBase, new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos para este Trabalhador");
		int qtdContratos = sc.nextInt();

		List<ContratosHora> contrato = new ArrayList<>();

		for (int x = 1; x <= qtdContratos; x++) {

			System.out.println("Entre com os dados do Contrato# " + x);

			System.out.print("Data (DD/MM/YYYY) # ");
			Date dataContrato = sdf.parse(sc.nextLine()); // Pega a data que o usuário digita no formato.

			System.out.print("Valor Hora# ");
			double valorHora = sc.nextDouble();

			System.out.print("Quantidade Horas# ");
			int qtdHoras = sc.nextInt();

			ContratosHora contratos = new ContratosHora(dataContrato, valorHora, qtdHoras);

			trabalhador.AddContrato(contratos); // adiciona o contrato chamadno o metodo

		}

		System.out.println();
		System.out.print("Digite o Mes e o Ano para ver Ganhos (MM/YYYY)");
		String MesEAno = sc.nextLine();
		int mes = Integer.parseInt(MesEAno.substring(0, 2)); // Recorta a data e converte para INTEIRO pega o mes
		int ano = Integer.parseInt(MesEAno.substring(4, 4)); // // Recorta a data e converte para INTEIRO pega o ano

		System.out.print("Nome" + trabalhador.getNomeTrabalhdor());
		System.out.print("Departamento " + trabalhador.getNomeDepartamento().getNomeDepartamento());
		System.out.println("Contratos do Mes " + MesEAno + ":" + String.format("%.2f",trabalhador.Areceber(mes,ano)));

		sc.close();
	}

}
