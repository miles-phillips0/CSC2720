import java.text.DecimalFormat;

class squareRootNthRootFinder {
    public static DecimalFormat format = new DecimalFormat("##.00000");
    public static void main(String[] args) {
        String result1 = squareRootFinder(9, 25);
        System.out.println(result1);
        String result2 = nthRootFinder(64, 20, 3);
        System.out.println(result2);
    }

    public static String squareRootFinder(int number, int iterations){
        double min = 0;
        double max = number;
        double mid = 0;
        for(int i = 0; i < iterations; i++){
            mid = (min+max)/2;
            if((mid*mid) > number){
                max = mid;
            }
            else if((mid*mid) < number){
                min = mid;
            }
        }
        return format.format(mid);

    }

    public static String nthRootFinder(int number, int iterations, int n){
        double min = 0;
        double max = number;
        double mid = 0;
        double midToTheN;
        for(int i = 0; i < iterations; i++){
            mid = (min+max)/2;
            midToTheN = Math.pow(mid, n);
            if(midToTheN > number){
                max = mid;
            }
            else if(midToTheN < number){
                min = mid;
            }
        }
        return format.format(mid);

    }

}
