package javatips.fsabino.app_codility;

public class FindBug {
	
	public static final String CONSTANT = "X";
	
	public static void main(String[] args) {
		
		FindBug t = new FindBug();
		System.out.println(t.solution("hzzzzzzzzzzzzzzzzzaaaaaielloii"));
		
	}
	
	String solution(String S) {
        int[] occurrences = new int[26];
        
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] >= best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }
}
