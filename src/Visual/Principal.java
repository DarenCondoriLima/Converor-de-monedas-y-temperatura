package Visual;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	private static JPanel content;
	String Item;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\1-Oracle\\Java\\Java JRE y JDK compile y ejecute su primer programa\\Java_Orientado_a_Objetos_G4-ONE\\Conversor\\media\\Balanza.png"));
		setTitle("Conversor");
		setResizable(false);
		getContentPane().setBackground(new Color(4, 135, 208));
		setSize(416,539);
		setMinimumSize(new Dimension(400, 539));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		content = new Fondo();
		content.setBounds(0, 90, 400, 410);
		getContentPane().add(content);
		
		JComboBox comboBox =new JComboBox();
		comboBox.setFont(new Font("Cambria Math", Font.BOLD, 25));
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Conversor de monedas", "Conversor de temperatura"}));
		comboBox.setBounds(20,30,360,60);
		getContentPane().add(comboBox);
		
		Conversor_M2 cm=new Conversor_M2();
		nuevoPanel(cm);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectMenu(comboBox);
				
			}
		});
	}	
	
	public void SelectMenu(JComboBox c){
		Item=c.getSelectedItem().toString();

		if(Item.equalsIgnoreCase("Conversor de monedas")) {
			Conversor_M2 cm=new Conversor_M2();
			nuevoPanel(cm);
		}
		if(Item.equalsIgnoreCase("Conversor de temperatura")) {
			Conversor_T2 ct=new Conversor_T2();
			nuevoPanel(ct);
		}
	}
	public static void nuevoPanel(JPanel panelActual){
		content.removeAll();
		content.add(panelActual);
		content.revalidate();	
		content.repaint();
	}
}
