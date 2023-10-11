import java.util.ArrayList;
import java.util.Comparator;
import static java.lang.Integer.parseInt;
import static java.util.Collections.*;

public class Main {
    public static void main(String[] args){
        Methods.fileCleaner();
        String[] lines = Methods.readFile(args[0], false, false);
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("Armstrong numbers up to:")) {
                Methods.armstrong(parseInt(lines[++i]));
            }
            if (lines[i].equals("Emirp numbers up to:")) {
                Methods.emirp(parseInt(lines[++i]));
            }
            if (lines[i].equals("Abundant numbers up to:")) {
                Methods.abundant(parseInt(lines[++i]));
            }
            if (lines[i].equals("Ascending order sorting:")) {
                Methods.writeToFile("output.txt","Ascending order sorting:",true,true);
                ArrayList<Integer> ascendinglist = new ArrayList<>();
                while (!(lines[++i].equals("-1"))) {
                    ascendinglist.add(parseInt(lines[i]));
                    sort(ascendinglist);
                    String formattedAscending = ascendinglist.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", "");
                    Methods.writeToFile("output.txt",formattedAscending,true,true);
                }
                Methods.writeToFile("output.txt", "\n",true,false);
            }
            if (lines[i].equals("Descending order sorting:")) {
                Methods.writeToFile("output.txt","Descending order sorting:",true,true);
                ArrayList<Integer> descendinglist = new ArrayList<>();
                while (!(lines[++i].equals("-1"))) {
                    descendinglist.add(parseInt(lines[i]));
                    Comparator<Integer> descendingOrder = reverseOrder();
                    descendinglist.sort(descendingOrder);
                    String formattedDescending = descendinglist.toString()
                            .replace("[", "")
                            .replace("]", "")
                            .replace(",", "");
                    Methods.writeToFile("output.txt",formattedDescending,true,true);
                }
                Methods.writeToFile("output.txt", "\n",true,false);
            }
            if (lines[i].equals("Exit")){
                Methods.writeToFile("output.txt","Finished...",true,false);
                break;
            }
        }
    }
}