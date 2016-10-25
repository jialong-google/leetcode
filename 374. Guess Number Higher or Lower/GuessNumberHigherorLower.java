/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int begin = 1;
        int end = n;
        while(begin < end)
        {    
            int medium = begin + (end - begin)/ 2;
            int res = guess(medium);
            switch(res)
            {
                case 1:
                    begin = medium + 1;
                    break;
                case -1:
                    end = medium - 1;
                    break;
                case 0:
                    return medium;
            }
        }
        return begin;
    }
}