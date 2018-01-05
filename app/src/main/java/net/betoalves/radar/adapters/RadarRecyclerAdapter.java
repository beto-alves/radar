package net.betoalves.radar.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allenliu.badgeview.BadgeFactory;
import com.allenliu.badgeview.BadgeView;

import net.betoalves.radar.R;
import net.betoalves.radar.models.ApiResponse;
import net.betoalves.radar.utils.ImageUtils;
import net.betoalves.radar.utils.StringUtils;
import net.betoalves.radar.viewholder.BizViewHolder;
import net.betoalves.radar.viewholder.NetworkingViewHolder;
import net.betoalves.radar.viewholder.SchoolViewHolder;
import net.betoalves.radar.viewholder.PublicationViewHolder;

import java.util.List;

/**
 * Created by beto on 05/01/18.
 * Adapter para o recyclerview do radar
 */

public class RadarRecyclerAdapter extends RecyclerView.Adapter {

    private List<ApiResponse> apiResponseList;

    public RadarRecyclerAdapter(List<ApiResponse> apiResponseList) {
        this.apiResponseList = apiResponseList;
    }

    /**
     * Cria o viewholder especifico de acordo com o tipo de objeto sendo exibido
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 2022:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_publication, parent, false);
                return new PublicationViewHolder(view);
            case 1999:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_school, parent, false);
                return new SchoolViewHolder(view);
            case 1994:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_networking, parent, false);
                return new NetworkingViewHolder(view);
            case 1997 :
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_biz, parent, false);
                return new BizViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ApiResponse apiResponse = apiResponseList.get(position);

        if (apiResponse != null) {

            //Realiza o bind do viewholder de acordo com o tipo de cada objeto informado.
            switch (apiResponse.getType()) {
                case 2022 :
                    loadRowPublication(apiResponse, holder);
                    break;
                case 1999:
                    loadRowSchool(apiResponse, holder);
                    break;
                case 1994:
                    loadRowNetworking(apiResponse, holder);
                    break;
                case 1997:
                    loadRowBiz(apiResponse, holder);
                    break;
            }

        }

    }

    @Override
    public int getItemCount() {
        return apiResponseList.size();
    }

    //Retorna o tipo de view para cada item
    @Override
    public int getItemViewType(int position) {
        switch (apiResponseList.get(position).getType()) {
            case 2022:
                return 2022;
            case 1999:
                return 1999;
            case 1994:
                return 1994;
            case 1997:
                return 1997;
            default:
                return -1;
        }
    }

    //Carrega as informações de "publicações"
    private void loadRowPublication(ApiResponse apiResponse, RecyclerView.ViewHolder holder) {
        ((PublicationViewHolder) holder).textViewTitle.setText(apiResponse.getData().getPublicationTitle());
        ((PublicationViewHolder) holder).textViewPublicationText.setText(apiResponse.getData().getPublicationDescription());
        ((PublicationViewHolder) holder).textViewAuthor.setText(apiResponse.getData().getPublicationAuthorName());
        ((PublicationViewHolder) holder).textViewCountLike.setText(String.valueOf(apiResponse.getData().getPublicationCountLike()));

        if (StringUtils.isNotNullOrEmpty(apiResponse.getData().getLinkUrl())) {
            ImageUtils.showImage(apiResponse.getData().getLinkUrl(), ((PublicationViewHolder) holder).imageViewPublication);
        }
    }

    //Carrega as informações da linha "escola"
    private void loadRowSchool(ApiResponse apiResponse, RecyclerView.ViewHolder holder) {
        if (StringUtils.isNotNullOrEmpty(apiResponse.getData().getTitle())) {
            ((SchoolViewHolder) holder).textViewText.setText(apiResponse.getData().getTitle());
        }

        String author = "";
        if (apiResponse.getData().getCommunity() != null &&
                StringUtils.isNotNullOrEmpty(apiResponse.getData().getCommunity().getName())) {
            author += apiResponse.getData().getCommunity().getName();
        }

        if (apiResponse.getData().getAuthor() != null &&
                StringUtils.isNotNullOrEmpty(apiResponse.getData().getAuthor().getName())) {
            author += " - " + apiResponse.getData().getAuthor().getName();
        }
        ((SchoolViewHolder) holder).textViewAuthor.setText(author);
    }

    //Carrega as informações das linhas "networking"
    private void loadRowNetworking(ApiResponse apiResponse, RecyclerView.ViewHolder holder) {
        if (StringUtils.isNotNullOrEmpty(apiResponse.getData().getTitle())) {
            ((NetworkingViewHolder) holder).textViewNetworkingText.setText(apiResponse.getData().getTitle());
        }

        String author = "";
        if (apiResponse.getData().getCommunity() != null &&
                StringUtils.isNotNullOrEmpty(apiResponse.getData().getCommunity().getName())) {
            author += apiResponse.getData().getCommunity().getName();
        }

        if (apiResponse.getData().getAuthor() != null &&
                StringUtils.isNotNullOrEmpty(apiResponse.getData().getAuthor().getName())) {
            author += " - " + apiResponse.getData().getAuthor().getName();
        }
        ((NetworkingViewHolder) holder).textViewAuthor.setText(author);
    }

    //Carrega as informaçõe das linhas "biz
    private void loadRowBiz(ApiResponse apiResponse, RecyclerView.ViewHolder holder) {
        if (StringUtils.isNotNullOrEmpty(apiResponse.getData().getTitle())) {
            ((BizViewHolder) holder).textViewText.setText(apiResponse.getData().getTitle());
        }

        String author = "";
        if (apiResponse.getData().getMasterName() != null &&
                StringUtils.isNotNullOrEmpty(apiResponse.getData().getMasterName())) {
            author += apiResponse.getData().getMasterName();
        }

        if (apiResponse.getData().getAuthorName() != null &&
                StringUtils.isNotNullOrEmpty(apiResponse.getData().getAuthorName())) {
            author += " - " + apiResponse.getData().getAuthorName();
        }
        ((BizViewHolder) holder).textViewAuthor.setText(author);
    }
}
