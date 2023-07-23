import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> teams = new ArrayList<>();
        FixtureBuilder fixtureBuilder = new FixtureBuilder();
        fixtureBuilder.addTeams(teams);
        fixtureBuilder.printMatches(teams);
        
    }
}
