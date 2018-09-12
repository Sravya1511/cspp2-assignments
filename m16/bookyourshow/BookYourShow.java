import java.util.*;
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
		for(Show s : showsList) {
			if(s!=null) {
		        if(s.nameOfMovie.equals(movieName) && s.date.equals(date)) {
                for(String seatNumber : listTic){
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

	 public void printTickets(String movieName, String date, String mobile) {
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
	    }
	}
}