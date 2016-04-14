public class Solution {
    public boolean isValid(String num){
        if(num.length()>1 && num.charAt(0)=='0')
            return false;
        return true;
    }
    public boolean Search(long num1,long num2, String result)
    {
        if(!isValid(result))
            return false;
        long expect=num1+num2;
        String expectation=Long.toString(expect);//.to_string();
        if(expectation.length()>result.length() ||!(result.substring(0,expectation.length())).equals(expectation))
            return false;
        else if(expectation.length()==result.length() && expectation.equals(result))
            return true;
        else
            return Search(num2,Long.parseLong(expectation),result.substring(expectation.length()));
    }
    
    public boolean isAdditiveNumber(String num) {
        for(int i=1;i<=num.length()/2;i++)//!!!!!
            for(int j=i+1;j<num.length();j++)
            {
                String checkN1=num.substring(0,i);
                String checkN2=num.substring(i,j);
                if(isValid(checkN1) && isValid(checkN2))
                {
                    long n1=Long.parseLong(checkN1);
                    long n2=Long.parseLong(checkN2);
                    if(Search(n1,n2,num.substring(j)))
                        return true;
                }
            }
        return false;
    }
}