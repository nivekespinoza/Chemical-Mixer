package product;
import java.util.ArrayList;
import java.util.Scanner;
 
 
public class CSE205_Assignment06 {
	private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        int chamberChosen = 0;
        Chamber c_1 = null;
        Chamber c_2 = null;
        Chamber c_3 = null;
       
        //Gives the user an option to pick which chamber their going to work on
        while(chamberChosen != 321)
        {
            displayChamberMenu();
            chamberChosen = kb.nextInt();// and volume
             
            switch(chamberChosen)
            {
            case 1:// chooses Chamber One
            	(c_1) = addSolutions();
                break;
             
            case 2:// chooses Chamber Two
            	(c_2) = addSolutions();
                break;
                 
            case 3:// Mixes Chamber one and two & make sure c1 and c2 aren't empty
            	c_1.combine(c_2);      
            	System.out.println(c_1);
                break;
                 
            case 321:// Exits the system
            	ShutDown();
                break; 
                
            default:
                MenuError();
            	break;          
            }     
         }
    }
 
    /*
     * adds solution to the chamber one or two when the user is ready
     */
	private static Chamber addSolutions()
    {
    	ArrayList<Solution> values = new ArrayList<Solution>();
    	String name= "";
    	int volume;
    	do{
    		System.out.print("Enter Solution (0 to exit: )\n" + "Name: ");//gets input
    		kb.nextLine(); //clear buffer
    		name = kb.nextLine().toLowerCase();
    		if(!name.equals("0"))
    		{
    			System.out.print("Volume:\n ");
        		volume = kb.nextInt();    		
        		values.add(new Solution(name,volume));//adds to arraylist
    		}
    	}
    	
		while(!name.equals("0"));    	
    	return new Chamber(values); //calls chamber constructor    	
	}

	//displays the options for the user
		private static void displayChamberMenu()
		{
	        System.out.println("*****************************************");
	        System.out.println("Mixing Chamber of Chemical Solutions");
	        System.out.println("*****************************************");
	        System.out.println("1) Enter Solutions for Chamber One");
	        System.out.println("2) Enter Solutions for Chamber Two");
	        System.out.println("3) Mix Chamber One & Two ");
	        System.out.println("321) Press # to Exit the System ");
        }
		
		 private static void MenuError() 
		 {
	        System.out.println("*****************************************");
	    	System.out.println("************Invaliad Entry***************");
	        System.out.println("*****************************************");
		 }
		 
		 private static void ShutDown()
		 {
			 System.out.println("System Shut Down");				
		 } 
}
