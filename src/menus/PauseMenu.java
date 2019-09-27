package menus;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import containers.ImageContainer;
import main.Game;

@SuppressWarnings("serial")
public class PauseMenu extends JPanel{
	
	JButton resume = new JButton("Resume");
    JButton options = new JButton("Options");
    JButton endMatch = new JButton("End Match");
    JLabel pauseBackground = new JLabel();
    
    private ImageContainer imageContainer = new ImageContainer();
	
	public PauseMenu()
	{
        resume.addActionListener(new resumeGame());
        options.addActionListener(new optionsMenu());
        endMatch.addActionListener(new endMatch());
        

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(endMatch)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(options, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resume, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(201, 201, 201))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {endMatch, options, resume});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(resume)
                .addGap(42, 42, 42)
                .addComponent(options)
                .addGap(44, 44, 44)
                .addComponent(endMatch)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {endMatch, options, resume});
        
        pauseBackground.setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.add(pauseBackground);
        pauseBackground.setIcon(imageContainer.getIcon("magicCave"));
	    

	}
	
	class SpaceKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent event) {
			if (event.getKeyCode() == 49) {
				
				Game.INSTANCE.batScrn.setVisible(true);
				Game.INSTANCE.pauseMenu.setVisible(false);	
			}
		}
	}
	
	class resumeGame implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.batScrn.setVisible(true);
			Game.INSTANCE.pauseMenu.setVisible(false);
		}
	}
	
	class optionsMenu implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.optMenu.setVisible(true);
			Game.INSTANCE.pauseMenu.setVisible(false);
			
			Game.INSTANCE.add(Game.INSTANCE.optMenu);
		}
	} 
	
	class endMatch implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);;
			Game.INSTANCE.sfxClip.start();
			Game.INSTANCE.musicContainer.stopSong();
			Game.INSTANCE.chrSel.returnFromMatch();
			
			Game.INSTANCE.chrSel.setVisible(true);
			Game.INSTANCE.pauseMenu.setVisible(false);
		}
	}
	

}
