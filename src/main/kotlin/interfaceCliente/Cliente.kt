package interfaceCliente

interface Cliente {

    val id: Int
    val nome: String
    val cpf: String
    val rg: String
    var assento: Int
    val email: String

    fun ValidaCpf(): Boolean
    fun ValidaRg(): Boolean
    fun ValidaEmail(): Boolean
    fun ConsultarAssento(): Int

}