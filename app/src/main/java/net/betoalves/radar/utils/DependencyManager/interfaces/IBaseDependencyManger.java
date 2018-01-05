package net.betoalves.radar.utils.DependencyManager.interfaces;

/**
 * Created by beto on 02/01/2017.
 */

public interface IBaseDependencyManger {
    <T> void disposeInstance(Class<T> tClass);

    <T> T get(Class<T> tClass);

    <T> T get(Class<T> tClass, String profile);

    void link(Class _interface, Class _implementation);
}
