import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class State implements Cloneable {

    private int numberOfLines;
    private int numberOfColumns;
    private char[][] state;

    public State() {
        this.numberOfLines = 0;
        this.numberOfColumns = 0;
        this.state = new char[numberOfLines][numberOfColumns];
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setBounds() {
        this.state = new char[numberOfLines][numberOfColumns];
    }

    public void setStateIndex(int lineIndex, int columnIndex, char value) {
        this.state[lineIndex][columnIndex] = value;
    }

    public Position getEmptyPosition() {
        for (int i = 0; i < numberOfLines; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if (state[i][j] == '0')
                    return new Position(i, j);
            }
        }

        return null;
    }

    public void swap(Position pos1, Position pos2) {
        char temp = state[pos2.getX()][pos2.getY()];
        this.setStateIndex(pos2.getX(), pos2.getY(), state[pos1.getX()][pos1.getY()]);
        this.setStateIndex(pos1.getX(), pos1.getY(), temp);
    }

    public ArrayList<State> getChilds() {
        ArrayList<State> childs = new ArrayList<>();
        Position emptyPos = this.getEmptyPosition();

        if (emptyPos.getX() > 0) {
            State newState = (State) this.clone();
            newState.swap(emptyPos, new Position(emptyPos.getX() - 1, emptyPos.getY()));
            childs.add(newState);
        }
        if (emptyPos.getX() < numberOfLines - 1) {
            State newState = (State) this.clone();
            newState.swap(emptyPos, new Position(emptyPos.getX() + 1, emptyPos.getY()));
            childs.add(newState);
        }
        if (emptyPos.getY() > 0) {
            State newState = (State) this.clone();
            newState.swap(emptyPos, new Position(emptyPos.getX(), emptyPos.getY() - 1));
            childs.add(newState);
        }
        if (emptyPos.getY() < numberOfColumns - 1) {
            State newState = (State) this.clone();
            newState.swap(emptyPos, new Position(emptyPos.getX(), emptyPos.getY() + 1));
            childs.add(newState);
        }

        return childs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state1 = (State) o;
        if (numberOfLines == state1.numberOfLines && numberOfColumns == state1.numberOfColumns) {
            for (int i = 0; i < this.numberOfLines; i++) {
                for (int j = 0; j < this.numberOfColumns; j++) {
                    if (this.state[i][j] != ((State) o).getState(i, j))
                        return false;
                }
            }
        }
        return true;
    }

    public char getState(int i, int j) {
        return state[i][j];
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfLines, numberOfColumns);
        result = 31 * result + Arrays.hashCode(state);
        return result;
    }

    @Override
    protected Object clone() {
        try {
            State cloned = ((State) super.clone());
            cloned.numberOfLines = this.numberOfLines;
            cloned.numberOfColumns = this.numberOfColumns;
            cloned.state = new char[cloned.numberOfLines][cloned.numberOfColumns];

            for (int i = 0; i < cloned.numberOfLines; i++) {
                for (int j = 0; j < cloned.numberOfColumns; j++) {
                    cloned.state[i][j] = this.state[i][j];
                }
            }

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < this.numberOfLines; i++) {
            stringBuffer.append(" ");
            for (int j = 0; j < this.numberOfColumns; j++) {
                stringBuffer.append("[" + state[i][j] + "]");
            }
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }
}
