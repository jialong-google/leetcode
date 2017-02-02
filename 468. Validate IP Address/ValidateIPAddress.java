public class Solution {
    private boolean ipv4(String IP)
    {
        if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.')
            return false;
        String[] args = IP.split("\\.");
        //System.out.println(args.length);
        if(args.length != 4)
            return false;
        for(int i = 0; i < 4; i++)
        {
            if(args[i] == null || args[i].length() == 0)
                return false;
            int current = 0;
            for(int j = 0; j < args[i].length(); j++)
            {
                char cur = args[i].charAt(j);
                if(cur > '9' || cur < '0')
                    return false;
                if(cur == '0' && j != args[i].length() - 1)
                    return false;
                current = current * 10 + cur - '0';
            }
            if(current != 0 && args[i].charAt(0) == '0' || current >= 256 || current < 0)
                return false;
        }
        return true;
    }
    private boolean ipv6(String IP)
    {
        if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':')
            return false;
        String[] args = IP.split(":");
        if(args.length != 8)
            return false;
        for(int i = 0; i < 8 ; i++)
        {
            if(args[i] == null || args[i].length() > 4 || args[i].length() == 0)
                return false;
            for(int j = 0; j < args[i].length(); j++)
            {
                char current = args[i].charAt(j);
                if(current >= '0' && current <= '9' || current >= 'a' && current <= 'f')
                    continue;
                return false;
            }
        }
        return true;
    }
    public String validIPAddress(String IP) {
        IP = IP.toLowerCase();
        if(IP == null || IP.length() == 0)
            return "Neither";
        else if(ipv4(IP))
            return "IPv4";
        else if(ipv6(IP))
            return "IPv6";
        return "Neither";
    }
}