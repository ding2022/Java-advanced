package test;

import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class T2 {
	ImageIO imageIO=null;
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		VideoCapture capture=new VideoCapture();
		capture.open(1);
		Mat frame=new Mat();
		ByteArrayInputStream inputStream=null;
		ImageWriter writer=null;
		if(capture.isOpened()){
			capture.read(frame);
			Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
			MatOfByte buffer=new MatOfByte();
			Imgcodecs.imencode(".png", frame, buffer);
			inputStream=new ByteArrayInputStream(buffer.toArray());
		
		}
	}
	
	
	
}
