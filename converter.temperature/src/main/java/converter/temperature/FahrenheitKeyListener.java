package converter.temperature;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;

/**
 * Listens for input in Fahrenheit text field and updates Celsius and Kelvin
 * fields.
 * 
 * @author Footeware.ca
 */
class FahrenheitKeyListener extends KeyAdapter {

	private static final String EMPTY = "";
	private TemperaturePanel temperaturePanel;
	private NumberFormat formatter;

	/**
	 * Constructor.
	 * 
	 * @param temperaturePanel {@link TemperaturePanel}
	 */
	FahrenheitKeyListener(TemperaturePanel temperaturePanel) {
		this.temperaturePanel = temperaturePanel;
		formatter = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		formatter.setMaximumFractionDigits(340);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String inputStr = ((JTextField) e.getComponent()).getText().trim();
		Double input = null;
		if (!inputStr.isEmpty()) {
			try {
				input = Double.parseDouble(inputStr);
			} catch (NumberFormatException e1) {
				// do nothing
			}
		}

		boolean isValid = (input != null && !input.isNaN());

		// update celsius
		this.temperaturePanel.celsiusText.removeKeyListener(this.temperaturePanel.celsiusListener);
		this.temperaturePanel.celsiusText.setText(isValid ? formatter.format((input - 32) * 5 / 9) : EMPTY);
		this.temperaturePanel.celsiusText.addKeyListener(this.temperaturePanel.celsiusListener);

		// update kelvin
		this.temperaturePanel.kelvinText.removeKeyListener(this.temperaturePanel.kelvinListener);
		this.temperaturePanel.kelvinText.setText(isValid ? formatter.format((input  + 459.67) * 5 / 9) : EMPTY);
		this.temperaturePanel.kelvinText.addKeyListener(this.temperaturePanel.kelvinListener);
	}
}