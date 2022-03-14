package BLL

class Gerencia {
    private val listEspectadores = mutableMapOf<String, Espectador>()

    fun addEspectador(key: String,espectador: Espectador){
        listEspectadores[key] = espectador
    }

    fun consultarEspectadorVazio(key: String): Boolean {
        return this.listEspectadores.containsKey(key)
    }

    fun consultarEspectador(key: String): Espectador{
        return this.listEspectadores[key]!!.getEspec()
    }

    fun atualizarEspec(key: String,espectador: Espectador){
        listEspectadores[key] = espectador
    }
}