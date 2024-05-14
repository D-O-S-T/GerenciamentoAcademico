package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;        
import java.util.ArrayList;
import java.util.List;

import model.ProjetoPesquisa;

public class GerenciamentoProjetos {
	private List<ProjetoPesquisa>projetos;
	
	public GerenciamentoProjetos() {
		this.projetos = new ArrayList<>();
	}
	
	public void adivionarProjeto(ProjetoPesquisa projeto) {
		projetos.add(projeto);
	}
	
	public void SalvarEmArquivo(String nomeArquivo, String id, String titulo, String descricao, 
			String professorResponsavel, String alunosParticipantes) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
				writer.write(id + ", "+ titulo + ", " + descricao + ", "+ professorResponsavel + ", " + alunosParticipantes);
				writer.newLine();
				System.out.println("Dados salvos em "+ nomeArquivo+ ".");
			
		} catch (IOException e) {
				e.printStackTrace();
			}		
		
	}
}
