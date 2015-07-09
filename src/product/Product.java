 /**
  * Product is an abstract class defining the properties
  * and behavior of the Product datatype
  * 
  * @author Kevin Espinoza
  * @author Patrick Michaelsen
  * @version "%I%, %G%"
  * @since 1.0
  */

package product;
abstract class Product implements Comparable<Product>{
	
	final static String UNITS = "mL";
	
    /**
     * Gets the product's name
     * @return  the product's name
     */
    abstract String getName();
    
    /**
     * Updates the product's name
     * @param  name the new lowercase name 
     */
    abstract void setName(String name);
     
    /**
     * Gets product's volume
     * @return	the product's volume
     */
    abstract double getVolume();
    
    /**
     * Updates the product's volume
     * @param volume	the new volume
     */
    abstract Product setVolume(double volume);
    
    /**
     * Combines two products by adding
     * <code>other</code> product to <code>this</code>
     * product
     * @return the new product
     */
    abstract Product combine(Product other);
    
    
    /**
	 * Compares two products by volume
	 * @return returns an integer indicating whether
	 * this product is greater than (result is > 0)
	 * equal to (result is = 0) or less than
	 * (result is < 0) the argument <code>other</code>
	 * @param other the product to be added
	 */
	@Override
	public int compareTo(Product other) {
		return (int) (this.getVolume() - other.getVolume());
	}
}