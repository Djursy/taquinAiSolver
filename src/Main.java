import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        for (int i =1; i<29; i++){
            final InstanceReader instanceReaderTest = new InstanceReader("test/taquin" + i +".txt");
            final State initialState = instanceReaderTest.getInitialState();
            final State finalState = instanceReaderTest.getFinalState();
            final Taquin taquin = new Taquin(initialState, finalState);
            System.out.println( "Depth-first search:");
            TaquinSolver.depthSearch(taquin);
            System.out.println( "Best-first search:");
            TaquinSolver.bestFirstSearch(taquin);
            System.out.println( "Breadth-first search:");
            TaquinSolver.widthSearch(taquin);
        }
    }
}
