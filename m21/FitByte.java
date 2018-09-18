import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class Food {
	private String nameOffood;
    private double quantity;
    private String date;
    Food(String n, double q, String t) {
     this.nameOffood = n;
     this.quantity = q;
     this.date = t;
    }
    public String getnameOfFood(){
    	return this.nameOffood;
    }
    public double getQuantity() {
    	return this.quantity;
    }
    public String getDate() {
    	return this.date;
    }
}

class Water {
	double amount;
	String date;
	Water(double a, String t) {
		this.amount = a;
		this.date = t;
	}
	public double getAmount() {
		return this.amount;
	}
	public String getDate() {
		return this.date;
	}
}

class PhysicalActivity {
	String activityName;
	String date;
	String startTime;
	String endTime;
	// String notes;
	PhysicalActivity(String a, String d, String s, String e) {
		this.activityName = a;
		this.date = d;
		this.startTime = s;
		this.endTime = e;
		// this.notes = n;
	}
	public String getActivityName() {
		return this.activityName;
	}
	public String getDate() {
		return this.date;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndtime() {
		return this.endTime;
	}
}

class Weight {
	double kgs;
	double fat;
	String date;
	Weight(double k, double f, String d) {
		this.kgs = k;
		this.fat = f;
		this.date = d;
	}
	public double getkgs() {
		return this.kgs;
	}
	public double getFat() {
		return this.fat;
	}
	public String getDate() {
		return this.date;
	}
}

class Sleep {
	String date;
	String starttime;
	String dateEnd;
	String endTime;
	Sleep(String d, String s, String de, String e) {
		this.date = d;
		this.starttime = s;
		this.dateEnd = de;
		this.endTime = e;
	}
	public String getDate() {
		return this.date;
	}
	public String getStartTime() {
		return this.starttime;
	}
	public String getDateEnd() {
		return this.dateEnd;
	}
	public String getEndtime() {
		return this.endTime;
	}

}

class Summary {
     Food[] food;
     Water[] water;
     PhysicalActivity[] pa;
     Weight[] weight;
     Sleep[] sleep;
     int foodSize = 0;
     int waterSize = 0;
     int paSize = 0;
     int weightSize = 0;
     int sleepSize = 0;

     Summary() {
     	food = new Food[20];
     	water = new Water[20];
        pa = new PhysicalActivity[20];
        weight = new Weight[20];
        sleep = new Sleep[20];
     }

     public void addFood(Food f) {
         food[foodSize++] = f;
     }

     public void addWater(Water w) {
     	water[waterSize++] = w;
     }

     public void addPA(PhysicalActivity p) {
     	pa[paSize++] = p;
     }

     public void addWeight(Weight w) {
     	weight[weightSize++] = w;
     }

     public void addSleep(Sleep s) {
     	sleep[sleepSize++] = s;
     }

     public void show(String date) {
     	System.out.println("**Food Log**");
     	int c = 0;
     	for(int i = 0; i<foodSize; i++){
     		String[] list2 = food[i].getDate().split(" ");
     		if(list2[0].equals(date)) {
     			System.out.println(food[i].getnameOfFood()+", "+food[i].getQuantity()+", "+list2[1]);
     			c = 1;
     		}
     	}
     	if(c == 0) {
     	    System.out.println("Food log is empty for "+date);
     	}
     	System.out.println("**Water Log**");
     	int a = 0;
     	for(int i = 0; i<waterSize; i++) {
     		String[] list2 = water[i].getDate().split(" ");
     		if(list2[0].equals(date)) {
     			System.out.println(water[i].getAmount()+", "+list2[1]);
     			a = 1;
     		}
     	}
     	if(a == 0) {
     		System.out.println("Water log is empty for "+date);
     	}
     	int b = 0;
     	System.out.println("**Physical Activity Log**");
     	for(int i = 0; i<paSize; i++) {
     		if(pa[i].getDate().equals(date)){
                System.out.println(pa[i].getActivityName()+", "+pa[i].getStartTime()+", "+pa[i].getEndtime());
                b = 1;
     		}
     	}
     	if(b == 0) {
     		System.out.println("Physical Activity Log is empty for"+date);
     	}
     	int d = 0;
     	System.out.println("**Weight Activity log**");
     	for(int i = 0; i<weightSize; i++) {
     		String[] list2 = weight[i].getDate().split(" ");
     		if(list2[0].equals(date)) {
     			System.out.println(weight[i].getkgs()+", "+weight[i].getFat()+", "+list2[1]);
     			d = 1;
     		}
     	}
     	if(d == 0) {
     		System.out.println("Weight is empty for "+date);
     	}
     	System.out.println("**Sleep log**");
     	int e = 0;
     	for(int i = 0; i<sleepSize; i++) {
     		if(sleep[i].getDate().equals(date)) {
     			System.out.println(" from "+sleep[i].getStartTime()+ " to "+sleep[i].getEndtime());
     			e = 1;
     		}
     	}
     	if(e == 0) {
     		System.out.println("Sleep log is empty");
     	}
    }
}

class FitByte {
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
		Summary summary = new Summary();
		Scanner input = new Scanner(System.in);
		int lines = Integer.parseInt(input.nextLine());
		for(int i = 0; i<lines; i++) {
			String[] list1 = input.nextLine().split(",");
			switch (list1[0]) {
				case "addFood":
				summary.addFood(new Food(list1[1], Double.parseDouble(list1[2]), list1[3]));
				break;
				case "addWater":
				summary.addWater(new Water(Double.parseDouble(list1[1]), list1[2]));
				break;
				case "addPA":
				summary.addPA(new PhysicalActivity(list1[1], list1[2], list1[3], list1[4]));
				break;
				case "addWeight":
				summary.addWeight(new Weight(Double.parseDouble(list1[1]), Double.parseDouble(list1[2]), list1[3]));
				break;
				case "addSleep":
				summary.addSleep(new Sleep(list1[1], list1[2], list1[3], list1[4]));
				break;
				case "show":
				if(list1.length ==1) {
					summary.show(formatter.format(date));
				}
				else {
					summary.show(list1[1]);
				}

				break;
			}
		}
	}
}