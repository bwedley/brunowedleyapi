package br.edu.infnet.brunowedleyapi.services;

import java.io.BufferedWriter;
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
	
	
}
