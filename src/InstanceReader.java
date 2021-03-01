import java.io.*;

/**
 * C'est la classe qui lit les instances du jeu du Taquin proposés en cours.
 */
public class InstanceReader {

    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private File file;

    private State initialState = new State();
    private State finalState = new State();

    public InstanceReader(String pathToFile) throws IOException {
        this.file = new File(pathToFile);
        this.fileReader = new FileReader(file);
        this.bufferedReader = new BufferedReader(fileReader);

        int numberOfLines;
        int numberOfColumns;

        numberOfLines = Integer.parseInt(bufferedReader.readLine());

        this.initialState.setNumberOfLines(numberOfLines);
        this.finalState.setNumberOfLines(numberOfLines);

        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = bufferedReader.readLine();

            if (i == 0) {
                numberOfColumns = currentLine.length();

                this.initialState.setNumberOfColumns(numberOfColumns);
                this.finalState.setNumberOfColumns(numberOfColumns);

                initialState.setBounds();
                finalState.setBounds();
            }

            for (int j = 0; j < currentLine.length(); j++) {
                if (currentLine.charAt(j) == ' ')
                    this.initialState.setStateIndex(i, j, '0');
                else this.initialState.setStateIndex(i, j, currentLine.charAt(j));
            }
        }

        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = bufferedReader.readLine();

            for (int j = 0; j < currentLine.length(); j++) {
                if (currentLine.charAt(j) == ' ')
                    this.finalState.setStateIndex(i, j, '0');
                else this.finalState.setStateIndex(i, j, currentLine.charAt(j));
            }
        }
    }

    public State getInitialState() {
        return initialState;
    }

    public State getFinalState() {
        return finalState;
    }
}
