package converter.length;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;

/**
 * Listens for input in the foot field and updates the other fields.
 *
 * @author Footeware.ca
 */
public class FtKeyListener extends KeyAdapter {

	private static final String EMPTY = "";
	private LengthPanel lengthPanel;
	private NumberFormat formatter;

	/**
	 * Constructor.
	 *
	 * @param lengthPanel {@link LengthPanel}
	 */
	public FtKeyListener(LengthPanel lengthPanel) {
		this.lengthPanel = lengthPanel;
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

		// update millimeters
		this.lengthPanel.mmText.removeKeyListener(this.lengthPanel.mmListener);
		this.lengthPanel.mmText.setText(isValid ? String.valueOf(input * 304.8) : EMPTY);
		this.lengthPanel.mmText.addKeyListener(this.lengthPanel.mmListener);

		// update centimeters
		this.lengthPanel.cmText.removeKeyListener(this.lengthPanel.cmListener);
		this.lengthPanel.cmText.setText(isValid ? String.valueOf(input * 30.48) : EMPTY);
		this.lengthPanel.cmText.addKeyListener(this.lengthPanel.cmListener);

		// update meters
		this.lengthPanel.mText.removeKeyListener(this.lengthPanel.mListener);
		this.lengthPanel.mText.setText(isValid ? String.valueOf(input / 3.281) : EMPTY);
		this.lengthPanel.mText.addKeyListener(this.lengthPanel.mListener);

		// update kilometers
		this.lengthPanel.kmText.removeKeyListener(this.lengthPanel.kmListener);
		this.lengthPanel.kmText.setText(isValid ? String.valueOf(input / 3281) : EMPTY);
		this.lengthPanel.kmText.addKeyListener(this.lengthPanel.kmListener);

		// update inches
		this.lengthPanel.inText.removeKeyListener(this.lengthPanel.inListener);
		this.lengthPanel.inText.setText(isValid ? String.valueOf(input * 12) : EMPTY);
		this.lengthPanel.inText.addKeyListener(this.lengthPanel.inListener);

		// update miles
		this.lengthPanel.miText.removeKeyListener(this.lengthPanel.miListener);
		this.lengthPanel.miText.setText(isValid ? String.valueOf(input / 5280) : EMPTY);
		this.lengthPanel.miText.addKeyListener(this.lengthPanel.miListener);
	}
}
