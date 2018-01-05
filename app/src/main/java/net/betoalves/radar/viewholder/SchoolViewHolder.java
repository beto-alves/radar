package net.betoalves.radar.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.betoalves.radar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beto on 05/01/18.
 */

public class SchoolViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textView_row_school_text)
    public TextView textViewText;

    @BindView(R.id.textView_row_school_author)
    public TextView textViewAuthor;

    public SchoolViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
