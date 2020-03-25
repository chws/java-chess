package chess.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Square {
    private final static Map<String, Square> CACHE = new HashMap<>();

    static {
        for (char file = 'a'; file <= 'h'; file++) {
            for (int rank = 1; rank <= 8; rank++) {
                CACHE.put(String.valueOf(file) + rank, new Square(file, rank));
            }
        }
    }

    private final char file;
    private final int rank;

    private Square(char file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public static Square of(String location) {
        if (Objects.isNull(location) || !CACHE.containsKey(location)) {
            throw new IllegalArgumentException("잘못된 square의 입력입니다");
        }

        return CACHE.get(location);
    }

}