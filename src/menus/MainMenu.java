package menus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import containers.StageContainer;
import main.Game;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	
	JLabel menuBackground = new JLabel();
	JButton gameStart = new JButton("Start Game");
	JButton gameOptions = new JButton("Options");
	JButton gameExit = new JButton("Exit");
	StageContainer stgContainer = new StageContainer();
	
	public MainMenu()
	{
		gameStart.addActionListener(new goToCharacterSelect());
		gameExit.addActionListener(new exit());
		gameOptions.addActionListener(new optionsMenu());
		this.add(gameStart);
	    this.add(gameOptions);
	    this.add(gameExit);
	    this.add(menuBackground);
	    
	    menuBackground.setLayout(new GridBagLayout());
		menuBackground.add(gameStart, new GridBagConstraints());
		menuBackground.add(gameOptions, new GridBagConstraints());
		menuBackground.add(gameExit, new GridBagConstraints());
	    this.add(menuBackground);
	    this.setVisible(true);
	    menuBackground.setVisible(true);
	    
	    menuBackground.setIcon(stgContainer.getRandomStage());
	}

	class goToCharacterSelect implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.mnMu.setVisible(false);
			Game.INSTANCE.chrSel.setVisible(true);
			
			Game.INSTANCE.add(Game.INSTANCE.chrSel);
		}
	}
	
	class optionsMenu implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.mainOptMenu.setVisible(true);
			Game.INSTANCE.mnMu.setVisible(false);
			
			Game.INSTANCE.add(Game.INSTANCE.mainOptMenu);
		}
	} 
	
	class exit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			System.exit(0);
		}
	}
}
