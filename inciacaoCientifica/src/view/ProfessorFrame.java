package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import com.formdev.flatlaf.FlatLightLaf;


public class ProfessorFrame extends JPanel{

    private static final long serialVersionUID = 1L;

    public ProfessorFrame() {
        FlatLightLaf.setup();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Descrição");
        model.addColumn("Data");
        model.addColumn("Aluno");
        //model.addColumn("Feedback");

        // Lendo os projetos do arquivo e adicionando à tabela
        try (BufferedReader reader = new BufferedReader(new FileReader("dadosAtividade.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4  ) {
                    model.addRow(parts);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

	    JButton btnAlterar = new JButton("Comentar");
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
	    
	    JPanel panel = new JPanel(new BorderLayout());
	    panel.add(scrollPane, BorderLayout.CENTER);
	    panel.add(btnAlterar, BorderLayout.SOUTH);
	    JOptionPane.showMessageDialog(null, panel, "Atividades Realizadas", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void salvarAlteracoes(JTable table, DefaultTableModel model) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosAtividade.txt"))) {
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
}


