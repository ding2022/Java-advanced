/*package WangYi;
import javax.media.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class music implements ControllerListener {// ControllerListener
              // �����¼�
 private Player player;

 private boolean first, loop;

 private String path;
 private List mp3List;
 private int mp3NO = 0;
 
 music(List mp3List) {
  this.mp3List = mp3List;
 }

 public void start() {
  try {
   player = Manager.createPlayer(new MediaLocator("file://" + mp3List.get(mp3NO)));
  } catch (NoPlayerException ex) {
   ex.printStackTrace();
   System.out.println("���ܲ����ļ�");
   return;
  } catch (IOException ex) {
   ex.printStackTrace();
   return;
  }
  if (player == null) {
   System.out.println("������Ϊ��");
   return;
  }

  first = false;
  player.addControllerListener(this);
  // ��ȡý������
  player.prefetch();

 }

public void controllerUpdate(ControllerEvent e) {
  // ��ý�岥�Ž���ʱ,ѭ������
  if (e instanceof EndOfMediaEvent) {
   mp3NO++;
   if(mp3NO<this.mp3List.size()){
    this.start();
   }
   return;
  }

  // ��Ԥ��ȡý������ݽ���
  if (e instanceof PrefetchCompleteEvent) {
   player.start();
   return;
  }
  // ��ʵ������
  if (e instanceof RealizeCompleteEvent) {
   // pack(); //ִ��pack()����
   return;
  }

 }
 public static void main(String[] args) {
  List mp3List = new ArrayList();
  mp3List.add("d://a.mp3");
  mp3List.add("d://b.mp3");
  mp3List.add("d://c.mp3");
  PlayerMusic pm = new PlayerMusic(mp3List);
  pm.start();
 }
}*/