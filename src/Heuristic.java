public class Heuristic {

    /**
     * Prmière heuristique : cette fonction calcule la distance de Hamming entre deux états du jeu du Taquin
     * @param state1 Etat 1 à comparer
     * @param state2 Etat 2 à comparer
     * @return distance de Hamming entre state1 et state2
     */
    public static int hammingDistance(State state1, State state2) {
        int hammingDistance = 0;

        for (int i = 0; i < state1.getNumberOfLines(); i++) {
            for (int j = 0; j < state1.getNumberOfColumns(); j++) {
                if (state1.getTile(i, j) != state2.getTile(i, j))
                    hammingDistance += 1;
            }
        }

        return hammingDistance;
    }
}
