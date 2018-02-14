import java.util.*;
public class Blackjack
{
    public static void main(String[] args)      //This comment is added for the sake of GitHub
    {
        Scanner myScanner = new Scanner(System.in);
        P1Random rng = new P1Random();
        int userCard;       //All variables declared here
        int numGame = 1;
        int userChoice;
        int userHand = 0;
        int userWins = 0;
        int dealerHand;
        int dealerWins = 0;
        int tieGames = 0;
        int gamesPlayed = 0;
        int newGame = 0;
        double percentWins;

        do
        {
            if (newGame == 0)
            {
                newGame = 1;
                System.out.println("START GAME #" + numGame);   //Initialises each Blackjack game
                System.out.println("");
                userCard = rng.nextInt(13) + 1;
                switch (userCard)
                {
                    case 1:
                        System.out.println("Your card is a ACE!");
                        break;

                    case 11:
                        System.out.println("Your card is a JACK!");
                        userCard = 10;
                        break;

                    case 12:
                        System.out.println("Your card is a QUEEN!");
                        userCard = 10;
                        break;

                    case 13:
                        System.out.println("Your card is a KING!");
                        userCard = 10;
                        break;

                    default:
                        System.out.println("Your card is a " + userCard + "!");
                        break;
                }
                userHand = userCard;
                System.out.println("Your hand is: " + userHand + "");
                System.out.println("");
            }
            System.out.println("1. Get another card\n2. Hold hand\n3. Print statistics\n4. Exit\n");
            System.out.print("Choose an option: ");
            System.out.println("");
            userChoice = myScanner.nextInt();
            switch (userChoice)
            {
                case 1:     //This case deals the user a card and displays their blackjack hand.
                    userCard = rng.nextInt(13) + 1;
                    switch (userCard)
                    {
                        case 1:
                            System.out.println("Your card is a ACE!");
                            break;

                        case 11:
                            System.out.println("Your card is a JACK!");
                            userCard = 10;
                            break;

                        case 12:
                            System.out.println("Your card is a QUEEN!");
                            userCard = 10;
                            break;

                        case 13:
                            System.out.println("Your card is a KING!");
                            userCard = 10;
                            break;

                        default:
                            System.out.println("Your card is a " + userCard + "!");
                            break;
                    }
                    userHand = userHand + userCard;
                    System.out.println("Your hand is: " + userHand + "");
                    System.out.println("");
                    if (userHand > 21)
                    {
                        System.out.println("You exceeded 21! You lose.");
                        System.out.println("");
                        dealerWins++;
                        numGame++;
                        gamesPlayed++;
                        newGame = 0;
                    }
                    else if (userHand == 21)
                    {
                        System.out.println("BLACKJACK! You win!");
                        System.out.println("");
                        userWins++;
                        numGame++;
                        gamesPlayed++;
                        newGame = 0;
                    }
                    break;

                case 2:     //This case prints the dealer's hand if the user decides to hold their hand.
                    dealerHand = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + userHand);
                    System.out.println("");
                    if ((dealerHand > 21) || (userHand > dealerHand))
                    {
                        System.out.println("You win!");
                        System.out.println("");
                        userWins++;
                        numGame++;
                        gamesPlayed++;
                        newGame = 0;
                    }
                    else if (dealerHand > userHand)
                    {
                        System.out.println("Dealer wins!");
                        System.out.println("");
                        dealerWins++;
                        numGame++;
                        gamesPlayed++;
                        newGame = 0;
                    }
                    else if (userHand == dealerHand)
                    {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println("");
                        tieGames++;
                        numGame++;
                        gamesPlayed++;
                        newGame = 0;
                    }
                    break;

                case 3:     //This case prints statistics of the game.
                    System.out.println("Number of Player wins: " + userWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + gamesPlayed);
                    if (userWins == 0)
                    {
                        System.out.println("Percentage of Player wins: 0.0%");
                        System.out.println("");
                    }
                    else
                    {
                        percentWins = ((userWins * 100) / gamesPlayed);
                        System.out.println("Percentage of Player wins: " + percentWins + "%");
                        System.out.println("");
                    }
                    break;

                case 4:
                    return;

                default:        //The default case displays an error if the user inputs an invalid integer.
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    System.out.println("");
            }
        } while (userChoice != 4);
    }
}