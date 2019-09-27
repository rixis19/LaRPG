package stages;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import containers.ImageContainer;

public abstract class Stage {
	
	protected ImageContainer imgContainer = new ImageContainer();
	protected ImageIcon stage;
	protected ImageIcon stagePortrait;
	protected String stageName;
	protected String songName;
	
	public Stage()
	{
		stageName = "dummy";
	}
	
	public Stage(String stgName, String stage, String stgPortrait) 
	{
		stageName = stgName;
		this.stage = imgContainer.getIcon(stage);
		this.stagePortrait = imgContainer.getIcon(stgPortrait);
	}
	
	public Stage(String stgName, String stage, String stgPortrait, String songFile) 
	{
		stageName = stgName;
		this.stage = imgContainer.getIcon(stage);
		this.stagePortrait = imgContainer.getIcon(stgPortrait);
		this.stagePortrait = imgContainer.getIcon(stgPortrait);
		this.songName = songFile;
	}
	
	public ImageIcon getPortrait()
	{
		return stagePortrait;
	}
	
	public ImageIcon getStage()
	{
		return stage;
	}
	
	public String getName()
	{
		return stageName;
	}
	
	public String getSongName()
	{
		return songName;
	}
	
	public JLabel getLabel()
	{
		JLabel stg = new JLabel();
		ImageIcon ico = this.getPortrait();
		stg.setIcon(ico);
		stg.setText(this.getName());
		return stg;
	}
	
	public JLabel getStageLabel()
	{
		JLabel stg = new JLabel();
		ImageIcon ico = this.getStage();
		stg.setIcon(ico);
		stg.setText(this.getName());
		return stg;
	}

}

