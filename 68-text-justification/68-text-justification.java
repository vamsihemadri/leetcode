class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        
        int left = 0;
        int len = words.length;
        
        List<String> ans = new ArrayList();
        
        while(left<len){
            int right = findRight( left,words, maxWidth);
            String str = justify(left, right, words, maxWidth);
            
            ans.add(str);
            left = right+1;
        }
        return ans;
        
    }
    
    
    private int findRight(int left, String[] words, int max){
        
        int currLen = words[left].length();
        int right = left+1;
        
        while(right<words.length && currLen + 1 + words[right].length() <=max){
            currLen+=1+words[right].length();
            right++;
        }
        return right-1;
    }
    
    private String justify(int left, int right, String[] words, int max){
        
        if(right==left)
            return pad(words[left],max);
        
        boolean isLast = right==words.length-1;
        
        StringBuilder res = new StringBuilder();
        
        int totalSpaceLen = max-getWordsLen(words, left, right);
        int numBreaks = right-left;
        
        int eachSpaceLen = totalSpaceLen/numBreaks;
        int rem = totalSpaceLen%numBreaks;
        
        if(isLast){
            eachSpaceLen = 1;
            rem = 0;
        }
        
        for(int i = left;i<=right;i++){
            res.append(words[i])
                .append(getBlank(eachSpaceLen))
                .append(rem>0?" ":"");
            rem--;
        }

        
        
        return pad(res.toString().trim(),max);
    }
    
    private int getWordsLen(String[] words, int left, int right){
        int sum = 0;
        for(int i = left;i<=right;i++){
            sum+=words[i].length();
        }
        return sum;
    }
    
    private String pad(String word, int max){
        
        int blankLen = max-word.length() ;
        return word + getBlank(blankLen);
    }
    
    
    private String getBlank(int len){
        char[] arr = new char[len];
        Arrays.fill(arr,' ');
        return new StringBuilder().append(arr).toString();
    }
}