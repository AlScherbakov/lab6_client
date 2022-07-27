package command;

import java.io.IOException;

/**
 * Functional interface. Used for all entities which may be executed (Commands)
 * @param <T>
 */

@FunctionalInterface
public interface Invokeable<T> {
    T execute() throws IOException;
}
