package iniciacaoCientifica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class frameInicio extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void frameInicio() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameInicio frame = new frameInicio();
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
	public frameInicio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 555, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoProjetos = new JButton("");
		botaoProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				projetos pj = new projetos();
				pj.projetos();
			}
		});
		botaoProjetos.setBorder(null);
		botaoProjetos.setContentAreaFilled(false);
		botaoProjetos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoProjetos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		botaoProjetos.setBounds(27, 134, 221, 100);
		contentPane.add(botaoProjetos);
		
		JButton botaoAtividades = new JButton("");
		botaoAtividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atividades at = new atividades();
				at.atividades();
			}
		});
		botaoAtividades.setBorderPainted(false);
		botaoAtividades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoAtividades.setContentAreaFilled(false);
		botaoAtividades.setAlignmentX(1.0f);
		botaoAtividades.setBounds(301, 143, 202, 83);
		contentPane.add(botaoAtividades);
		JButton botaoRecursos = new JButton("");
		botaoRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recursos rc = new recursos();
				rc.recursos();
			}
		});
		botaoRecursos.setBorderPainted(false);
		botaoRecursos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoRecursos.setContentAreaFilled(false);
		
		botaoRecursos.setAlignmentX(1.0f);
		botaoRecursos.setBounds(35, 253, 202, 83);
		contentPane.add(botaoRecursos);
		
		JButton botaoComunicação = new JButton("");
		botaoComunicação.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comunicacao cm = new comunicacao();
				cm.comunicacao();
			}
		});
		botaoComunicação.setBorderPainted(false);
		botaoComunicação.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoComunicação.setContentAreaFilled(false);
		botaoComunicação.setAlignmentX(1.0f);
		botaoComunicação.setBounds(301, 253, 202, 83);
		contentPane.add(botaoComunicação);
		
		JButton botaoDocumentacao = new JButton("");
		botaoDocumentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				documentacao dm = new documentacao();
				dm.documentacao();
			}
		});
		botaoDocumentacao.setBorderPainted(false);
		botaoDocumentacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoDocumentacao.setContentAreaFilled(false);
		botaoDocumentacao.setAlignmentX(1.0f);
		botaoDocumentacao.setBounds(35, 363, 202, 83);
		contentPane.add(botaoDocumentacao);
		
		JButton botaoCronograma = new JButton("");
		botaoCronograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cronograma cro = new cronograma();
				cro.cronograma();
			}
		});
		botaoCronograma.setBorderPainted(false);
		botaoCronograma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoCronograma.setContentAreaFilled(false);
		botaoCronograma.setAlignmentX(1.0f);
		botaoCronograma.setBounds(301, 363, 202, 83);
		contentPane.add(botaoCronograma);
		
		JButton botaoNotificacoes = new JButton("");
		botaoNotificacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notificacoes nt = new notificacoes();
				nt.notificacoes();
			}
		});
		botaoNotificacoes.setBorderPainted(false);
		botaoNotificacoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoNotificacoes.setContentAreaFilled(false);
		botaoNotificacoes.setAlignmentX(1.0f);
		botaoNotificacoes.setBounds(35, 472, 202, 83);
		contentPane.add(botaoNotificacoes);
		
		JButton botaoAvaliacao = new JButton("");
		botaoAvaliacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avaliacao av = new avaliacao();
				av.avaliacao();
			}
		});
		botaoAvaliacao.setBorderPainted(false);
		botaoAvaliacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoAvaliacao.setContentAreaFilled(false);
		botaoAvaliacao.setAlignmentX(1.0f);
		botaoAvaliacao.setBounds(301, 472, 202, 83);
		contentPane.add(botaoAvaliacao);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(10, 10, 566, 566);
		//Aqui vai o caminho da imagem da tela de início no seu computador/computador da undf
		lblNewLabel.setIcon(new ImageIcon("src/imagens/layout_inicio.png"));
		contentPane.add(lblNewLabel);	
		
	}
}

