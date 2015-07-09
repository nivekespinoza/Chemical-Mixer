/*
Description: <The Chamber Class allows chemical to be added to certain 
chamber. The user is allowed to enter any chemicals and amount they need 
to any chamber. If there is a repeated chemical, the mixer will handle
 the redundancy and combine the the same chemical and reports the updated 
 volume. Mixes the solutions for the next phase.Then it orders the chemicals with a sort 
 method in desending order
 */
 
 /**
  * Chamber is a concrete class that defines
  * properties and behavior of a chamber datatype
  * <p>
  * Chambers contain a list of solutions and
  * can be added to other Chambers
  * or Solutions to create new Chambers.
  * <p>
  *  
  * @author Kevin Espinoza
  * @version "%I%, %G%"
  */

import java.util.*;
 
public class Chamber implements Product{
    private ArrayList<Solution> values;
    private String name;
    
	private Chamber()
	{
		values=new ArrayList<Solution>();
		name="";
	}
    
    public Chamber(ArrayList<Solution> values)
    {
    	Chamber();
    	for (Solution solution : values)
    		this.add(solution);
     }
     
     public Chamber(String name, ArrayList<Solution> values)
     {
     	Chamber(name,values);
     }
     	
     	/**
     	 * Adds a solution to the chamber, combines duplicates
     	 * @param Solution s 	the solution to add
     	 */
	// add solution s to this chamber		
	// look through all the solutions in this chamber
	// and if the solution we are adding is already in this chamber then
	// increment the volume
	public void add(Solution s)
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

	
	/**
	 * Searches for solution by solution name
	 * @param Solution s	solution to be searched for by name
	 * @return index of found solution, -1 if solution is not found
	 * @deprecated use <code>add</code> to remove duplicates, use of
	 * search not encouraged
	 */
	/*
     * looks thru the array for s.name
     * if found save the location
     * return location of index
     */
    public int search(Solution s)
    {
        int index = -1;//*******
        for(int i = 0; i < values.size(); i++)
        {
            String name1 = s.getName();
            String name2 = values.get(i).getName();
             
            if(name1.equals(name2))
            {
                return index; //index of found solution
            }
        }
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
    		newChamber.add(solution);
    	
    	for (Solution solution : other.values)
    		newChamber.add(solution);
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
 
