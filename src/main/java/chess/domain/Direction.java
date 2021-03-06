package chess.domain;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    N(0, 1),
    S(0, -1),
    E(1, 0),
    W(-1, 0),
    NE(1, 1),
    NNE(1, 2),
    NEE(2, 1),
    SE(1, -1),
    SSE(1, -2),
    SEE(2, -1),
    NW(-1, 1),
    NWW(-2, 1),
    NNW(-1, 2),
    SW(-1, -1),
    SWW(-2, -1),
    SSW(-1, -2);

    private final int fileIncrement;
    private final int rankIncrement;

    Direction(int fileIncrement, int rankIncrement) {
        this.fileIncrement = fileIncrement;
        this.rankIncrement = rankIncrement;
    }

    public static List<Direction> linearDirection() {
        return Arrays.asList(N, E, S, W);
    }

    public static List<Direction> diagonalDirection() {
        return Arrays.asList(NE, SE, SW, NW);
    }

    public static List<Direction> everyDirection() {
        return Arrays.asList(N, E, S, W, NE, SE, SW, NW);
    }

    public static List<Direction> knightDirection() {
        return Arrays.asList(NNE, NNW, SSE, SSW, NEE, SEE, NWW, SWW);
    }

    public static List<Direction> whitePawnDirection() {
        return Arrays.asList(N, NE, NW);
    }

    public static List<Direction> blackPawnDirection() {
        return Arrays.asList(S, SE, SW);
    }

    public int getFileIncrement() {
        return fileIncrement;
    }

    public int getRankIncrement() {
        return rankIncrement;
    }
}
