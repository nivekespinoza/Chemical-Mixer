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
     * Gets element of name from the end of the list
     * @return 
     */
    abstract String getName();
    
    /**
     * Sets element of name from the end of the list
     * @return 
     */
    abstract void setName(String name);
     
    /**
     * Gets element of Volume from the end of the list
     * @return 
     */
    abstract double getVolume();
    
    /**
     * Sets element of Volume from the end of the list
     * @return 
     */
    abstract void setVolume(double volume);
    
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
	 */
	@Override
	public int compareTo(Product other) {
		return (int) (this.getVolume() - other.getVolume());
	}
}