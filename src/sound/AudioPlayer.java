package sound;
/**
 * A thread wrapper for the sound player.
 * @author Fitz
 *
 */
public class AudioPlayer extends Thread {
	
	private String Path;
	private Boolean Loop;
	
	public AudioPlayer(String path, boolean loop)
	{
		Path = path;
		Loop = loop;
	}
	
	public void run()
	{
		 AudioPlayerListener player = new AudioPlayerListener();
		 player.play(Path, Loop);
	}
	
	public void startSound()
	{
		this.start();
	}
	
	public void stopSound()
	{
		this.interrupt();
	}
}
