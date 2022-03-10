package BLL

import java.util.regex.Pattern


class Espectador(
    override var nome: String,
    override var cpf: String,
    override var rg: String,
    override var email: String
) : IEspectador  {

    override var assento: Int = 0

    constructor(nome: String, cpf: String, rg: String, assento: Int, email: String) : this(nome, cpf, rg, email) {

        this.nome = nome
        this.cpf = cpf
        this.rg = rg
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

    companion object {


        fun validaCpf(cpf: String): Boolean {
            var isValid = true
            val expression = "\\d{3}.\\d{3}.\\d{3}-\\d{2}"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(cpf)
            if (!matcher.matches()) {
                isValid = false
                throw Exception("CPF Incorreto")
            }
            return isValid
        }

        fun validaRg(rg: String): Boolean {
            var isValid = true
            val expression = "\\d{2}.\\d{3}.\\d{3}-\\d"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(rg)
            if (!matcher.matches()) {
                isValid = false
            }
            return isValid
        }

        fun validaEmail(email: CharSequence): Boolean {
            var isValid = true
            val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)
            if (!matcher.matches()) {
                isValid = false
            }
            return isValid

        }

    }

    override fun setNome(nome: String): Boolean {
        if (nome.isNotEmpty()) {
            this.nome = nome
            return true
        } else {
            return false
        }

    }

    override fun setCpf(cpf: String): Boolean {
        if (validaCpf(cpf)) {
            this.cpf = cpf
            return true
        } else {
            return false
        }

    }

    override fun setEmail(email: String): Boolean {
        if (validaEmail(email)) {
            this.email = email
            return true
        } else {
            return false
        }

    }

    override fun setRg(rg: String): Boolean {
        if (validaRg(rg)) {
            this.rg = rg
            return true
        } else {
            return false
        }

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