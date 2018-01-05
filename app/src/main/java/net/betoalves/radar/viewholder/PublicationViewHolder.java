package net.betoalves.radar.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.betoalves.radar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beto on 01/01/18.
 */

public class PublicationViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textView_row_publication_title)
    public TextView textViewTitle;

    @BindView(R.id.textView_row_publication_text)
    public TextView textViewPublicationText;

    @BindView(R.id.textView_row_publication_author)
    public TextView textViewAuthor;

    @BindView(R.id.textView_row_publication_count_like)
    public TextView textViewCountLike;

    @BindView(R.id.imageView_row_publication_image)
    public ImageView imageViewPublication;

    public PublicationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
