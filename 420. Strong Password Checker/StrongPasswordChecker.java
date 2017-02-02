public class Solution {
    public int strongPasswordChecker(String s) {
        if(s == null)
            return 6;
        if(s.length() <= 4)
            return 6 - s.length();
        int endrep = 1;
        char end = s.charAt(0);
        boolean hasLetter = end >= 'a' && end <= 'z';
        boolean hasBig = end >= 'A' && end <= 'Z';
        boolean hasNum = end >= '0' && end <= '9';
        int replacement = 0;
        int[] delete = new int[3];
        
        for(int i = 1; i < s.length(); i++)
        {
            char current = s.charAt(i);
            if(end == current)
            {
                endrep ++;
            }
            else
            {
                replacement += endrep / 3;
                if(endrep / 3 != 0)
                    delete[endrep % 3] ++;
                end = current;
                hasLetter |= current >= 'a' && current <= 'z';
                hasBig |= current >= 'A' && current <= 'Z';
                hasNum |= current >= '0' && current <= '9';
                endrep = 1;
            }
        }
        replacement += endrep / 3;
        if(endrep / 3 != 0)
            delete[endrep % 3] ++;
        
        int checkThree = ((hasLetter)? 0: 1 )+ ((hasBig)? 0: 1) + ((hasNum)? 0: 1);
        if(s.length() > 20)
        {
            int del = s.length() - 20;
            if(del <= delete[0])//if within. replacement overlaps with delete[0] by one character.
            {
                replacement -= del;
            }
            else if(del - delete[0] <= 2 * delete[1])// replacement overlaps with delete[1] by two character.
            {
                replacement -= delete[0] + (del - delete[0])/2;
            }
            else//delete two [1] can only reduce replacement by one. and can only reduce up to delete[1] character.
            {
                replacement -= delete[0] + delete[1] +(del- delete[0] - 2 * delete[1])/3;// important.
            }
            return del + Math.max(replacement, checkThree);
        }
        else
        {
            return Math.max(6- s.length(), Math.max(checkThree, replacement));
        }
    }
}