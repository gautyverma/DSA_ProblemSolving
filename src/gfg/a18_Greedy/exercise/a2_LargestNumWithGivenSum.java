package gfg.a18_Greedy.exercise;

public class a2_LargestNumWithGivenSum {
    public static void main(String[] args){
        System.out.println(largestNumber(5,12));
        System.out.println(largestNumber(3,29));
    }

    private static String largestNumber(int n, int sum) {
        if(n*9 < sum){
            return "-1";
        }
        if(sum == 0){
            if (n==1)
                return "0";

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i= 0 ;i<n;i++){
            if(sum >= 9){
                stringBuilder.append(9);
                sum -= 9;
            }else {
                stringBuilder.append(sum);
                sum = 0;
            }
        }
        return stringBuilder.toString();
    }
}
