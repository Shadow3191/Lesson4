package pl.lesson4.kwasny.pawel;

public enum Sign {
    CROSS('X'),
    CIRCLE('O');

    private char mark;

    Sign(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }
}
