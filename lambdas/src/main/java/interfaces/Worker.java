package interfaces;

/**
 * @author Aleksandr Melnikov
 * created on 2022-05-09
 */
@FunctionalInterface
public interface Worker<T, S> {
    T worker(S s);
}
