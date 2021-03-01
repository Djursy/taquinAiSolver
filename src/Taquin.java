public class Taquin {

    State initialState;
    State finalState;

    public Taquin(State initialState, State finalState) {
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    public State getFinalState() {
        return finalState;
    }

    public void setFinalState(State finalState) {
        this.finalState = finalState;
    }
}
