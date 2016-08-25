package ×°ÊÎÆ÷Ä£Ê½;

public class KuoYinQi {
	private voiceTest voice;
	public KuoYinQi(voiceTest voice){
		super();
		this.voice=voice;
	}
	
	public void say(){
		System.out.println(100*voice.getVoice());
	}

}
