package fr.blackbalrog;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.blackbalrog.change.Font;

@SuppressWarnings("serial")
public class GPanel extends JPanel implements ActionListener
{

	private JLabel labelText = new JLabel("Texte:");
	private JLabel labelFontText = new JLabel("Texte modifier:");
	
	private JTextPane paneText = new JTextPane();
	private JTextPane paneFontText = new JTextPane();
	
	private JButton buttonCopy = new JButton("Copier");
	
	public GPanel()
	{
		this.setLayout(null);
		this.setBackground(new Color(46, 64, 83));
		
		this.add(labelText);
		labelText.setBounds(40, 20, 100, 20);
		labelText.setForeground(new Color(64, 93, 106));
		
		this.add(labelFontText);
		labelFontText.setBounds(40, 130, 100, 20);
		labelFontText.setForeground(new Color(64, 93, 106));
		
		this.add(paneText);
		paneText.setBounds(40, 40, 400, 50);
		paneText.setBorder(new MatteBorder(1, 1, 1, 1, new Color(64, 93, 106)));
		paneText.setCaretColor(new Color(96, 129, 162));
		paneText.setForeground(new Color(96, 129, 162));
		paneText.setBackground(new Color(52, 73, 94));
		paneText.setSelectionColor(new Color(0, 0, 0, 0));
		paneText.setSelectedTextColor(new Color(122, 141, 205));
		
		paneText.getDocument().addDocumentListener(new DocumentListener()
		{
			
			@Override
			public void removeUpdate(DocumentEvent event)
			{
				paneFontText.setText(Font.setMessage(paneText.getText()));
			}
			
			@Override
			public void insertUpdate(DocumentEvent event)
			{
				paneFontText.setText(Font.setMessage(paneText.getText()));
			}
			
			@Override
			public void changedUpdate(DocumentEvent event)
			{
				paneFontText.setText(Font.setMessage(paneText.getText()));
			}
		});
		
		paneText.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				super.mouseClicked(event);
				labelText.setForeground(new Color(93, 127, 240));
				labelFontText.setForeground(new Color(64, 93, 106));
				paneText.setBorder(new MatteBorder(1, 1, 1, 1, new Color(93, 127, 240)));
				paneFontText.setBorder(new MatteBorder(1, 1, 1, 1, new Color(64, 93, 106)));
			}
		});
		
		this.add(paneFontText);
		paneFontText.setBounds(40, 150, 400, 50);
		paneFontText.setBorder(new MatteBorder(1, 1, 1, 1, new Color(64, 93, 106)));
		paneFontText.setCaretColor(new Color(219, 132, 33));
		paneFontText.setForeground(new Color(219, 132, 33));
		paneFontText.setBackground(new Color(52, 73, 94));
		paneFontText.setSelectionColor(new Color(0, 0, 0, 0));
		paneFontText.setSelectedTextColor(new Color(248, 196, 113));
		
		paneFontText.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				super.mouseClicked(event);
				labelFontText.setForeground(new Color(93, 127, 240));
				labelText.setForeground(new Color(64, 93, 106));
				paneFontText.setBorder(new MatteBorder(1, 1, 1, 1, new Color(93, 127, 240)));
				paneText.setBorder(new MatteBorder(1, 1, 1, 1, new Color(64, 93, 106)));
			}
		});
		paneFontText.setEditable(false);
		
		
		this.add(buttonCopy);
		buttonCopy.setBounds(340, 220, 100, 25);
		buttonCopy.setBackground(new Color(0, 0, 0, 0));
		buttonCopy.setForeground(new Color(64, 93, 106));
		buttonCopy.setContentAreaFilled(false);
		buttonCopy.setOpaque(true);
		buttonCopy.setBorder(new MatteBorder(1, 1, 1, 1, new Color(64, 93, 106)));
		buttonCopy.setFocusPainted(false);
		buttonCopy.setOpaque(false);
		
		buttonCopy.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent event)
			{
				super.mouseEntered(event);
				buttonCopy.setForeground(new Color(93, 127, 240));
				buttonCopy.setBorder(new MatteBorder(1, 1, 1, 1, new Color(93, 127, 240)));
			}
			
			@Override
			public void mouseExited(MouseEvent event)
			{
				super.mouseExited(event);
				buttonCopy.setForeground(new Color(64, 93, 106));
				buttonCopy.setBorder(new MatteBorder(1, 1, 1, 1, new Color(64, 93, 106)));
			}	
		});
		buttonCopy.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == buttonCopy)
		{
			StringSelection selection = new StringSelection(paneFontText.getText());
			Clipboard pressePapier = Toolkit.getDefaultToolkit().getSystemClipboard();
			pressePapier.setContents(selection, selection);
		}
	}
}
