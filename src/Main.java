import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList file = new ArrayList();
        file = readFileToList(file);
        System.out.println(errors(file) + " Errors");
        ArrayList githubAktivitetsLog = new ArrayList();
        githubAktivitetsLog = GithubAktivitetsLog(file);
    }

    public static ArrayList GithubAktivitetsLog(ArrayList input){
        ArrayList githubAktivitetsLog = new ArrayList();
        int y = 0;
        for (int x = 0; x<input.size(); x++) {
            String txt = String.valueOf(input.get(x));
            if (txt.contains("github ")) {
                githubAktivitetsLog.add(txt);
                System.out.println(githubAktivitetsLog.get(y));
                y++;
            }

        }
        return githubAktivitetsLog;
    }

    public static ArrayList readFileToList(ArrayList listan) throws FileNotFoundException {
        Scanner in = new Scanner(new File("ideaold.log"));
        while(in.hasNext()){
            listan.add(in.nextLine());
        }
        return listan;
    }

    public static int errors(ArrayList listan){
        int antalErrors = 0;
        for (int x = 0; x<listan.size(); x++){
            String txt = String.valueOf(listan.get(x));
            if (txt.contains("ERROR")){
                antalErrors++;
            }
        }
        return (antalErrors);
    }
}