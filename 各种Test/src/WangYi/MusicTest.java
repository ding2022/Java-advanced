package WangYi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicTest {
	public static final String MUSIC_FILE = "���һЦ.wav";

	public static void main(String[] args) throws LineUnavailableException,
			UnsupportedAudioFileException, IOException {
		// ��ȡ��Ƶ������
		FileInputStream fis=new FileInputStream(new File(MUSIC_FILE));
		AudioInputStream audioInputStream = AudioSystem
				.getAudioInputStream(fis);
		// ��ȡ��Ƶ�������
		AudioFormat audioFormat = audioInputStream.getFormat();
		// ������������
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
				audioFormat, AudioSystem.NOT_SPECIFIED);
		SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem
				.getLine(dataLineInfo);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start();
		/*
		 * ���������ж�ȡ���ݷ��͵�������
		 */
		int count;
		byte tempBuffer[] = new byte[1024];
		while ((count = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
			if (count > 0) {
				sourceDataLine.write(tempBuffer, 0, count);
			}
		}
		// ������ݻ���,���ر�����
		sourceDataLine.drain();
		sourceDataLine.close();
	}
}
