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

public abstract class GenericArrayAdapter<T> extends ArrayAdapter<T> {

    private LayoutInflater mInflater;

    private static final int DEFAULT_RESOURCE = android.R.layout.simple_spinner_item;

    public GenericArrayAdapter(@NonNull Context context, @NonNull List<T> objects) {
        super(context, DEFAULT_RESOURCE, objects);
        this.mInflater = LayoutInflater.from(context);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public abstract String getItemLabel(T item);

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final TextView textView;

        if (convertView == null) {
            textView = (TextView) mInflater.inflate(DEFAULT_RESOURCE, parent, false);
        } else {
            textView = (TextView) convertView;
        }

        textView.setText(getItemLabel(getItem(position)));

        return textView;
    }
}
