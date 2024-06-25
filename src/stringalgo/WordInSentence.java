package stringalgo;

public class WordInSentence {


    public String solution(String str) {

        int length = Integer.MIN_VALUE, idx = 0;
        String result = "";

        while ((idx = str.indexOf(" ")) != -1) {
            String temp = str.substring(0, idx);
            if (temp.length() > length) {
                length = temp.length();
                result = temp;
            }
            str = str.substring(idx + 1);
        }
        if (str.length() > length) {
            return str;
        }
        return result;
    }


//    public String solution(String str) {
//
//        int length  = Integer.MIN_VALUE;
//        String result="";
//
//        String[] strArray = str.split(" ");
//
//        for (String s : strArray) {
////            System.out.println(s);
//            if (s.length() > length) {
//                length = s.length();
//                result = s;
//            }
//        }
//
//        return result;
//    }
}
