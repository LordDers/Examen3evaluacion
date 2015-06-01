import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;


public class ChechBox_Ruben extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JButton btnEnviar;
	private JButton btnCancelar;
	
	List<JCheckBox> checkGrupo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChechBox_Ruben frame = new ChechBox_Ruben();
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
	public ChechBox_Ruben() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("Examen Rubén Álvarez");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona tus deportes favoritos:");
		lblNewLabel.setBounds(87, 25, 244, 15);
		contentPane.add(lblNewLabel);
		
		chckbxNewCheckBox = new JCheckBox("Fútbol");
		chckbxNewCheckBox.setBounds(8, 70, 129, 23);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Tenis");
		chckbxNewCheckBox_1.setBounds(159, 70, 129, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Baloncesto");
		chckbxNewCheckBox_2.setBounds(311, 70, 129, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Natación");
		chckbxNewCheckBox_3.setBounds(8, 110, 129, 23);
		contentPane.add(chckbxNewCheckBox_3);
		
		chckbxNewCheckBox_4 = new JCheckBox("Balonmano");
		chckbxNewCheckBox_4.setBounds(159, 110, 129, 23);
		contentPane.add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_5 = new JCheckBox("Atletismo");
		chckbxNewCheckBox_5.setBounds(311, 110, 129, 23);
		contentPane.add(chckbxNewCheckBox_5);
		
		checkGrupo = new ArrayList<JCheckBox>();
		checkGrupo.add(chckbxNewCheckBox);
		checkGrupo.add(chckbxNewCheckBox_1);
		checkGrupo.add(chckbxNewCheckBox_2);
		checkGrupo.add(chckbxNewCheckBox_3);
		checkGrupo.add(chckbxNewCheckBox_4);
		checkGrupo.add(chckbxNewCheckBox_5);
		
		btnEnviar = new JButton("OK");
		btnEnviar.setBounds(87, 180, 117, 25);
		btnEnviar.addActionListener(this);
		contentPane.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(256, 180, 117, 25);
		btnCancelar.addActionListener(this);
		contentPane.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object boton_accion = e.getSource();
		
		if (boton_accion == btnEnviar) {
			System.out.println("OK");
			System.out.println("Has seleccionado: ");
			if (chckbxNewCheckBox.isSelected()) {
				System.out.println("Futbol");
			} 
			if (chckbxNewCheckBox_1.isSelected()) {
				System.out.println("Tenis");
			} 
			if (chckbxNewCheckBox_2.isSelected()) {
				System.out.println("Baloncesto");
			}
			if (chckbxNewCheckBox_3.isSelected()) {
				System.out.println("Natación");
			} 
			if (chckbxNewCheckBox_4.isSelected()) {
				System.out.println("Balonmano");
			}
			if (chckbxNewCheckBox_5.isSelected()) {
				System.out.println("Atletismo");
			}
		} else if (boton_accion == btnCancelar) {
			System.out.println("Has cancelado");
			
			for (JCheckBox vaciar : checkGrupo) {
				if (vaciar.isSelected()) {
					vaciar.setSelected(false);
				}
			}
		}
	}
}
