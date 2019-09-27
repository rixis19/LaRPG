package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import containers.CharacterContainer;
import containers.StageContainer;
import main.Game;

@SuppressWarnings("serial")
public class TitleScreen extends JPanel {
	
	private JButton startGame = new JButton("Start Game");
	private JLabel splashBackground = new JLabel();
	private JLabel title = new JLabel("LaRPG");
	private JPanel chrList = new JPanel();
	private CharacterContainer chrContainer = new CharacterContainer();
	private StageContainer stgContainer = new StageContainer();
	
	public TitleScreen()
	{
		startGame.addActionListener(new goToMainMenu());
		
		GridLayout chrLayout = new GridLayout(1,12, 5, 0);
		chrList.setOpaque(false);
		
		int i = 0;
		for (int row = 0; row < 7; row++)
		{
            	JLabel chr = chrContainer.getSprite(i);
            	chr.setText("");
            	chrList.add(chr).setLocation(1, row);
            	i++;
        }

		chrList.setLayout(chrLayout);
		title.setVisible(true);
		title.setFont(new Font("Times New Roman", 1, 60));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
		GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(85, 85)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(startGame))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(chrList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(startGame)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(chrList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        
        splashBackground.setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.add(splashBackground);
	    splashBackground.setIcon(stgContainer.getRandomStage());
	}
	
	class goToMainMenu implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.start();
			Game.INSTANCE.tleScn.setVisible(false);
			Game.INSTANCE.mnMu.setVisible(true);
			
			Game.INSTANCE.add(Game.INSTANCE.mnMu);
		}
	}

}
