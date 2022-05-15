package LEARN;

/**
 * @author sanmu
 * @version 1.0
 */
public class test {
    //回溯法之01背包问题
    int n=4;
    int space=6;
    int[] weight={5,3,2,1};
    int[] value={4,4,3,1};
    int[] x=new int[n];
    int[] bestx=new int[n];
    int best=0;
    int temp=0;
    int tempw=0;
    public static void main(String[] args) {
        test test = new test();
        test.backfuck(0);
        test.output();
    }
    public void backfuck(int t){
        if(t>=n){
            if(temp>best){
                best=temp;
                for (int i = 0; i < n; i++) {
                    bestx[i]=x[i];
                }
            }
        }
        else{
            for (int i = 0; i <=1; i++) {
                x[t]=i;
                if(i==1){
                    if(cut(t)){
                        temp+=value[t];
                        tempw+=weight[t];
                        backfuck(t+1);
                        temp-=value[t];
                        tempw-=weight[t];
                    }
                }
                else{
                    backfuck(t+1);
                }
            }
        }
    }
    public boolean cut(int t){
        if(tempw+weight[t]>space) return false;
        else return true;
    }
    public void output(){
        for (int i = 0; i < n; i++) {
            System.out.print(bestx[i]+" ");
        }
        System.out.println();
        System.out.println(best);
    }
}

