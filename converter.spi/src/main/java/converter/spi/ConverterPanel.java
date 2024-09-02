/**
 *
 */
package converter.spi;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * @author Footeware.ca
 *
 * Extend this class to produce a tab panel in <code>Converter</code>.
 */
public interface ConverterPanel {

	/**
	 * Get the label identifying the tabPanel.
	 *
	 * @return {@link String}
	 */
	String getLabel();

	/**
	 * Get the icon image for this tab's composite.
	 *
	 * @return {@link ImageIcon}
	 */
	ImageIcon getImage();

	/**
	 * Get the panel laying out the controls for the tab.
	 *
	 * @return parent {@link JComponent}
	 */
	JComponent getPanel();
}
