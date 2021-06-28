package br.com.bruno.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import br.com.bruno.financask.R
import br.com.bruno.financask.model.Tipo
import br.com.bruno.financask.model.Transacao
import br.com.bruno.financask.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraLista(transacoes)

    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo(): List<Transacao> {
        return listOf(
                Transacao(valor = BigDecimal(20.5),
                        categoria = "Comida",
                        tipo = Tipo.DESPESA),
                Transacao(valor = BigDecimal(100.0),
                        categoria = "Economia",
                        tipo = Tipo.RECEITA),
                Transacao(valor = BigDecimal(50.0),
                        categoria = "Economia",
                        tipo = Tipo.RECEITA),
                Transacao(valor = BigDecimal(15.0),
                        categoria = "Comida",
                        tipo = Tipo.DESPESA)

        )
    }
}