import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        start();
    }
    public static void start(){
        welcome();
        Scanner input = new Scanner(System.in);
        chooseDifficulty(input.nextLine(), input);
        handlePlayAgain(input);
    }

    public static void welcome (){
        System.out.println("velkommen til gæt et tal \n vælg en sværhedsgrad: nem (1-10), medium (1-50) og svær (1-100)");
    }

    public static void chooseDifficulty (String difficulty, Scanner input){
        if (difficulty.equalsIgnoreCase("nem")) {
            easyDifficulty(input);
        }
        if (difficulty.equalsIgnoreCase("medium")){
            mediumDifficulty(input);
        }
        if (difficulty.equalsIgnoreCase("svær")){
            hardDifficulty(input);
        }
    }
    public static void easyDifficulty(Scanner input) {
        boolean easy = true;
        System.out.println("gæt et tal fra 0-10");
        int tal = (int) (Math.random() * 10);
        while (easy) {
            easy = checkGuess(input.nextInt(), tal);
        }
    }
    public static void mediumDifficulty(Scanner input) {
        boolean medium = true;
        System.out.println("gæt et tal fra 0-50");
        int tal = (int) (Math.random() * 50);
        while (medium) {
            checkGuess(input.nextInt(), tal);
            medium = checkGuess(input.nextInt(), tal);
        }
    }
    public static void hardDifficulty(Scanner input) {
        boolean hard = true;
        System.out.println("gæt et tal fra 0-100");
        int tal = (int)(Math.random()* 100);
        do {
            System.out.println("farvel");
            checkGuess(input.nextInt(), tal);
            hard = checkGuess(input.nextInt(), tal);

            System.out.println("hej");
        } while (hard);

    }

    public static boolean checkGuess (int input, int numbrt){
        if (input < numbrt){
            System.out.println("dit gæt er for lavt");
        } else if (input > numbrt){
            System.out.println("dit gæt er for højt");
        } else if (input == numbrt){
            System.out.println("du gættede rigtigt :D");
            return false;
        }
        return true;
    }

    public static void handlePlayAgain(Scanner input){
        System.out.println("vil du spille igen? \n ja/nej");
        input.nextLine();
        String playAgain = input.nextLine();
        if (playAgain.equalsIgnoreCase("ja")){
            start();
        }
        input.close();
    }
}