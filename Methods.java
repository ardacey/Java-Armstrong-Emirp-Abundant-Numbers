import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.PrintWriter;

public class Methods{

        public static String[] readFile(String path, boolean discardEmptyLines, boolean trim) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(path));
                if (discardEmptyLines) {
                    lines.removeIf(line -> line.trim().equals(""));
                }
                if (trim) {
                    lines.replaceAll(String::trim);
                }
                return lines.toArray(new String[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        public static void writeToFile(String path, String content, boolean append, boolean newLine) {
            PrintStream ps = null;
            try {
                ps = new PrintStream(new FileOutputStream(path, append));
                ps.print(content + (newLine ? "\n" : ""));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    ps.flush();
                    ps.close();
                }
            }
        }

        public static void fileCleaner() {
            try {
                PrintWriter writer = new PrintWriter("output.txt");
                writer.print("");
                writer.close();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        public static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        public static void armstrong(int arnumber){
                writeToFile("output.txt","Armstrong numbers up to " + arnumber + ":",true,true);
                for(int i = 1; i<arnumber+1; i++){
                    int sum = 0,digit = 0;
                    int temp = i; // for saving the original value of i
                    while (temp != 0) {
                        temp /= 10;
                        ++digit;
                    }
                    temp = i;
                    while (temp > 0){
                        sum += Math.pow(temp%10, digit);
                        temp /= 10;
                    }
                    if (sum == i){
                        writeToFile("output.txt",sum + " ",true,false);
                    }
                }
                writeToFile("output.txt", "\n\n",true,false);
            }
        public static void emirp(int emnumber){
            writeToFile("output.txt","Emirp numbers up to " + emnumber + ":",true,true);
            for(int j = 13; j<emnumber+1; j++){
                int emtemp = j; // for saving the original value of j
                int reversedNumber = 0;
                while (emtemp != 0) {
                    int digit = emtemp % 10;
                    reversedNumber = reversedNumber * 10 + digit;
                    emtemp /= 10;
                }
                if (isPrime(j) && isPrime(reversedNumber) && j != reversedNumber){
                    writeToFile("output.txt",j+ " ",true, false);
                }
            }
            writeToFile("output.txt", "\n\n",true,false);
        }
        public static boolean isAbundant(int n) {
            int absum = 0;
            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0) {
                    absum += i;
                }
            }
            return absum > n;
        }
        public static void abundant(int abnumber) {
            writeToFile("output.txt","Abundant numbers up to " + abnumber + ":",true,true);
            for (int k = 1; k <= abnumber+1; k++) {
                if (isAbundant(k)) {
                    writeToFile("output.txt",k + " ",true,false);
                }
            }
            writeToFile("output.txt", "\n\n",true,false);
        }
}