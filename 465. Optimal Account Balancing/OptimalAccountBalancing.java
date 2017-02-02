public class Solution {
    private int res = Integer.MAX_VALUE;
    public void helper(int[] record, int start, int num, int len)
    {
        while(start < len && record[start] == 0)
        {
            start ++;
        }
        if(start == len)
        {
            res = Math.min(num, res);
            return;
        }
        for(int i = start + 1; i < len; i++)
        {
            if(record[i] * record[start]< 0)
            {
                record[i] += record[start];
                helper(record, start + 1, num + 1, len);
                record[i] -= record[start];
            }
        }
    }
    public int minTransfers(int[][] transactions) {
        if(transactions == null || transactions.length == 0 || transactions[0] == null || transactions[0].length == 0)
            return 0;
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for(int [] trans : transactions)
        {
            Integer temp = hash.get(trans[0]);
            if(temp == null)
            {
                hash.put(trans[0], trans[2]);
            }
            else
            {
                hash.put(trans[0], trans[2] + temp);
            }
            Integer temp2 = hash.get(trans[1]);
            if(temp2 == null)
            {
                hash.put(trans[1], -trans[2]);
            }
            else
            {
                hash.put(trans[1], temp2 - trans[2]);
            }
        }
        int[] record = new int[hash.size()];
        int counter = 0;
        for(Map.Entry<Integer, Integer> item: hash.entrySet())
        {
            record[counter++] = item.getValue();
            //System.out.println(record[counter - 1]);
        }
        helper(record, 0, 0, counter);
        return res;
    }
}