public class change {
    public boolean judege(double money){
        int money_need=(int)money;
        if(Math.abs(money_need-money)>0.000001)
            return false;
        if(money_need>93||money_need<0)
            return false;

        int[] c=new int[100];
        int[][] change={{1,3},{5,2},{10,1},{20,1},{50,1}};
        for(int i=0;i<100;i++){
            c[i]=0;
        }
        c[0]=1;
        for(int i=0;i<change.length;i++){
            for(int j=0;j<change[i][1];j++){
                for(int k=99;k>=change[i][0];k--){
                    c[k]=Math.max(c[k],c[k-change[i][0]]);
                }
            }
        }
        return c[money_need]==1;
    }

    public static void main(String[] args) {
        change c=new change();
        c.judege(1);
    }

}
