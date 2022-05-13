package interfaces;

/**
 * inzheneher created on 28/12/2020 inside the package - interfaces
 */
@FunctionalInterface
public interface IFunction<T, S> {
    T function(S argument);
}
