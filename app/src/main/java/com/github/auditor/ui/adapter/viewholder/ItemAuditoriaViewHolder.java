package com.github.auditor.ui.adapter.viewholder;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.auditor.R;

public class ItemAuditoriaViewHolder extends RecyclerView.ViewHolder {

    public TextView data;
    public TextView descricao;
    public Spinner ocorrencia;

    public ItemAuditoriaViewHolder(@NonNull View itemView) {
        super(itemView);
        data = itemView.findViewById(R.id.item_auditoria_line_data);
        descricao = itemView.findViewById(R.id.item_auditoria_line_descricao);
        ocorrencia = itemView.findViewById(R.id.item_auditoria_line_ocorrencia);
    }
}
