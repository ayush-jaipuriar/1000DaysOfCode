import java.util.ArrayList;
import java.util.List;

public class ProductSumRecursion {

	public static int productSum(List<Object> array) {
	    // Write your code here.
	    return productSumHelper(array,1);
	  }

	  public static int productSumHelper(List<Object> array, int multiplier) {
	    int sum =0;
	    for (Object obj : array) {
	      if (obj instanceof ArrayList) {
	        @SuppressWarnings("unchecked")
	        ArrayList<Object> ls = (ArrayList<Object>) obj;
	        sum += productSumHelper(ls, multiplier+1);
	      } else {
	        sum += (int) obj;
	      }
	    }
	    return sum * multiplier;
	  }

}
