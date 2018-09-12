import java.util.*;
class Show {
	String nameOfMovie;
	String date;
	String[] list;
	// Patron[] bookedSeats;

	Show(String n, String d, String[] l) {
		nameOfMovie = n;
		date = d;
		list = l;
		// bookedSeats = new Patron(l.length);
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

	Patron(String u, String m) {
		user = u;
		mobile = m;
	}
}



// public class Solution {
// 	public static void main(String[] args) {
// 		// Scanner input = new Scanner(system.in);
// 		String movieName = "Mission Impossible";
//         String datetime = "Aug 18, 2015 17:30";
//         String[] seats = {"A1","A2","A3","B1","B2","B3","C1","C2"};
//         Show show = new Show(movieName, datetime, seats);
//         BookYourShow book = new BookYourShow();
//          book.addAShow(show);
//         String movieName1 = "Mission Impossible";
//         String datetime1 = "Aug 18, 2015 17:30";
//         String[] seats1 = {"A1","A2","A3","B1","B2","B3","C1","C2"};
//         Show show1 = new Show(movieName1, datetime1, seats1);
//         book.addAShow(show1);
//         book.getAShow("Mission Impossible", "Aug 18, 2015 17:30");


// 	}
// }
//
//
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    bys.getAShow(check[1], tokens[1]);
                    // if (show != null) {
                    //    System.out.println(show);
                    // } else {
                    //     System.out.println("No show");
                    // }
                break;

                // case "print":
                //     bys.printTicket(check[1], tokens[1], tokens[2]);
                // break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
