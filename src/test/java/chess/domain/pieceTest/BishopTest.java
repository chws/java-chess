package chess.domain.pieceTest;

import chess.domain.piece.*;
import chess.domain.square.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BishopTest {
    @Test
    @DisplayName("두 동일한 객체를 가져왔을 때 같은지 확인")
    void checkSameInstance() {
        Piece piece = Bishop.of(Color.BLACK);
        assertThat(piece).isEqualTo(Bishop.of(Color.BLACK));
    }

    @ParameterizedTest
    @ValueSource(strings = {"b7", "d7", "b5", "d5", "a4", "e4", "e8"})
    @DisplayName("판의 정보를 가져와서 bishop이 갈 수 있는 칸에 장애물이 있는지 판단하여 이동할 수 있는 리스트 반환하는 테스트")
    void movableBishopSquareTest(String input) {
        Map<Square, Piece> board = new HashMap<>();
        board.put(Square.of("b7"), Pawn.of(Color.WHITE));
        board.put(Square.of("c7"), Pawn.of(Color.WHITE));
        board.put(Square.of("a6"), King.of(Color.WHITE));
        board.put(Square.of("c5"), Pawn.of(Color.BLACK));
        board.put(Square.of("e8"), Knight.of(Color.WHITE));
        board.put(Square.of("f6"), Queen.of(Color.BLACK));
        board.put(Square.of("f3"), Pawn.of(Color.BLACK));
        board.put(Square.of("g6"), King.of(Color.BLACK));
        board.put(Square.of("g2"), Pawn.of(Color.WHITE));

        Piece piece = Bishop.of(Color.BLACK);
        Set<Square> availableSquares = piece.calculateMovableSquares(Square.of("c6"), board);

        assertThat(availableSquares.contains(Square.of(input))).isTrue();
        assertThat(availableSquares.size()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"c1", "e1", "c3", "b4", "a5", "e3", "f4", "g5", "h6"})
    @DisplayName("말의 위치(비숍)를 받고 말의 종류에 따라 이동할 수 있는 칸 리스트 반환")
    void calculateScopeBishop(String input) {
        Piece piece = Bishop.of(Color.WHITE);
        Set<Square> availableSquares = piece.calculateScope(Square.of("d2"));
        assertThat(availableSquares.contains(Square.of(input))).isTrue();
        assertThat(availableSquares.size()).isEqualTo(9);
    }
}
