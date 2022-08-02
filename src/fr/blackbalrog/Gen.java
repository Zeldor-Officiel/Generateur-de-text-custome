package fr.blackbalrog;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Gen extends JFrame
{
	
	private static Gen instance;
	private GPanel panel;
	public Gen()
	{
		this.setTitle("Generateur de text");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setContentPane(panel = new GPanel());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		instance = new Gen();
	}

	public static Gen getInstance()
	{
		return instance;
	}
}
