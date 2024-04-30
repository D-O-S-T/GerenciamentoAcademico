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


public class projetos extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void projetos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					projetos frame = new projetos();
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
	public projetos() {
		setTitle("Projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton voltar = new JButton("");
		voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();			}
		});
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setBounds(10, 0, 114, 52);
		contentPane.add(voltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		//Aqui vai o caminho da imagem da aba projetos no seu computador / computador da undf
		lblNewLabel.setIcon(new ImageIcon("src/imagens/layout_projetos.png"));
		lblNewLabel.setBounds(0, 0, 519, 581);
		contentPane.add(lblNewLabel);
		
		
	}

}

