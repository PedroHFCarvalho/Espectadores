package BLL

sealed interface IEspectador {

    var nome: String
    var cpf: String
    var rg: String
    var email: String
    var assento: Int

    fun setNome(nome: String): Boolean
    fun setCpf(cpf: String): Boolean
    fun setEmail(email: String): Boolean
    fun setRg(rg: String): Boolean
    fun apresentar(): String

}