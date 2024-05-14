package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Atividades;

public class GerenciamentoAtividades {
private List<Atividades>atividades;
	
	public GerenciamentoAtividades() {
		this.atividades = new ArrayList<>();
	}
	
	public void adivionarProjeto(Atividades atividade) {
		atividades.add(atividade);
	}
	
	public void SalvarEmArquivo(String nomeArquivo, String nomeAtividade, String descricao, String dataAtividade, 
			String aluno) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
				writer.write(nomeAtividade + ", "+ descricao + ", " + dataAtividade + ", "+ aluno);
				writer.newLine();
				System.out.println("Dados salvos em "+ nomeArquivo+ ".");
			
		} catch (IOException e) {
				e.printStackTrace();
			}		
		
	}
}
