import parse.ParsePage;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file = new File("./src/main/resources/Output.csv");

        ParsePage.getInfo();

        ParsePage.writeToFile(file);

    }
}
