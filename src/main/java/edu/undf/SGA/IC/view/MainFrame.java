package edu.undf.SGA.IC.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatLightLaf;


public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
    	FlatLightLaf.setup();
		setTitle("Iniciação Científica");
		setName("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
        JPanel contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        // Button Coordenador
        JButton btnCoordenador = new JButton("Coordenador");
        btnCoordenador.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnCoordenador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCoordenador.addActionListener(e -> {
            CoordenacaoFrame coordenacaoFrame = new CoordenacaoFrame();
            coordenacaoFrame.setVisible(true);
        });
        btnCoordenador.setBounds(20, 147, 280, 49);
		contentPane.add(btnCoordenador);
        
        // Button Professor
        JButton btnProfessor = new JButton("Professor");
        btnProfessor.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnProfessor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnProfessor.addActionListener(e -> {
            ProfessorFrame professorFrame = new ProfessorFrame();
            professorFrame.setVisible(true);
        });
        btnProfessor.setBounds(20, 404, 280, 49);
		contentPane.add(btnProfessor);
        
        // Button Aluno
        JButton btnAluno = new JButton("Aluno");
        btnAluno.setFont(new Font("Malgun Gothic Semilight", Font.BOLD, 20));
		btnAluno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAluno.addActionListener(e -> {
            AlunoFrame alunoFrame = new AlunoFrame();
            alunoFrame.setVisible(true);
        });
        btnAluno.setBounds(20, 281, 280, 49);
		contentPane.add(btnAluno);
		
		JLabel lblNewLabel_1 = new JLabel("Seja Bem Vindo(a)!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 50, 300, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(440, 129, 300, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Iniciação Científica");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_4.setBounds(430, 147, 250, 100);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("imagens/undflogo.png"));
		lblNewLabel_2.setBounds(269, 147, 415, 400);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 318, 611);
		contentPane.add(panel);
    }
}
