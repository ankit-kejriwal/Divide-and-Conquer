public class maxSubArray {


    public static  int bruteForce(int[] arr){
//        Time complexity is O(n**3)
        int ans =0;
        for(int i=1;i<arr.length;i++){
            for(int start_index =0;start_index<arr.length;start_index++){
                int sum =0;
                for(int k = start_index;k<(start_index+i);k++){
                    if(k>=arr.length){
                        break;
                    }
                    sum+= arr[k];
                }
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }

    public static  int bruteForce1(int[] arr){
//        Time complexity is O(n**2)
        int ans =0;
        for(int start_index=0;start_index<arr.length;start_index++){
            int sum=0;
            for(int j=1;j<=arr.length;j++){
                if((start_index+j)>= arr.length){
                    break;
                }
                sum += arr[start_index+j-1];
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }

    public static int dcapproach(int arr[],int low, int high){
        int res =0,left_sum=0,right_sum=0;
        if(low == high){
            return arr[low];
        }
        int m = (high+low)/2;
        int left_arr = dcapproach(arr,low,m);
        int right_arr = dcapproach(arr,m+1,high);
        int sum =0;
        for(int i=m;i<high;i++){
            sum+=arr[i];
            right_sum= Math.max(right_sum,sum);
        }
        sum=0;
        for(int i=m-1;i>=0;i--){
            sum+=arr[i];
            left_sum= Math.max(left_sum,sum);
        }
        int ans = Math.max(left_arr,right_arr);

        return Math.max(ans,left_sum+right_sum);
    }

    public static void main(String[] args){
        int[] arr = {2,-5,4,6,4,-5,-6,1,2,-8};
        int res = bruteForce(arr);
        System.out.println("Maximum sum: " +res);
        int res1 = bruteForce1(arr);
        System.out.println("Maximum sum: " +res1);
        int res2 = dcapproach(arr,0,arr.length-1);
        System.out.println("Maximum sum: " +res2);
    }
}
