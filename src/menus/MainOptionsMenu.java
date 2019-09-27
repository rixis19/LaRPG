package menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import containers.ImageContainer;
import containers.StageContainer;
import main.Game;

@SuppressWarnings("serial")
public class MainOptionsMenu extends JPanel {
	
	String[] chrRoster = { "Default", "CSTSF" };
	
	private JLabel optBackground = new JLabel();
	private JLabel chrRosterLabel = new JLabel("Character Roster");
    private JComboBox<String> jComboBox1 = new JComboBox<>(chrRoster);
    private JLabel masterVolLabel = new JLabel("Master Volume");
    private JSlider masterVolSlider = new JSlider();
    private JLabel musicVolLabel = new JLabel("Music Volume");
    private JSlider musicVolSlider = new JSlider();
    private JLabel sfxVolLabel = new JLabel("SFX Volume");
    private JSlider sfxVolSlider = new JSlider();
    private JButton back = new JButton("Back");
    private JLabel optsMenuBack = new JLabel();
     
    private StageContainer stgContainer = new StageContainer();
    private ImageContainer imageContainer = new ImageContainer();
    
    private BoundedRangeModel master;
    private BoundedRangeModel music;
    private BoundedRangeModel sfx;
	
	public MainOptionsMenu()
	{
		masterVolLabel.setForeground(Color.WHITE);
		musicVolLabel.setForeground(Color.WHITE);
		sfxVolLabel.setForeground(Color.WHITE);
		chrRosterLabel.setForeground(Color.WHITE);
		back.addActionListener(new goToMainMenu());
		jComboBox1.setEnabled(false);
		music = musicVolSlider.getModel();
		music.setRangeProperties(10, 1, 0, 10, false);
		music.addChangeListener(new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			Game.INSTANCE.musicContainer.setVolume(musicVolSlider.getValue());
		}});
		musicVolSlider = new JSlider(music);
		
		
		sfx = sfxVolSlider.getModel();
		sfx.setRangeProperties(10, 1, 0, 10, false);
		sfx.addChangeListener(new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			Game.INSTANCE.setSFXVolume(sfxVolSlider.getValue());
		}});
		sfxVolSlider = new JSlider(sfx);
		
		
		master = masterVolSlider.getModel();
		master.setRangeProperties(10, 1, 0, 10, false);
		master.addChangeListener(new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			Game.INSTANCE.setMasterVolume(masterVolSlider.getValue());
			sfxVolSlider.setMaximum(masterVolSlider.getValue());
			musicVolSlider.setMaximum(masterVolSlider.getValue());
			sfxVolSlider.setValue(masterVolSlider.getValue());
			musicVolSlider.setValue(masterVolSlider.getValue());
		}});
		masterVolSlider = new JSlider(master);
		
		GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(sfxVolLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(musicVolLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(masterVolLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(chrRosterLabel))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(masterVolSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(musicVolSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sfxVolSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(back)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {chrRosterLabel, masterVolLabel, musicVolLabel, sfxVolLabel});

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jComboBox1, masterVolSlider, musicVolSlider, sfxVolSlider});

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(masterVolSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(masterVolLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(musicVolLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addComponent(musicVolSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(sfxVolLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sfxVolSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(chrRosterLabel, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addGap(42, 42, 42)
                .addComponent(back)
                .addGap(52, 52, 52))
        );

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {chrRosterLabel, masterVolLabel, musicVolLabel, sfxVolLabel});

        layout.linkSize(SwingConstants.VERTICAL, new Component[] {jComboBox1, masterVolSlider, musicVolSlider, sfxVolSlider});

        optsMenuBack.setBounds(55, 95, 400, 200);
        this.add(optsMenuBack);
        optsMenuBack.setIcon(imageContainer.resizeIcon("blackBox", 400, 200));
        
        optBackground.setBounds(0, 0, Game.WIDTH, Game.HEIGHT);
        this.add(optBackground);
        optBackground.setIcon(stgContainer.getRandomStage());
        
        
        
	}
	
	class goToMainMenu implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.INSTANCE.sfxClip.setFramePosition(0);
			Game.INSTANCE.sfxClip.start();
			
			Game.INSTANCE.mainOptMenu.setVisible(false);
			Game.INSTANCE.mnMu.setVisible(true);
		}
	}

}
