package Funcionamiento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Funcion_Conversor_T {

	// temperaturasList es la lista de temperaturas que acepta el conversor de
	// temperaturas.
	private String[] temperaturasList = { "Celsius °C", "Fahrenheit °F", "Kelvin K", "Rankine °R" };

	// listm introduce temperaturasList dentro de JComboBox
	public void listm(JComboBox<String> j) {

		j.setModel(new DefaultComboBoxModel<>(temperaturasList));

	}

	/*
	 * Este método obtiene los datos seleccionados en los dos JComboBox "c,c2"
	 * ademas del valor introducido nen el JtenField v1 y realiza las operaciones
	 * correspondientes para convertir la temperatura "v1" (de adecuado a lo
	 * seleccionado en "c") a la temperatura "c2", el resultado es mostrado en
	 * JTextField "mostrar_resultado".
	 */
	public void convertirTemperaturas(JComboBox c, JComboBox c2, JTextField v1, JTextField mostrar_resultado) {
		String Item = c.getSelectedItem().toString();
		String Item2 = c2.getSelectedItem().toString();
		String temperatura1 = v1.getText();
		BigDecimal valor1 = new BigDecimal(temperatura1);
		BigDecimal resultado;
		BigDecimal fraccion;
		switch (Item) {
		case "Celsius °C": {

			switch (Item2) {
			case "Celsius °C": {
				mostrar_resultado.setText(temperatura1);
				break;
			}
			case "Fahrenheit °F": {
				resultado = valor1.multiply(new BigDecimal(1.8)).add(new BigDecimal(32));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Kelvin K": {
				resultado = valor1.add(new BigDecimal(273));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Rankine °R": {
				resultado = valor1.multiply(new BigDecimal(9)).divide(new BigDecimal(5)).add(new BigDecimal(491.67));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Item2);
			}
			break;
		}
		case "Fahrenheit °F": {
			switch (Item2) {
			case "Celsius °C": {
				resultado = valor1.subtract(new BigDecimal(32)).divide(new BigDecimal(1.8), 4, RoundingMode.DOWN);
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Fahrenheit °F": {
				mostrar_resultado.setText(temperatura1);
				break;
			}
			case "Kelvin K": {
				resultado = valor1.add(new BigDecimal(459.67)).multiply(new BigDecimal(5)).divide(new BigDecimal(9), 4,
						RoundingMode.DOWN);
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Rankine °R": {
				resultado = valor1.add(new BigDecimal(460));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Item2);
			}
			break;
		}
		case "Kelvin K": {
			switch (Item2) {
			case "Celsius °C": {
				resultado = valor1.subtract(new BigDecimal(273));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Fahrenheit °F": {
				resultado = valor1.subtract(new BigDecimal(273.15)).multiply(new BigDecimal(1.8))
						.add(new BigDecimal(32));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Kelvin K": {

				mostrar_resultado.setText(temperatura1);
				break;
			}
			case "Rankine °R": {
				resultado = valor1.multiply(new BigDecimal(1.8));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Item2);
			}
			break;
		}
		case "Rankine °R": {
			switch (Item2) {
			case "Celsius °C": {
				resultado = valor1.multiply(new BigDecimal(5)).divide(new BigDecimal(9), 4, RoundingMode.DOWN)
						.subtract(new BigDecimal(273.15));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Fahrenheit °F": {
				resultado = valor1.subtract(new BigDecimal(460));
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Kelvin K": {
				resultado = valor1.divide(new BigDecimal(1.8), 4, RoundingMode.DOWN);
				resultado = resultado.divide(new BigDecimal(1), 2, RoundingMode.DOWN);
				mostrar_resultado.setText(resultado.toString());
				break;
			}
			case "Rankine °R": {
				mostrar_resultado.setText(temperatura1);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Item2);
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + Item);
		}
	}

}
