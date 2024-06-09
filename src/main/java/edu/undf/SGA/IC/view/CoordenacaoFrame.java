package edu.undf.SGA.IC.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;

import edu.undf.SGA.IC.controller.GerenciamentoProjetos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CoordenacaoFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldID;
    private JTextField textFieldTitulo;
    private JTextField textFieldDescricao;
    private JTextField textFieldProfessor;
    private GerenciamentoProjetos gerenciamentoProjetos;
    private JTextField textFieldAluno;

    public CoordenacaoFrame() {
        gerenciamentoProjetos = new GerenciamentoProjetos();
        setTitle("Coordenação");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FlatLightLaf.setup();
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);
		setLocationRelativeTo(null);

        JLabel lblID = new JLabel("ID:");
        lblID.setBounds(20, 30, 70, 15);
        contentPane.add(lblID);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 60, 70, 15);
        contentPane.add(lblTitulo);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 90, 70, 15);
        contentPane.add(lblDescricao);

        JLabel lblProfessor = new JLabel("Professor:");
        lblProfessor.setBounds(20, 120, 70, 15);
        contentPane.add(lblProfessor);

        textFieldID = new JTextField();
        textFieldID.setBounds(100, 30, 150, 19);
        contentPane.add(textFieldID);
        textFieldID.setColumns(10);

        textFieldTitulo = new JTextField();
        textFieldTitulo.setBounds(100, 60, 150, 19);
        contentPane.add(textFieldTitulo);
        textFieldTitulo.setColumns(10);

        textFieldDescricao = new JTextField();
        textFieldDescricao.setBounds(100, 90, 150, 19);
        contentPane.add(textFieldDescricao);
        textFieldDescricao.setColumns(10);

        textFieldProfessor = new JTextField();
        textFieldProfessor.setBounds(100, 120, 150, 19);
        contentPane.add(textFieldProfessor);
        textFieldProfessor.setColumns(10);
        
        JLabel lblAluno = new JLabel("Aluno:");
        lblAluno.setBounds(20, 154, 70, 15);
        contentPane.add(lblAluno);
        
        textFieldAluno = new JTextField();
        textFieldAluno.setColumns(10);
        textFieldAluno.setBounds(100, 152, 150, 19);
        contentPane.add(textFieldAluno);

        JButton btnSalvar = new JButton("Salvar Projeto");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarProjeto();
            }
        });
        btnSalvar.setBounds(20, 226, 150, 25);
        contentPane.add(btnSalvar);

        JButton btnVisualizar = new JButton("Visualizar Projetos");
        btnVisualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProjetos();
            }
        });
        btnVisualizar.setBounds(178, 226, 150, 25);
        contentPane.add(btnVisualizar);
    }

    private void salvarProjeto() {
        String id = textFieldID.getText();
        String titulo = textFieldTitulo.getText();
        String descricao = textFieldDescricao.getText();
        String professor = textFieldProfessor.getText();
        String aluno = textFieldAluno.getText();
        

        
        gerenciamentoProjetos.SalvarEmArquivo("dadosProjeto.txt", id, titulo, descricao, professor, aluno);

        JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
    }

    private void listarProjetos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Título");
        model.addColumn("Descrição");
        model.addColumn("Professor");
        model.addColumn("Alunos");


        // Lendo os projetos do arquivo e adicionando à tabela
        try (BufferedReader reader = new BufferedReader(new FileReader("dadosProjeto.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    model.addRow(parts);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

	    JButton btnAlterar = new JButton("Alterar");
	    btnAlterar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int selectedRow = table.getSelectedRow();
	            int selectedColumn = table.getSelectedColumn();
	            if (selectedRow != -1 && selectedColumn != -1) {
	                String columnName = table.getColumnName(selectedColumn);
	                String currentValue = (String) table.getValueAt(selectedRow, selectedColumn);
	                String newValue = JOptionPane.showInputDialog(null, "Novo valor para " + columnName + ":", currentValue);
	                if (newValue != null && !newValue.isEmpty()) {
	                    table.setValueAt(newValue, selectedRow, selectedColumn);
	                    salvarAlteracoes(table, model); // Chamada para salvar as alterações no arquivo
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Selecione um campo para alterar.");
	            }
	        }
	    });
	    
	    JButton btnExcluir = new JButton("Excluir");
	    btnExcluir.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            excluirProjeto(table, model); // Chama o método para excluir o projeto
	        }
	    });
	    
	    JPanel panel = new JPanel(new BorderLayout());
	    panel.add(scrollPane, BorderLayout.CENTER);
	    panel.add(btnAlterar, BorderLayout.NORTH);
	    panel.add(btnExcluir, BorderLayout.SOUTH); 

	    JOptionPane.showMessageDialog(null, panel, "Lista de Projetos", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void salvarAlteracoes(JTable table, DefaultTableModel model) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosProjeto.txt"))) {
	        for (int i = 0; i < model.getRowCount(); i++) {
	            for (int j = 0; j < model.getColumnCount(); j++) {
	                writer.write(model.getValueAt(i, j).toString());
	                if (j < model.getColumnCount() - 1) {
	                    writer.write(", ");
	                }
	            }
	            writer.newLine();
	        }
	        writer.flush();
	        JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao salvar as alterações.");
	    }
	}
	
	private void excluirProjeto(JTable table, DefaultTableModel model) {
	    int selectedRow = table.getSelectedRow();
	    if (selectedRow != -1) {
	        int option = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este projeto?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
	        if (option == JOptionPane.YES_OPTION) {
	            model.removeRow(selectedRow);
	            salvarAlteracoes(table, model); // Atualiza o arquivo após a exclusão
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Selecione um projeto para excluir.");
	    }
	}
}