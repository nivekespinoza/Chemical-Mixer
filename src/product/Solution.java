package product;
 /**
  * Solution is a concrete class defining the properties
  * and behavior of the Solution datatype
  * 
  * @author Kevin Espinoza
  * @author Patrick Michaelsen
  * @version "%I%, %G%"
  * @since 1.0
  */

public class Solution extends Product implements Comparable<Product> {
   
    private String name;
    private double volume;

    public Solution(String name, double volume)
    {
    	if(volume<0)
    		throw new NegativeVolumeException(""+volume);
        this.name = name;
        this.volume = volume;    
    }    
    
    /**
     * Empties and combines contents of <code>other</code> 
     * <code>this</code> solution. 
     * @param Product other		the product to be combined
     */
    public Product combine(Product other)
    {
    	if(other==null)
    		return other;
    	
    	if(other instanceof Chamber){
    		Chamber chamber = (Chamber) other;
    		chamber.add(this);
    		chamber.sort();
    		
    		return chamber;
    	}
    	
    	if(other instanceof Solution){
    		Solution solution = (Solution) other;
    		
    		//if the solutions are the same combine them
    		//and return new solution
    		if(equals(solution)){
    			double volume = this.getVolume();
        		double volumeOther = solution.getVolume();
         	         
        		this.setVolume(volume+volumeOther);
        		solution.setVolume(0);
        		 
        		
        	    other = null;
        	    
        	    return this;
        	//otherwise create new chamber
        	//and return that
    		}else{
    			Chamber chamber = new Chamber();
    			chamber.add(solution);
    			chamber.add(this);
    			
    			//other is now empty so delete it
    			other = null;
    			
    			return chamber;
    		}
    			
    		
    	}
        
    	return null;
    }
 
    public String getName()
    {
        return name;
    }
 
    public double getVolume()
    {
        return volume;
    }
     
    public void setName(String name)
    {
        this.name = name;
    }
     
    public void setVolume(double volume)
    {
    	if(volume>getVolume())
			throw new CannotIncreaseVolumeException(volume/getVolume()*100+"");
        this.volume = volume;       
    }
    
	@Override
	public String toString()
	{
		return getClass().getSimpleName() + 
				" " + name + 
				": " + volume + 
				" " + UNITS;
	}
	
	@Override
	public boolean equals(Object other){
		 if (other == null){
			 return false;
		 }

		 if (getClass() != other.getClass()){
			 return false;
		 }
		 
		 Solution solution = (Solution) other;
		 if(!getName().equals(solution.getName())){
			return false;
		 }
		 
		 return true;
	}
	
	@Override
	public int hashCode(){
		return Integer.valueOf(name);
	}
}
 
