package com.bvlabs.digitalmanager.tableview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bvlabs.digitalmanager.R;
import com.bvlabs.digitalmanager.tableview.holder.ColumnHeaderViewHolder;
import com.bvlabs.digitalmanager.tableview.popup.ColumnHeaderLongPressPopup;
import com.bvlabs.digitalmanager.tableview.popup.RowHeaderLongPressPopup;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.listener.ITableViewListener;

public class TableViewListener implements ITableViewListener {
    private Toast mToast;
    private Context mContext;
    private TableView mTableView;

    TextView mLikerOrComment;
    TextView mStatuerEvaluer;

    public TableViewListener(TableView tableView) {
        this.mContext = tableView.getContext();
        this.mTableView = tableView;
    }

    /**
     * Called when user click any cell item.
     *
     * @param cellView : Clicked Cell ViewHolder.
     * @param column   : X (Column) position of Clicked Cell item.
     * @param row      : Y (Row) position of Clicked Cell item.
     */
    @Override
    public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {

        // Do what you want.
        //showToast("Cell " + column + " " + row + " has been clicked.");
        showToast("Row Id "+ row);

    }

    /**
     * Called when user long press any cell item.
     *
     * @param cellView : Long Pressed Cell ViewHolder.
     * @param column   : X (Column) position of Long Pressed Cell item.
     * @param row      : Y (Row) position of Long Pressed Cell item.
     */
    @Override
    public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, final int column,
                                  int row) {
        FloatingActionButton fab = (FloatingActionButton) cellView.itemView.findViewById(R.id.fab_add);
        Button btn = (Button) cellView.itemView.findViewById(R.id.cell_data_btn);
        Button btnValid = (Button) cellView.itemView.findViewById(R.id.data_btn);

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Showing Menu", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Remplissage button", Toast.LENGTH_SHORT).show();
            }
        });
        btnValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Valider", Toast.LENGTH_SHORT).show();
            }
        }); */

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Remplissage button", Toast.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "Showing Menu", Toast.LENGTH_SHORT).show();
            }
        });

        // Do What you want
        //showToast("Cell " + column + " " + row + " has been long pressed.");


    }

    /**
     * Called when user click any column header item.
     *
     * @param columnHeaderView : Clicked Column Header ViewHolder.
     * @param column           : X (Column) position of Clicked Column Header item.
     */
    @Override
    public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int
            column) {
        // Do what you want.
        showToast("Column header  " + column + " has been clicked.");
    }

    /**
     * Called when user long press any column header item.
     *
     * @param columnHeaderView : Long Pressed Column Header ViewHolder.
     * @param column           : X (Column) position of Long Pressed Column Header item.
     */
    @Override
    public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int
            column) {

        if (columnHeaderView != null && columnHeaderView instanceof ColumnHeaderViewHolder) {
            // Create Long Press Popup
            ColumnHeaderLongPressPopup popup = new ColumnHeaderLongPressPopup(
                    (ColumnHeaderViewHolder) columnHeaderView, mTableView);
            // Show
            popup.show();
        }
    }

    /**
     * Called when user click any Row Header item.
     *
     * @param rowHeaderView : Clicked Row Header ViewHolder.
     * @param row           : Y (Row) position of Clicked Row Header item.
     */
    @Override
    public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {
        // Do what you want.


        showToast("Row header " + row + " has been clicked.");
    }

    /**
     * Called when user long press any row header item.
     *
     * @param rowHeaderView : Long Pressed Row Header ViewHolder.
     * @param row           : Y (Row) position of Long Pressed Row Header item.
     */
    @Override
    public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {

        if (rowHeaderView != null) {
            // Create Long Press Popup
            RowHeaderLongPressPopup popup = new RowHeaderLongPressPopup(rowHeaderView, mTableView);
            // Show
            popup.show();
        }
    }


    private void showToast(String p_strMessage) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
        }

        mToast.setText(p_strMessage);
        mToast.show();
    }
}
