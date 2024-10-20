import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static int point(int attempts){
        int points;
        if(attempts <= 3){
            points = 10;
        }else if(attempts <= 5){
            points = 5;
        }else{
            points = 2;
        }
        return points;

    }
    public static void main(String args[]){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundNumber = 0;
        while (playAgain){
            roundNumber++;
            int randomNumber = random.nextInt(100)+1;
            int guess = 0;
            int attempts = 0;
            int maxAttempts = 10;
            System.out.println("Round"+ roundNumber+": Guess The Number between 1 to 100.");
            while(guess != randomNumber && attempts < maxAttempts){
                System.out.print("Enter the Guess: ");
                guess = scanner.nextInt();
                attempts++;
                if(guess < randomNumber){
                    System.out.println("Too low...Try Again");
                }else if(guess > randomNumber){
                    System.out.println("Too High...Try Again");
                }else{
                    System.out.println("_____________________________________");
                    System.out.println("Congratulation...! You Win this Round");
                    
                }
                if(attempts == maxAttempts && guess != randomNumber){
                    System.out.println("Attempts are Finished.");
                    break;
                }
            }
            int pointsEarned = point(attempts);
            totalScore += pointsEarned;
            System.out.println("You earned:" + pointsEarned + "points in this round.");
            System.out.println("_____________________________________");
            System.out.println("Your Total score after round: " + roundNumber + " is: " + totalScore + " points");
            System.out.println("_____________________________________");
            System.out.println("Do you want to play another round..?(y/n)");
            String response = scanner.next();
            if(!response.equalsIgnoreCase("y")){
                
                playAgain = false;
            }
        }
        System.out.println("Game Over");
        scanner.close();
    }
    
}
