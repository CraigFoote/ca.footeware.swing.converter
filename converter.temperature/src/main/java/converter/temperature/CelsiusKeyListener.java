package converter.temperature;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;

/**
 * Listens for input in Celsius text field and updates Fahrenheit and Kelvin
 * fields.
 * 
 * @author Footeware.ca
 */
class CelsiusKeyListener extends KeyAdapter {

	private static final String EMPTY = "";
	private TemperaturePanel temperaturePanel;
	private NumberFormat formatter;

	/**
	 * Constructor.
	 * 
	 * @param temperaturePanel {@link TemperaturePanel}
	 */
	CelsiusKeyListener(TemperaturePanel temperaturePanel) {
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

		// update fahrenheit
		this.temperaturePanel.fahrenheitText.removeKeyListener(this.temperaturePanel.fahrenheitListener);
		this.temperaturePanel.fahrenheitText.setText(isValid ? formatter.format((input * 9 / 5) + 32) : EMPTY);
		this.temperaturePanel.fahrenheitText.addKeyListener(this.temperaturePanel.fahrenheitListener);

		// update kelvin
		this.temperaturePanel.kelvinText.removeKeyListener(this.temperaturePanel.kelvinListener);
		this.temperaturePanel.kelvinText.setText(isValid ? formatter.format(input + 273.15) : EMPTY);
		this.temperaturePanel.kelvinText.addKeyListener(this.temperaturePanel.kelvinListener);
	}
}