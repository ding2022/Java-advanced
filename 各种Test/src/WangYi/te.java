package WangYi;

public class te{
public static void main(String[] args){
        String[][] str = new String[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                str[i][j] = i+""+j;
            }
        }
        int i=0;
        int j=4;
        while(i<5){
            for(int k=0;k<=i;k++){
                System.out.print(str[k][j-i+k]+" ");
            }
            i++;
            System.out.println();
        }
        i=1;
        j=0;
        while(i<5){
            for(int k=i;k<5;k++){
                System.out.print(str[k][j+k-i]+" ");
            }
            i++;
            System.out.println();
        }
    }
}