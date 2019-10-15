package com.github.auditor.ui.adapter;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.auditor.R;
import com.github.auditor.models.ItemAuditoria;
import com.github.auditor.models.Ocorrencia;
import com.github.auditor.ui.adapter.viewholder.ItemAuditoriaViewHolder;

import java.util.List;

public class ItemAuditoriaAdapter extends RecyclerView.Adapter<ItemAuditoriaViewHolder> {

    private final List<ItemAuditoria> itensAuditoria;

    private final List<Ocorrencia> ocorrencias;

    private final OcorrenciaSelectedListener listener;


    public ItemAuditoriaAdapter(List<ItemAuditoria> itensAuditoria, List<Ocorrencia> ocorrencias, OcorrenciaSelectedListener listener) {
        this.itensAuditoria = itensAuditoria;
        this.ocorrencias = ocorrencias;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemAuditoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemAuditoriaViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_auditoria_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemAuditoriaViewHolder holder, int position) {
        ItemAuditoria item = itensAuditoria.get(position);
        CharSequence data = new DateFormat().format("dd/MM/yyyy", item.getData());
        holder.data.setText(data);
        holder.descricao.setText(item.getDescricao());

        // CONFIG ADAPTER
        ArrayAdapter adapter = new GenericArrayAdapter<Ocorrencia>(holder.itemView.getContext(), ocorrencias, audit -> audit.getOcorrencia());
        holder.ocorrencia.setAdapter(adapter);

        // MARCANDO SELECIONADOS
        if (item.getOcorrencia() != null) {
            int index = ocorrencias.indexOf(item.getOcorrencia());
            holder.ocorrencia.setSelection(index + 1, false);
        }

        holder.ocorrencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    Ocorrencia ocorrencia = ocorrencias.get(position - 1);
                    int pos = holder.getAdapterPosition();
                    listener.onOcorrenciaSelected(pos, ocorrencia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("adapter", "Nothing");
            }
        });
    }


    public interface OcorrenciaSelectedListener {

        void onOcorrenciaSelected(int auditoriaIndex, Ocorrencia ocorrencia);

    }

    @Override
    public int getItemCount() {
        return itensAuditoria.size();
    }
}
