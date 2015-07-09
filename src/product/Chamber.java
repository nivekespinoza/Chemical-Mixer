/*
CSE 205: <Class #40302> / <MTWTrF 8:30 am - 9:30 am>

Assignment: <assignment #06>

Author: <Kevin Espinoza> & <1203366978>, …

Description: <The Chamber Class allows chemical to be added to certain 
chamber. The user is allowed to enter any chemicals and amount they need 
to any chamber. If there is a repeated chemical, the mixer will handle
 the redundancy and combine the the same chemical and reports the updated 
 volume. Mixes the solutions for the next phase.Then it orders the chemicals with a sort 
 method in descending order
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
  * @author Patrick Michaelsen
  * @version "%I%, %G%"
  */

package product;

import java.util.*;
 
public class Chamber extends Product implements Comparable<Product>{
	private ArrayList<Solution> values;
	private String name;
	private static int id = 0;
    
	/**
	 * create empty chamber with auto-incrementing <code>name</code>
	 */
	public Chamber()
	{
		values=new ArrayList<Solution>();
		name=""+id++;
	}
    
	/**
	 * create a chamber with auto-incrementing <code>name</code>
	 * with list of solutions
	 * @param values an array of solutions
	 * @see #Chamber()
	 */
    public Chamber(ArrayList<Solution> values)
    {
    	this();
    	for (Solution solution : values)
    		add(solution);
    	sort();
    }
     
    /**
     * create a named chamber
	 * with list of solutions
	 * @param values an array of solutions
	 * @param name the lowercase name of the chamber 
	 * @see #Chamber(values)
	 */
    public Chamber(String name, ArrayList<Solution> values)
    {
    	this(values);
    	this.name = name.toLowerCase();
    	sort();
    }
     	
    /**
     * Adds a solution to the chamber, combines duplicate solutions
     * @param s 	the solution to add
     */
	// add solution s to this chamber		
	// look through all the solutions in this chamber
	// and if the solution we are adding is already in this chamber then
	// increment the volume
	public void add(Solution s)
	{
		if(s.getVolume()>0){
			for (Solution solution : values)
			{
				if (solution.equals(s))
				{
					solution.combine(s);
					return;
				}
			}
			// else, add this new solution
			values.add(s);
		}
		//sort();
	}
	
	/**
	 * Searches for solution by solution name
	 * @param s	solution to be searched for by name
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
        return index;
    }
     
     
    /**
     * Empties and combines the product <code>other</code> to 
     * <code>this</code> chamber, removes duplicates,
     * and sorts in descending order by solution 
     * volume.
     * @param other		the product to be combined
     * @return the resulting chamber
     */
    /*
     * the combine method does the values being passed in
     * if the strings are the same add the 
     * integer value and convert the string into one element
     * copies both arrays into one array
     * repeats till there are no further copies
     */
    public Product combine(Product other)
	{
    	if(other==null)
    		return other;
    	
    	if(other instanceof Chamber){
    		Chamber chamber = (Chamber) other;
        	for (Solution solution : chamber.values){
        		this.add(solution);
        	}
        	
        	chamber.values.removeAll(values);
        	this.sort();
    	}
    	
    	if(other instanceof Solution){
    		Solution solution = (Solution) other;
    		this.add(solution);
    		this.sort();
    	}
    	
    	
    	//other is now empty so delete it
    	other = null;
    	
    	return this;
     	
    }  
     
    public ArrayList<Solution> getValues()
    {
        return values;
    }
    
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + 
				" " + getName() + 
				": " + getVolume() + 
				" " + UNITS + 
				"\nIngredients: " + 
				values;
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
	public double getVolume()
	{
		double volume = 0;
		for(Solution s: values)
			volume+=s.getVolume();
		return volume;
	}

	/**
	 * Reduce the volume of a chamber,
	 * assumes solution is homogeneously
	 * mixed
	 * @throws NegativeVolumeException volume must be > 0
	 * @throws CannotIncreaseVolumeException volume cannot 
	 * scale beyond 100%<br>of original volume
	 * @return 
	 */
	@Override
	public Product setVolume(double volume)
	{
		double scalar = volume/getVolume();
		
		if(volume<0){
			throw new NegativeVolumeException(""+volume);
		}
		
		if(volume>getVolume()){
			throw new CannotIncreaseVolumeException(100*scalar+"%");
		}
		
		Chamber excessChamber = new Chamber();
		
		//for each solution in values
		for(Solution s: values){
			//add it to the excess chamber
			excessChamber.add(
					//get the excess solution
					(Solution)s.setVolume(
							//adjust the volume
							s.getVolume()*scalar));
		}
		
		return excessChamber;
	}
	
	/**
	 * @returns true if <code>this</code>
	 * chamber has same ratio of solutions
	 * as <code>other</code> chamber
	 * @param other the other Product
	 */
	@Override
	public boolean equals(Object other){
		 if (other == null){
			 return false;
		 }

		 if (getClass() != other.getClass()){
			 return false;
		 }
		 
		 Chamber chamber = (Chamber) other;
		 
		 if(values.size()!=chamber.values.size()){
			 return false;
		 }
		
		 double chamberVolume = getVolume();
		 double chamberOtherVolume = chamber.getVolume();
		 
		 for(int i = 0; i < values.size(); i++){
			 Solution solution = values.get(i);
			 Solution solutionOther = chamber.values.get(i);
			 
			 if(!solution.equals(solutionOther))
				 return false;
			 
			 double solutionVolume = solution.getVolume();
			 double solutionOtherVolume = solutionOther.getVolume();
			 
			 if(solutionVolume/chamberVolume!=solutionOtherVolume/chamberOtherVolume)
				 return false;
		 }
		 
		 return true;
	}
	
	@Override
	public int hashCode(){
		
		int namesHash = 0;
		int volumesHash = 0;
		
		double chamberVolume = getVolume();
		
		for(int i = 0; i < values.size(); i++){
			Solution solution = values.get(i);
			double solutionVolume = solution.getVolume();
			
			volumesHash += solutionVolume/chamberVolume;
			namesHash += Integer.valueOf(solution.getName());
		 }
		 
		return (volumesHash << 16) | (namesHash >>> 16);
	}
	
	/**
	 * sorts solutions in descending
	 * order by volume
	 */
	public void sort()
	{
		Collections.sort(values);
		Collections.reverse(values);
	}

	
	
}
 
