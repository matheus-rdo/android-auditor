package com.github.auditor.ui.adapter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.auditor.models.ItemAuditoria;
import com.github.auditor.models.Ocorrencia;
import com.github.auditor.service.AuditoriaService;

import java.util.List;

public class AuditoriaViewModel extends ViewModel {

    private AuditoriaService auditoriaService;

    private final MutableLiveData<List<ItemAuditoria>> itensAuditoria = new MutableLiveData<>();
    private final MutableLiveData<List<Ocorrencia>> ocorrencias = new MutableLiveData<>();

    public AuditoriaViewModel() {
        this.auditoriaService = new AuditoriaService();
    }

    public MutableLiveData<List<ItemAuditoria>> getItensAuditoria() {
        if (itensAuditoria.getValue() == null) {
            itensAuditoria.setValue(auditoriaService.getItensAuditoria());
        }
        return itensAuditoria;
    }


    public MutableLiveData<List<Ocorrencia>> getOcorrencias() {
        if (ocorrencias.getValue() == null) {
            ocorrencias.setValue(auditoriaService.getOcorrencias());
        }
        return ocorrencias;
    }


}
