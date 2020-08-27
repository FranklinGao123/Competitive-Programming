/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3;

/**
 *
 * @author frank
 */
public class Fix {
    public static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static class word implements Comparable<word>{
        String word;
        int length;

        public word(String word){
            this.word = word;
            this.length = word.length();
        }

        public int compareTo(word o){
            return this.length-o.length;
        }
    }

    public static void main(String[] args) {
        FastReader s = new FastReader();
        int n = s.nextInt();
        for(int i = 0; i<n; i++){
            word[] words = new word[3];
            for(int j = 0; j<3; j++){
                words[j] = new word(s.next());
            }
            Arrays.sort(words);
            if(words[1].word.substring(0, words[0].length).equals(words[0].word) ||
                    words[1].word.substring(words[1].length-words[0].length, words[1].length).equals(words[0].word) ||
                    words[2].word.substring(0, words[2].length).equals(words[0].word) ||
                    words[2].word.substring(words[2].length-words[0].length, words[2].length).equals(words[0].word) ||
                    words[2].word.substring(0, words[1].length).equals(words[1].word) ||
                    words[2].word.substring(words[2].length-words[1].length, words[2].length).equals(words[1].word)){
                System.out.println("No");
                continue;
            }
            System.out.println("Yes");
        }



    }
}
