package com.bvlabs.digitalmanager.tableview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.bvlabs.digitalmanager.R;
import com.bvlabs.digitalmanager.tableview.model.Cell;
import com.bvlabs.digitalmanager.tableview.model.ColumnHeader;
import com.bvlabs.digitalmanager.tableview.model.RowHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TableViewModel {

    // Columns indexes

    public static final int CELL_BTN_COLUMN_INDEX = 2;
    public static final int CELL_BTN_ACTION_COLUMN_INDEX = 6;



    // Constant size for dummy data sets
    private static final int COLUMN_SIZE = 7;
    private static final int ROW_SIZE = 3;


    private Context mContext;

    public TableViewModel(Context context) {
        mContext = context;

    }

    private List<RowHeader> getSimpleRowHeaderList() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            RowHeader header = new RowHeader(String.valueOf(i), "" + i);
            list.add(header);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    public static List<RowHeader> getSimpleRowHeaderList(int startIndex) {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            RowHeader header = new RowHeader(String.valueOf(i), "" + (startIndex + i));
            list.add(header);
        }

        return list;
    }


    private List<ColumnHeader> getSimpleColumnHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();

        for (int i = 0; i < COLUMN_SIZE; i++) {
            String title = "column " + i;
            if (i % 6 == 2) {
                title = "large column " + i;
            }
            ColumnHeader header = new ColumnHeader(String.valueOf(i), title);
            list.add(header);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    private List<ColumnHeader> getRandomColumnHeaderList() {
        List<ColumnHeader> list = new ArrayList<>();

        for (int i = 0; i < COLUMN_SIZE; i++) {
            //String title = "Libellé " + i;
            String title = "Libellé";
            if (i==1){
                title = "Date création ";
            }else if (i==2){
                title = "Evaluation";
            }else if (i==3){
                title = "Délai";
            }else if (i==4){
                title = "Superviseur ";
            }else if (i==5){
                title = "Description";
            }else if (i==6){
                title = "Action";
            }
            /*int nRandom = new Random().nextInt();
            if (nRandom % 4 == 0 || nRandom % 3 == 0 || nRandom == i) {
                title = "large column " + i;
            }*/

            ColumnHeader header = new ColumnHeader(String.valueOf(i), title);
            list.add(header);
        }

        return list;
    }

    private List<List<Cell>> getSimpleCellList() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<Cell> cellList = new ArrayList<>();

            for (int j = 0; j < COLUMN_SIZE; j++) {
                String text = "cell " + j + " " + i;
                if (j % 4 == 0 && i % 5 == 0) {
                    text = "large cell " + j + " " + i + ".";
                }
                String id = j + "-" + i;

                Cell cell = new Cell(id, text);
                cellList.add(cell);
            }
            list.add(cellList);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    private List<List<Cell>> getCellListForSortingTest() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<Cell> cellList = new ArrayList<>();
            for (int j = 0; j < COLUMN_SIZE; j++) {
                Object text = "cell " + j + " " + i;

                final int random = new Random().nextInt();
                if (j == 0) {
                    text = "Formulaire "+i;
                } else if (j == 1) {
                    text = "01/04/2019";
                }else if (j==3){
                    text = "10/07/2019";
                }else if (j==4){
                    text = "NED.Ménès";
                }else if (j==5){
                    text = "Desc"+i;
                }else if (j==CELL_BTN_COLUMN_INDEX){
                    text = "Valide";
                }else if (j==CELL_BTN_ACTION_COLUMN_INDEX){
                    text = "Remplir";
                }

                // Create dummy id.
                String id = j + "-" + i;

                Cell cell;
                if (j == 2) {
                    cell = new Cell(id, text,"#7b1fa2");
                } else if (j == 6) {
                    // NOTE female and male keywords for filter will have conflict since "female"
                    // contains "male"
                    cell = new Cell(id, text,"#7b1fa2");
                } else {
                    cell = new Cell(id, text);
                }
                cellList.add(cell);
            }
            list.add(cellList);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    private List<List<Cell>> getRandomCellList() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<Cell> cellList = new ArrayList<>();
            list.add(cellList);
            for (int j = 0; j < COLUMN_SIZE; j++) {
                String text = "cell " + j + " " + i;
                int random = new Random().nextInt();
                if (random % 2 == 0 || random % 5 == 0 || random == j) {
                    text = "large cell  " + j + " " + i + getRandomString() + ".";
                }

                // Create dummy id.
                String id = j + "-" + i;

                Cell cell = new Cell(id, text);
                cellList.add(cell);
            }
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    private List<List<Cell>> getEmptyCellList() {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<Cell> cellList = new ArrayList<>();
            list.add(cellList);
            for (int j = 0; j < COLUMN_SIZE; j++) {

                // Create dummy id.
                String id = j + "-" + i;

                Cell cell = new Cell(id, "");
                cellList.add(cell);
            }
        }

        return list;
    }

    private List<RowHeader> getEmptyRowHeaderList() {
        List<RowHeader> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            RowHeader header = new RowHeader(String.valueOf(i), "");
            list.add(header);
        }

        return list;
    }

    /**
     * This is a dummy model list test some cases.
     */
    public static List<List<Cell>> getRandomCellList(int startIndex) {
        List<List<Cell>> list = new ArrayList<>();
        for (int i = 0; i < ROW_SIZE; i++) {
            List<Cell> cellList = new ArrayList<>();
            list.add(cellList);
            for (int j = 0; j < COLUMN_SIZE; j++) {
                String text = "cell " + j + " " + (i + startIndex);
                int random = new Random().nextInt();
                if (random % 2 == 0 || random % 5 == 0 || random == j) {
                    text = "large cell  " + j + " " + (i + startIndex) + getRandomString() + ".";
                }

                String id = j + "-" + (i + startIndex);

                Cell cell = new Cell(id, text);
                cellList.add(cell);
            }
        }

        return list;
    }


    private static String getRandomString() {
        Random r = new Random();
        String str = " a ";
        for (int i = 0; i < r.nextInt(); i++) {
            str = str + " a ";
        }

        return str;
    }

    public List<List<Cell>> getCellList() {
        return getCellListForSortingTest();
    }

    public List<RowHeader> getRowHeaderList() {
        return getSimpleRowHeaderList();
    }

    public List<ColumnHeader> getColumnHeaderList() {
        return getRandomColumnHeaderList();
    }


}
