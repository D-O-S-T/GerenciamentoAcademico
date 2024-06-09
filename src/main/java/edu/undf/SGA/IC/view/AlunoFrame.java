package edu.undf.SGA.IC.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import edu.undf.SGA.IC.controller.GerenciamentoAtividades;
import edu.undf.SGA.IC.controller.GerenciamentoProjetos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AlunoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private GerenciamentoAtividades gerenciamentoAtividades;

	
	public AlunoFrame() {
		gerenciamentoAtividades = new GerenciamentoAtividades();
        FlatLightLaf.setup();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Atividades");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(147, 10, 144, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Atividade");
		lblNewLabel_1.setBounds(34, 70, 97, 19);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(147, 70, 245, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Descrição da atividade");
		lblNewLabel_2.setBounds(34, 99, 97, 19);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 99, 245, 42);
		contentPane.add(textField_1);
		
		lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setBounds(104, 155, 27, 19);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 155, 97, 19);
		contentPane.add(textField_2);
		
		lblNewLabel_4 = new JLabel("Alunos Responsáveis");
		lblNewLabel_4.setBounds(34, 187, 97, 19);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 187, 245, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(185, 216, 81, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarAtividades();
				dispose();

				JFrame frame = new MainFrame();
				frame.setVisible(true);
			}
        });
	}
		private void enviarAtividades() {
		        String nomeAtividade = textField.getText();
		        String descricao = textField_1.getText();
		        String dataAtividade = textField_2.getText();
		        String aluno = textField_3.getText();
		        

		        
		        gerenciamentoAtividades.SalvarEmArquivo("dadosAtividade.txt", nomeAtividade, descricao, dataAtividade, aluno);

		        JOptionPane.showMessageDialog(null, "Enviado!");

	}
}
