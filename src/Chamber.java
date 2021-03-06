/*
CSE 205: <Class #40302> / <MTWTrF 8:30 am - 9:30 am>

Assignment: <assignment #06>

Author: <Kevin Espinoza> & <1203366978>, �

Description: <The Chamber Class allows chemical to be added to certain 
chamber. The user is allowed to enter any chemicals and amount they need 
to any chamber. If there is a repeated chemical, the mixer will handle
 the redundancy and combine the the same chemical and reports the updated 
 volume. Mixes the solutions for the next phase.Then it orders the chemicals with a sort 
 method in desending order
 >
 */

import java.util.*;
 
public class Chamber implements Product{
    private ArrayList<Solution> values = new ArrayList<Solution>();
    private String name;
    
	public Chamber()
	{
		// TODO 
	}
    
    public Chamber(ArrayList<Solution> values)
    {
    	for (Solution solution : values)
    		this.Add(solution);
     }
     	
	// add solution s to this chamber		
	// look through all the solutions in this chamber
	// and if the solution we are adding is already in this chamber then
	// increment the volume
	public void Add(Solution s)
	{
		for (Solution solution : values)
		{
			if (solution.getName().equals(s.getName()))
			{
				solution.combine(s);
				return;
			}
		}
		// else, add this new solution
		values.add(s);
	}

	/*
     * looks thru the array for s.name
     * if found save the location
     * return location of index
     */
    private int search(Solution s)
    {
        int index = -1;//*******
        for(int i = 0; i < values.size(); i++)
        {
            String name1 = s.getName();
            String name2 = values.get(i).getName();
             
            if(name1.equals(name2))
            {
                index = i;
            }
        }
        return index;//the index of copy        
    }
     
    /*
     * the combine method does the values being passed in
     * if the strings are the same add the 
     * integer value and convert the string into one element
     * copies both arrays into one array
     * repeats till there are no further copies
     */
    public Chamber combine(Chamber other)
    {
    	Chamber newChamber = new Chamber();
    	
    	for (Solution solution : this.values)
    		newChamber.Add(solution);
    	
    	for (Solution solution : other.values)
    		newChamber.Add(solution);
    	//instan sort
    	newChamber.sort();
    	
    	return newChamber;
    	
    }  
     
    public ArrayList<Solution> getValues()
    {
        return values;
    }
    
	@Override
	public String toString()
	{
		return "Ingredients: " + values;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public int getVolume()
	{
		return 0;
	}

	@Override
	public void setVolume(int volume)
	{
		// TODO Auto-generated method stub		
	}
	
	public void sort()
	{
		Collections.sort(values);
		Collections.reverse(values);
	}
}
 