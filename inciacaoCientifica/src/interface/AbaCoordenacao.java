package iniciacaoCientifica;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AbaCoordenacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void AbaCoordenacao() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbaCoordenacao frame = new AbaCoordenacao();
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
	public AbaCoordenacao() {
		getContentPane().setFont(new Font("Verdana", Font.BOLD, 22));
		setTitle("Aba Coordenação");
		setName("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Coordenação");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(296, 11, 200, 60);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 790, 80);
		panel.setBackground(new Color(0, 0, 64));
		getContentPane().add(panel);
		
		
		//JPanel panel = new JPanel();
		//panel.setBounds(0, 0, 318, 611);
		//panel.setBackground(new Color(0, 0, 64));
		//getContentPane().add(panel);
	}
}
