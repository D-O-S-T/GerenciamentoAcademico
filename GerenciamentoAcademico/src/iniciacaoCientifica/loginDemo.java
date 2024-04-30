package iniciacaoCientifica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginDemo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioTextField;
	private JPasswordField senhaTextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginDemo frame = new loginDemo();
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
	public loginDemo() {
		setTitle("Login Sistema Iniciação Científica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 472);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				frameInicio ti = new frameInicio();
				ti.frameInicio();
				dispose();
				
			}
			
			
		});
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setBackground(UIManager.getColor("CheckBox.highlight"));
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEntrar.setBounds(215, 372, 103, 30);
		contentPane.add(btnEntrar);
		
		
		usuarioTextField = new JTextField();
		usuarioTextField.setBounds(156, 211, 224, 30);
		contentPane.add(usuarioTextField);
		usuarioTextField.setColumns(10);
		
		senhaTextfield = new JPasswordField();
		senhaTextfield.setBounds(156, 310, 224, 30);
		contentPane.add(senhaTextfield);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 589, 432);
		// Aqui vai o caminho da imagem da tela de login no seu computador/ computador na undf
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\anapa\\Downloads\\layout login.png"));
		contentPane.add(lblNewLabel);
		
		
	}

}

