package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import containers.ImageContainer;
import main.Game;

@SuppressWarnings("serial")
public class BattleScreen extends JPanel {
	
	private JPanel menu = new JPanel();
	private JTextPane textBox = new JTextPane();
	private JButton attack = new JButton("Attack");
    private JButton combo = new JButton("Combo");
    private JButton defend = new JButton("Defend");
	private JButton item = new JButton("Item");
    private JButton magic = new JButton("Magic");
    private JButton run = new JButton("Run");
    private JButton nextText = new JButton("Continue"); 
    private JButton nextTurn = new JButton("Next Turn"); 
    private JButton endGame = new JButton("End Game");
	private JLabel textBoxImage = new JLabel();
    private JLabel magicBar = new JLabel("Magic");
    private JLabel healthBar = new JLabel("Health");
    private JLabel pOneNPC = new JLabel("");
    private JLabel pTwoNPC = new JLabel("");
    private JLabel nameBar = new JLabel("Player");   
    private JLabel battleBackground = new JLabel();
    private int damage = 0;
    private int pOneHealth;
    private int pTwoHealth; 
    private int pOneComboPoints = 0;
    private int pTwoComboPoints = 0;
    private int pOneItemCap = 0;
    private int pTwoItemCap = 0;
    private String currentPlayer = "Player 2";
    private Random gen = new Random();
    private ImageContainer imageContainer = new ImageContainer();
    private boolean gameFinished = false;
    private boolean gameStart = true;
    private boolean pOneDefend = false;
    private boolean pTwoDefend = false;
	
