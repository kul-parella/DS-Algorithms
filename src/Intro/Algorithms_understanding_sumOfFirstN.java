package Intro;

public class Algorithms_understanding_sumOfFirstN {


    public static  void  main(String[] args) {

        System.out.println(bestSumOfN(10));
        System.out.println(intermediateSumOfN(10));
        System.out.println(worstSumOfN(10));

        System.out.println(4%2);
        System.out.println(4/2);

    }


    /**
     * time complexity is constant C
     * @param n
     * @return
     */
    public static int bestSumOfN(int n) {
        return n*(n+1)/2;
    }

    /**
     * time complexity is C2n+C3
     * @param n
     * @return
     */
    public static int intermediateSumOfN(int n) {
        int sum=0;
        for(int i=1;i<=n;i++) {
            sum = sum+i;
        }
    return sum;
    }

    /**
     * time complexity is C4nsquare+ c5n + c6
     * @param n
     * @return
     */
   public static int worstSumOfN(int n) {
       int sum=0;
       for(int i=1; i<=n; i++) {
           for(int j=1; j<=i; j++) {
               sum++;
           }
       }
       return sum;
   }

}
