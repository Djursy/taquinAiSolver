import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class TaquinSolver {

    /**
     * @param taquin Premier parcours de recherche, le parcours en profondeur
     */
    public static void depthSearch(Taquin taquin) {
        Stack<State> open = new Stack<>();
        Stack<State> close = new Stack<>();

        open.push(taquin.getInitialState());

        while (!open.isEmpty() && !open.peek().equals(taquin.getFinalState())) {
            State e = open.pop();
            close.push(e);

            ArrayList<State> childs = e.getChilds();
            for (State child : childs) {
                if (!open.contains(child) && !close.contains(child)) {
                    open.push(child);
                }
            }
        }

        if (open.isEmpty())
            System.out.println("Pas de solution");
        else System.out.println(open.peek() + "\nest une solution !");
    }

    /**
     * Deuxième parcours de recherche, le parcours en largeur.
     * @param taquin
     */
    public static void widthSearch(Taquin taquin) {
        ArrayList<State> open = new ArrayList<>();
        ArrayList<State> close = new ArrayList<>();

        open.add(taquin.getInitialState());

        while (!open.isEmpty() && !open.get(0).equals(taquin.getFinalState())) {
            State e = open.remove(0);
            close.add(e);

            ArrayList<State> childs = e.getChilds();
            for (State child : childs) {
                if (!open.contains(child) && !close.contains(child)) {
                    open.add(child);
                }
            }
        }

        if (open.isEmpty())
            System.out.println("Pas de solution");
        else System.out.println(open.get(0) + "\nest une solution !");
    }

    /**
     * Troisième parcours de recherche, il s'agit de la recherche du meilleur d'abord.
     * La liste open est trié en fonction de l'heuristique utilisé.
     * @param taquin
     */
    public static void bestFirstSearch(Taquin taquin) {
        ArrayList<State> open = new ArrayList<>();
        ArrayList<State> close = new ArrayList<>();

        open.add(taquin.getInitialState());

        while (!open.isEmpty() && !open.get(0).equals(taquin.getFinalState())) {
            State e = open.remove(0);
            close.add(e);

            ArrayList<State> childs = e.getChilds();
            for (State child : childs) {
                if (!open.contains(child) && !close.contains(child)) {
                    open.add(child);
                }
            }

            Comparator<State> comparator = (state1, state2) ->
                    (Heuristic.hammingDistance(state1, taquin.getFinalState()) > Heuristic.hammingDistance(state2, taquin.getFinalState()))
                            ? 1 : (Heuristic.hammingDistance(state1, taquin.getFinalState()) == Heuristic.hammingDistance(state2, taquin.getFinalState())
                            ? 0 : -1);

            Collections.sort(open, comparator);
        }

        if (open.isEmpty())
            System.out.println("Pas de solution");
        else System.out.println(open.get(0) + "\nest une solution !");
    }
}
