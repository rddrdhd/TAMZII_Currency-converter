package com.example.netactivity;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// TODO 1. - Aktualne funguje aplikace tak, ze se nacte a zobrazi v listu kody men ze souboru http://www.cnb.cz/cs/financni_trhy/devizovy_trh/kurzy_devizoveho_trhu/denni_kurz.xml
// TODO 1. - Cilem je upravit zobrazovani tak aby se zobrazovalo: vlajka statu, nazev meny, kod statu, nazev statu a cena.
// TODO 1. - Kazdy radek listu je reprezentovan instancemi tridy Entry, v tento okamzik je ve tride Entry udaj pouze pro kod zeme
// TODO 1. - V nastaveni aplikace muzete nastavit jestli se maji data stahovat pouze pres wifi
//  |-----------|----------------------------------|
//  | ImageView |          NAZEV MENY              |  
//  |           |Kod                               | 
//  |  vlajka   |Stat                              |
//  |   statu   |Cena                              | 
//  |           |                                  |
//  |----------------------------------------------|
//

public class CNBAdapter extends ArrayAdapter<Entry>{

    Context context;
    int layoutResourceId;   
    List<Entry> data = null;
    
   
    public CNBAdapter(Context context, int layoutResourceId, List<Entry> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EntryHolder holder = null;
       
        if(row == null)
        {
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );      	
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new EntryHolder();
            holder.txtKod = row.findViewById(R.id.txtKod);
            holder.txtNazev = row.findViewById(R.id.txtNazev);
            holder.txtStat = row.findViewById(R.id.txtStat);
            holder.txtCena = row.findViewById(R.id.txtCena);
            holder.imgFlag = row.findViewById(R.id.imageView);
            
            row.setTag(holder);
        }
        else
        {
            holder = (EntryHolder)row.getTag();
        }

        Entry entry = data.get(position);
        String cena = Double.toString(entry.cena);
        holder.txtNazev.setText(entry.mena);
        holder.txtKod.setText(entry.kod);
        holder.txtStat.setText(entry.stat);
        holder.txtCena.setText(cena);


        Context context = holder.imgFlag.getContext();
        String imgName = "flag_"+entry.kod.toLowerCase();
        int id = context.getResources().getIdentifier(imgName, "drawable", context.getPackageName());
        holder.imgFlag.setImageResource(id);


        
        return row;
    }
   
    static class EntryHolder
    {
        TextView txtKod;
        TextView txtNazev;
        TextView txtStat;
        TextView txtCena;
        ImageView imgFlag;
    }
}
