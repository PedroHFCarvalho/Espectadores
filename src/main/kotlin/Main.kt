import BLL.Espectador
import interfaceCliente.Cliente

fun main() {

    val listAssentos = mutableMapOf<Int,Cliente>()
    val cliente: Cliente
    var assento = 0
    var assentoPCDs = 25

    println("_______________________________________")
    println("Primeira Inicialização")
    println("Por favor digite o numero máximo de cadeiras na plateia")
    assento = readLine()!!.toInt()
    println("Por favor digite o numero máximo de cadeiras na plateia reservadas para PCDs")
    assentoPCDs = readLine()!!.toInt()

    if (assentoPCDs >= assento){
        
    }

    assento -= assentoPCDs
    println("_______________________________________")


    println("PCD ou Não [s/n]")
    val yesOrNot = readLine()!!

    if (yesOrNot.compareTo("s", true) == 0 && assento != 0) {

        println("Nome:")
        val nome = readLine()!!

        println("CPF:")
        val cpf = readLine()!!

        println("RG:")
        val rg = readLine()!!

        cliente = Espectador(nome, cpf, rg)

        listAssentos.put(assento, cliente)
        cliente.assento = assento
        assento--
    } else if (yesOrNot.compareTo("n", true) == 0 && assentoPCDs != 0) {

        println("Nome:")
        val nome = readLine()!!

        println("CPF:")
        val cpf = readLine()!!

        println("RG:")
        val rg = readLine()!!

        cliente = Espectador(nome, cpf, rg)

        listAssentos.put(assentoPCDs, cliente)
        cliente.assento = assentoPCDs
        assentoPCDs--
    } else if (assento == 0 && assentoPCDs == 0){
        println("Sem Ingressos")
    }else{
        println("404")
    }




    println(assento)
    println(assentoPCDs)


    listAssentos.forEach {
        println(it.toString())

    }

}


