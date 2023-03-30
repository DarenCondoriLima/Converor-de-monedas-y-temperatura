package Funcionamiento;

import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Hashtable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

public class Funcion_Conversor_M {

	Hashtable<Object, ImageIcon> mElementos;

	// monedasList son la lista de monedas admitidas por el conversor de monedas.
	private String[] monedasList = { "Dólar", "Euro", "Yen Japonés", "Sol Peruano", "Libra Esterlina",
			"Won Surcoreano" };
	/*
	 * Estos datos String[] son los valores de conversion de a la moneda 1 a moneda
	 * 2. Siendo moneda 1 el nombre del String[] y moneda 2 sus valores, los cuales
	 * estan en el orden de monedasList.
	 * de:https://www.xe.com/es/currencyconverter/convert/ Día 28/03/23 Hora: 01:37
	 * a.m.
	 */
	private String[] deDolar = { "1", "0.9245", "130.97", "3.7723", "0.8114", "1299.5" };
	private String[] deEuro = { "1.0815", "1", "141.61", "4.0741", "0.8776", "1405.3" };
	private String[] deYen = { "0.0076", "0.0071", "1", "0.0288", "0.0062", "9.9238" };
	private String[] deSol = { "0.2651", "0.2451", "34.697", "1", "0.2151", "344.19" };
	private String[] deLibra = { "1.2324", "1.1399", "161.29", "4.6489", "1", "1599.8" };
	private String[] deWon = { "0.0008", "0.0007", "0.1009", "0.0029", "0.0006", "1" };
	// Estas variables son las rutas de los iconos/banderas.
	private String bUSD = "/Img/Estados-Unidos.png";
	private String bEUR = "/Img/Europa.png";
	private String bJPY = "/Img/Japón.png";
	private String bPEN = "/Img/Perú.png";
	private String bGBP = "/Img/Reino Unido.png";
	private String bKRW = "/Img/Corea del Sur.png";
	private String img_default = "/Img/default.jpg";

	// valores de medida de los iconos de JComboBox
	int width = 50;
	int height = 40;

	// Este método obtiene los iconos de las rutas antes mensionadas, las cuales se
	// reescalan a los valores width y height establecidos arriba
	public ImageIcon getIcono(String paht) {
		return new ImageIcon(new ImageIcon(getClass().getResource(paht)).getImage().getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH));
	}

	// Estos dos métodos establecen los iconos dentro del JComboBox junto con sus
	// valores.
	public class JComboBoxRender extends JLabel implements ListCellRenderer {

		Hashtable<Object, ImageIcon> mElementos;
		ImageIcon mImg = getIcono(img_default);

		public JComboBoxRender(Hashtable<Object, ImageIcon> mElementos) {
			this.mElementos = mElementos;
		}

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			if (mElementos.get(value) == null) {
				setIcon(mImg);
			} else {
				setIcon(mElementos.get(value));
			}

			setText(value.toString());
			return this;
		}
	}

	public void listm(JComboBox<String> j) {
		mElementos = new Hashtable<>();

		j.setModel(new DefaultComboBoxModel<>(monedasList));

		mElementos.put("Dólar", getIcono(bUSD));
		mElementos.put("Euro", getIcono(bEUR));
		mElementos.put("Yen Japonés", getIcono(bJPY));
		mElementos.put("Sol Peruano", getIcono(bPEN));
		mElementos.put("Libra Esterlina", getIcono(bGBP));
		mElementos.put("Won Surcoreano", getIcono(bKRW));

		JComboBoxRender mRender = new JComboBoxRender(mElementos);
		j.setRenderer(mRender);

	}

	/*
	 * Este método reconoce el valor seleccionado en JComboBox "c"(moneda a convertir)
	 *  luego llama al metodo multiplicar_M que reconoce la selección de
	 *  JComboBox "c2"(moneda de destino),multiplicar_M llama el método multiplicar que
 	 * recolecta los datos de JTextField "m"(valor introducido, esta va de acuerdo a
	 * JComboBox "c") y junto a los valores de conversión antes declarados los
	 * convierte a la moneda seleccionada en JComboBox "c2", luego retorna el valor
	 * en JTextField "m2".
	 */
	public void convertirMonedas(JComboBox c, JComboBox c2, JTextField m, JTextField m2) {
		String Item = c.getSelectedItem().toString();
		String Item2 = c2.getSelectedItem().toString();
		switch (Item) {
		case "Dólar": {
			multiplicar_M(c2, m, m2, deDolar);
			break;
		}
		case "Euro": {
			multiplicar_M(c2, m, m2, deEuro);
			break;
		}
		case "Yen Japonés": {
			multiplicar_M(c2, m, m2, deYen);
			break;
		}
		case "Sol Peruano": {
			multiplicar_M(c2, m, m2, deSol);
			break;
		}
		case "Libra Esterlina": {
			multiplicar_M(c2, m, m2, deLibra);
			break;
		}
		case "Won Surcoreano": {
			multiplicar_M(c2, m, m2, deWon);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + Item);
		}
	}

	public void multiplicar(JTextField m1, JTextField r, String x) {
		String moneda1 = m1.getText();
		BigDecimal resultado;
		BigDecimal valor1;
		BigDecimal valor2;
		valor1 = new BigDecimal(moneda1);
		valor2 = new BigDecimal(x);
		resultado = valor1.multiply(valor2);
		resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
		r.setText(resultado.toString());
	}

	public void multiplicar_M(JComboBox v2, JTextField m1, JTextField r, String[] x) {
		String Item2 = v2.getSelectedItem().toString();

		switch (Item2) {
		case "Dólar": {
			multiplicar(m1, r, x[0]);
			break;
		}
		case "Euro": {
			multiplicar(m1, r, x[1]);
			break;
		}
		case "Yen Japonés": {
			multiplicar(m1, r, x[2]);
			break;
		}
		case "Sol Peruano": {
			multiplicar(m1, r, x[3]);
			break;
		}
		case "Libra Esterlina": {
			multiplicar(m1, r, x[4]);
			break;
		}
		case "Won Surcoreano": {
			multiplicar(m1, r, x[5]);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + Item2);
		}
	}

	/*
	 * for(String lista: monedasList) { System.out.println(lista); }
	 */

}
