package com.applus.task;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgressList extends BaseAdapter {
private Context context;
        ArrayList<HashMap<String, Object>> _data;
        public ProgressList(ArrayList<HashMap<String, Object>> _arr, Context c) {
            this.context = c;
            _data = _arr;
        }

        @Override
        public int getCount() {
            return _data.size();
        }

        @Override
        public HashMap<String, Object> getItem(int _index) {
            return _data.get(_index);
        }

        @Override
        public long getItemId(int _index) {
            return _index;
        }

        @Override
        public View getView(final int _position, View _v, ViewGroup _container) {
            LayoutInflater _inflater = LayoutInflater.from(context);
            View _view = _v;
            if (_view == null) {
                _view = _inflater.inflate(R.layout.random_progress, null);
            }
            final TextView toptext = _view.findViewById(R.id.toptext);
            final TextView firstnum = _view.findViewById(R.id.firstnum);
            final TextView secondnum = _view.findViewById(R.id.secondnum);
            final ProgressBar pb = _view.findViewById(R.id.progress);
String perc =_data.get(_position).get("percentage").toString();

firstnum.setText(_data.get(_position).get("firstnum").toString());
secondnum.setText(_data.get(_position).get("secondnum").toString());
pb.setProgress(Double.valueOf(_data.get(_position).get("percentage").toString()).intValue(), true);
            try {

                if (perc.length() > 4){
                    perc = perc.substring(0, 4);
                }
                toptext.setText(_data.get(_position).get("between").toString().concat(" = %").concat(perc));

            }catch (Exception e){
                toptext.setText(_data.get(_position).get("between").toString().concat(" = %").concat(_data.get(_position).get("percentage").toString()));

            }
            return _view;
        }


}
