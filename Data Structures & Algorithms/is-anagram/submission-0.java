class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[128];

        if(s.length() != t.length()) return false;

        for(char ch : s.toCharArray()){
            hash[ch]++;
        }

        for(char ch : t.toCharArray()){
            hash[ch]--;
        }

        for(int count : hash){
            if(count>0) return false;
        }
        return true;
    }
}
