package br.com.bruno.financask.model

import java.math.BigDecimal
import java.util.*

class Transacao(val valor: BigDecimal,
                val categoria: String,
                val data: Calendar)