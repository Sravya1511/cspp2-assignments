import java.util.*;
class Show {
	String nameOfMovie;
	String date;
	String[] list;
	Patron[] bookedSeats;

	Show (String n, String d, String[] l) {
		nameOfMovie = n;
		date = d;
		list = l;
		bookedSeats = new Patron[l.length];
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(nameOfMovie + ",");
            sb.append(date + ",");
            sb.append("[");
            for(int i = 0; i<list.length-1; i++) {
            	sb.append(list[i] + ",");
            }
            sb.append(list[list.length-1] + "]");
        return sb.toString();
    }
}
class Patron {
	String user;
	String mobile;
	/**
	 * Constructs the object.
	 *
	 * @param      u     { parameter_description }
	 * @param      m     { parameter_description }
	 */

	Patron(final String u, final String m) {
		user = u;
		mobile = m;
	}
}

public class BookYourShow {
	Show[] showsList;
	int size;
	BookYourShow() {
		showsList = new Show[10];
        size = 0;
	}


	public void addAShow(Show show) {
		showsList[size++] = show;
		// for(Show i : showsList)
		// System.out.println(i);
	}

	public void getAShow(String movie, String time) {
		int j = 0;
		for(int i = 0; i<size; i++) {
			if(showsList[i].nameOfMovie.equals(movie) && showsList[i].date.equals(time)) {
				System.out.println(movie+","+time);
					j = 1;
					break;
			}
		}
		if(j == 0)
		System.out.println("No show");
	}

	public void showAll() {
		for(int i = 0; i<size; i++)
			System.out.println(showsList[i]);
	}

	public void bookAShow(String movieName, String date, Patron p, String[] listTic) {
		if(size == 0){
			System.out.println("No show");
			return;
		}
		// if(s.nameOfMovie.equals(movieName) && s.date.equals(date)) {

		// }
		int c = 0;
		for(Show s : showsList) {
			if(s!=null) {
		        if(s.nameOfMovie.equals(movieName) && s.date.equals(date)) {
		        	c = 1;
                for(String seatNumber : listTic) {
            	    for(int j = 0; j<s.list.length; j++) {
            		    if(s.list[j].equals(seatNumber)) {
            			s.list[j] = "N/A";
            			s.bookedSeats[j] = p;

            		    }
            	    }
                }
		        }
            }
	    }
	    if(c == 0){
	    	System.out.println("No show");
	    }

	}

	// public void bookAShow(String movieName, String date, Patron p, String[] list_tic) {
	// 	for(int i = 0; i<size; i++) {
	// 	if(showsList[i].nameOfMovie.equals(movieName) && showsList[i].date.equals(date)) {
 //            for(int m = 0; m<list_tic.length; m++) {
	// 		int k = 0;
	// 		for(int j = 0; j<showsList[k].list.length; j++) {
	// 			if(list_tic[m] == showsList[k].list[j])
	// 				showsList[k].list[j] = "N/A";
	// 			k++;
	// 		}
	// 	  }
	// 	}
 //       }
	// }

	 public void printTicket(String movieName, String date, String mobile) {
		boolean x = false;
		for(Show s : showsList) {
			if(s!=null) {
		        if(s.nameOfMovie.equals(movieName) && s.date.equals(date)) {
                    for(int i = 0; i<s.bookedSeats.length; i++) {
             	        if(s.bookedSeats[i]!=null) {
             	            if(s.bookedSeats[i].mobile.equals(mobile)) {
             		            x = true;
             	            }
                        }
		            }
	            }
	        }
	    }
	    if(x == true) {
	    	System.out.println(mobile+" "+movieName+" "+date);
	    } else {
	    	System.out.println("Invalid");
	    }
	}
}