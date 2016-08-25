package 基础习题;/*銆愮▼搴�28銆� 
棰樼洰锛氬10涓暟杩涜鎺掑簭 
*/
enum Color {  
	qer ,qewr,qer2,qwer,erqe,r,wer
	}
public class T28 {

	public static void main(String[] args) {
		int[] a={123,134,1324,1234,543,6734,1324,13489,15834,3479};
		int num=a.length;
		for(int i=0;i<num;i++)
			for(int j=i;j<num;j++){
				if(a[j]<=a[i]){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			}
		for(int i=0;i<num;i++){
			System.out.println(a[i]);
		}
	}
	
}
