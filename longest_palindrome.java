class longest_palindrome {
    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return s.substring(0, 1);
        }
        int right = s.length() - 1, left = 0, i = 0;
        String ret = null;
        //String reversedString = null;
        // StringBuilder string= null;
        String ss = null;
        while ((right + 1 - left) > 1) {
            ss = s.substring(left, right + 1);
            //reversedString = new StringBuilder(ss).reverse().toString();
            // System.out.println(s.substring(left,right+1)+" "+reversedString);
            if (ss.equals(new StringBuilder(ss).reverse().toString())) {
                ret = new StringBuilder(ss).reverse().toString();
                break;
            } else {
                left++;
                right++;
            }
            if (right == s.length()) {
                left = 0;
                i++;
                right = s.length() - i;
            }
        }
        if (ret == null)
            return s.substring(0, 1);
        return ret;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String ret = longestPalindrome("busislnescsicxpvvysuqgcudefrfjbwwjcchtgqyajdfwvkypfwshnihjdztgmyuuljxgvhdiwphrweyfkbnjgerkmifbirubhseuhrugwrabnjafnbdfjnufdstjbkuwtnpflffaqmjbhssjlnqftgjiglvvequhapasarlkcvbmkwnkuvwktbgfoaxteprobdwswcdyddyvrehvmxrrjiiidatidlpihkbmmruysmhhsncmfdanafdrfpdtfgkglcqpwrrtvacuicohspkounojuziittugpqjyhhkwfnflozbispehrtrnizowrlzcuollagxwtznjwzcumvedjwokueuqktvvouwnsmpxqvvpuwprezrbobrpnwaccwljchdguubjulyilzvmandjjleitweybqkjttschrjjlebnmponvlktzzcdtuybugggcqffkcffpamauvxfbonjrobgpvlyzveiwemmtdvbjciaytvesnocnjrwodtcokgcuoiicxapmrzpkfphjniuvzjrhbnqndfshoduejyktebgdabidxlkstepuwvtrtgbxaeheylicvhrxddijshcvdadxzsccmainyfpfdhqdanfccqkzlmhsfilvoybqojlvbcixjzqpbngdvesuokbxhkomsiqfyukvspqthlzxdnlwthrgaxhtpjzhrugqbfokrdcyurivmzgtynoqfjbafboselxnfupnpqlryvlcxeksirvufepfwczosrrjpudbwqxwldgjyfjhzlzcojxyqjyxxiqvfhjdwtgoqbyeocffnyxhyyiqspnvrpxmrtcnviukrjvpavervvztoxajriuvxqveqsrttjqepvvahywuzwtmgyrzduxfqspeipimyoxmkadrvrdyefekjxcmsmzmtbugyckcbjsrymszftjyllfmoeoylzeahnrxlxpnlvlvzltwnmldi");
        long stopTime = System.currentTimeMillis();
        long executionTime = stopTime - startTime;
        System.out.println("Execution Time: " + executionTime + " milliseconds");
    }
}