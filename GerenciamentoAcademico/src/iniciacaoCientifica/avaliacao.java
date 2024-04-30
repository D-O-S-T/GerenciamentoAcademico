package iniciacaoCientifica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;


public class avaliacao extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void avaliacao() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					avaliacao frame = new avaliacao();
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
	public avaliacao() {
		setTitle("Avaliação e Feedback");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton voltar = new JButton("");
		voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setBounds(0, 0, 99, 40);
		contentPane.add(voltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		//Aqui vai o caminho da imagem da aba avaliação no seu computador/ computador da undf
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gabri\\OneDrive\\Imagens\\layout avaliação.png"));
		lblNewLabel.setBounds(0, -17, 539, 598);
		contentPane.add(lblNewLabel);
		
		
	}

}