	public BattleScreen()
	{
		nameBar.setForeground(Color.WHITE);
		healthBar.setForeground(Color.WHITE);
		magicBar.setForeground(Color.WHITE);
		endGame.addActionListener(new endToChrSel());
		nextText.addActionListener(new proceedText());
		nextTurn.addActionListener(new showMenu());
		attack.addActionListener(new attack());
		combo.addActionListener(new combo());
		defend.addActionListener(new defend());
		item.addActionListener(new item());
		magic.addActionListener(new magic());
		
		run.addActionListener(new run());
        
		GroupLayout jPanel1Layout = new GroupLayout(menu);
        menu.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(defend, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(attack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(item, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(run, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(magic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(magicBar, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(healthBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(attack)
                    .addComponent(magic)
                    .addComponent(nameBar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(defend)
                    .addComponent(combo)
                    .addComponent(healthBar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(item)
                    .addComponent(run)
                    .addComponent(magicBar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
        );
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(menu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(menu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        
        nextText.setBounds(400, 330, 100, 30);
        this.add(nextText);
        nextText.setVisible(false);
        nextTurn.setBounds(400, 330, 100, 30);
        this.add(nextTurn);
        nextTurn.setVisible(false);
        endGame.setBounds(400, 330, 100, 30);
        this.add(endGame);
        endGame.setVisible(false);
        
        menu.setOpaque(false);
        
        textBox.setBounds(0, 330, 390, 81);
        textBox.setFont(new Font("Times New Roman", 1, 18));
        this.add(textBox);
        textBox.setVisible(false);
        textBox.setEditable(false);
        textBox.setOpaque(false);
        textBox.setForeground(Color.WHITE);
        
        StyledDocument doc = textBox.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        
        textBoxImage.setBounds(0, 290, Game.WIDTH, 111);
        this.add(textBoxImage);
        textBoxImage.setIcon(imageContainer.resizeIcon("blackBox", Game.WIDTH,111));
        
        
	}
	
	@SuppressWarnings("static-access")
	public void startMatch()
	{
		if(gameFinished)
		{
			endGame.setVisible(false);
			nextText.setVisible(false);
			pOneItemCap = 0;
			pTwoItemCap = 0;
			pOneNPC.setVisible(true);
			pTwoNPC.setVisible(true);
			pOneComboPoints = 0;
			pTwoComboPoints = 0;
			Game.INSTANCE.stgEngine.restartSong();
			currentPlayer = "Player 2";
			gameFinished = false;
			gameStart = true;
		}
		
		Game.INSTANCE.musicContainer.stopSong();
		if(Game.INSTANCE.stgEngine.getCurrentStage().getName().equals("Final Destination"))
		{
			pOneNPC.setIcon(Game.INSTANCE.chrEngine.getPlayerOne().getSprite());
			pOneNPC.setBounds(90, 130, pOneNPC.getIcon().getIconWidth(), pOneNPC.getIcon().getIconHeight());
	        this.add(pOneNPC);
	        
	        pTwoNPC.setIcon(new ImageIcon(imageContainer.horizontalFlip((BufferedImage)Game.INSTANCE.chrEngine.getPlayerTwo().getSprite().getImage())));
			pTwoNPC.setBounds(370, 130, pTwoNPC.getIcon().getIconWidth(), pTwoNPC.getIcon().getIconHeight());
	        this.add(pTwoNPC);
		}
		else
		{
			pOneNPC.setIcon(Game.INSTANCE.chrEngine.getPlayerOne().getSprite());
			pOneNPC.setBounds(50, 185, pOneNPC.getIcon().getIconWidth(), pOneNPC.getIcon().getIconHeight());
			this.add(pOneNPC);
        
			pTwoNPC.setIcon(new ImageIcon(imageContainer.horizontalFlip((BufferedImage)Game.INSTANCE.chrEngine.getPlayerTwo().getSprite().getImage())));
			pTwoNPC.setBounds(380, 180, pTwoNPC.getIcon().getIconWidth(), pTwoNPC.getIcon().getIconHeight());
			this.add(pTwoNPC);
		}
        
        pOneHealth = Game.INSTANCE.chrEngine.getPlayerOne().getHealth();
        pTwoHealth = Game.INSTANCE.chrEngine.getPlayerTwo().getHealth();
        if(Game.INSTANCE.stgEngine.getCurrentStage().getName().equals("Onett"))
        {
        	battleBackground.setBounds(0, -130, Game.WIDTH, Game.HEIGHT);
        	this.add(battleBackground);
        	battleBackground.setIcon(Game.INSTANCE.stgEngine.getCurrentStage().getStage());
        }
        else
        {
        	battleBackground.setBounds(0, 0, Game.WIDTH, Game.HEIGHT-130);
        	this.add(battleBackground);
        	battleBackground.setIcon(Game.INSTANCE.stgEngine.getCurrentStage().getStage());
        }
        
        if(gameStart)
        {
        	textBox.setText("Get ready... Get set... GO!");
        	nextTurn.setText("Begin");
        	pOneComboPoints = 0;
			pTwoComboPoints = 0;
        }
        
        nextText.setVisible(true);
		textBox.setVisible(true);
		menu.setEnabled(false);
		menu.setVisible(false);
		
        Game.INSTANCE.stgEngine.playSong();
        
		validate();
		repaint();
		
		drawTextBoxes();	
	}
	
	public void endMatch()
	{
		nextText.setVisible(false);
		nextTurn.setVisible(false);
		menu.setEnabled(false);
		textBox.setText(currentPlayer + " has won the battle! Congratulations! Click anyhwere to return to the character selection.");
		Game.INSTANCE.stgEngine.stopSong();
		gameFinished = true;
		gameStart = false; //Changed during art show
		endGame.setVisible(true);
	}
	
	public void drawTextBoxes()
	{
		if(currentPlayer.equals("Player 1"))
		{
			nameBar.setText("Player: "+Game.INSTANCE.chrEngine.getPlayerOne().getName());
			magicBar.setText("Combo Points: "+pOneComboPoints);
			healthBar.setText("Health: "+pOneHealth+"/"+Game.INSTANCE.chrEngine.getPlayerOne().getHealth());
		}
		else if(currentPlayer.equals("Player 2"))
		{
			nameBar.setText("Player: "+Game.INSTANCE.chrEngine.getPlayerTwo().getName());
			magicBar.setText("Combo Points: "+pTwoComboPoints);
			healthBar.setText("Health: "+pTwoHealth+"/"+Game.INSTANCE.chrEngine.getPlayerTwo().getHealth());
		}
	}
	
	class endToChrSel implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.batScrn.setVisible(false);
			Game.INSTANCE.chrSel.setVisible(true);
			Game.INSTANCE.chrSel.returnFromMatch();
		}
	}
	
	class run implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.batScrn.setVisible(false);
			Game.INSTANCE.pauseMenu.setVisible(true);
			
			Game.INSTANCE.add(Game.INSTANCE.pauseMenu);
		}
	}
	
	class showMenu implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			drawTextBoxes();
			nextTurn.setText("Next Turn");
			menu.setEnabled(true);
			menu.setVisible(true);
			nextTurn.setVisible(false);
			textBox.setVisible(false);
		}
		
	}
	
	class proceedText implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(currentPlayer.equals("Player 1"))
			{
				if(pTwoHealth<=0)
				{
					pTwoNPC.setVisible(false);
					endMatch();
				}
				else
				{
					System.out.println(currentPlayer);
					textBox.setText("- Player 2's Turn -");
					currentPlayer = "Player 2";
					nextText.setVisible(false);
					nextTurn.setVisible(true);
				}
			}
			else if(currentPlayer.equals("Player 2"))
			{
				if(pOneHealth<=0)
				{
					pOneNPC.setVisible(false);
					endMatch();
				}
				else
				{
					System.out.println(currentPlayer);
					textBox.setText("- Player 1's Turn -");
					currentPlayer = "Player 1";
					nextText.setVisible(false);
					nextTurn.setVisible(true);
				}
			}
			
		}
		
	}
	
	class attack implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setEnabled(false);
			if(currentPlayer.equals("Player 1"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				if(pTwoDefend)
				{
					damage = ((((Game.INSTANCE.chrEngine.getPlayerOne().getAttack() * 5/4)*2) + gen.nextInt(7))/2);
					pTwoDefend = false;
				}
				else if(!pTwoDefend)
				{
					damage = (((Game.INSTANCE.chrEngine.getPlayerOne().getAttack() * 5/4)*2) + gen.nextInt(7));
				}
				
				textBox.setText(Game.INSTANCE.chrEngine.getPlayerOne().getName()+" attacked "+Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" and did "+damage+"!" );
				pTwoHealth = pTwoHealth-damage;
				pOneComboPoints++;
			}
			
			else if(currentPlayer.equals("Player 2"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				if(pOneDefend)
				{
					damage = ((((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack() * 5/4)*2) + gen.nextInt(7))/2);
					pOneDefend = false;
				}
				else if(!pOneDefend)
				{
					damage = (((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack() * 5/4)*2) + gen.nextInt(7));
				}
				
				textBox.setText(Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" attacked "+Game.INSTANCE.chrEngine.getPlayerOne().getName()+" and did "+damage+"!" );
				pOneHealth = pOneHealth-damage;
				pTwoComboPoints++;
			}
		}
	}
	
	class magic implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setEnabled(false);
			if(currentPlayer.equals("Player 1"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				if(pTwoDefend)
				{
					damage = ((((Game.INSTANCE.chrEngine.getPlayerOne().getMagic() * 4/3)) + gen.nextInt(10))/2);
					pTwoDefend = false;
				}
				else if(!pTwoDefend)
				{
					damage = (((Game.INSTANCE.chrEngine.getPlayerOne().getMagic() * 4/3)) + gen.nextInt(10));
				}
				
				textBox.setText(Game.INSTANCE.chrEngine.getPlayerOne().getName()+" used magic against "+Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" and did "+damage+"!" );
				pTwoHealth = pTwoHealth-damage;
				pOneComboPoints++;
			}
			
			else if(currentPlayer.equals("Player 2"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				if(pOneDefend)
				{
					damage = ((((Game.INSTANCE.chrEngine.getPlayerTwo().getMagic() * 4/3)) + gen.nextInt(10))/2);
					pOneDefend = false;
				}
				else if(!pOneDefend)
				{
					damage = (((Game.INSTANCE.chrEngine.getPlayerTwo().getMagic() * 4/3)) + gen.nextInt(10));
				}
				
				textBox.setText(Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" used magic against "+Game.INSTANCE.chrEngine.getPlayerOne().getName()+" and did "+damage+"!" );
				pOneHealth = pOneHealth-damage;
				pTwoComboPoints++;
			}
		}
	}
	
	class item implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setEnabled(false);
			if(currentPlayer.equals("Player 1"))
			{	
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				pTwoDefend = false;
				if(pOneItemCap>=3)
				{
					textBox.setText("You don't have any more items!");
				}
				else
				{
					pOneItemCap++;
					textBox.setText(Game.INSTANCE.chrEngine.getPlayerOne().getName()+" used a item and regained 30 health!");
					pOneHealth = pOneHealth+30;
					if(pOneHealth>Game.INSTANCE.chrEngine.getPlayerOne().getHealth())
					{
						pOneHealth = Game.INSTANCE.chrEngine.getPlayerOne().getHealth();
					}
				}
			}
			else if(currentPlayer.equals("Player 2"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				pOneDefend = false;
				if(pTwoItemCap>=3)
				{
					textBox.setText("You don't have any more items!");
				}
				else
				{
					pTwoItemCap++;
					textBox.setText(Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" used a item and regained 30 health!");
					pTwoHealth = pTwoHealth+30;
					if(pTwoHealth>Game.INSTANCE.chrEngine.getPlayerTwo().getHealth())
					{
						pTwoHealth = Game.INSTANCE.chrEngine.getPlayerTwo().getHealth();
					}
				}
			}
		}
	}
	
	class combo implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setEnabled(false);
			if(currentPlayer.equals("Player 1"))
			{	
				if(pOneComboPoints>=3)
				{
					nextText.setVisible(true);
					menu.setVisible(false);
					textBox.setVisible(true);
					if(pTwoDefend)
					{
						damage = ((((Game.INSTANCE.chrEngine.getPlayerOne().getAttack())) + gen.nextInt(4) 
							+ ((Game.INSTANCE.chrEngine.getPlayerOne().getAttack())) + gen.nextInt(4) 
							+ ((Game.INSTANCE.chrEngine.getPlayerOne().getAttack())) + gen.nextInt(4))/2);
						pTwoDefend = false;
					}
					else if(!pTwoDefend)
					{
						damage = ((((Game.INSTANCE.chrEngine.getPlayerOne().getAttack())) + gen.nextInt(4) 
							+ ((Game.INSTANCE.chrEngine.getPlayerOne().getAttack())) + gen.nextInt(4)
							+ ((Game.INSTANCE.chrEngine.getPlayerOne().getAttack())) + gen.nextInt(4)));
						
					}
					textBox.setText(Game.INSTANCE.chrEngine.getPlayerOne().getName()+" attacked "+Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" 3 times to do a combined "+damage+" damage!" );
					pTwoHealth = pTwoHealth-damage;
					pOneComboPoints=0;
				}
				else
				{
					nextTurn.setText("Back");
					nextTurn.setVisible(true);
					menu.setVisible(false);
					textBox.setVisible(true);
					textBox.setText("You need 3 combo points for this move!");
				}
			}
			
			
			else if(currentPlayer.equals("Player 2"))
			{
				if(pTwoComboPoints>=3)
				{
					nextText.setVisible(true);
					menu.setVisible(false);
					textBox.setVisible(true);
					
					if(pOneDefend)
					{
						damage = ((((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack())) + gen.nextInt(4)
							+ ((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack())) + gen.nextInt(4)
							+ ((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack())) + gen.nextInt(4))/2);
						pOneDefend = false;
					}
					else if(!pOneDefend)
					{
						damage = (((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack())) + gen.nextInt(4)
							+ ((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack())) + gen.nextInt(4)
							+ ((Game.INSTANCE.chrEngine.getPlayerTwo().getAttack())) + gen.nextInt(4));						
					}
					
					textBox.setText(Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" attacked "+Game.INSTANCE.chrEngine.getPlayerTwo().getName()+" 3 times to do a combined "+damage+" damage!" );
					pOneHealth = pOneHealth-damage;
					pTwoComboPoints=0;
				}
				else
				{
					nextTurn.setText("Back");
					nextTurn.setVisible(true);
					menu.setVisible(false);
					textBox.setVisible(true);
					textBox.setText("You need 3 combo points for this move!");
				}
			}
		}
	}
	
	class defend implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			menu.setEnabled(false);
			if(currentPlayer.equals("Player 1"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				textBox.setText(Game.INSTANCE.chrEngine.getPlayerOne().getName()+" put their guard up!" );
				pOneDefend = true;
				
			}
			
			if(currentPlayer.equals("Player 2"))
			{
				nextText.setVisible(true);
				menu.setVisible(false);
				textBox.setVisible(true);
				textBox.setText(Game.INSTANCE.chrEngine.getPlayerOne().getName()+" put their guard up!" );
				pTwoDefend = true;
			}
		}
	}
	
}