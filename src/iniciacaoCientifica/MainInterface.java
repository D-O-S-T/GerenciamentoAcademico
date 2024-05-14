package iniciacaoCientifica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainInterface() {
		setTitle("Início Gerenciamento Iniciação científica");
		setName("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCoordenacao = new JButton("Coordenação");
		btnCoordenacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbaCoordenacao ac = new AbaCoordenacao();
				ac.AbaCoordenacao();
			}
		});
		btnCoordenacao.setBounds(20, 147, 280, 49);
		contentPane.add(btnCoordenacao);
		
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbaProfessor ap = new AbaProfessor();
				ap.AbaProfessor();				
			}
		});
		btnProfessor.setBounds(20, 404, 280, 49);
		contentPane.add(btnProfessor);
		
		btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbaAlunos ab = new AbaAlunos();
				ab.AbaAlunos();
			}
		});
		btnAluno.setBounds(20, 281, 280, 49);
		contentPane.add(btnAluno);
		
		JLabel lblNewLabel_1 = new JLabel("Seja Bem Vindo(a)!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 26));
		lblNewLabel_1.setBounds(12, 55, 300, 50);
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("src/imagens/undf_logo.png"));
		lblNewLabel_2.setBounds(269, 147, 415, 400);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 318, 611);
		contentPane.add(panel);
		
		
	}
}
