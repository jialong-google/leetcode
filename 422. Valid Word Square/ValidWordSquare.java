public class Solution {
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0)
            return true;
        for(int i = 0; i < words.size(); i++)
        {
            String current = words.get(i);
            for(int j = 0; j < current.length(); j++)
            {
                if(j >= words.size() || i >= words.get(j).length() || words.get(j).charAt(i) != current.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }
}