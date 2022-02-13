package Grade_11.UIUC_CS124;


class Output {
  String word;
  int word_length;
  InputWords ipwords;
  public Output(String input_word, InputWords ip) {
    word = input_word;
    word_length = input_word.length();
    ipwords = ip;
  }
  public boolean print() {
    char[] letters = ipwords.baseWordArray;
    boolean win = true;
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == '\u0000') {
        System.out.print('_');
        win = false;
      } else {
        System.out.print(letters[i]);
      }
    }
    System.out.println();
    if (ipwords.errors == 3) {
      System.out.println("You lose :(");
      System.out.println("The word was: " + word);
      return true;
    } else {
      if (win) {
        System.out.println("You win!");
      }
    }
    return win;
  }
}