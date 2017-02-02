public class Solution {
    public int findClose(int[] heaters, int target)
    {
        int begin = 0;
        int end = heaters.length - 1;
        while(begin < end - 1)
        {
           int medium = begin + (end - begin) / 2;
           if(heaters[medium] == target)
           {
               return medium;
           }
           else if(target < heaters[begin])
           {
               return begin;
           }
           else if(target > heaters[end])
           {
               return end;
           }
           else if(target < heaters[medium])
           {
               end = medium;
           }
           else
           {
               begin = medium;
           }
        }
        if(Math.abs(target - heaters[begin]) > Math.abs(target - heaters[end]))
        {
            return end;
        }
        else
        {
            return begin;
        }
    }
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0)
            return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++)
        {
            int close = findClose(heaters, houses[i]);
            radius = Math.max(radius, Math.abs(heaters[close] - houses[i]));
        }
        return radius;
    }
}