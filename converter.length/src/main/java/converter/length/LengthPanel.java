/**
 *
 */
package converter.length;

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
 * Converts between millimeters, centimeters, meters, kilometers, inches, feet
 * and miles lengths.
 *
 * @author Footeware.ca
 */
public class LengthPanel implements ConverterPanel {

	JTextField mmText;
	JTextField cmText;
	JTextField mText;
	JTextField kmText;
	JTextField inText;
	JTextField ftText;
	JTextField ydText;
	JTextField miText;

	KeyListener mmListener;
	KeyListener cmListener;
	KeyListener mListener;
	KeyListener kmListener;
	KeyListener inListener;
	KeyListener ftListener;
	KeyListener ydListener;
	KeyListener miListener;

	public LengthPanel() {
		mmListener = new MmKeyListener(this);
		cmListener = new CmKeyListener(this);
		mListener = new MKeyListener(this);
		kmListener = new KmKeyListener(this);
		inListener = new InKeyListener(this);
		ftListener = new FtKeyListener(this);
		ydListener = new YdKeyListener(this);
		miListener = new MiKeyListener(this);
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
	public ImageIcon getImage() {
		URL url = LengthPanel.class.getResource("/ruler.png");
		return new ImageIcon(url);
	}

	@Override
	public String getLabel() {
		return "Length";
	}

	@Override
	public JComponent getPanel() {
		JPanel panel = new JPanel();
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.setPreferredSize(new Dimension(390, 420));
		scrollPane.setPreferredSize(new Dimension(400, 430));

		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);

		// millimeters
		mmText = new JTextField();
		mmText.setFont(font);
		mmText.setForeground(Color.GRAY);
		JPopupMenu mmPopup = new JPopupMenu("mm");
		JMenuItem mmCopyMenuItem = new JMenuItem("Copy");
		mmCopyMenuItem.addActionListener(e -> copy(mmText.getText()));
		mmPopup.add(mmCopyMenuItem);
		mmText.add(mmPopup);
		mmText.setComponentPopupMenu(mmPopup);
		mmText.addKeyListener(mmListener);
		panel.add(mmText);

		JLabel mmLabel = new JLabel("mm", SwingConstants.LEFT);
		mmLabel.setFont(font);
		panel.add(mmLabel);

		// centimeters
		cmText = new JTextField();
		cmText.setFont(font);
		cmText.setForeground(Color.GRAY);
		JPopupMenu cmPopup = new JPopupMenu("cm");
		JMenuItem cmCopyMenuItem = new JMenuItem("Copy");
		cmCopyMenuItem.addActionListener(e -> copy(cmText.getText()));
		cmPopup.add(cmCopyMenuItem);
		cmText.add(cmPopup);
		cmText.setComponentPopupMenu(cmPopup);
		cmText.addKeyListener(cmListener);
		panel.add(cmText);

		JLabel cmLabel = new JLabel("cm", SwingConstants.LEFT);
		cmLabel.setFont(font);
		panel.add(cmLabel);

		// meters
		mText = new JTextField();
		mText.setFont(font);
		mText.setForeground(Color.GRAY);
		JPopupMenu mPopup = new JPopupMenu("m");
		JMenuItem mCopyMenuItem = new JMenuItem("Copy");
		mCopyMenuItem.addActionListener(e -> copy(mText.getText()));
		mPopup.add(mCopyMenuItem);
		mText.add(mPopup);
		mText.setComponentPopupMenu(mPopup);
		mText.addKeyListener(mListener);
		panel.add(mText);

		JLabel mLabel = new JLabel("m ", SwingConstants.LEFT);
		mLabel.setFont(font);
		panel.add(mLabel);

		// kilometers
		kmText = new JTextField();
		kmText.setFont(font);
		kmText.setForeground(Color.GRAY);
		JPopupMenu kmPopup = new JPopupMenu("km");
		JMenuItem kmCopyMenuItem = new JMenuItem("Copy");
		kmCopyMenuItem.addActionListener(e -> copy(kmText.getText()));
		kmPopup.add(kmCopyMenuItem);
		kmText.add(kmPopup);
		kmText.setComponentPopupMenu(kmPopup);
		kmText.addKeyListener(kmListener);
		panel.add(kmText);

		JLabel kmLabel = new JLabel("km", SwingConstants.LEFT);
		kmLabel.setFont(font);
		panel.add(kmLabel);

		// inches
		inText = new JTextField();
		inText.setFont(font);
		inText.setForeground(Color.GRAY);
		JPopupMenu inPopup = new JPopupMenu("in");
		JMenuItem inCopyMenuItem = new JMenuItem("Copy");
		inCopyMenuItem.addActionListener(e -> copy(inText.getText()));
		inPopup.add(inCopyMenuItem);
		inText.add(inPopup);
		inText.setComponentPopupMenu(inPopup);
		inText.addKeyListener(inListener);
		panel.add(inText);

		JLabel inLabel = new JLabel("in", SwingConstants.LEFT);
		inLabel.setFont(font);
		panel.add(inLabel);

		// feet
		ftText = new JTextField();
		ftText.setFont(font);
		ftText.setForeground(Color.GRAY);
		JPopupMenu ftPopup = new JPopupMenu("ft");
		JMenuItem ftCopyMenuItem = new JMenuItem("Copy");
		ftCopyMenuItem.addActionListener(e -> copy(ftText.getText()));
		ftPopup.add(ftCopyMenuItem);
		ftText.add(ftPopup);
		ftText.setComponentPopupMenu(ftPopup);
		ftText.addKeyListener(ftListener);
		panel.add(ftText);

		JLabel ftLabel = new JLabel("ft", SwingConstants.LEFT);
		ftLabel.setFont(font);
		panel.add(ftLabel);

		// yards
		ydText = new JTextField();
		ydText.setFont(font);
		ydText.setForeground(Color.GRAY);
		JPopupMenu ydPopup = new JPopupMenu("yd");
		JMenuItem ydCopyMenuItem = new JMenuItem("Copy");
		ydCopyMenuItem.addActionListener(e -> copy(ydText.getText()));
		ydPopup.add(ydCopyMenuItem);
		ydText.add(ydPopup);
		ydText.setComponentPopupMenu(ydPopup);
		ydText.addKeyListener(ydListener);
		panel.add(ydText);

		JLabel ydLabel = new JLabel("yd", SwingConstants.LEFT);
		ydLabel.setFont(font);
		panel.add(ydLabel);

		// miles
		miText = new JTextField();
		miText.setFont(font);
		miText.setForeground(Color.GRAY);
		JPopupMenu miPopup = new JPopupMenu("mi");
		JMenuItem miCopyMenuItem = new JMenuItem("Copy");
		miCopyMenuItem.addActionListener(e -> copy(miText.getText()));
		miPopup.add(miCopyMenuItem);
		miText.add(miPopup);
		miText.setComponentPopupMenu(miPopup);
		miText.addKeyListener(miListener);
		panel.add(miText);

		JLabel miLabel = new JLabel("mi", SwingConstants.LEFT);
		miLabel.setFont(font);
		panel.add(miLabel);

		// millimeters
		layout.putConstraint(SpringLayout.WEST, mmText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, mmText, 15, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, mmLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, mmLabel, 20, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.EAST, mmText, -10, SpringLayout.WEST, mmLabel);

		// centimeters
		layout.putConstraint(SpringLayout.WEST, cmText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, cmText, 20, SpringLayout.SOUTH, mmText);
		layout.putConstraint(SpringLayout.EAST, cmLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, cmLabel, 25, SpringLayout.SOUTH, mmLabel);
		layout.putConstraint(SpringLayout.EAST, cmText, -10, SpringLayout.WEST, cmLabel);

		// meters
		layout.putConstraint(SpringLayout.WEST, mText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, mText, 20, SpringLayout.SOUTH, cmText);
		layout.putConstraint(SpringLayout.EAST, mLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, mLabel, 25, SpringLayout.SOUTH, cmLabel);
		layout.putConstraint(SpringLayout.EAST, mText, -10, SpringLayout.WEST, mLabel);

		// kilometers
		layout.putConstraint(SpringLayout.WEST, kmText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, kmText, 20, SpringLayout.SOUTH, mText);
		layout.putConstraint(SpringLayout.EAST, kmLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, kmLabel, 25, SpringLayout.SOUTH, mLabel);
		layout.putConstraint(SpringLayout.EAST, kmText, -10, SpringLayout.WEST, kmLabel);

		// inches
		layout.putConstraint(SpringLayout.WEST, inText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, inText, 20, SpringLayout.SOUTH, kmText);
		layout.putConstraint(SpringLayout.EAST, inLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, inLabel, 25, SpringLayout.SOUTH, kmLabel);
		layout.putConstraint(SpringLayout.EAST, inText, -10, SpringLayout.WEST, inLabel);

		// feet
		layout.putConstraint(SpringLayout.WEST, ftText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ftText, 20, SpringLayout.SOUTH, inText);
		layout.putConstraint(SpringLayout.EAST, ftLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, ftLabel, 25, SpringLayout.SOUTH, inLabel);
		layout.putConstraint(SpringLayout.EAST, ftText, -10, SpringLayout.WEST, ftLabel);

		// yards
		layout.putConstraint(SpringLayout.WEST, ydText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, ydText, 20, SpringLayout.SOUTH, ftText);
		layout.putConstraint(SpringLayout.EAST, ydLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, ydLabel, 25, SpringLayout.SOUTH, ftLabel);
		layout.putConstraint(SpringLayout.EAST, ydText, -10, SpringLayout.WEST, ydLabel);

		// miles
		layout.putConstraint(SpringLayout.WEST, miText, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, miText, 20, SpringLayout.SOUTH, ydText);
		layout.putConstraint(SpringLayout.EAST, miLabel, -20, SpringLayout.EAST, panel);
		layout.putConstraint(SpringLayout.NORTH, miLabel, 25, SpringLayout.SOUTH, ydLabel);
		layout.putConstraint(SpringLayout.EAST, miText, -10, SpringLayout.WEST, miLabel);

		return scrollPane;
	}
}
