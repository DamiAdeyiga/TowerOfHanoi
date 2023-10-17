// -----------------------------------------------------------------------------
// Author: Sanjay Bhattacherjee
// Module: CO518
//  Assignment 2
//  Task 2
// Program: Check the correctness of a solution for the Tower of Hanoi problem
// -----------------------------------------------------------------------------

import java.util.*; // Import the util library
import java.io.*; // Import the I/O library
import java.util.*;
public class da476_task2 {

    // ---------------------------------------------------------------------
    // Function: Empty Constructor

    // ---------------------------------------------------------------------

    public da476_task2 ()
    {
    }

    // ---------------------------------------------------------------------
    // Function: isBlank
    // ---------------------------------------------------------------------
    public static boolean isBlank (int character) {
        if (
        character == ' ' ||
        character == '\t' ||
        character == '\n' ||
        character == '\r'
        )
            return true;
        return false;

        Stack<Integer>[] towers = (Stack<Integer>[]) new Stack[t];
        Stack<Integer> old_stack_s = new Stack();
        Stack<Integer> new_stack_s = new Stack();
        Stack<Integer> old_stack_d = new Stack();
        Stack<Integer> new_stack_d = new Stack();
        try{
            for(int i =0 ; i<t;i++){
                Stack<Integer> stack = new Stack<Integer>();
                towers[i] = stack;

            }
            for(int i =n;i>0;i--){
                towers[s-1].push(i);//adding in the number of disc into the first source stack

            }    
            int c =1;
            for(Stack k : towers){
                System.out.println("Tower" + c + ":"+ k);
                c++;

            }    
            for(int i =0;i<lines-1;i++){
                n=getNextInteger(input_file);
                s=getNextInteger(input_file);
                d=getNextInteger(input_file);
                n=getNextInteger(input_file);
                old_stack s = towers[s-1];
                old_stack d = towers[d-1];
                if(print_move(n,s,d,old_stack_s,old_stack_d,new_stack_s,new_stack_d,towers)==1){
                    break;
                }
            }

            int f=1;
            System.out.println();
            for(Stack k : towers){
                System.out.println("Tower" + f + ":" + k);

            }
            input_file.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.printf("\n");

        // ---------------------------------------------------------------------
        // Function: getNextInteger
        // This function only works assuming that the file has positive integers
        // ---------------------------------------------------------------------
    }

    public static int getNextInteger (FileInputStream input_file) {
        int character;
        int digit;
        int number = 0;
        try {
            while ((character = input_file.read()) != -1 && !isBlank(character))
            {
                number *= 10;
                digit = (int) character - '0';
                number += digit;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }

    // ---------------------------------------------------------------------
    // Function: main
    // ---------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int n, t, s, d;
        String str_filename;
        String my_ID = new String("da476");

        // Check if the input filename has been provided as an argument
        if (args.length < 1)
        {
            System.out.printf("Usage: java %s_task2 <file_name>\n", my_ID);
            return;
        }

        try {
            // Get the filename
            str_filename = args[0];
            System.out.printf("Reading the file " + str_filename + "\n");

            // Create the object for reading the input file
            FileInputStream input_file = new FileInputStream(str_filename);

            // Read the four parameters in the first row of the input file
            n = getNextInteger (input_file);
            t = getNextInteger (input_file);
            s = getNextInteger (input_file);
            d = getNextInteger (input_file);
            System.out.printf("%d\t%d\t%d\t%d\n", n, t, s, d);

            // Your code for checking the correctness of the generalised ToH problem here

            // Close the file
            input_file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("\n");
        return;

    }

    public static int print_move(int disc, int source_tower,int destination_tower,Stack old_stack_s,Stack old_stack_d,Stack new_stack_s,Stack new_stack_d,Stack<Integer>[]towers)
    {
        int return_value = 0;
        System error_message = "";
        System.out.println("Move:disk"+ disc+"from"+ source_tower+"to" + destination_tower);
        System.out.println("Before the move");
        System.out.println("Source tower " + source_tower+ old_stack_s);
        System.out.println("Destination tower" +destination_tower + ":" + old_stack_d);
        System.out.println("After the move:");
        Integer y= towers[source_tower_1].pop();
        if(!towers[destination_tower-1].empty() && y>towers[destination_tower-1].peek()){

            error_message ="has a smaller t=disc than" + disc + "on the top";
            return_value =1;
        }else{
            Integer x = towers[destination_tower-1].push(y);
        }
        new_stack_d = towers[destination_tower-1];
        new_stack_s = towers[source_tower-1];
        System.out.println("Source tower "+ source_tower+":"+ new_stack_s);
        System.out.println("Destination tower "+ destination_tower+":"+ new_stack_d+ error_message);
        return return_value;
    }
}

