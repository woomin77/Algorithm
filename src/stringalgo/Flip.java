package stringalgo;

import java.util.ArrayList;

public class Flip {

    public ArrayList<String> solution(int n, String[] strArr) {

        ArrayList<String> list = new ArrayList<>();

        for (String s : strArr) {
            char[] charArray = s.toCharArray();

            int lp=0, rp=charArray.length-1;

            while (lp < rp) {
                char tmp = charArray[lp];
                charArray[lp] = charArray[rp];
                charArray[rp] = tmp;

                lp++;
                rp--;
            }
            String tmp = String.valueOf(charArray);
            list.add(tmp);
        }

        return list;

    }
}
