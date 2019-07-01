import java.util.*;
public class Dirsort {
        public class DirComp implements Comparator<String> {
        	@Override 
        	public int compare(String a, String b) {
        		String[] arr = a.split("/");
        		String[] brr = b.split("/");
        		int diff = arr.length - brr.length;
        		if (diff < 0) {
        			return -1;
        		}
        		if (diff > 0) {
        			return 1;
        		}
        		int ans = 0;
        		if (diff == 0) {
        			for (int k = 0; k < arr.length; k++) {
        				int comp = arr[k].compareTo(brr[k]);
        				if (comp < 0) {
        					return -1;
        				}
        				if (comp > 0) {
        					return 1; 
        				}
        				else {
        					ans = 0;
        				}
        				
        
        			}
        			
        		}
        		
        		return ans;
        		
        	}
        	
        }
    	public String[] sort(String[] dirs) {
    		Arrays.sort(dirs, new DirComp());
    		return dirs;
    	}
}
