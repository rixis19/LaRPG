package containers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JSlider;


public class MusicContainer
{
	JSlider musicVolSlider = new JSlider();
	public AudioInputStream audioIn;
	public Clip clip;
	public File file;
	
	private Map<String, File> map;
	private Map<String, Integer> startMap;
	private Map<String, Integer> endMap;
	
	public MusicContainer() //creates hashmap
	{
		map = new HashMap<String, File>();
		songLibrary();
	}

	public void addSong(String name, String fileName) {
		file = new File("./src/resources/music/"+fileName);
		map.put(name,file);
	}
	
	public void addSong(String name, String fileName, int startLoop, int endLoop) {
		file = new File("./src/resources/music/"+fileName);
		map.put(name,file);
		startMap.put(name,startLoop);
		endMap.put(name,endLoop);
	}
	
	public void songLibrary()
	{
	    this.addSong("Blooming Villain", "bloomingVillain.wav");
		this.addSong("Undersea Palace", "underseaPalace.wav");
		this.addSong("Jesus H Macy", "jesusHMacy.wav");
		this.addSong("Strawberry Swisher", "strawberrySwisher.wav");
		this.addSong("Twister", "twister.wav");
		this.addSong("One Winged Angel", "oneWingedAngel.wav");
		this.addSong("Pounce Bounce", "pounceBounce.wav");
		this.addSong("Violent Ography", "violentOgraphy.wav");
		this.addSong("Dark Impetus", "darkImpetus.wav");
		this.addSong("Final Destination", "finalDestination.wav");
	}
	
	@SuppressWarnings("static-access")
	public void playSong(String key)
	{
		try {
			audioIn = AudioSystem.getAudioInputStream(map.get(key));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			System.out.print(clip.getFrameLength());
			clip.loop(clip.LOOP_CONTINUOUSLY);
			
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void stopSong()
	{
		if(clip.isRunning())
		{
			clip.close();
		}
	}
	
	public void restartSong()
	{
		clip.setFramePosition(0);
	}
	
	public float getVolume() {
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	    return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}

	public void setVolume(float volume) {
	    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	    float dB = (float) (Math.log(volume/10) / Math.log(10.0) * 20.0);
	    gainControl.setValue(dB);
	}
	
}
