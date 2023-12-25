class valid_palindrome {
    //good
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left<right){
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            else if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            else{
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                right--;
                left++;
            }
        }
        return true;
    }
}