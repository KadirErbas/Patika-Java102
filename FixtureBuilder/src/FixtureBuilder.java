import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FixtureBuilder {
    public void addTeams(ArrayList<String> arr){
            Scanner scan = new Scanner(System.in);

            System.out.println("How many teams will you enter? ");
            int totalTeams = scan.nextInt();

            System.out.println("Input teams: ");
            for (int i = 0; i < totalTeams; i++) {
                arr.add(scan.next());
            }

            if (arr.size() % 2 != 0){
                arr.add("Bay");
            }
    }

    public void printMatches(ArrayList<String> teams){
            // Takımları karıştırma
            Collections.shuffle(teams);
            // Tur sayısını belirleme
            int rounds = teams.size() - 1;

            // Her turda eşleşecek maç sayısını belirleyin
            int matchesPerRound = teams.size() / 2;

            int round = 1;

            // Eşleştirilen takımları ekrana yazdırma işlemi
            System.out.println("Futbol Ligi Fikstürü");
            for (;round <= rounds; round++) {
                System.out.println("ROUND " + round);
                for (int match = 0; match < matchesPerRound; match++) {
                    String homeTeam = teams.get(match);
                    String awayTeam = teams.get(teams.size() - 1 - match);
                    System.out.println(homeTeam + " vs " + awayTeam);
                }
                Collections.rotate(teams.subList(1, teams.size()), 1);
                System.out.println();
            }

            for (;round <= rounds * 2 ; round++) {
                System.out.println("ROUND " + round);
                for (int match = 0; match < matchesPerRound; match++) {
                    String homeTeam = teams.get(match);
                    String awayTeam = teams.get(teams.size() - 1 - match);
                    System.out.println(awayTeam + " vs " + homeTeam);
                }
                // Takımları bir sonraki tur için ilk indexten sonrasını 1 adım kaydırma
                Collections.rotate(teams.subList(1, teams.size()), 1);
                System.out.println();
            }
    }


}


