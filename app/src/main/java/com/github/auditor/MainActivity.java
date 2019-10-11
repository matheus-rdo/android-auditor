package com.github.auditor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.github.auditor.models.ItemAuditoria;
import com.github.auditor.models.Ocorrencia;
import com.github.auditor.service.AuditoriaService;
import com.github.auditor.ui.adapter.ItemAuditoriaAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AuditoriaService auditoriaService;

    private RecyclerView itensAuditoriaRecyclerView;

    private ItemAuditoriaAdapter itensAuditoriaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.auditoriaService = new AuditoriaService();
        this.itensAuditoriaRecyclerView = findViewById(R.id.itensAuditoriaRecyclerView);

        List<Ocorrencia> ocorrencias = auditoriaService.getOcorrencias();
        List<ItemAuditoria> auditorias = auditoriaService.getItensAuditoria();

        this.itensAuditoriaAdapter = new ItemAuditoriaAdapter(auditorias, ocorrencias);
        itensAuditoriaRecyclerView.setAdapter(itensAuditoriaAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        itensAuditoriaRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}
