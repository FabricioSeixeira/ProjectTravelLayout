package com.example.fabriciosteixeira.slider_app;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by fabricio.steixeira on 14/03/2018.
 */

public class Slide_Adapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    //lista de imagens

    public int[] lst_imagens = {
            R.drawable.astronauta,
            R.drawable.buraco_negro,
            R.drawable.foguete,
            R.drawable.satelite,
            R.drawable.google

    };

    //lista de títulos

    public String[] lst_titulo = {
            "ASTRONALTA",
            "SATELITE",
            "GALAXIA",
            "FOGUETE",
            "GOOGLE"
    };

    //lista de descrições

    public String[] lst_descricao = {
            "Descrição 1",
            "Descrição 2",
            "Descrição 3",
            "Descrição 4",
            "Descrição 5"

    };

    public int[] lst_background = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(198,57, 57)
    };

    public Slide_Adapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {

        return lst_titulo.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container, false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitulo);
        TextView descrition = (TextView) view.findViewById(R.id.txtDescricao);
        layoutslide.setBackgroundColor(lst_background[position]);
        imgslide.setImageResource(lst_imagens[position]);
        txtTitle.setText(lst_titulo[position]);
        descrition.setText(lst_descricao[position]);
        container.addView(view);
        return view;
    }
}
