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

    public static void main(String[] args){
        int[] arr = {2,-5,4,6,4,-5,6,14,12,-8};
        int res = bruteForce(arr);
        System.out.println("Maximum sum: " +res);
        int res1 = bruteForce1(arr);
        System.out.println("Maximum sum: " +res1);
    }
}
