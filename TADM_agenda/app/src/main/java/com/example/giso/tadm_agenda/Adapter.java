package com.example.giso.tadm_agenda;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by giso on 21/05/18.
 */

public class Adapter extends BaseAdapter{

    Context context;
    String nom[];
    String  tel[];
    String ini[];
    LayoutInflater inflater;
    String p,t;

    public Adapter(Context context, String[] nom, String[] tel) {
        this.context = context;
        this.nom = nom;
        this.tel = tel;
        ini=getIniciales();
    }

    public String[] getIniciales(){
        String temp[]=new String[nom.length];
        for (int i=0;i<nom.length;i++){
            temp[i]=nom[i].substring(0,1);
        }
        return temp;
    }

    @Override
    public int getCount() {
        return nom.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Declare Variables
        TextView txtNombre;
        TextView txtTelefono;
        TextView ini;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item, viewGroup, false);

        // Locate the TextViews in listview_item.xml
        txtNombre = (TextView) itemView.findViewById(R.id.nom);
        txtTelefono = (TextView) itemView.findViewById(R.id.tel);
        //ini = (TextView) itemView.findViewById(R.id.ini);

        // Capture position and set to the TextViews
        txtNombre.setText(nom[i]);
        txtTelefono.setText(tel[i]);
        //ini.setText(this.ini[i]);

        return itemView;
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
