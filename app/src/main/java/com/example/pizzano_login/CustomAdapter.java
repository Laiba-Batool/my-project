package com.example.pizzano_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context gridContext;
    private final String[] menu;
    private final int[] Imageid;

    public CustomAdapter(Context gridContext, String[] menu, int[] Imageid) {
        this.gridContext = gridContext;
        this.menu = menu;
        this.Imageid = Imageid;
    }

    @Override
    public int getCount()

    {
        return menu.length;
    }

    @Override
    public Object getItem(int position)
    {
        return 0;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater=
                (LayoutInflater)gridContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null) {

            grid = new View(gridContext);
            grid = inflater.inflate(R.layout.single_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(menu[position]);
            imageView.setImageResource(Imageid[position]);
        }
        else
        {
            grid=(View)convertView;

        }
        return grid;
    }
}
