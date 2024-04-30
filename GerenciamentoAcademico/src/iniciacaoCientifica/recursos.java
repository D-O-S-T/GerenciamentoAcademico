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


public class recursos extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void recursos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recursos frame = new recursos();
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
	public recursos() {
		setTitle("Recursos Financeiros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 620);
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
		voltar.setBounds(0, 11, 106, 41);
		contentPane.add(voltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		//Aqui vai o caminho da imagem da aba recursos no seu computador / computador da undf
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gabri\\OneDrive\\Imagens\\layout recursos.png"));
		lblNewLabel.setBounds(0, 0, 529, 585);
		contentPane.add(lblNewLabel);
		
		
	}

}

