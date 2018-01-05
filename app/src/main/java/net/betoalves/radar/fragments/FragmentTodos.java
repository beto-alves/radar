package net.betoalves.radar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.betoalves.radar.R;
import net.betoalves.radar.adapters.RadarRecyclerAdapter;
import net.betoalves.radar.models.ApiResponse;
import net.betoalves.radar.mvp.interfaces.ITodosFragment;
import net.betoalves.radar.mvp.interfaces.ITodosPresenter;
import net.betoalves.radar.utils.DependencyManager.impl.DependencyManager;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beto on 02/01/18.
 */

public class FragmentTodos extends Fragment implements ITodosFragment {

    //Realiza a injeção do presenter dentro do Fragment
    private ITodosPresenter presenter = DependencyManager.getInstance().get(ITodosPresenter.class);

    //Realiza o bind do componente recyclerview utilizando o Butterknife
    @BindView(R.id.recyclerView_fragment_todos)
    RecyclerView mRecyclerView;

    public FragmentTodos() {

    }

    public static FragmentTodos newInstance() {
        return new FragmentTodos();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todos, container, false);
        ButterKnife.bind(this, view); //Binda a view com o butterknife

        //Injeta a view no presenter, através de sua interface
        presenter.setTodosFragmentWeakReference(new WeakReference<ITodosFragment>(this));
        //Carrega a lista de itens através do presenter
        presenter.carregaList();

        return view;
    }

    @Override
    public void toast(String response) {
        Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
    }

    //Callback da chamada do retrofit via rx android
    @Override
    public void setRecyclerViewContent(List<ApiResponse> apiResponseList) {

        RadarRecyclerAdapter adapter = new RadarRecyclerAdapter(apiResponseList);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(adapter);

    }
}