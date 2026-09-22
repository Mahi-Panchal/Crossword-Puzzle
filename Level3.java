//MAHI K PANCHAL(202302626010095)
//MARHAMA SHAIKH (202302626010124)
//ANANYA TIWARI (202302626010138)
//MAIN METHOD LEVEL 3
import java.util.Scanner;

class Level3 
{
	public static int flag = 1;
	public static int x = 0; 		//LOCATION VARIABLES
	public static int y = 0;
	public static void ready(Grid arr[][])
	{
			for (int i = 0; i < 10 ; i++ ) 
			{
				for (int j = 0; j < 8 ;j++ ) 		// GRID INITIALIZATION//
				{
					arr[i][j] = new Grid();
				}
			}
			for (int i = 0; i < 10 ; i++ ) 
			{
				for (int j = 0; j < 8 ;j++ ) 
				{
					if (i == 0 && j == 1) 
					{
						arr[i][j] = new Letter('M',1);
					}
					else if (i == 2 && j == 3) 
					{
						arr[i][j] = new Letter('P',1);
					}
					else if (i == 3 && j == 4) 
					{
						arr[i][j] = new Letter('I',1);			//GRID INSTANTIATION
					}
					else if (i == 3 && j == 5) 					//NON EDITABLE LOCATIONS
					{
						arr[i][j] = new Letter('N',1);
					}
					else if (i == 4 && j == 1) 
					{
						arr[i][j] = new Letter('O',1);
					}
					else if (i == 5 && j == 1) 
					{
						arr[i][j] = new Letter('L',1);
					}
					else if (i == 5 && j == 3) 
					{
						arr[i][j] = new Letter('R',1);
					}
					else if (i == 8 && j == 1) 
					{
						arr[i][j] = new Letter('M',1);
					}
					else if (i == 8 && j == 3) 
					{
						arr[i][j] = new Letter('H',1);
					}
					else if ((i == 1 && j == 1) || (i == 2 && j == 1) ||(i == 3 && j == 1) ||(i == 3 && j == 2) ||(i == 3 && j == 3) ||(i == 3 && j == 6) ||(i == 4 && j == 3) ||(i == 6 && j == 1) ||(i == 6 && j == 3) ||(i == 7 && j == 1) ||(i == 7 && j == 3)) 
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
		for (int i = 0; i < 10 ; i++ ) 
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
		if (arr[1][1].letter == 'A' && arr[2][1].letter == 'U' && arr[3][1].letter == 'S' && arr[3][2].letter == 'P' && arr[3][3].letter == 'H' && arr[3][6].letter == 'X' && arr[4][3].letter == 'A' && arr[6][1].letter == 'E' && arr[6][3].letter == 'A' && arr[7][1].letter == 'U' && arr[7][3].letter == 'O') 
		{
			System.out.println();
			System.out.printf("%20s","Congratulations!! You have passed level 3!!\n");
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
		Grid array[][] = new Grid[10][8];
		ready(array);							//CALLS READY()
		while(flag == 1)						// LOOP FOR INTERACTIVE SWITCH CASE
		{
			System.out.println();
			System.out.println("                                 Level 3");
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