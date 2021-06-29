package br.com.bruno.financask.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import br.com.bruno.financask.R
import br.com.bruno.financask.extension.formataParaBrasileiro
import br.com.bruno.financask.model.Resumo
import br.com.bruno.financask.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(private val view: View,
                 private val context: Context,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)
    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)

    fun adicionaReceita() {
        val totalReceitas = resumo.receita()

        with(view.resumo_card_receita) {
            setTextColor(corReceita)
            text = totalReceitas.formataParaBrasileiro()
        }
    }


    fun adicionaDespesa() {
        val totalDespesas = resumo.despesa()

        with(view.resumo_card_despesa) {
            setTextColor(corDespesa)
            text = totalDespesas.formataParaBrasileiro()
        }
    }

    fun adicionaTotal() {
        val total = resumo.total()

        val corTotal: Int = formataCorTotal(total)
        with(view.resumo_card_total) {
            setTextColor(corTotal)
            text = total.formataParaBrasileiro()
        }
    }

    private fun formataCorTotal(valor: BigDecimal): Int {
        if (valor >= BigDecimal.ZERO) {
            return corReceita
        }
        return corDespesa
    }
}