import java.io.IOException;

public class Solver {
    public static void main(String[] args) throws IOException {
        final int argsLength = args.length;

        if (argsLength < 2 || argsLength > 3) {
            System.out.println("Usage : Solver plm -h grid.grid");
            return;
        } else if (argsLength == 2) {
            final InstanceReader instanceReaderTest = new InstanceReader(args[1] +".grid");
            final State initialState = instanceReaderTest.getInitialState();
            final State finalState = instanceReaderTest.getFinalState();
            final Taquin taquin = new Taquin(initialState, finalState);

            switch (args[0]) {
                case "p":
                    System.out.println( "Launching a depth-first search on the instance " + args[1] + " :");
                    TaquinSolver.depthSearch(taquin);
                    break;
                case "l":
                    System.out.println( "Launching a breadth-first search on the instance " + args[1] + " :");
                    TaquinSolver.breadthSearch(taquin);
                    break;
                default:
                    System.out.println("Usage : Solver plm -h grid.grid");
                    return;
            }
        } else {
            if (args[0].equals("m")) {
                final InstanceReader instanceReaderTest = new InstanceReader(args[2] +".grid");
                final State initialState = instanceReaderTest.getInitialState();
                final State finalState = instanceReaderTest.getFinalState();
                final Taquin taquin = new Taquin(initialState, finalState);

                switch (args[1]) {
                    case "1":
                        System.out.println( "Launching a best-first search on the instance " + args[2] + " with the heuristic 'Distance of Hamming' :");
                        TaquinSolver.bestFirstSearch(taquin, Integer.parseInt(args[1]));
                        break;
                    default:
                        System.out.println("Usage : Solver plm -h grid.grid\nThere is only one heuristic\nDistance of Hamming with the code : 1");
                        return;
                }
            } else {
                System.out.println("Usage : Solver plm -h grid.grid");
                return;
            }
        }
    }
}
