import java.util.*;
public class ClientsList {
	public class Person implements Comparable<Person>{
		private String first;
		private String last;
		
		public Person(String fname, String lname) {
			first = fname;
			last = lname; 
		}
		public String getFirst() {
			return first;
		}
		public String getLast() {
			return last;
		}
		@Override 
		public int compareTo(Person p) {
			int ldiff= last.compareTo(p.last);
			if (ldiff!=0) {
				return ldiff;
			}
			return first.compareTo(p.first);	
		}
	}
	 public String[] dataCleanup(String[] names) {
         Person[] list = new Person[0];
         Comparator<Person> comp = Comparator.comparing(Person::getLast);
         comp = comp.thenComparing(Person::getFirst);
         Arrays.sort(list,comp);
         for(int k=0; k < names.length; k++) {
        	 names[k] = list[k].toString();
         }
         return names;

    }

}
