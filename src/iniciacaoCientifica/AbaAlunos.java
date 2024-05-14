package iniciacaoCientifica;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

public class AbaAlunos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void AbaAlunos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbaAlunos frame = new AbaAlunos();
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
	public AbaAlunos() {
		getContentPane().setFont(new Font("Verdana", Font.BOLD, 22));
		setTitle("Aba Aluno");
		setName("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aluno");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 142, 45);
		getContentPane().add(lblNewLabel);
	}

}
