package menus;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import containers.ImageContainer;
import containers.StageContainer;
import main.Game;

@SuppressWarnings("serial")
public class StageSelection extends JPanel
{
	private ImageContainer imageContainer = new ImageContainer();
	private StageContainer stgContainer = new StageContainer();
	private JLabel selectBackground = new JLabel();
	public JButton back = new JButton("<- Back");
	public JButton readyToFight = new JButton("Go To Battle ->");
    public JLabel stgSelectBar = new JLabel("Choose the Stage!");
    public JPanel stgList = new JPanel();
    public JLabel stgName = new JLabel();
    public JLabel stgPreview = new JLabel();
    public JLabel stgListBack = new JLabel();
    public String selectedStg;
	
	public StageSelection()
	{
		back.addActionListener(new goBackToMenu());
		readyToFight.addActionListener(new goToBattle());
		readyToFight.setEnabled(false);
		
		GridLayout stgLayout = new GridLayout(3,3, 7, 15);
		stgList.setOpaque(false);
		
		int i = 0;
		for (int row = 0; row < 3; row++)
		{
            for (int col = 0; col < 3; col++)
            {
            	JLabel stg = stgContainer.getLabel(i);
            	stg.setHorizontalAlignment(JLabel.CENTER);
            	stg.setVerticalAlignment(JLabel.CENTER);
            	stg.setHorizontalTextPosition(JLabel.CENTER);
            	stg.setVerticalTextPosition(JLabel.BOTTOM);
            	stg.setForeground(Color.WHITE);
            	stgList.add(stg).setLocation(row, col);
            	stg.addMouseListener(new selectStage());
            	stg.setVisible(true);
            	i++;
            }
        }
		
		stgList.setLayout(stgLayout);
		
		 GroupLayout layout = new GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(back)
	                        .addGap(18, 18, 18)
	                        .addComponent(stgSelectBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGap(18, 18, 18)
	                        .addComponent(readyToFight))
	                    .addGroup(layout.createSequentialGroup()
	                    	.addGap(0, 18, Short.MAX_VALUE)
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(stgPreview)
	                            .addComponent(stgName, 130, 130, 130))
	                        .addGap(1, 1, 1)
	                        .addComponent(stgList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(back)
	                    .addComponent(readyToFight)
	                    .addComponent(stgSelectBar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                        .addGap(18, 18, 18)
	                        .addComponent(stgList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
	                        .addGap(35, 35, 35)
	                        .addComponent(stgPreview, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(stgName, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(21, Short.MAX_VALUE))
	        );
        
        stgListBack.setBounds(10, 40, 495, 315);
        this.add(stgListBack);
        stgListBack.setIcon(imageContainer.resizeIcon("blackBox", 495, 315));
        
        selectBackground.setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.add(selectBackground);
	    selectBackground.setIcon(stgContainer.getRandomStage());
	    stgName.setForeground(Color.WHITE);
	    
	}
	
	class selectStage implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			stgPreview.setIcon(((JLabel) e.getSource()).getIcon());
			stgName.setText(((JLabel) e.getSource()).getText());
			System.out.println(((JLabel) e.getSource()).getName());
			readyToFight.setEnabled(true);
			selectedStg = (((JLabel) e.getSource()).getText());
			Game.INSTANCE.stgEngine.setStage(selectedStg);
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {} 
		
	}
	
	class goBackToMenu implements ActionListener
	{ 
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.stageMenu.setVisible(false);
			Game.INSTANCE.chrSel.setVisible(true);
		}
	}
	
	class goToBattle implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.stageMenu.setVisible(false);
			Game.INSTANCE.batScrn.setVisible(true);
			Game.INSTANCE.add(Game.INSTANCE.batScrn);	
			
			Game.INSTANCE.batScrn.startMatch();
			
		}
	}
	
}
