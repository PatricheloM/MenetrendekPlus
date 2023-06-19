package hu.menetrendekplus.backend.util;

public final class Coalesce {

    private Coalesce() {
    }

    public static <T> T coalesce(T one, T two)
    {
        return one != null ? one : two;
    }
}
