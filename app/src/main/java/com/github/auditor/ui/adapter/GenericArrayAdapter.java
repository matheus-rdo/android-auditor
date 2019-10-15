package com.github.auditor.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public abstract class GenericArrayAdapter<T> extends ArrayAdapter<String> {

    private static final int DEFAULT_HEIGHT = 96;

    private static final int DEFAULT_RESOURCE = android.R.layout.simple_spinner_item;

    public GenericArrayAdapter(@NonNull Context context, @NonNull List<T> objects) {
        super(context, DEFAULT_RESOURCE);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fillOptions(objects);
    }

    private void fillOptions(List<T> objects) {
        add("Selecione");
        for (T obj : objects) {
            add(getItemLabel(obj));
        }
    }


    public abstract String getItemLabel(T item);

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (position == 0) {
            layoutParams.height = 1;
        } else {
            layoutParams.height = DEFAULT_HEIGHT;
        }
        view.setLayoutParams(layoutParams);
        return view;
    }
}
