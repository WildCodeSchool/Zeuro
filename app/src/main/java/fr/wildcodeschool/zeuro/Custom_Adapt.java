package fr.wildcodeschool.zeuro;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apprenti on 25/11/16.
 */

public class Custom_Adapt extends ArrayAdapter<ForfaitObj> {
    private final Activity context;
    private final ForfaitObj[] list;


    public Custom_Adapt(Activity context, ForfaitObj[] list) {
        super(context, R.layout.list, list);
        this.context = context;
        this.list = list;
    }

    public View getView(int posisition, View View, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list, parent, false );

        ForfaitObj m = getItem(posisition);
        TextView ptiText = (TextView) rowView.findViewById(R.id.internet);
        ImageView element = (ImageView) rowView.findViewById(R.id.icon);
        TextView apelle = (TextView) rowView.findViewById(R.id.apelle);
        TextView prix   = (TextView) rowView.findViewById(R.id.prix);
        if(m.getApelle() == 0){
            apelle.setText("Illimité");
        }
        else if(m.getApelle() != 0){
            apelle.setText(m.getApelle().toString() + " H");
        }

        prix.setText(m.getPrix().toString() + " €");
        ptiText.setText(m.getInternet().toString() + " Go");
        element.setImageResource(m.getImgoperateur());

        return rowView;
    }
}