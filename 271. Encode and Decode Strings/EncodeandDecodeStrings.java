public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String i : strs)
        {
            sb.append(i.length());
            sb.append("#");
            sb.append(i);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int index = 0;
        int num = 0;
        while(index < s.length())
        {
            num = s.indexOf("#", index);
            int l = Integer.parseInt(s.substring(index, num));
            res.add(s.substring(num + 1, num + l + 1));
            index = num + l + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));