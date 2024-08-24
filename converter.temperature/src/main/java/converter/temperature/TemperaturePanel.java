/**
 *
 */
package converter.temperature;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import converter.spi.ConverterPanel;

/**
 * Converts between celsius, fahrenheit and kelvin temperatures.
 *
 * @author Footeware.ca
 */
public class TemperaturePanel implements ConverterPanel {

	JTextField celsiusText;
	JTextField fahrenheitText;
	JTextField kelvinText;
	KeyListener celsiusListener;
	KeyListener fahrenheitListener;
	KeyListener kelvinListener;

	/**
	 * Constructor.
	 */
	public TemperaturePanel() {
		celsiusListener = new CelsiusKeyListener(this);
		fahrenheitListener = new FahrenheitKeyListener(this);
		kelvinListener = new KelvinKeyListener(this);
	}

	@Override
	public String getLabel() {
		return "Temperature";
	}

	@Override
	public ImageIcon getImage() {
		URL url = TemperaturePanel.class.getResource("/temperature.png");
		return new ImageIcon(url);
	}

	/**
	 * Copy the provided string to the system clipboard.
	 * 
	 * @param string {@link String}
	 */
	void copy(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	@Override
	public JComponent getPanel() {
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.setPreferredSize(new Dimension(295, 165));
		scrollPane.setPreferredSize(new Dimension(300, 17));

		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);

		celsiusText = new JTextField();
		celsiusText.setFont(font);
		celsiusText.setForeground(Color.GRAY);
		JPopupMenu celsiusPopup = new JPopupMenu("celsius");
		JMenuItem celsiusCopyMenuItem = new JMenuItem("Copy");
		celsiusCopyMenuItem.addActionListener(e -> copy(celsiusText.getText()));
		celsiusPopup.add(celsiusCopyMenuItem);
		celsiusText.add(celsiusPopup);
		celsiusText.setComponentPopupMenu(celsiusPopup);
		celsiusText.addKeyListener(celsiusListener);
		panel.add(celsiusText);

		JLabel celsiusLabel = new JLabel("°C", SwingConstants.LEFT);
		celsiusLabel.setFont(font);
		panel.add(celsiusLabel);

		fahrenheitText = new JTextField();
		fahrenheitText.setFont(font);
		fahrenheitText.setForeground(Color.GRAY);
		JPopupMenu fahrenheitPopup = new JPopupMenu("fahrenheit");
		JMenuItem fahrenheitCopyMenuItem = new JMenuItem("Copy");
		fahrenheitCopyMenuItem.addActionListener(e -> copy(fahrenheitText.getText()));
		fahrenheitPopup.add(fahrenheitCopyMenuItem);
		fahrenheitText.add(fahrenheitPopup);
		fahrenheitText.setComponentPopupMenu(fahrenheitPopup);
		fahrenheitText.addKeyListener(fahrenheitListener);
		panel.add(fahrenheitText);

		JLabel fahrenheitLabel = new JLabel("°F", SwingConstants.LEFT);
		fahrenheitLabel.setFont(font);
		panel.add(fahrenheitLabel);

		kelvinText = new JTextField();
		kelvinText.setFont(font);
		kelvinText.setForeground(Color.GRAY);
		JPopupMenu kelvinPopup = new JPopupMenu("kelvin");
		JMenuItem kelvinCopyMenuItem = new JMenuItem("Copy");
		kelvinCopyMenuItem.addActionListener(e -> copy(kelvinText.getText()));
		kelvinPopup.add(kelvinCopyMenuItem);
		kelvinText.add(kelvinPopup);
		kelvinText.setComponentPopupMenu(kelvinPopup);
		kelvinText.addKeyListener(kelvinListener);
		panel.add(kelvinText);

		JLabel kelvinLabel = new JLabel("°K", SwingConstants.LEFT);
		kelvinLabel.setFont(font);
		panel.add(kelvinLabel);

		layout.putConstraint(SpringLayout.WEST, celsiusText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, celsiusText, 15, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, celsiusLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, celsiusLabel, 20, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, celsiusText, -10, SpringLayout.WEST, celsiusLabel);

		layout.putConstraint(SpringLayout.WEST, fahrenheitText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, fahrenheitText, 20, SpringLayout.SOUTH, celsiusText);
		layout.putConstraint(SpringLayout.EAST, fahrenheitLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, fahrenheitLabel, 25, SpringLayout.SOUTH, celsiusLabel);
		layout.putConstraint(SpringLayout.EAST, fahrenheitText, -10, SpringLayout.WEST, fahrenheitLabel);

		layout.putConstraint(SpringLayout.WEST, kelvinText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, kelvinText, 20, SpringLayout.SOUTH, fahrenheitText);
		layout.putConstraint(SpringLayout.EAST, kelvinLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, kelvinLabel, 25, SpringLayout.SOUTH, fahrenheitLabel);
		layout.putConstraint(SpringLayout.EAST, kelvinText, -10, SpringLayout.WEST, kelvinLabel);

		return scrollPane;
	}
}
