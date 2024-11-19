/**
 *
 */
package converter.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import converter.spi.ConverterPanel;

/**
 * Show tabs with panels that convert something in some way.
 *
 * @author Footeware.ca
 */
public class Converter {

	/**
	 * Application entry point.
	 *
	 * @param args {@link String}[]
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // dark mode did work but now doesn't
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(() -> createAndShowGUI());
	}

	/**
	 * Create and uh...show the GUI.
	 */
	protected static void createAndShowGUI() {
		JFrame frame = new JFrame("Converter");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// find all the ConverterPanel implementations & put them in a list
		List<ConverterPanel> panels = new ArrayList<>();
		ServiceLoader<ConverterPanel> converterPanelLoader = ServiceLoader.load(ConverterPanel.class);
		for (ConverterPanel converterPanel : converterPanelLoader) {
			panels.add(converterPanel);
		}

		// sort by tab names
		panels.sort((o1, o2) -> o1.getLabel().compareTo(o2.getLabel()));
		// add each panel
		JTabbedPane tabPane = new JTabbedPane();
		for (ConverterPanel converterPanel : panels) {
			JComponent panel = converterPanel.getPanel();
			tabPane.addTab(converterPanel.getLabel(), converterPanel.getImage(), panel);
		}
		frame.add(tabPane);

		frame.pack();
		// center on screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2, screenSize.height / 2 - frame.getHeight() / 2);
		frame.setVisible(true);
	}
}
