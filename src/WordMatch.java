public class WordMatch {
    private String secretString;
    public WordMatch(String secretString) {
        this.secretString = secretString;
    }
    public int scoreGuess(String wordToCheck){
        int score = 0;
        if (wordToCheck.length() > secretString.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        } else if (wordToCheck.length() == 0) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        String secret = secretString;
        for (int i = 0; i < 1; i++){
            if (secret.indexOf(wordToCheck) > -1) {
                score++;
                i--;
                secret = secret.substring(secret.indexOf(wordToCheck)+1,secret.length());

            }
        }
        return score * wordToCheck.length() * wordToCheck.length();
    }
    public String findBetterGuess(String a, String b) {
        int scoreA = scoreGuess(a);
        int scoreB = scoreGuess(b);
        if (scoreA > scoreB) {
            return a;
        } else if (scoreB > scoreA) {
            return b;
        }
        if (b.compareTo(a) > 0) {
            return b;
        }
        return a;
    }
 }