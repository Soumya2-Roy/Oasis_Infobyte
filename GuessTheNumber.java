import java.util.Random;
import java.util.Scanner;

class game{                          
    private  int points;

    private int number;
    private int chance;

    private String name;
    boolean gamer=false;


        void play(){
        Random rand=new Random();    

        Scanner sc=new Scanner(System.in);
        System.out.println("USER NAME-");  
        name= sc.nextLine(); 
        int min=1,max=100;
        
        int num=rand.nextInt(max-min+1)+min;
        number=num;
        System.out.println("Enter the number of choice less than 50:- ");
        int count=sc.nextInt();
        if(count>=50 || count <0){
            System.out.println("\nTRY AGAIN LATER ...\n");
            return;

        }
        
        chance=count;
        System.out.printf("\nYou have %d chances you must score greater than %d : \n\n",count,count/2);
        System.out.println("\n If you guess wrong every time one point will cut ");
        
        System.out.println("\nGUESS THE NUMBER , GIVEN RANGE "+1+" to "+100);
        int g;
        int i=0;
        
        points=count;
        while (count!=0){
            System.out.println("\nGuess Number Chance "+ ++i);
        
            g=sc.nextInt();
            
            if(g>100 || g<0){
                System.out.print("Guess number within range");
                System.out.println("\nThe RANGE IS 1 TO 100 ");
            } 

            if(g==num){
                gamer=true;
                break;
            }
            else if (g<num) {
                System.out.println("Guess little higher");

            } else if (g>num) {
                System.out.println("Guess little lower");

            }

            count--;

        }
        points-=i;
        }
        void result(){
            if((gamer==true) && (points>chance/2)){
                System.out.println();
                System.out.println(name+" Won the game with "+points+" points ");
            }
            else{
        
                System.out.println("\nTry again later your points "+points);
                System.out.println("\nTHE NUMBER WAS "+number);
                

            }
            
        }
}


public class import java.util.Random;
import java.util.Scanner;

class game{                          
    private  int points;

    private int number;
    private int chance;

    private String name;
    boolean gamer=false;


        void play(){
        Random rand=new Random();    

        Scanner sc=new Scanner(System.in);
        System.out.println("USER NAME-");  
        name= sc.nextLine(); 
        int min=1,max=100;
        
        int num=rand.nextInt(max-min+1)+min;
        number=num;
        System.out.println("Enter the number of choice less than 50:- ");
        int count=sc.nextInt();
        if(count>=50 || count <0){
            System.out.println("\nTRY AGAIN LATER ...\n");
            return;

        }
        
        chance=count;
        System.out.printf("\nYou have %d chances you must score greater than %d : \n\n",count,count/2);
        System.out.println("\n If you guess wrong every time one point will cut ");
        
        System.out.println("\nGUESS THE NUMBER , GIVEN RANGE "+1+" to "+100);
        int g;
        int i=0;
        
        points=count;
        while (count!=0){
            System.out.println("\nGuess Number Chance "+ ++i);
        
            g=sc.nextInt();
            
            if(g>100 || g<0){
                System.out.print("Guess number within range");
                System.out.println("\nThe RANGE IS 1 TO 100 ");
            } 

            if(g==num){
                gamer=true;
                break;
            }
            else if (g<num) {
                System.out.println("Guess little higher");

            } else if (g>num) {
                System.out.println("Guess little lower");

            }

            count--;

        }
        points-=i;
        }
        void result(){
            if((gamer==true) && (points>chance/2)){
                System.out.println();
                System.out.println(name+" Won the game with "+points+" points ");
            }
            else{
        
                System.out.println("\nTry again later your points "+points);
                System.out.println("\nTHE NUMBER WAS "+number);
                

            }
            
        }
}


public class GuessTheNumber {

    public static void main(String[] args) {
        System.out.println("\nNUMBER GUESSER GAME ");
        System.out.println("\nREAD ALL THE GAME RULES CAREFULLY");
        System.out.println("\nALL THE BEST FOR THE GAME \n");
        game object=new game();     
        object.play();
        object.result();
        System.out.println("\nTHANK YOU FOR USING THE GAME ");
        System.out.println("\nPLEASE GIVE THE FEEDBACK");
}

}
