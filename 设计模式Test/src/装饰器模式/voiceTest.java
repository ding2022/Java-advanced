package 装饰器模式;

//主要用于io流  提高性能 增强功能 
//主要对于 类和类之间的关系
public class voiceTest {
	private int voice=10;

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
	public void say(){
		System.out.println(voice);
	}

}
