public class Taquin {

    final State initialState;
    final State finalState;

    public Taquin(State initialState, State finalState) {
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public State getInitialState() {
        return initialState;
    }

    public State getFinalState() {
        return finalState;
    }
}
