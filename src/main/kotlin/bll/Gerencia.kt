package bll

class Gerencia {
    private val listEspectadores = mutableMapOf<String, Espectador>()

    fun addEspectador(key: String, espectador: Espectador) {
        this.listEspectadores[key] = espectador
    }

    fun consultarEspectadorVazio(key: String): Boolean {
        return this.listEspectadores.containsKey(key)
    }

    fun consultarEspectador(key: String): Espectador {
        return this.listEspectadores[key]!!.getEspectador()
    }

    fun atualizarEspectador(key: String, espectador: Espectador) {
        this.listEspectadores[key] = espectador
    }

}