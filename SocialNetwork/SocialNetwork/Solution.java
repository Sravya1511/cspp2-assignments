import java.util.*;
import java.io.*;
class Users {
	String name;
	ArrayList<String> followers;
	Users(String user, ArrayList<String> followers) {
		this.name = user;
		this.followers = followers;
	}
}

class Social {
	ArrayList<Users> user;
	Social() {
       user = new ArrayList<Users>();
	}

	public void addC(Users u) {
		user.add(u);
	}

	public void addConnections(Users u) {
		boolean x = false;
		for(int i = 0; i<user.size(); i++) {
			if(user.get(i).name.equals(u.name)) {
				for(int j = 0;j<u.followers.size();j++)
				user.get(i).followers.add(u.followers.get(j));
			    x = true;
			}
		}
		if(!x)
        System.out.println("Not a user in Network");
		// for (int i=0; i<user.size(); i++) {
		// 	System.out.print(user.get(i).user+" ");
  //           System.out.println(user.get(i).followers);
		}
	public ArrayList<String> getConnections(String a) {
		for(int i = 0; i<user.size(); i++) {
			if(user.get(i).name.equals(a)) {
                return user.get(i).followers;
			}
		}
		return null;
	}

	public void getCommonConnections(String a, String b) {
		ArrayList<String> list1;
		ArrayList<String> list2;
		list1 = new ArrayList<String>();
		list2 = new ArrayList<String>();
		for(int i = 0; i<user.size(); i++) {
			if(user.get(i).name.equals(a)) {
				list1 = getConnections(a);
				// System.out.println(list1);
			}
			if(user.get(i).name.equals(b)) {
				list2 = getConnections(b);
				// System.out.println(list2);
			}
	    }
	    ArrayList<String> s;
	    s = new ArrayList<String>();
	    for(String i : list1) {
	    	if (list2.contains(i)) {
	    		s.add(i);
	    	}

	    }

	    System.out.println(s);
	}

	public void network() {
		for(int i = 0; i<user.size(); i++) {
			System.out.print(user.get(i).name +": ");
			System.out.print(user.get(i).followers+ ", ");
		}
		System.out.println();
	}
}


class Solution {
	public static void main(String[] args) {
		Social s = new Social();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String token = input.nextLine();
			String[] list1 = token.split(" ");
			// System.out.println(Arrays.toString(list1));
			switch(list1[0]) {
				case "Create":
				for(int i = 0; i<Integer.parseInt(list1[1]); i++) {
					String[] line1 = input.nextLine().replace(", ",",").split("\\.");
					String[] line2 = line1[0].split(" is connected to ");
					String[] line3 = line2[1].split(",");
					// System.out.println(Arrays.toString(line2));
					// System.out.println(Arrays.toString(line3));
                    String n = line2[0];
                    ArrayList<String> f;
                    f = new ArrayList<String>(line3.length-1);
                    for(int j = 0; j<line3.length; j++) {
                    	f.add(line3[j]);
                    }
                    s.addC(new Users(n, f));
				}
				break;
				case "addConnections":
				String s1 = list1[1];
				ArrayList<String> s2;
			    s2 = new ArrayList<String>(list1.length-2);
				for(int i = 2; i<list1.length; i++) {
                    s2.add(list1[i]);
				}
				s.addConnections(new Users(s1, s2));
				break;
				case "getConnections":

				if(s.getConnections(list1[1]) == null) {
					System.out.println("Not a user in Network");
				}
				else {
					System.out.println(s.getConnections(list1[1]));
				}

				break;
				case "CommonConnections":
				s.getCommonConnections(list1[1], list1[2]);
				break;
				case "Network" :
				s.network();
				break;
			}
		}
	}
}


