import java.util.Scanner;

public class BanhChung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập vò số nhóm : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<arr.length;i++){
            System.out.println("nhập vào số thành viên của nhóm "+(i+1));
            arr[i]=sc.nextInt();
        }
        System.out.println("số bánh tối thiểu cần là : "+mincake(arr));
    }
    public static int mincake(int groupSizes[]){
    double countCake = 0;
    for(int i = 0;i<groupSizes.length;i++){
        countCake += groupSizes[i];
    }
    countCake = countCake/4;
    int mincake1 = (int)countCake;
    if(countCake>mincake1){
        mincake1 +=1;
    }
    return mincake1;
    }
}
