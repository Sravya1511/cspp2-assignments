import java.util.*;
/**
 * Class for book your show.
 */
public class BookYourShow {
	/**
	 * { var_description }.
	 */
	Show[] showsList;
	/**
	 * { var_description }.
	 */
	int size;
	/**
	 * Constructs the object.
	 */
	BookYourShow() {
		showsList = new Show[10];
        size = 0;
	}
	/**
	 * Adds a show.
	 *
	 * @param      show  The show
	 */
	public void addAShow(Show show) {
		showsList[size++] = show;
		// for(Show i : showsList)
		// System.out.println(i);
	}
	/**
	 * Gets a show.
	 *
	 * @param      movie  The movie
	 * @param      time   The time
	 */

	public void getAShow(String movie, String time) {
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (showsList[i].nameOfMovie.equals(movie) && showsList[i].date.equals(time)) {
				System.out.println(movie+","+time);
					j = 1;
					break;
			}
		}
		if (j == 0) {
			System.out.println("No show");
		}

	}
	/**
	 * Shows all.
	 */

	public void showAll() {
		for (int i = 0; i < size; i++)
			System.out.println(showsList[i]);
	}
	/**
	 * { function_description }.
	 *
	 * @param      movieName  The movie name
	 * @param      date       The date
	 * @param      p          { parameter_description }
	 * @param      listTic    The list tic
	 */

	public void bookAShow(String movieName, String date, Patron p, String[] listTic) {
		if (size == 0) {
			System.out.println("No show");
			return;
		}
		// if(s.nameOfMovie.equals(movieName) && s.date.equals(date)) {

		// }
		int c = 0;
		for (Show s : showsList) {
			if (s != null) {
		        if (s.nameOfMovie.equals(movieName) && s.date.equals(date)) {
		        	c = 1;
                for (String seatNumber : listTic) {
            	    for (int j = 0; j < s.list.length; j++) {
            		    if (s.list[j].equals(seatNumber)) {
            			s.list[j] = "N/A";
            			s.bookedSeats[j] = p;

            		    }
            	    }
                }
		        }
            }
	    }
	    if (c == 0) {
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


/**
 * { function_description }.
 *
 * @param      movieName  The movie name
 * @param      date       The date
 * @param      mobile     The mobile
 */
	 public void printTicket(String movieName, String date, String mobile) {
		boolean x = false;
		for (Show s : showsList) {
			if (s!=null) {
		        if (s.nameOfMovie.equals(movieName) && s.date.equals(date)) {
                    for (int i = 0; i < s.bookedSeats.length; i++) {
             	        if (s.bookedSeats[i] != null) {
             	            if (s.bookedSeats[i].mobile.equals(mobile)) {
             		            x = true;
             	            }
                        }
		            }
	            }
	        }
	    }
	    if (x == true) {
	    	System.out.println(mobile+" "+movieName+" "+date);
	    } else {
	    	System.out.println("Invalid");
	    }
	}
}