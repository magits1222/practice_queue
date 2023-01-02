import java.util.*;
public class greedy{
    public static int BalancedPartition(String str , int n){
        if(n == 0){
            return 0;
        }
        int r=0, l=0;
        int ans=0;
        for(int i=0 ; i<n ; i++){
            if(str.charAt(i)=='R'){
                r++;
            }
            else if(str.charAt(i)=='L'){
                l++;
            }
            if(l==r){
                ans++;
            }
        }
        return ans;
    }
    public static int kthOdd(int[] range, int k){
        if(k<=0){
            return 0;
        }
        int L= range[0];
        int R= range[1];
        if((R & 1)>0){
            int count= (int) Math.ceil((R - L + 1)/2);
            if(k>count)
            return 0;
            else
            return(R-2*k+2);
        }else{
            int count=(R-L+1)/2;
            if(k>count)
            return 0;
            else
            return (R-2 *k +1);
        }
    }
    public static char[] lexo_small(int n, int k){
        char arr[]=new char[n];
        Arrays.fill(arr,'a');
        for(int i= n-1 ; i>=0 ; i-- ){
            k -= i;
            if(k>=0){
                if(k>=26){
                    arr[i]='z';
                    k -= 26;
                }else{
                    arr[i]=(char)(k+97-1);
                    k -= arr[i]-'a'+1;
                }
            }
            else
            break;
        }
        return arr;
    }
    public static int ans=10000000;
    public static void solve(int a[], int n , int k , int index, int sum , int maxsum){
        if(k==1){
            maxsum=Math.max(maxsum, sum);
            sum=0;
            for(int i=index ; i<n ; i++){
                sum += a[i];
            }
            maxsum = Math.max(maxsum, sum);
            ans = Math.min(sum, maxsum);
            return;
        }
        sum=0;
        for(int i=0 ; i<n ; i++){
            sum += a[i];
            maxsum= Math.max(maxsum, sum);
            solve(a, n, k-1, i+1, sum, maxsum);
        }
    }
    public static void main(String[] args) {
       int arr[]={1,2,3,4};
       int k=3;
       int n=4;
       solve(arr, n, k, 0 , 0 , 0);
       System.out.print(ans+"\n");
    }
}