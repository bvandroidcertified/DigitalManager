package com.bvlabs.digitalmanager.tableview.holder;

import android.view.View;
import android.widget.TextView;

import com.bvlabs.digitalmanager.R;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class RowHeaderViewHolder extends AbstractViewHolder {
    public final TextView row_header_textview;

    public RowHeaderViewHolder(View itemView) {
        super(itemView);
        row_header_textview = (TextView) itemView.findViewById(R.id.row_header_textview);
    }
}
