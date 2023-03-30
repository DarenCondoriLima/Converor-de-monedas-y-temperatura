package Visual;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import Funcionamiento.Funcion_Conversor_T;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Hashtable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;

public class Conversor_T extends Fondo {
	private JTextField valor_1;
	Hashtable<Object,ImageIcon>mElementos;
	private JTextField resultado;

	public Conversor_T() {
		this.setSize(400,550);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 90, 90, 90, 90, 20, 0};
		gridBagLayout.rowHeights = new int[]{30, 80, 60, 30, 30, 60, 30, 30, 60, 40, 100, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titulo_cm = new JLabel("Conversor de temperaturas");
		titulo_cm.setForeground(new Color(0, 0, 0));
		titulo_cm.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_cm.setFont(new Font("Cambria", Font.BOLD, 26));
		GridBagConstraints gbc_titulo_cm = new GridBagConstraints();
		gbc_titulo_cm.gridwidth = 4;
		gbc_titulo_cm.fill = GridBagConstraints.BOTH;
		gbc_titulo_cm.insets = new Insets(0, 0, 5, 5);
		gbc_titulo_cm.gridx = 1;
		gbc_titulo_cm.gridy = 1;
		add(titulo_cm, gbc_titulo_cm);
		
		Funcion_Conversor_T datosT= new Funcion_Conversor_T();
		JComboBox temperatura_1 =new JComboBox();
		temperatura_1.setFont(new Font("Cambria", Font.PLAIN, 20));
		temperatura_1.setBackground(new Color(255, 255, 255));
		temperatura_1.setModel(new DefaultComboBoxModel(new String[] {}));
		GridBagConstraints gbc_temperatura_1 = new GridBagConstraints();
		gbc_temperatura_1.gridwidth = 2;
		gbc_temperatura_1.gridheight = 2;
		gbc_temperatura_1.insets = new Insets(0, 0, 5, 5);
		gbc_temperatura_1.fill = GridBagConstraints.BOTH;
		gbc_temperatura_1.gridx = 1;
		gbc_temperatura_1.gridy = 3;
		add(temperatura_1, gbc_temperatura_1);
			
		datosT.listm(temperatura_1);
		
		valor_1 = new JTextField();	
		valor_1.setFont(new Font("Cambria", Font.PLAIN, 20));
		TextPrompt placeholder = new TextPrompt("Ingrese su valor a convertir", valor_1);
		placeholder.setFont(new Font("Cambria", Font.PLAIN, 13));
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.BOLD);
		GridBagConstraints gbc_valor_1 = new GridBagConstraints();
		gbc_valor_1.gridheight = 2;
		gbc_valor_1.gridwidth = 2;
		gbc_valor_1.insets = new Insets(0, 0, 5, 5);
		gbc_valor_1.fill = GridBagConstraints.BOTH;
		gbc_valor_1.gridx = 3;
		gbc_valor_1.gridy = 3;
		add(valor_1, gbc_valor_1);
		valor_1.setColumns(10);
		
		JComboBox temperatura_2 = new JComboBox();
		temperatura_2.setFont(new Font("Cambria", Font.PLAIN, 20));
		GridBagConstraints gbc_temperatura_2 = new GridBagConstraints();
		gbc_temperatura_2.gridwidth = 2;
		gbc_temperatura_2.gridheight = 2;
		gbc_temperatura_2.insets = new Insets(0, 0, 5, 5);
		gbc_temperatura_2.fill = GridBagConstraints.BOTH;
		gbc_temperatura_2.gridx = 1;
		gbc_temperatura_2.gridy = 6;
		add(temperatura_2, gbc_temperatura_2);
		
		datosT.listm(temperatura_2);
		
		JButton convertir = new JButton("convertir");
		convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarNumero(valor_1)) {
				datosT.convertirTemperaturas(temperatura_1, temperatura_2, valor_1, resultado);}
				else {}
			}
		});
		
		resultado = new JTextField();
		resultado.setFont(new Font("Cambria", Font.PLAIN, 20));
		resultado.setEditable(false);
		GridBagConstraints gbc_resultado = new GridBagConstraints();
		gbc_resultado.gridheight = 2;
		gbc_resultado.gridwidth = 2;
		gbc_resultado.insets = new Insets(0, 0, 5, 5);
		gbc_resultado.fill = GridBagConstraints.BOTH;
		gbc_resultado.gridx = 3;
		gbc_resultado.gridy = 6;
		add(resultado, gbc_resultado);
		convertir.setFont(new Font("Cambria", Font.BOLD, 20));
		GridBagConstraints gbc_convertir = new GridBagConstraints();
		gbc_convertir.fill = GridBagConstraints.BOTH;
		gbc_convertir.gridwidth = 2;
		gbc_convertir.insets = new Insets(0, 0, 5, 5);
		gbc_convertir.gridx = 2;
		gbc_convertir.gridy = 9;
		add(convertir, gbc_convertir);
		
	}
	
	public boolean validarNumero(JTextField t) {
		String valor=valor_1.getText();
		String decimal;
		BigDecimal redondeo;
		while(!valor.matches("\\d{1,100}\\.\\d{1,2}")) {//1.00		
			if(valor.matches("\\d{0}")) {//
				JOptionPane.showMessageDialog(null, "Ingrese un valor");
				return false;
			}else if(valor.matches("\\d{1,10}")) {//1
				decimal=(valor+".00");
				t.setText(decimal);
				return true;	
			}else if(valor.matches("\\d{1,100}\\.\\d{3,20}")) {//1.0000
				redondeo=new BigDecimal(valor);
				redondeo=redondeo.divide(new BigDecimal(1),2,RoundingMode.DOWN);
				t.setText(redondeo.toString());
				return true;
			}else if(valor.matches("\\d{0}\\-\\d{1,100}\\.\\d{3,20}")) {//-1.0000
				redondeo=new BigDecimal(valor);
				redondeo=redondeo.divide(new BigDecimal(1),2,RoundingMode.DOWN);
				t.setText(redondeo.toString());
				return true;
			}else if(valor.matches("\\d{0}\\-\\d{1,100}")) {//-1
				return true;	
			}else if(valor.matches("\\d{1,100}\\,\\d{1,20}")){//1,0000
			JOptionPane.showMessageDialog(null, "Por favor reemplace la  \",\"  por  \".\"");
			return false;
			}else{
			JOptionPane.showMessageDialog(null,"El valor : " + valor + " no esta permitido");
			return false;
			}
		}
		return true;
	}
	
}
