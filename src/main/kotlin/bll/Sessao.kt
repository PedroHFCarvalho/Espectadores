package bll

class Sessao() {

    private val listAssentos = mutableMapOf<Int, Espectador>()

    private var assentoTotal: Int = 0
    private var assentoAtual: Int = 1
    private var assentoPcdTotal: Int = 1
    private var assentoPcdAtual: Int = 1


    fun consultarCadeiraVazia(key: Int): Boolean {
        return this.listAssentos.containsKey(key)
    }

    fun consultarSessao(): MutableMap<Int, Espectador> {
        return this.listAssentos
    }

    fun consultarEspectador(key: Int): Espectador {
        return this.listAssentos[key]!!.getEspectador()
    }

    fun validarAssento(): Boolean {
        return if (this.assentoPcdTotal >= this.assentoTotal) {
            true
        } else {
            this.assentoAtual = this.assentoTotal
            this.assentoPcdAtual = this.assentoPcdTotal
            calcularAssento()
            false
        }

    }

    private fun calcularAssento() {
        this.assentoAtual -= this.assentoPcdAtual
    }

    fun atualizarEspec(key: Int, espectador: Espectador) {
        this.listAssentos[key] = espectador
    }

    private fun reduzirAssentoPcd() {
        this.assentoPcdAtual = this.assentoPcdAtual - 1
    }

    private fun reduzirAssento() {
        this.assentoAtual = this.assentoAtual - 1
    }

    private fun aumentarAssentoPcd() {
        this.assentoPcdAtual = this.assentoPcdAtual + 1
    }

    private fun aumentarAssento() {
        this.assentoAtual = this.assentoAtual + 1
    }

    fun addAssento(key: Int, espectador: Espectador) {
        if (espectador.getPcd()) {
            this.listAssentos[key] = espectador
            espectador.setAssento(key)
            reduzirAssentoPcd()
        } else {
            this.listAssentos[key] = espectador
            espectador.setAssento(key)
            reduzirAssento()
        }
    }

    fun removerAssento(key: Int, espectador: Espectador) {
        if (espectador.getPcd()) {
            this.listAssentos.remove(key)
            aumentarAssentoPcd()
            espectador.setAssento(0)
        } else {
            this.listAssentos.remove(key)
            aumentarAssento()
            espectador.setAssento(0)
        }
    }

    @JvmName("getAssentoX")
    fun getAssento(): Int {
        return this.assentoTotal
    }

    @JvmName("setAssentoX")
    fun setAssento(assento: Int) {
        this.assentoTotal = assento
    }

    @JvmName("getAssentoPcdX")
    fun getAssentoPcd(): Int {
        return this.assentoPcdTotal
    }

    @JvmName("setAssentoPcdX")
    fun setAssentoPcd(assento: Int) {
        this.assentoPcdTotal = assento
    }

    @JvmName("getAssentoAtualX")
    fun getAssentoAtual(): Int {
        return this.assentoAtual
    }

    @JvmName("getAssentoPdcAtualX")
    fun getAssentoPcdAtual(): Int {
        return this.assentoPcdAtual
    }

}