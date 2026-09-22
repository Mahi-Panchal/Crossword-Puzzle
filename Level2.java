//MAHI K PANCHAL(202302626010095)
//MARHAMA SHAIKH (202302626010124)
//ANANYA TIWARI (202302626010138)
//MAIN METHOD LEVEL 2
import java.util.Scanner;
 
class Level2 
{
	public static int flag = 1;
	public static int x = 0; 		//LOCATION VARIABLES
	public static int y = 0;
	public static void ready(Grid arr[][])
	{
			for (int i = 0; i < 7 ; i++ ) 
			{
				for (int j = 0; j < 8 ;j++ ) 		// GRID INITIALIZATION//
				{
					arr[i][j] = new Grid();
				}
			}
			for (int i = 0; i < 7 ; i++ ) 
			{
				for (int j = 0; j < 8 ;j++ ) 
				{
					if (i == 1 && j == 5) 
					{
						arr[i][j] = new Letter('L',1);
					}
					else if (i == 2 && j == 2) 
					{
						arr[i][j] = new Letter('E',1);
					}
					else if (i == 3 && j == 3) 
					{
						arr[i][j] = new Letter('A',1);			//GRID INSTANTIATION
					}
					else if (i == 3 && j == 5) 					//NON EDITABLE LOCATIONS
					{
						arr[i][j] = new Letter('I',1);
					}
					else if (i == 3 && j == 7) 
					{
						arr[i][j] = new Letter('R',1);
					}
					else if (i == 5 && j == 5) 
					{
						arr[i][j] = new Letter('S',1);
					}
					else if ((i == 0 && j == 5) || (i == 1 && j == 2) ||(i == 2 && j == 5) ||(i == 3 && j == 1) ||(i == 3 && j == 2) ||(i == 3 && j == 4) ||(i == 3 && j == 6) ||(i == 4 && j == 2) ||(i == 4 && j == 5) ||(i == 5 && j == 2)) 
					{
						arr[i][j] = new Letter(0);
					}
					else
					{
						arr[i][j] = new Wall();			// FOR NON EDITABLE LOCATIONS
					}
				}
			}
	}
	public static void printMaze(Grid arr[][])		//DISPLAY MAZE
	{
		for (int i = 0; i < 7 ; i++ ) 
		{
			for (int j = 0; j < 8 ;j++ ) 
			{
				if (i == x && j == y) 
				{
					System.out.print("[ " + arr[i][j].letter + " ]");
				}
				else
				{
					System.out.print("  " + arr[i][j].letter + "  ");					
				}
			}
			System.out.println();
		}
	}
	public static void check(Grid arr[][])		//CHECKING FOR ALL CORRECT ANSWERS
	{
		if (arr[0][5].letter == 'P' && arr[1][2].letter == 'D' && arr[2][5].letter == 'A' && arr[3][1].letter == 'G' && arr[3][2].letter == 'L' && arr[3][4].letter == 'C' && arr[3][6].letter == 'E' && arr[4][2].letter == 'T' && arr[4][5].letter == 'N' && arr[5][2].letter == 'A') 
		{
			System.out.printf("\n","%20s","Congratulations!! You have passed level 3!!\n");
			flag = 0;
		}
		else
		{
			System.out.printf("%80s", "Incorrect!!" + "\n");
		}
	}
	public static void main(String[] args) 		//MAIN METHOD
	{

		Scanner scan = new Scanner(System.in);
		Grid array[][] = new Grid[7][8];
		ready(array);							//CALLS READY()
		while(flag == 1)						// LOOP FOR INTERACTIVE SWITCH CASE
		{
			System.out.println();
			System.out.println("                                 Level 2");
			System.out.println();
			printMaze(array);		// CALLS PRINTMAZE()
			System.out.print("Enter the choice(Up - U)(Down - D)(Right - R)(LefT - L)(Submit - S)(Exit - E)(Write - W): ");
			String choice;
			choice = scan.nextLine().toUpperCase();
			switch(choice)
			{
				case "U":											//UPWARD MOVEMENT
						{
							if (x == 0) 
							{
								System.out.printf("%80s", "Invalid up move!!" + "\n"); 
							}
							else
							{
								x--;
							}
							break;
						}
				case "R":										//RIGHTSIDE MOVEMENT
						{
							if (y == 10) 
							{
								System.out.printf("%80s", "Invalid right move!!" + "\n");
							}
							else
							{
								y++;
							}
							break;
						}
				case "D":											//DOWNWARD MOVEMENT
						{
							if (x == 10) 
							{
								System.out.printf("%80s", "Invalid down move!!" + "\n");
							}
							else
							{
								x++;
							}
							break;
						}
				case "L":							//LEFTSIDE MOVEMENT
						{
							if (y == 0) 
							{
								System.out.printf( "%80s", "Invalid left move!!" + "\n");
							}
							else
							{
								y--;
							}
							break;
						}
				case "W":						//WRITE
						{
							if (array[x][y] instanceof Letter && ((Letter) array[x][y]).pos == 0) 
							{
								System.out.print("Enter the letter:");
								String input = scan.nextLine().toUpperCase();
								if (!choice.isEmpty()) 
								{
    								char replace = input.charAt(0);
    								array[x][y].letter = replace;
								}
							}
							else
							{
								System.out.printf("%80s", "You cannot write in this place!!" + "\n");
							}
							break;
						}
				case "S":							//SUBMIT AND CHECK FOR CORRECT ANSWERS
						{
							check(array);
							break;
						}
				case "E":							//EXIT
						{
							flag = 0;
							System.out.println("Exiting the game!");
							System.exit(0);
							break;
						}
				default: System.out.printf("%80s", "Invalid choice!" + "\n");	
			}
		}
	}
}