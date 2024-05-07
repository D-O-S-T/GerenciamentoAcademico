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


public class atividades extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void atividades() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atividades frame = new atividades();
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
	public atividades() {
		setTitle("Atividades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 523, 620);
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
		voltar.setBounds(10, 27, 102, 40);
		contentPane.add(voltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		// Aqui vai o caminho da imagem da aba atividades no seu computador/computador da undf
		lblNewLabel.setIcon(new ImageIcon("src/imagens/layout_atividades.png"));
		lblNewLabel.setBounds(0, 0, 513, 589);
		contentPane.add(lblNewLabel);
		
		
	}
}


