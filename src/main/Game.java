package main;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import containers.ImageContainer;
import containers.MusicContainer;
import engines.CharacterSelectEngine;
import engines.StageSelectEngine;
import entities.Crono;
import menus.*;
import stages.MagicCave;

@SuppressWarnings("serial")
public class Game extends JFrame
{
	public static final String  TITLE  = "LaRPG";
	public static final int WIDTH = 512;
	public static final int HEIGHT = 422;
	
	public AudioInputStream audioIn;
	public Clip clip;
	
	public AudioInputStream sfx;
	public Clip sfxClip;
	
	public TitleScreen tleScn = new TitleScreen();
	public MainMenu mnMu = new MainMenu();
	public CharacterSelection chrSel = new CharacterSelection();
	public MainOptionsMenu mainOptMenu = new MainOptionsMenu();
	public OptionsMenu optMenu = new OptionsMenu();
	public BattleScreen batScrn = new BattleScreen();
	public PauseMenu pauseMenu = new PauseMenu();
	public StageSelection stageMenu = new StageSelection();
	
	public CharacterSelectEngine chrEngine = new CharacterSelectEngine(new Crono());
	public StageSelectEngine stgEngine = new StageSelectEngine(new MagicCave());
	public ImageContainer imageContainer = new ImageContainer();
	public MusicContainer musicContainer = new MusicContainer();
	public ArrayList<Image> icons = new ArrayList<Image>();
	
	public static Game INSTANCE;
	
	public Game() throws IOException, LineUnavailableException, UnsupportedAudioFileException
	{
		icons.add(imageContainer.getImage("Lara Icon")); 
		icons.add(imageContainer.resizeImage("Lara Icon", 32,32));
		icons.add(imageContainer.resizeImage("Lara Icon", 64, 64));
		icons.add(imageContainer.resizeImage("Lara Icon", 128, 128));
		this.setIconImages(icons);
		this.setBounds(0, 0, WIDTH, HEIGHT);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setFocusable(true);
	     
	    this.add(tleScn);
	    tleScn.setVisible(true);
	    
	    INSTANCE= this;
	    
	    musicContainer.playSong("Jesus H Macy");
	    
	    try {
	    // Open an audio input stream.
	    File file = new File("./src/resources/sfx/confirm.wav");
	    sfx = AudioSystem.getAudioInputStream(file);
	    // Get a sound clip resource.
	    sfxClip = AudioSystem.getClip();
	    // Open audio clip and load samples from the audio input stream.
	    sfxClip.open(sfx);
		} catch (UnsupportedAudioFileException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } catch (LineUnavailableException e) {
	    	e.printStackTrace();
	    } 
	}
	
	public float getSFXVolume() {
	    FloatControl gainControl = (FloatControl) sfxClip.getControl(FloatControl.Type.MASTER_GAIN);        
	    return (float) Math.pow(10f, gainControl.getValue() / 20f);
	}

	public void setSFXVolume(float volume) {
	    FloatControl gainControl = (FloatControl) sfxClip.getControl(FloatControl.Type.MASTER_GAIN);        
	    float dB = (float) (Math.log(volume/10) / Math.log(10.0) * 20.0);
	    gainControl.setValue(dB);
	}
	
	public void setMasterVolume(float volume) {
		musicContainer.setVolume(volume);
	    setSFXVolume(volume);
	    
	}
}
