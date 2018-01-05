package net.betoalves.radar.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import net.betoalves.radar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beto on 05/01/18.
 */

public class NetworkingViewHolder extends ViewHolder {

    @BindView(R.id.textView_row_networking_text)
    public TextView textViewNetworkingText;

    @BindView(R.id.textView_row_networking_author)
    public TextView textViewAuthor;

    @BindView(R.id.cardview)
    public CardView cardView;

    public NetworkingViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
