package com.github.auditor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.github.auditor.models.ItemAuditoria;
import com.github.auditor.models.Ocorrencia;
import com.github.auditor.ui.adapter.ItemAuditoriaAdapter;
import com.github.auditor.ui.adapter.viewmodel.AuditoriaViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AuditoriaViewModel model;

    private RecyclerView itensAuditoriaRecyclerView;

    private ItemAuditoriaAdapter itensAuditoriaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.model = ViewModelProviders.of(this).get(AuditoriaViewModel.class);
        this.itensAuditoriaRecyclerView = findViewById(R.id.itensAuditoriaRecyclerView);

        List<Ocorrencia> ocorrencias = model.getOcorrencias().getValue();
        List<ItemAuditoria> auditorias = model.getItensAuditoria().getValue();

        this.itensAuditoriaAdapter = new ItemAuditoriaAdapter(auditorias, ocorrencias, (auditoriaIndex, ocorrencia) -> {
            ItemAuditoria item = auditorias.get(auditoriaIndex);
            item.setOcorrencia(ocorrencia);
        });
        itensAuditoriaRecyclerView.setAdapter(itensAuditoriaAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        itensAuditoriaRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
