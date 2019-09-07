package com.bvlabs.digitalmanager.tableview.holder;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bvlabs.digitalmanager.R;
import com.bvlabs.digitalmanager.tableview.model.Cell;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class CellBtnViewHolder extends AbstractViewHolder {

    public final Button cell_btn_textview;
    public final LinearLayout cell_container_btn;
    private Cell cell;

    public CellBtnViewHolder(View itemView) {
        super(itemView);
        cell_btn_textview = (Button) itemView.findViewById(R.id.data_btn);
        cell_container_btn = (LinearLayout) itemView.findViewById(R.id.cell_container_btn);
    }

    public void setData(Cell cell) {

        this.cell = cell;
        cell_btn_textview.setText(String.valueOf(cell.getData()));
        //cell_btn_textview.setBackgroundColor(Color.parseColor(cell.getCodeColor()));
        // If your TableView should have auto resize for cells & columns.
        // Then you should consider the below lines. Otherwise, you can ignore them.

        // It is necessary to remeasure itself.
        cell_container_btn.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        cell_btn_textview.requestLayout();

    }
}
