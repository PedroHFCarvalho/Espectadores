package BLL

import java.util.regex.Pattern

abstract class Pessoa(
    protected open var nome: String,
    protected open var cpf: String,
    protected open var rg: String,
    protected open var email: String,
    protected open var pcd: Boolean
) {

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

    @JvmName("getNomeX")
    fun getNome(): String {
        return this.nome
    }

    fun setNome(nome: String): Boolean {
        return if (nome.isNotEmpty()) {
            this.nome = nome
            true
        } else {
            false
        }
    }

    @JvmName("getCpfX")
    fun getCpf(): String {
        return this.cpf
    }

    fun setCpf(cpf: String): Boolean {
        return if (validaCpf(cpf)) {
            this.cpf = cpf
            true
        } else {
            false
        }

    }

    @JvmName("getEmailX")
    fun getEmail(): String {
        return this.email
    }

    fun setEmail(email: String): Boolean {
        return if (validaEmail(email)) {
            this.email = email
            true
        } else {
            false
        }
    }

    @JvmName("getRgX")
    fun getRg(): String {
        return this.rg
    }

    fun setRg(rg: String): Boolean {
        return if (validaRg(rg)) {
            this.rg = rg
            true
        } else {
            false
        }
    }

    @JvmName("getPcdX")
    fun getPcd(): Boolean{
        return this.pcd
    }
    @JvmName("setPcdX")
    fun setPcd(pdc: Boolean){
        this.pcd = pcd
    }


    open fun apresentar(): String {
        return "Nome: $nome\n" +
                "CPF: $cpf\n" +
                "RG: $rg\n" +
                "Email: $email\n"


    }


}