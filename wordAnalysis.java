import java.lang.UnsupportedOperationException;
import java.util.Scanner;

public class wordAnalysis {
    // Constants for function names in input
    public static final String MIN_METHOD_NAME = "MIN";
    public static final String MAX_METHOD_NAME = "MAX";
    public static final String RANGE_METHOD_NAME = "RANGE";
    public static final String AVERAGE_METHOD_NAME = "AVERAGE";
    public static final String MODE_METHOD_NAME = "MODE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read in the method name that we want to call
        String methodName = sc.nextLine();

        // Read in number of words
        int numWords = Integer.parseInt(sc.nextLine());

        // Read in list of words
        String[] words = new String[numWords];
        for (int i = 0; i < numWords; i++) {
            words[i] = sc.nextLine();
        }

        // Run the specified method
        switch (methodName) {
            case MIN_METHOD_NAME:
                System.out.println(minWordLength(words));
                break;
            case MAX_METHOD_NAME:
                System.out.println(maxWordLength(words));
                break;
            case RANGE_METHOD_NAME:
                System.out.println(wordLengthRange(words));
                break;
            case AVERAGE_METHOD_NAME:
                System.out.println(averageWordLength(words));
                break;
            case MODE_METHOD_NAME:
                System.out.println(mostCommonWordLength(words));
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private static int minWordLength(String[] words) {
        String current;
        int min = 0;
        //iterates through the array and updates the minimum value
        for(int i = 0; i < words.length; i++){
            current = words[i];
            if(i==0) {
                min = current.length();
            }
            else if(current.length() < min){
                min = current.length();
            }
        }
        return min;
    }

    private static int maxWordLength(String[] words) {
        String current;
        int max = 0;
        //iterates through the array and updates the maximum value
        for(int i = 0; i < words.length; i++){
            current = words[i];
            if(i==0) {
                max = current.length();
            }
            else if(current.length() > max){
                max = current.length();
            }
        }
        return max;
    }

    private static int wordLengthRange(String[] words) {
        String current;
        int max = 0;
        int min = 0;
        int range;
        //updates max and min simultaneously and returns the difference between the two
        for(int i = 0; i < words.length;i++){
            current = words[i];
            if(i == 0){
                min = current.length();
                max = current.length();
            }
            else if(current.length() > max){
                max = current.length();
            }
            else if(current.length() < min){
                min = current.length();
            }
        }
        range = max-min;
        return range;
    }

    private static String averageWordLength(String[] words) {
        String current;
        int total = 0;
        int temp;
        double average;
        String strAverage;
        //a summation function for every word in the array
        for(int i = 0 ; i < words.length;i++){
            current = words[i];
            temp = current.length();
            total += temp;
        }
        average = (float)total/words.length;
        average *= 100;
        average = Math.round(average);
        strAverage = Double.toString(average/100);
        //this is inefficient but I kept getting failed tests for floats that end in a 0, I.E. the program would return 3.8 instead of 3.80
        if(strAverage.length()==3){
            strAverage = strAverage + "0";
        }



        return strAverage;

    }

    private static int mostCommonWordLength(String[] words) {
        int max = 0;
        int range = wordLengthRange(words);
        int[] counts = new int[range+1];
        String current;
        int currentLength;
        int maxIndex = 0;
        boolean tie = false;

        for(int j = 0; j < counts.length; j++){
            counts[j] = 0;
        }

        for(int i = 0; i < words.length; i++){
            current = words[i];
            currentLength = current.length();
            counts[currentLength-1]++;
        }
        for(int i = 0; i < counts.length; i++){
            if(i==0){
                max = counts[i];
            }
            else if(counts[i] > max){
                max = counts[i];
                maxIndex = i;
                tie = false;
            }
            else if(counts[i] == max){
                tie = true;
            }
        }
        if(tie){
            return -1;
        }
        return maxIndex + 1;
    }
}
