package br.edu.infnet.brunowedleyapi.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import br.edu.infnet.brunowedleyapi.interfaces.Impressao;


public class ImprimirArquivo implements Impressao {
	private static final String arquivo = "impressao.txt";

	@Override
	public void imprimir(String conteudo) {
		try (FileWriter file = new FileWriter(arquivo, true);
				BufferedWriter escrita = new BufferedWriter(file)) {
			escrita.write(conteudo);
			escrita.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finalizando escrita...");
		}
		
	}

	@Override
	public void lerRelatorio() {
		try{
			FileReader file = new FileReader(arquivo);
			try (BufferedReader leitura = new BufferedReader(file)) {
				String linha;
				
				System.out.println("========= CARDÁPIO =========");
				while((linha = leitura.readLine()) != null) {
					System.out.println(linha);
				}
			}
			System.out.println("=============================");
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado...");
		} catch (IOException e) {
			System.out.println("Problema na leitura do arquivo...");
		}
	}

	@Override
	public void imprimirSobrescrita(String conteudo) {
		try (FileWriter file = new FileWriter(arquivo, false);
				BufferedWriter escrita = new BufferedWriter(file)) {
			escrita.write(conteudo);	
			escrita.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finalizando sobrescrita...");
		}
		
	}
}
