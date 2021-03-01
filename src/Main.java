import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        final InstanceReader instanceReaderTest = new InstanceReader("testTaquin");

        final State initialState = instanceReaderTest.getInitialState();
        final State finalState = instanceReaderTest.getFinalState();

        final Taquin taquin = new Taquin(initialState, finalState);

        TaquinSolver.bestFirst(taquin);
    }
}
