package net.betoalves.radar.mvp.implementation;

import net.betoalves.radar.models.ApiResponse;
import net.betoalves.radar.mvp.interfaces.ITodosFragment;
import net.betoalves.radar.mvp.interfaces.ITodosPresenter;
import net.betoalves.radar.services.MockService;
import net.betoalves.radar.services.NetworkServiceHelper;

import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by beto on 01/01/18.
 */

public class TodosPresenter implements ITodosPresenter {

    //Instancia da view
    private WeakReference<ITodosFragment> todosFragmentWeakReference;

    //Recebe uma instancia da view como weakreference para poder acionar os callbacks
    @Override
    public void setTodosFragmentWeakReference(WeakReference<ITodosFragment> todosFragmentWeakReference) {
        this.todosFragmentWeakReference = todosFragmentWeakReference;
    }

    /**
     * Executa a chamada do Retrofit para recuperar as informações do webservice
     */
    @Override
    public void carregaList() {

        MockService mockService = new NetworkServiceHelper().getMockService();
        Observable<List<ApiResponse>> observable = mockService.getMockData();

        //Executa a chamada do retrofit em uma nova thread, definindo seu retorno para ser observado
        //na mainthread
        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ApiResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ApiResponse> response) {
                        //Executa o método da view que carrega o listview
                        todosFragmentWeakReference.get().setRecyclerViewContent(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Erro de conexão
                        todosFragmentWeakReference.get().toast("Erro, favor verifique conexão");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}