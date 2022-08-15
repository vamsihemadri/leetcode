class Solution {
    public int romanToInt(String s) {
        
        int ans = 0;
        
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'I'){
                if(i<s.length()-1){
                    if(s.charAt(i+1)=='V'){
                        ans+=4;
                        i++;
                        continue;
                    }
                    if(s.charAt(i+1)=='X'){
                        ans+=9;
                        i++;
                        continue;
                    }
                }
                ans+=1;
            }else if(ch=='V'){
                ans+=5;
            }else if(ch=='X'){
                                if(i<s.length()-1){
                    if(s.charAt(i+1)=='L'){
                        ans+=40;
                        i++;
                        continue;
                    }
                    if(s.charAt(i+1)=='C'){
                        ans+=90;
                        i++;
                        continue;
                    }
                }
                ans+=10;
            } else if(ch == 'L'){
                ans+=50;
            }else if(ch=='C'){
                                if(i<s.length()-1){
                    if(s.charAt(i+1)=='D'){
                        ans+=400;
                        i++;
                        continue;
                    }
                    if(s.charAt(i+1)=='M'){
                        ans+=900;
                        i++;
                        continue;
                    }
                }
                ans+=100;
            } else if(ch=='D'){
                ans+=500;
            }else{
                ans+=1000;
            }
        }
        return ans;
    }
}