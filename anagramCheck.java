import java.util.Arrays;

public class anagramCheck {
    public static boolean anagramChecker(String s1, String s2){

        if(s1.length() != s2.length()){
            return false;
        }
        char[] string1 = s1.toCharArray();
        char[] string2= s2.toCharArray(); //O(n)
        Arrays.sort(string1); //O(nlog(n))
        Arrays.sort(string2);
        for(int i = 0; i < s1.length(); i++){
            if(string1[i] != string2[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        System.out.print(anagramChecker("fd sa", "asdf "));
    }
