package BLL

import interfaceCliente.Cliente
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class Espectador(
    override var nome: String,
    override var cpf: String,
    override var rg: String
) : Cliente {

    override var id: Int = 0
    override var assento: Int = 0
    override var email: String = ""

    constructor(nome: String, cpf: String, rg: String, assento: Int) : this(nome, cpf, rg) {

        this.nome = nome
        this.cpf = cpf
        this.rg = rg
        this.assento = assento

    }

    override fun ValidaCpf(): Boolean {
        TODO()
    }

    override fun ValidaRg(): Boolean {
        TODO()
    }

    override fun ValidaEmail(): Boolean {
        TODO()
    }

    override fun ConsultarAssento(): Int {
        TODO()
    }

    override fun toString(): String {
        return "Nome: $nome\n" +
                "Cpf: $cpf\n" +
                "RG: $rg\n" +
                "Assento: $assento\n"

    }

}