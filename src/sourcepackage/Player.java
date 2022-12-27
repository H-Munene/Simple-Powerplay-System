package sourcepackage;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Player {
    //data members
    private String player_name;
    private int player_id;
    private double stake;
    private ArrayList<Integer>choice_nums;
    
    //constructor
    public Player() {
        user_details();
        make_stake();
        choose_nums();
    }

    //gettors and settors for data members
    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }
    
    public ArrayList<Integer> getchoice_nums() {
        return this.choice_nums;
    }

    public void setchoice_nums(ArrayList<Integer> choice_nums) {
        this.choice_nums = choice_nums;
    }

    public double getStake() {
        return stake;
    }

    public void setStake(double stake) {
        this.stake = stake;
    }

    //methods
    
    //this method obtains username and ID
    public void user_details(){
        input_username();
        input_ID();
    }
    
    public void input_username(){
        String username;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        username = scanner.nextLine();
        boolean hasNumbers = false;
        //this checks if username has numbers 
        for (int i = 0; i < username.length(); i++){
              if(Character.isDigit(username.charAt(i))){
                  hasNumbers = true;
                  break;
              }      
        } 
        
        if(hasNumbers){
            System.out.println("Invalid username");
            input_username();
        }
        
        setPlayer_name(username);
    }
    
    //gets users ID
    public void input_ID(){
        int id;
        
        Scanner scanner = new Scanner(System.in);
        try {
                System.out.println("Please enter your ID: ");
                id = scanner.nextInt();
                
                System.out.println("Your username and ID have been successfully set");
                setPlayer_id(id);
            } catch (InputMismatchException e) {
                System.out.println("Invalid ID");
                input_ID();
            }
    }
    
    //this method enables a user make a valid bet
    public void make_stake(){
        double amount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your bet amount (ksh. 10- ksh.1000): ksh.");
        try {
            amount = scanner.nextDouble();
            amount = (double)amount;
            if (amount >=10 && amount <=1000){
            System.out.println("Bet successfully placed!");
            setStake(amount);
            }else{
            System.out.println("Please enter bet amount within the specified range!");
            make_stake();
            }
        } catch (Exception e) {
            System.out.println("Please enter numbers only");
            make_stake();
        }

    }
    
    //this method makes user choose five random numbers
    public void choose_nums(){
        //create an arraylist nums
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("i am here");
            //input five unique numbers inclusive 1-69
            System.out.println("Please enter five unique numbers (1-69): ");
            
            //adds numbers to nums
            for(int i = 0; i < 5; i++){
               nums.add(scanner.nextInt());
            }
            
            for( int i : nums){
                //checks if numbers are within specified range
                if( i > 69 || i < 1){
                    //when out of range
                    System.out.println("Choose numbers within specified range!");
                    choose_nums();
                }
            }
            //when within range
            //create a set called set with integers in num as values
            Set<Integer>set = new HashSet<Integer>(nums);
                    
            //if size of set is less than nums
            if( set.size() < nums.size()){
                System.out.println("Your have repeating choice numbers");
                choose_nums();
            }else{
                //else all values in nums are unique
                System.out.println("Your choice numbers have been placed!\nGOOD lUCK");
                setchoice_nums(nums);
            }
    
        } catch (Exception e) {
            System.out.println("Please enter numbers only");
            choose_nums();
        }
        
    } 
    
}


