package com.example.netactivity;

import android.content.Context;

public class Entry {
    public final String kod;
    public String mena;
    public String stat;
    public Double cena;
 
    // tudu 3. Rozsirit dalsi udaje ve tride, ktere se budou vest pro kazdou menu
    //  3. To zahrnuje i upraveni konstruktoru
            
    Entry(String mena, String kod, String stat, double cena) {
        this.kod = kod;
        this.mena = mena;
        this.stat = stat;
        this.cena = cena;
    }
}
