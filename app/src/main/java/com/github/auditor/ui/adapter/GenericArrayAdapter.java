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

public class GenericArrayAdapter<T> extends ArrayAdapter<String> {

    private static final int DEFAULT_HEIGHT = 96;

    private static final int DEFAULT_RESOURCE = android.R.layout.simple_spinner_item;

    public GenericArrayAdapter(@NonNull Context context, @NonNull List<T> objects, PresentationParser<T> presentationParser) {
        super(context, DEFAULT_RESOURCE);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fillOptions(objects, presentationParser);
    }

    private void fillOptions(List<T> objects, PresentationParser<T> presentationParser) {
        add("Selecione");
        for (T obj : objects) {
            add(presentationParser.toPresentation(obj));
        }
    }

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

    public interface PresentationParser<T> {

        String toPresentation(T item);

    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
