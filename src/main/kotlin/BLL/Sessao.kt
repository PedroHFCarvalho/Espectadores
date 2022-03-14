package BLL

class Sessao() {

    private val listAssentos = mutableMapOf<Int, Espectador>()

    private var assentoTotal: Int = 0
    private var assentoAtual: Int = 0
    private var assentoPcdTotal: Int = 0
    private var assentoPcdAtual: Int = 0


    fun consultarCadeiraVazia(key: Int): Boolean {
        return listAssentos.containsKey(key)
    }

    fun consultarSessao(): MutableMap<Int, Espectador> {
        return listAssentos
    }

    fun consultarEspectador(key: Int): Espectador {
        return listAssentos[key]!!.getEspec()
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
        listAssentos[key] = espectador
    }

    fun reduzirAssentoPcd() {
        this.assentoPcdAtual--
    }

    fun reduzirAssento() {
        this.assentoAtual--
    }

    private fun aumentarAssentoPcd() {
        this.assentoPcdAtual++
    }

    private fun aumentarAssento() {
        this.assentoAtual++
    }

    fun addAssento(key: Int, espectador: Espectador) {
        if (espectador.getPcd()) {
            listAssentos[key] = espectador
            reduzirAssentoPcd()
        } else {
            listAssentos[key] = espectador
            reduzirAssento()
        }
    }

    fun removerAssento(key: Int, espectador: Espectador) {
        if (espectador.getPcd()) {
            listAssentos.remove(key)
            aumentarAssentoPcd()
        } else {
            listAssentos.remove(key)
            aumentarAssento()
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