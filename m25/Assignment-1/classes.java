import java.util.Scanner;
import java.util.Arrays;
class Task {
    String title;
    String assignedTo;
    int timeToComplete;
    boolean important;
    boolean urgent;
    String status;
    String s1;
    String s2;
    Task(String t, String a, int time, boolean i, boolean u, String s) {
        this.title = t;
        this.assignedTo = a;
        this.timeToComplete = time;
        if(i && u) {
        this.s1 = "Important";
        this.s2 = "Urgent";
        }
        if(i && !u) {
        this.s1 = "Important";
        this.s2 = "Not Urgent";
        }
        if(!i && u) {
        this.s1 = "Not Important";
        this.s2 = "Urgent";
        }
         if(!i && !u) {
        this.s1 = "Not Important";
        this.s2 = "Not Urgent";
        }
        this.status = s;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title+", "+assignedTo+", "+timeToComplete+", "+s1+", "+s2+", "+status);
        return sb.toString();
    }

}

class Todoist {
    Task[] array;
    int size;

    Todoist() {
        array = new Task[50];
        size = 0;
    }
    public void addTask(Task task) {
        if(size == 50) {
          resize();
        }
        array[size++] = task;
    }
    public void resize() {
        array = Arrays.copyOf(array, 2 * 50);
    }

    public String toString() {
        String s = "";
        for(int i = 0; i<size; i++) {
            s = s+array[i].title+", "+array[i].assignedTo+", "+array[i].timeToComplete
            +", "+array[i].s1+", "+array[i].s2+", "+array[i].status;
            if(i != size-1) {
                s = s+"\n";
            }
        }
        return s;
    }

    public int totalTime4Completion() {
        int total = 0;
        for(int i = 0; i<size; i++) {
            if(array[i].status.equals("todo")) {
                total = total+array[i].timeToComplete;
            }
        }
        return total;
    }

    public Task getNextTask(String name) {
        int k = 0;
        int c = 0;
        int d = 0;
        int l = 0;
        for(int i = 0; i<size; i++) {
            if(array[i].assignedTo.equals(name)) {
                if(array[i].status.equals("todo")) {
                    if(array[i].s1.equals("Important") && array[i].s2.equals("Not Urgent")) {
                        c = 1;
                        k = i;
                        break;
                    }
                    if(array[i].s1.equals("Important") && array[i].s2.equals("Urgent")) {
                        d = 1;
                        l = i;

                    }
                }
            }
        }
        if(c == 1) {
            return array[k];
        }
        if(d == 1) {
            return array[l];
        }
        return null;
    }

    public Task[] getNextTask(String name, int c) {
        Task arr[];
        arr = new Task[c];
        int k = 0;
        int count = 0;
        int d = 0;
        int l = 0;
        int p = 0;
        for(int i = 0; i<size; i++) {
            int a = 0;
            if(array[i].assignedTo.equals(name)) {
                if(array[i].status.equals("todo")) {
                    if(array[i].s1.equals("Important") && array[i].s2.equals("Not Urgent")) {
                        count++;
                        k = i;
                        a = 1;
                        if(count>c) {
                            break;
                        }
                    }
                    if(array[i].s1.equals("Important") && array[i].s2.equals("Urgent")) {
                        d = 1;
                        l = i;

                    }
                    if(a == 1) {
                    arr[p] = array[k];
                    p++;
                    }
                }
            }
        }
    return arr;

    }
}

class InvalidException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     */
    InvalidException(final String s) {
        super(s);
    }
}
