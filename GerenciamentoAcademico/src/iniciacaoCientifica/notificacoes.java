package iniciacaoCientifica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class notificacoes extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void notificacoes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notificacoes frame = new notificacoes();
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
	public notificacoes() {
		setTitle("Notificações e Relatórios");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 529, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton voltar = new JButton("");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltar.setContentAreaFilled(false);
		voltar.setBorderPainted(false);
		voltar.setBounds(10, 0, 111, 47);
		contentPane.add(voltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		// Aqui vai o caminho da imagem da aba notificações no seu computador/ computador da undf
		lblNewLabel.setIcon(new ImageIcon("../imagens/layout notificações.png"));
		lblNewLabel.setBounds(0, 0, 553, 570);
		contentPane.add(lblNewLabel);
		
		
	}
}

