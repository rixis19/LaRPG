package engines;

import containers.StageContainer;
import main.Game;
import stages.MagicCave;
import stages.Stage;

public class StageSelectEngine 
{

	public Stage currentStage = new MagicCave();
	public StageContainer stgContainer = new StageContainer();
	
	public StageSelectEngine(Stage stg)
	{
		currentStage = stg;
	}
	
	public void setStage(String label)
	{
		if(label!=null)
		{
			currentStage = stgContainer.getStage(label);
		}
	}
	
	public Stage getCurrentStage()
	{
		return currentStage;
	}
	
	public String toString()
	{
		return "Current Stage: "+currentStage.getName();
	}
	
	public void playSong()
	{
		Game.INSTANCE.musicContainer.playSong(currentStage.getSongName());
	}
	
	public void stopSong()
	{
		Game.INSTANCE.musicContainer.stopSong();
	}
	
	public void restartSong()
	{
		Game.INSTANCE.musicContainer.restartSong();
	}
}
