package product;
 /**
  * Solution is a concrete class defining the properties
  * and behavior of the Solution datatype
  * 
  * @author Kevin Espinoza
  * @version "%I%, %G%"
  * @since 1.0
  */

public class Solution implements Product, Comparable<Solution> {
   
    private String name;
    private int volume;

    private Solution()
    {
    	name="";
    	volume=0;
    }

    public Solution(String name, int volume)
    {
        this.name = name;
        this.volume = volume;    
    }    
    
    /**
     * Empties and adds contents of <code>other</code> 
     * <code>this</code> solution. 
     * //TODO add solution name check
     * @param Solution other	solution to be added
     */
    public void combine(Solution other)
    {
        int measure = this.getVolume();
        int measure2 = other.getVolume();
        int measurement = measure + measure2;
         
        this.setVolume(measurement);
        other.setVolume(0);
    }
 
    public String getName()
    {
        return name;
    }
 
    public int getVolume()
    {
        return volume;
    }
     
    public void setName(String name)
    {
        this.name = name;
    }
     
    public void setVolume(int i)
    {
        this.volume = i;       
    }
    
	@Override
	public String toString()
	{
		return name + ": " + volume + " Liter(s)";
	}

	@Override
	public int compareTo(Solution other)
	{
		return this.getVolume() - other.getVolume();
	}
}
 
