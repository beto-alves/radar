package net.betoalves.radar.mvp.interfaces;

import java.lang.ref.WeakReference;

/**
 * Created by beto on 01/01/18.
 */

public interface ITodosPresenter {

    void setTodosFragmentWeakReference(WeakReference<ITodosFragment> todosFragmentWeakReference);

    void carregaList();

}