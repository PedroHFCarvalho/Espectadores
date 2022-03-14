package BLL


data class Espectador(
    override var nome: String,
    override var cpf: String,
    override var rg: String,
    override var email: String,
    override var pcd: Boolean

) : Pessoa(nome, cpf, rg, email, pcd) {

    private var assento: Int = 0

    constructor(
        nome: String,
        cpf: String,
        rg: String,
        email: String,
        assento: Int,
        pdc: Boolean
    ) : this(nome, cpf, rg, email, pdc) {

        this.assento = assento
    }

    init {
        if (!validaRg(rg)) {
            throw Exception("RG Incorreto")
        }
        if (!validaEmail(email)) {
            throw Exception("Email Incorreto")
        }
        if (!validaCpf(cpf)) {
            throw Exception("CPF Incorreto")
        }

    }

    fun getAssento(): Int {
        return this.assento
    }

    fun setAssento(assento: Int) {
        this.assento = assento
    }

    fun getEspec(): Espectador{
        return this
    }


    override fun apresentar(): String {
        return "Nome: $nome\n" +
                "CPF: $cpf\n" +
                "RG: $rg\n" +
                "Email: $email\n" +
                "Assento: $assento\n"
    }

    override fun toString(): String {
        return "[Nome: $nome]"
    }

}