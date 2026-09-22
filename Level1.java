//MAIN METHOD LEVEL 1
import java.util.Scanner;

class Level1 
{	
	public static int flag = 1;
	public static int x = 0; 		//LOCATION VARIABLES
	public static int y = 0;
	public static void ready(Grid arr[][])
	{
			for (int i = 0; i < 10 ; i++ ) 
			{
				for (int j = 0; j < 10 ;j++ ) 		// GRID INITIALIZATION//
				{
					arr[i][j] = new Grid();
				}
			}
			for (int i = 0; i < 10 ; i++ ) 
			{
				for (int j = 0; j < 10 ;j++ ) 
				{
					if (i == 1 && j == 1) 
					{
						arr[i][j] = new Letter('D',1);
					}
					else if (i == 2 && j == 2) 
					{
						arr[i][j] = new Letter('L',1);
					}
					else if (i == 2 && j == 7) 
					{
						arr[i][j] = new Letter('T',1);			//GRID INSTANTIATION
					}
					else if (i == 2 && j == 9) 					//NON EDITABLE LOCATIONS
					{
						arr[i][j] = new Letter('M',1);
					}
					else if (i == 3 && j == 6) 
					{
						arr[i][j] = new Letter('R',1);
					}
					else if (i == 4 && j == 1) 
					{
						arr[i][j] = new Letter('A',1);
					}
					else if (i == 7 && j == 6) 
					{
						arr[i][j] = new Letter('L',1);
					}
					else if ((i == 1 && j == 6) || (i == 2 && j == 1) ||(i == 2 && j == 3) ||(i == 2 && j == 4) ||(i == 2 && j == 5) ||(i == 2 && j == 6) ||(i == 2 && j == 8) ||(i == 3 && j == 1) ||(i == 4 && j == 6) ||(i == 5 && j == 6) ||(i == 6 && j == 6)) 
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
			for (int j = 0; j < 10 ;j++ ) 
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
		if (arr[1][6].letter == 'V' && arr[2][1].letter == 'A' && arr[2][3].letter == 'G' && arr[2][4].letter == 'O' && arr[2][5].letter == 'R' && arr[2][6].letter == 'I' && arr[2][8].letter == 'H' && arr[3][1].letter == 'T' && arr[4][6].letter == 'T' && arr[5][6].letter == 'U' && arr[6][6].letter == 'A') 
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
		Grid array[][] = new Grid[10][10];
		ready(array);							//CALLS READY()
		while(flag == 1)						// LOOP FOR INTERACTIVE SWITCH CASE
		{
			System.out.println();
			System.out.println("                                 Level 1");
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