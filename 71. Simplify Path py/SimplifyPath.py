class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        v=[str(i) for i in path.split('/')]
        strpath=''
        for i in range(len(v)):
            if( v[i] is '' )or(v[i] == '.')or (not v[i] ):
                continue
            if v[i] =='..':
                print strpath
                for p in (range(len(strpath))[::-1]):
                    if strpath[p]=='/':
                        strpath=strpath[0:p]
                        break
            else:
                strpath+='/'
                strpath+=v[i]
        if(strpath is ''):
            return '/'
        return strpath