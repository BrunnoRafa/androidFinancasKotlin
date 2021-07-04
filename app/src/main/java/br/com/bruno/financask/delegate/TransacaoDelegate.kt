package br.com.bruno.financask.delegate

import br.com.bruno.financask.model.Transacao

interface TransacaoDelegate {
    fun delegate(transacao: Transacao)
}