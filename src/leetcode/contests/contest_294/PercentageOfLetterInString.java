package leetcode.contests.contest_294;

import others.MasterPrinter;

public class PercentageOfLetterInString {
    public static void main(String[] args) {
        PercentageOfLetterInString ps= new PercentageOfLetterInString();
        int result= ps.percentageLetter("foobar",'o');
        System.out.println(result);
    }
    public int percentageLetter(String s, char letter) {
        int[] arr=new int[26];

        int total=s.length();
        for(char c: s.toCharArray()){
            arr[c-'a']+=1;
        }

        MasterPrinter.printArray(arr);
        int count=arr[letter-'a'];
        return (count*100)/total;

    }
}
