import BLL.Espectador
import BLL.Gerencia

fun main() {

    val listAssentos = mutableMapOf<Int, Espectador>()
    val listEspectadores = mutableMapOf<String, Espectador>()
    var cliente: Espectador
    var assento = 0
    var assentoPCDs = 25
    var opc = 0


    println("_______________________________________")
    println("Primeira Inicialização")
    println("Por favor digite o numero máximo de cadeiras na plateia")
    while (true) {
        try {
            assento = readLine()!!.toInt()
            break
        } catch (e: Exception) {
            println("Digite o numero máximo de cadeiras na plateia novamente")
        }
    }
    println("Por favor digite o numero máximo de cadeiras na plateia reservadas para PCDs")
    while (true) {
        try {
            assentoPCDs = readLine()!!.toInt()
            break
        } catch (e: Exception) {
            println("Digite o numero máximo de cadeiras para PCDs na plateia novamente")
        }
    }
    while (assentoPCDs >= assento) {
        println("Numero de assentos PCDs é maior que o numero total de cadeiras, Porfavor digite novamente")
        println("Por favor digite o numero máximo de cadeiras na plateia reservadas para PCDs")
        try {
            assentoPCDs = readLine()!!.toInt()
        } catch (_: Exception) {

        }
    }
    println("_______________________________________")
    assento -= assentoPCDs

    do {
        println("_______________________________________")
        println("Assentos livres: $assento\nAssentos livres PCDs $assentoPCDs")
        Gerencia.menu()
        println("_______________________________________")
        try {
            opc = readLine()!!.toInt()
        } catch (_: Exception) {
        }

        when (opc) {
            1 -> {
                println("PCD ou Não [s/n]")
                val yesOrNot = readLine()!!
                var cpf: String
                var rg: String
                var email: String

                println("Nome:")
                var nome = readLine()!!
                println("CPF:")
                while (true) {
                    try {
                        cpf = readLine()!!
                        Espectador.validaCpf(cpf)
                        break
                    } catch (e: Exception) {
                        println(e.message)
                        println("Digite o CPF novamente:")
                    }
                }
                while (true) {
                    println("RG:")
                    try {
                        rg = readLine()!!
                        Espectador.validaRg(rg)
                        break
                    } catch (e: Exception) {
                        println(e.message)
                        println("Digite o RG novamente:")
                    }

                }
                while (true) {
                    println("Email:")
                    try {
                        email = readLine()!!
                        Espectador.validaEmail(email)
                        break
                    } catch (e: Exception) {
                        println(e.message)
                        println("Digite o Email novamente:")
                    }

                }

                cliente = Espectador(nome, cpf, rg, email)
                listEspectadores[cliente.cpf] = cliente



                if (yesOrNot.compareTo("n", true) == 0 && assento != 0) {

                    listAssentos[assento] = cliente
                    cliente.assento = assento
                    assento--

                    println("Pessoa adicionado com secesso")
                    println("Aperte ENTER para continuar")
                    readLine()

                } else if (yesOrNot.compareTo("s", true) == 0 && assentoPCDs != 0) {

                    listAssentos[assentoPCDs] = cliente
                    cliente.assento = assentoPCDs
                    assentoPCDs--
                    println("Pessoa adicionado com secesso")
                    println("Aperte ENTER para continuar")
                    readLine()

                } else if (assento == 0 && assentoPCDs == 0) {
                    println("Sem Ingressos a venda")
                    println("Aperte ENTER para continuar")
                    readLine()
                } else {
                    println("404")
                    println("Aperte ENTER para continuar")
                    readLine()
                }
            }
            2 -> {
                println("Digite o numero da cadeira a ser consultada")
                var cadeira = 0
                while (true) {
                    try {
                        cadeira = readLine()!!.toInt()
                        break
                    } catch (e: Exception) {
                        println("Digite o numero da cadeira novamente")
                    }
                }


                if (listAssentos.containsKey(cadeira)) {
                    println("${listAssentos[cadeira]?.nome} esta nesta cadeira")
                    println("Aperte ENTER para continuar")
                    readLine()
                }
            }
            3 -> {
                listAssentos.forEach {
                    println(it.toString())
                }
                println("Aperte ENTER para continuar")
                readLine()
            }
            4 -> {
                println("Digite o numero da cadeira a ser atualizada")
                var cadeira = 0
                while (true) {
                    try {
                        cadeira = readLine()!!.toInt()
                        break
                    } catch (e: Exception) {
                        println("Digite o numero da cadeira novamente")
                    }
                }

                if (listAssentos.containsKey(cadeira)) {
                    println("${listAssentos[cadeira]?.nome} esta nesta cadeira")
                    println("Digite os dados da nova pessoa: ")

                    println("Nome:")
                    val nome = readLine()!!

                    var cpf: String
                    var rg: String
                    var email: String

                    println("CPF:")
                    while (true) {
                        try {
                            cpf = readLine()!!
                            Espectador.validaCpf(cpf)
                            break
                        } catch (e: Exception) {
                            println(e.message)
                            println("Digite o CPF novamente:")
                        }
                    }
                    while (true) {
                        println("RG:")
                        try {
                            rg = readLine()!!
                            Espectador.validaRg(rg)
                            break
                        } catch (e: Exception) {
                            println(e.message)
                            println("Digite o RG novamente:")
                        }

                    }
                    while (true) {
                        println("Email:")
                        try {
                            email = readLine()!!
                            Espectador.validaEmail(email)
                            break
                        } catch (e: Exception) {
                            println(e.message)
                            println("Digite o Email novamente:")
                        }

                    }

                    cliente = Espectador(nome, cpf, rg, email)

                    listAssentos[cadeira] = cliente
                    cliente.assento = cadeira
                    println("Pessoa atualizada com sucesso")
                    println("Aperte ENTER para continuar")
                    readLine()

                }
            }
            5 -> {
                println("Digite o numero da cadeira a ser removido")
                var cadeira = 0
                while (true) {
                    try {
                        cadeira = readLine()!!.toInt()
                        break
                    } catch (e: Exception) {
                        println("Digite o numero da cadeira novamente")
                    }
                }
                if (listAssentos.containsKey(cadeira)) {
                    println("${listAssentos[cadeira]?.nome} esta nesta cadeira")

                    println("deseja realmente cancelar esse ingresso? [s/n]")
                    val yesOrNot = readLine()!!
                    while (true) {
                        if (yesOrNot.compareTo("s", true) == 0) {
                            listAssentos.remove(cadeira)
                            println("Ingresso cancelado com sucesso")
                            println("Aperte ENTER para continuar")
                            readLine()
                            break
                        } else if ((yesOrNot.compareTo("n", true) == 0)) {
                            println("Ingresso não foi cancelado")
                            println("Aperte ENTER para continuar")
                            readLine()
                            break
                        } else {
                            println("operação nao identificada")
                        }
                    }

                }

            }
            6 ->{
                println("Digite o sue CPF")
                val cpf = readLine()!!
                if (listEspectadores.containsKey(cpf)) {
                    println(listEspectadores[cpf]?.apresentar())

                    println("Digite 1 - Mudar o nome")
                    println("Digite 2 - Mudar CPF")
                    println("Digite 3 - Mudar RG")
                    println("Digite 4 - Mudar Email")

                    var opc = readLine()!!.toInt()

                    when(opc){
                        1 -> {
                            println("Digite o novo nome")
                            var nome = readLine()!!
                            if(listEspectadores[cpf]?.setNome(nome) == true){
                                println("Nome editado com sucesso")
                            }else{
                                println("Nome não editado")
                            }
                        }
                        2 -> {
                            println("Digite o novo CPF")
                            var cpfN = readLine()!!
                            if(listEspectadores[cpf]?.setCpf(cpfN) == true){
                                println("CPF editado com sucesso")
                            }else{
                                println("CPF não editado")
                            }
                        }
                        3 -> {
                            println("Digite o novo RG")
                            var rg = readLine()!!
                            if(listEspectadores[cpf]?.setRg(rg) == true){
                                println("RG editado com sucesso")
                            }else{
                                println("RG não editado")
                            }
                        }
                        4 -> {
                            println("Digite o novo Email")
                            var email = readLine()!!
                            if(listEspectadores[cpf]?.setEmail(email) == true){
                                println("Email editado com sucesso")
                            }else{
                                println("Email não editado")
                            }
                        }
                    }

                }
            }

            7 -> println("Programa foi finalizado")

            else -> {
                println("Não foi possível verificar a operação")
                println("Aperte ENTER para continuar")
                readLine()
            }
        }

    } while (opc != 6)

}


