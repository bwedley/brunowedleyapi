package br.edu.infnet.brunowedleyapi;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.edu.infnet.brunowedleyapi.model.domain.Prato;

@SpringBootApplication
public class BrunowedleyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrunowedleyapiApplication.class, args);
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Iniciando cadastro...");
		
		Prato pratoUm = new Prato();
		
		System.out.print("Informe o nome do prato: ");
		pratoUm.nome = in.nextLine();
		
		System.out.print("Informe a descrição do prato: ");
		pratoUm.descricao = in.nextLine();
		
		System.out.print("O prato é vegano? (sim/não) ");
		String resposta = in.nextLine();
		
		if(resposta.equalsIgnoreCase("sim")) {
			pratoUm.vegano = true;
		} else {
			pratoUm.vegano = false;
		}
		
		System.out.print("O prato vai possuir adicionais? ");
		String temAdicionais = in.nextLine();
		if(temAdicionais.equalsIgnoreCase("sim")) {
			System.out.print("Quantos? ");
			pratoUm.adicionais = in.nextInt();
			
		} else {
			pratoUm.adicionais = 0;
		}
		
		System.out.print("Informe o preço base do prato: ");
		if(!in.hasNextDouble()) {
			System.out.println("Digite um valor válido!");
			in.next();
		}
		pratoUm.precoBase = in.nextDouble();			
		
		pratoUm.imprimirPrato();
		
		in.close();
		
	}
}
