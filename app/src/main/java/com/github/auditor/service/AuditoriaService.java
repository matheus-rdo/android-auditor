package com.github.auditor.service;

import com.github.auditor.models.ItemAuditoria;
import com.github.auditor.models.Ocorrencia;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AuditoriaService {

    public List<ItemAuditoria> getItensAuditoria() {

        return Arrays.asList(
                new ItemAuditoria(new Date(), "Capacete"),
                new ItemAuditoria(new Date(), "Protetor auricular"),
                new ItemAuditoria(new Date(), "Luva"),
                new ItemAuditoria(new Date(), "Bota")

        );
    }

    public List<Ocorrencia> getOcorrencias() {
        return Arrays.asList(
                new Ocorrencia("001", "Uso adequado", "Nada", Ocorrencia.Tipo.OK),
                new Ocorrencia("002", "Não se aplica", "Equipamento não entregue", Ocorrencia.Tipo.OK),
                new Ocorrencia("003", "Equipamento não entregue", "Nada", Ocorrencia.Tipo.OK),
                new Ocorrencia("004", "Equipamento perdido", "Nada", Ocorrencia.Tipo.NOK)
        );
    }

}
