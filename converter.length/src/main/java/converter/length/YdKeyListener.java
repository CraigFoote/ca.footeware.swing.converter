package converter.length;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;

/**
 * Listens for input in the yards field and updates the other fields.
 *
 * @author Footeware.ca
 */
public class YdKeyListener extends KeyAdapter {

	private static final String EMPTY = "";
	private LengthPanel lengthPanel;
	private NumberFormat formatter;

	/**
	 * Constructor.
	 *
	 * @param lengthPanel {@link LengthPanel}
	 */
	public YdKeyListener(LengthPanel lengthPanel) {
		this.lengthPanel = lengthPanel;
		formatter = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		formatter.setMaximumFractionDigits(340); // fucking magic!
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String inputStr = ((JTextField) e.getComponent()).getText().trim();
		Double input = null;
		if (!inputStr.isEmpty()) {
			try {
				input = Double.parseDouble(inputStr);
			} catch (NumberFormatException e1) {
				// jump up and down and squeal
			}
		}

		boolean isValid = (input != null && !input.isNaN());

		// update millimeters
		this.lengthPanel.mmText.removeKeyListener(this.lengthPanel.mmListener);
		this.lengthPanel.mmText.setText(isValid ? formatter.format(input * 1.609e+6) : EMPTY);
		this.lengthPanel.mmText.addKeyListener(this.lengthPanel.mmListener);

		// update centimeters
		this.lengthPanel.cmText.removeKeyListener(this.lengthPanel.cmListener);
		this.lengthPanel.cmText.setText(isValid ? formatter.format(input * 160900) : EMPTY);
		this.lengthPanel.cmText.addKeyListener(this.lengthPanel.cmListener);

		// update meters
		this.lengthPanel.mText.removeKeyListener(this.lengthPanel.mListener);
		this.lengthPanel.mText.setText(isValid ? formatter.format(input * 1609) : EMPTY);
		this.lengthPanel.mText.addKeyListener(this.lengthPanel.mListener);

		// update kilometers
		this.lengthPanel.kmText.removeKeyListener(this.lengthPanel.kmListener);
		this.lengthPanel.kmText.setText(isValid ? formatter.format(input * 1.609) : EMPTY);
		this.lengthPanel.kmText.addKeyListener(this.lengthPanel.kmListener);

		// update inches
		this.lengthPanel.inText.removeKeyListener(this.lengthPanel.inListener);
		this.lengthPanel.inText.setText(isValid ? formatter.format(input * 63360) : EMPTY);
		this.lengthPanel.inText.addKeyListener(this.lengthPanel.inListener);

		// update feet
		this.lengthPanel.ftText.removeKeyListener(this.lengthPanel.ftListener);
		this.lengthPanel.ftText.setText(isValid ? formatter.format(input * 5280) : EMPTY);
		this.lengthPanel.ftText.addKeyListener(this.lengthPanel.ftListener);

		// update miles
		this.lengthPanel.miText.removeKeyListener(this.lengthPanel.miListener);
		this.lengthPanel.miText.setText(isValid ? formatter.format(input / 1760) : EMPTY);
		this.lengthPanel.miText.addKeyListener(this.lengthPanel.miListener);
	}
}
