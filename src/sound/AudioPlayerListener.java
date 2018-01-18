package sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 * This is an example program that demonstrates how to play back an audio file
 * using the Clip in Java Sound API.
 * 
 * @author www.codejava.net
 *
 */
public class AudioPlayerListener implements LineListener {

	/**
	 * this flag indicates whether the playback completes or not.
	 */
	boolean playCompleted = false;

	/**
	 * Play a given audio file.
	 * 
	 * @param audioFilePath
	 *            Path of the audio file.
	 */
	void play(String audioFilePath, boolean loop) {
		File audioFile = new File(audioFilePath);
		Clip audioClip = null;
		try {
			try {
				AudioInputStream audioStream = AudioSystem
						.getAudioInputStream(audioFile);

				AudioFormat format = audioStream.getFormat();

				DataLine.Info info = new DataLine.Info(Clip.class, format);

				audioClip = (Clip) AudioSystem.getLine(info);

				audioClip.addLineListener(this);

				audioClip.open(audioStream);

				audioClip.start();
				try {
					do {
						while (!playCompleted) {
							// wait for the playback completes

							Thread.sleep(1000);
						}
					} while (loop);
				} catch (InterruptedException ex) {
					// ex.printStackTrace();
					audioClip.stop();
				}
				audioClip.close();

			} catch (UnsupportedAudioFileException ex) {
				System.out
						.println("The specified audio file is not supported.");
				ex.printStackTrace();
			} catch (LineUnavailableException ex) {
				System.out
						.println("Audio line for playing back is unavailable.");
				ex.printStackTrace();
			} catch (IOException ex) {
				System.out.println("Error playing the audio file.");
				ex.printStackTrace();
			}
		} finally {
			if (audioClip != null && audioClip.isOpen()) {
				audioClip.close();
			}
		}
	}

	/**
	 * Listens to the START and STOP events of the audio line.
	 */
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();

		if (type == LineEvent.Type.START) {
			System.out.println("Playback started.");

		} else if (type == LineEvent.Type.STOP) {
			playCompleted = true;
			System.out.println("Playback completed.");
		}

	}
}