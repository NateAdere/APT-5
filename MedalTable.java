import java.util.*;
public class MedalTable {
	private Map<String,Integer> gold = new HashMap<>();
	private Map<String,Integer> silver = new HashMap<>();
	private Map<String,Integer> bronze = new HashMap<>();
	
	public class Country implements Comparable<Country> {
		public String country;
		public Country(String s) {
			country = s;
		}
		@Override 
		public int compareTo(Country x) {
			int g = gold.get(country) - gold.get(x.country);
			int s = silver.get(country) - silver.get(x.country);
			int b = bronze.get(country) - bronze.get(x.country);
			if (g!= 0) {
				return -1*g;
			}
			if (s!= 0) {
				return -1*s;
			}
			if (b!= 0) {
				return -1*b;
			}
			return country.compareTo(x.country);
		}
		@Override
		public String toString() {
			return String.format("%s %d %d %d", country, gold.get(country), silver.get(country),bronze.get(country));
		}
	}
	public String[] generate(String[] results) {
	      for (String k : results) {
	    	  String[] array = k.split(" ");
	    	  for(String i : array) {
	    		  gold.putIfAbsent(i, 0);
	    		  silver.putIfAbsent(i, 0);
	    		  bronze.putIfAbsent(i, 0);
	    		  
	    	  }
	    	  String gc = array[0];
	    	  String sc = array[1];
	    	  String bc = array[2];
	    	  gold.put(gc,gold.get(gc) + 1);
	    	  silver.put(sc,silver.get(sc) + 1);
	    	  bronze.put(bc,bronze.get(bc) + 1);
	      }
	      ArrayList<Country> lst = new ArrayList<>();
	      for (String k : gold.keySet()) {
	    	  lst.add(new Country(k));
	      }
	      Collections.sort(lst);
	      String[] ans = new String[lst.size()];
	      for(int k=0; k < ans.length; k+=1) {
	    	  ans[k] = lst.get(k).toString();
	      }
	      return ans;
	
	

}
}
