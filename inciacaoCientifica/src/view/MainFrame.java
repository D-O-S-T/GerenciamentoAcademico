package view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.GerenciamentoProjetos;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GerenciamentoProjetos gestaoProjetos = new GerenciamentoProjetos();
                    JFrame frame = new MainFrame(gestaoProjetos);
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
    public MainFrame(GerenciamentoProjetos gestaoProjetos) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        // Use GridBagLayout for flexible layout
        contentPane.setLayout(new GridBagLayout());
        
        // Create GridBagConstraints for positioning components
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Button Coordenador
        JButton btnCoordenador = new JButton("Coordenador");
        btnCoordenador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CoordenacaoFrame coordenacaoFrame = new CoordenacaoFrame();
                coordenacaoFrame.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.insets.set(5, 5, 5, 5);
        contentPane.add(btnCoordenador, gbc);
        
        // Button Professor
        JButton btnProfessor = new JButton("Professor");
        btnProfessor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfessorFrame professorFrame = new ProfessorFrame();
                professorFrame.setVisible(true);
            }
        });
        gbc.gridy = 1;
        contentPane.add(btnProfessor, gbc);
        
        // Button Aluno
        JButton btnAluno = new JButton("Aluno");
        btnAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AlunoFrame alunoFrame = new AlunoFrame();
                alunoFrame.setVisible(true);
            }
        });
        gbc.gridy = 2;
        contentPane.add(btnAluno, gbc);
    }
}
