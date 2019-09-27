package menus;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import containers.CharacterContainer;
import containers.ImageContainer;
import containers.StageContainer;
import main.Game;

@SuppressWarnings("serial")
public class CharacterSelection extends JPanel {
	
	private CharacterContainer chrContainer = new CharacterContainer();
	private ImageContainer imageContainer = new ImageContainer();
	private StageContainer stgContainer = new StageContainer();
	private JPanel chrList = new JPanel();
	private JLabel charSelectBar = new JLabel("Choose your Character!");
	private JLabel selectBackground = new JLabel();
	private JLabel charSelectPlayer1 = new JLabel(" ");
    private JLabel charSelectPlayer2 = new JLabel(" ");
    private JLabel charSelectPlayer3 = new JLabel();
    private JLabel charSelectPlayer4 = new JLabel();
    private JLabel chrListBack = new JLabel();
	private JButton charSelectBack = new JButton("<-Back");
    private JButton readyToFight = new JButton("Ready To Fight ->");
    private JLabel versus = new JLabel("vs.");
    private JLabel charSelOneName = new JLabel();
    private JLabel charSelTwoName = new JLabel();
    private JComboBox<String> jComboBox2 = new JComboBox<>();
    private String selectedChar;
    private String playerSelection = "null";
    private JButton pkChrOne = new JButton("Player 1");
    private JButton pkChrTwo = new JButton("Player 2");
 
	public CharacterSelection() throws IOException
	{
		jComboBox2.setEnabled(false);
		charSelectBack.addActionListener(new goBackToMenu());
		readyToFight.addActionListener(new goToBattle());
		pkChrOne.addActionListener(new selectPlayer());
		pkChrTwo.addActionListener(new selectPlayer());
		readyToFight.setEnabled(false);
		
		GridLayout layout = new GridLayout(2,6, 10, 7);
		chrList.setOpaque(false);
		
		int i = 0;
		for (int row = 0; row < 2; row++)
		{
            for (int col = 0; col < 6; col++)
            {
            	JLabel chr = chrContainer.getLabel(i);
            	chr.setHorizontalTextPosition(JLabel.CENTER);
            	chr.setVerticalTextPosition(JLabel.BOTTOM);
            	chr.setForeground(Color.WHITE);
            	chrList.add(chr).setLocation(row, col);
            	chr.addMouseListener(new selectChar());
            	i++;
            }
        }
		
		chrList.setEnabled(false);
		chrList.setLayout(layout);
		
		DefaultComboBoxModel<String> slotTwo = new DefaultComboBoxModel<>(new String[] { "CPU 1", "Player 2" });
        jComboBox2.setModel(slotTwo);

        charSelectBar.setHorizontalAlignment(SwingConstants.CENTER);
        charSelectBar.setForeground(Color.WHITE);
        versus.setHorizontalAlignment(SwingConstants.CENTER);
        versus.setForeground(Color.WHITE);
        charSelOneName.setHorizontalAlignment(SwingConstants.CENTER);
        charSelOneName.setForeground(Color.WHITE);
        charSelTwoName.setHorizontalAlignment(SwingConstants.CENTER);
        charSelTwoName.setForeground(Color.WHITE);
//       
        GroupLayout this1Layout = new GroupLayout(this);
        this.setLayout(this1Layout);
        this1Layout.setHorizontalGroup(
            this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(this1Layout.createSequentialGroup()
                .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(this1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(chrList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(this1Layout.createSequentialGroup()
                                .addComponent(charSelectBack)
                                .addGap(24, 24, 24)
                                .addComponent(charSelectBar, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(readyToFight))))
                    .addGroup(this1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pkChrOne)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(charSelectPlayer1, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(charSelOneName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(versus, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(this1Layout.createSequentialGroup()
                                .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(charSelectPlayer2, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(charSelTwoName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(pkChrTwo))
                            .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        this1Layout.setVerticalGroup(
            this1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, this1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(charSelectBack)
                    .addComponent(charSelectBar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(readyToFight))
                .addGap(10, 10, 10)
                .addComponent(chrList, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(charSelectPlayer1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                    .addComponent(charSelectPlayer2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                    .addComponent(versus)
                    .addComponent(pkChrOne)
                    .addComponent(pkChrTwo))
                .addGap(2, 2, 2)
                .addGroup(this1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(charSelOneName)
                    .addComponent(charSelTwoName))
                .addContainerGap())
        );
        
        
		charSelectPlayer1.setIcon(imageContainer.getIcon("charRed"));
		charSelectPlayer2.setIcon(imageContainer.getIcon("charBlue"));
		charSelectPlayer3.setIcon(imageContainer.getIcon("charYellow"));
		charSelectPlayer4.setIcon(imageContainer.getIcon("charGreen"));
		
		chrListBack.setBounds(15, 40, 485, 180);
        this.add(chrListBack);
        chrListBack.setIcon(imageContainer.resizeIcon("blackBox", 485,180));
		
        selectBackground.setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.add(selectBackground);
	    selectBackground.setIcon(stgContainer.getRandomStage());
	    
	   
		 
	}
	
	public void returnFromMatch()
	{
		Game.INSTANCE.musicContainer.playSong("Jesus H Macy");
	}
	
	class goBackToMenu implements ActionListener
	{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.chrSel.setVisible(false);
			Game.INSTANCE.mnMu.setVisible(true);
		}
	}
	
	class goToBattle implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.chrSel.setVisible(false);
			Game.INSTANCE.stageMenu.setVisible(true);
			Game.INSTANCE.add(Game.INSTANCE.stageMenu);	
			
		}
	}
	
	class selectPlayer implements ActionListener
	{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			JButton jb = (JButton)e.getSource();
			playerSelection = (String)jb.getText();
			chrList.setEnabled(true);
		}
	}

	class selectChar implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(!playerSelection.equals("null"))
			{
				if(playerSelection.equals("Player 1"))
				{
					charSelectPlayer1.setIcon(((JLabel) e.getSource()).getIcon());
					charSelOneName.setText(((JLabel) e.getSource()).getName());
					selectedChar = (((JLabel) e.getSource()).getText());
					Game.INSTANCE.chrEngine.setPlayerOne(selectedChar);
					if(!Game.INSTANCE.chrEngine.getPlayerOne().getName().equals("dummy") && !Game.INSTANCE.chrEngine.getPlayerTwo().getName().equals("dummy"))
					{
						readyToFight.setEnabled(true);
					}
				}
				if(playerSelection.equals("Player 2"))
				{
					charSelectPlayer2.setIcon(((JLabel) e.getSource()).getIcon());
					charSelTwoName.setText(((JLabel) e.getSource()).getName());
					selectedChar = (((JLabel) e.getSource()).getText());
					Game.INSTANCE.chrEngine.setPlayerTwo(selectedChar);
					if(!Game.INSTANCE.chrEngine.getPlayerOne().getName().equals("dummy") && !Game.INSTANCE.chrEngine.getPlayerTwo().getName().equals("dummy"))
					{
						readyToFight.setEnabled(true);
					}
				}
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
