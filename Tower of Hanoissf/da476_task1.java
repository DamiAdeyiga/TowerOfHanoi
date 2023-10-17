// -----------------------------------------------------------------------------
// Author: Sanjay Bhattacherjee
// Module: CO518 - Class 5 (2020-21)
// Program: Tower of Hanoi
// -----------------------------------------------------------------------------

import java.util.Scanner;  // Import the Scanner class

public class da476_task1{

    // ---------------------------------------------------------------------
    // Function: Empty Constructor
    // ---------------------------------------------------------------------
    public da476_task1 ()
    {
    }

    // ---------------------------------------------------------------------
    // Function: The recursive function for tower_of_hanoi
    // Computes: Prints all the moves with disk numbers
    // ---------------------------------------------------------------------
	 public int move (int n, int towerN, int source_tower, int destination_tower)
	 {
	  if (towerN < n) {
	   System.out.println("Error: The number of towers must be greater than or equal to the number of disks.");
	   return -1;
	  }

	  int buffer_tower[] = new int[towerN-1];

	  for(int i=1 ,count=0;i<=towerN;i++)
	  { 
	   if(i!= destination_tower && i!= source_tower){
		buffer_tower[count] = i;
		count++;
	   }
	  }

        // The terminating condition (when n == 1)
        if (n == 1)
        {
            System.out.printf("\nMove disk %d from T%d to T%d\n", n, source_tower, destination_tower);
            return 0;
        }  
		if (n > 2 && n < towerN){
		   // Move the top n-1 disks from source to buffer, using destination as a buffer
		   move(n-1, towerN, source_tower, buffer_tower[0], destination_tower);
		   
		   // Move the nth disk from source to destination
		   System.out.printf("\nMove disk %d from T%d to T%d\n", n, source_tower, destination_tower);
		   
		   // Move the n-1 disks from buffer to destination, using source as a buffer
		   move(n-1, towerN, buffer_tower[0], destination_tower, source_tower);
		}
        // The buffer tower number has to be determined appropriately
        // based on the source and destination towers
        if (n==2){
            buffer_tower[0] = 0;
            if (source_tower == 1)
                if (destination_tower == 2)
                    buffer_tower[1] = 3;
                else
                    buffer_tower[1] = 2;
            else if (source_tower == 2)
                if (destination_tower == 3)
                    buffer_tower[1] = 1;   
                else 
                    buffer_tower[1] = 3;
            else if (source_tower == 3)
                if (destination_tower == 1)
                    buffer_tower[1] = 2;
                else
                    buffer_tower[1] = 1;

            // First move the smaller disk to the buffer tower
            System.out.printf("\nMove disk %d from T%d to T%d\n", n-1, source_tower, buffer_tower[1]);
            // Then move the larger disk to the destination tower
            System.out.printf("\nMove disk %d from T%d to T%d\n", n, source_tower, destination_tower);
            // Finally move move the smaller disk back from the buffer tower to the destination tower
            System.out.printf("\nMove disk %d from T%d to T%d\n", n-1, buffer_tower[1], destination_tower);

            return 0;
        }
        buffer_tower[0] = 0;
        buffer_tower[1] = 0;
        if (source_tower == 1)
            if (destination_tower == 2)
            {
                buffer_tower[0] = 3;
                buffer_tower[1] = 4;

            }
            else if (destination_tower == 3)
            {
                buffer_tower[0] = 2;
                buffer_tower[1] = 4;
            }
            else if (destination_tower == 4)
            {
                buffer_tower[0] = 2;
                buffer_tower[1] = 3;
            }
            else if (destination_tower == 5)
            {
                buffer_tower[0] = 2;
                buffer_tower[1] = 3;

            }

            else if (source_tower == 2)
                if (destination_tower == 1)
                {
                    buffer_tower[0] = 3;
                    buffer_tower[1] = 4;
                }
                else if (destination_tower == 3)
                {
                    buffer_tower[0] = 1;
                    buffer_tower[1] = 4;
                }
                else if (destination_tower == 4)
                {
                    buffer_tower[0] = 1;
                    buffer_tower[1] = 3;
                }
                else if (source_tower == 3)
                    if (destination_tower == 1)
                    {
                        buffer_tower[0] = 2;
                        buffer_tower[1] = 4;
                    }
                    else if (destination_tower == 2)
                    {
                        buffer_tower[0] = 1;
                        buffer_tower[1] = 4;
                    }
                    else if (destination_tower == 4)
                    {
                        buffer_tower[0] = 1;
                        buffer_tower[1] = 2;
                    }
                    else if (source_tower == 4)
                        if (destination_tower == 1)
                        {
                            buffer_tower[0] = 2;
                            buffer_tower[1] = 3;
                        }
                        else if (destination_tower == 2)
                        {
                            buffer_tower[0] = 1;
                            buffer_tower[1] = 3;
                        }
                        else if (destination_tower == 3)
                        {
                            buffer_tower[0] = 1;
                            buffer_tower[1] = 2;
                        }
                      

                        

                        
                        
        // The first recursive call to move the top n-2 disks from the source tower to the first buffer tower
        move (n-2,towerN, source_tower, buffer_tower[0]);

        // The (n-1)th disk is now ready to be moved to the second buffer tower
        System.out.printf("\nMove disk %d from T%d to T%d\n", n-1, source_tower, buffer_tower[1]);

        // The nth disk is now ready to be moved to the destination tower
        System.out.printf("\nMove disk %d from T%d to T%d\n", n, source_tower, destination_tower);

        // The (n-1)th disk is now ready to be moved from the second buffer tower to the destination tower
        System.out.printf("\nMove disk %d from T%d to T%d\n", n-1, buffer_tower[1], destination_tower);

        // The second recursive call to move the n-2 disks from the first buffer tower to the destination tower
        move (n-2,towerN, buffer_tower[0], destination_tower);

        return 0;
    }

    // ---------------------------------------------------------------------
    // Function: main
    // ---------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int n, t, s, d;

        System.out.printf("Please enter the number of disks n: ");
        n = myObj.nextInt();  // Read user input n
        System.out.printf("Please enter the number towers used t: ");
        t = myObj.nextInt();  // Read user input i

        System.out.printf("Please enter the source s: ");
        s = myObj.nextInt();

        System.out.printf("Please enter the destination tower d: ");
        d = myObj.nextInt();  // Read user input j

        da476_task1 ToH = new da476_task1();

        ToH.move(n, t, s,d);
    }
}