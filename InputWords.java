package Grade_11.UIUC_CS124;

public class InputWords{
    int[] alphabet; //This holds all of the letters in the alphabet via char number 
    String baseWord; //original word
    char[] baseWordArray; //letters the user has guessed correctly
    char[] userWordStorage; //all guesses
    public int errors = 0; //mistakes the user has made

    //constructor
    public InputWords(String s){
        alphabet = new int[26];
        baseWord = s;
        baseWordArray = new char[baseWord.length()];
        userWordStorage = new char[baseWord.length() + 3];
        for(int i = 0; i < userWordStorage.length; i ++){
            userWordStorage[i] = '_';
        } //??
        for(int j = 0; j < alphabet.length; j++){
            alphabet[j] = 97 + j;
        }
    }
 
    public static void main(String[] args){
        InputWords obj = new InputWords("greetings");
        System.out.println(obj.checkLetter('g'));
    }
    
    //This checks to see if the letter that the user inputs has already been used. 
    public boolean checkLetter(char x){
        boolean chk = false;
        for(int i = 0; i < alphabet.length; i++){
            if(alphabet[i] == (int) x){
                alphabet[i] = -1;
                chk = true;
                break;
            }
        }
        return chk;
    }

    public boolean addCorrectLetter(char guess) {
        boolean repeat_letter = false;
        boolean letter_is_correct = false;
        if (!checkLetter(guess)) {
                return true;
            }
        for (int i = 0; i < baseWord.length(); i++) {
            if (guess == baseWord.charAt(i)) {
                baseWordArray[i] = guess;
                letter_is_correct = true;
            }
        }
        if (!letter_is_correct) {
            errors++;
        }
        return repeat_letter;
    }
}