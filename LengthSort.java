import java.util.*;

public class LengthSort {
	public String[] rearrange(String[] values){
		Map<Integer,ArrayList<String>> map = new HashMap<>();
        for (String k : values) {
        	int len = k.length();
        	ArrayList<String> empty = new ArrayList<String>();
            map.putIfAbsent(len, empty);
            map.get(len).add(k);
        }
        Set<Integer> keys = map.keySet();
        List<Integer> list = new ArrayList<>(keys);
        Collections.sort(list);   
        String [] ans = new String[values.length];
        for (int k=0; k< list.size(); k+=1) {
        	int fnull = 0;
            for(int v = 0; v < ans.length; v++) {
                if(ans[v] == null) {
                    fnull = v;
                    break;
                }
              }
        	int key = list.get(k);
        	ArrayList<String> value = map.get(key);
        	Collections.sort(value);
        	if (value.size() > 1) {
        		for (int i=0; i < value.size(); i +=1 ) {
        			ans[fnull] = value.get(i);
        			fnull ++;
        		}
        	}
        	else {
        		ans[fnull] = value.get(0);
        	}
        	
        }
        
        return ans;
    }

}
