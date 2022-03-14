import bll.*

fun main() {

    val sessao = Sessao()
    val gerencia = Gerencia()
    var cliente: Espectador
    var opc = 0

    println("_______________________________________")
    println("Primeira Inicialização")
    println("Por favor digite o numero máximo de cadeiras na plateia")
    while (true) {
        try {
            sessao.setAssento(readLine()!!.toInt())
            break
        } catch (e: Exception) {
            println("Digite o numero máximo de cadeiras na plateia novamente")
        }
    }
    println("Por favor digite o numero máximo de cadeiras na plateia reservadas para PCDs")
    while (true) {
        try {
            sessao.setAssentoPcd(readLine()!!.toInt())
            break
        } catch (e: Exception) {
            println("Digite o numero máximo de cadeiras para PCDs na plateia novamente")
        }
    }
    while (sessao.validarAssento()) {
        println("Numero de assentos PCDs é maior que o numero total de cadeiras, Por favor digite novamente")
        println("Por favor digite o numero máximo de cadeiras na plateia reservadas para PCDs")
        try {
            sessao.setAssentoPcd(readLine()!!.toInt())
        } catch (_: Exception) {

        }
    }

    do {
        println("_______________________________________")
        println("Assentos livres: ${sessao.getAssentoAtual()}\nAssentos livres PCDs ${sessao.getAssentoPcdAtual()}")
        println("Digite 1 - Adicionar Espectador")
        println("Digite 2 - Consultar uma Cadeira")
        println("Digite 3 - Listar todas as cadeiras")
        println("Digite 4 - Editar Cadeira")
        println("Digite 5 - Remover Cadeira")
        println("Digite 6 - Editar Espectador")
        println("Digite 7 - Sair")
        println("_______________________________________")
        println("Digite o numero da Operação")
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
                val nome = readLine()!!
                println("CPF:")
                while (true) {
                    try {
                        cpf = readLine()!!
                        Pessoa.validaCpf(cpf)
                        break
                    } catch (e: Exception) {
                        println(e.message)
                        println("Digite o CPF novamente:")
                    }
                }
                println("RG:")
                while (true) {
                    try {
                        rg = readLine()!!
                        Pessoa.validaRg(rg)
                        break
                    } catch (e: Exception) {
                        println(e.message)
                        println("Digite o RG novamente:")
                    }

                }
                println("Email:")
                while (true) {
                    try {
                        email = readLine()!!
                        Pessoa.validaEmail(email)
                        break
                    } catch (e: Exception) {
                        println(e.message)
                        println("Digite o Email novamente:")
                    }

                }

                if (yesOrNot.compareTo("n", true) == 0 && sessao.getAssento() != 0) {

                    cliente = Espectador(nome, cpf, rg, email, false)
                    gerencia.addEspectador(cliente.getCpf(), cliente)
                    sessao.addAssento(sessao.getAssentoAtual(), cliente)

                    println("Pessoa adicionado com secesso")
                    println("Aperte ENTER para continuar")
                    readLine()

                } else if (yesOrNot.compareTo("s", true) == 0 && sessao.getAssentoPcdAtual() != 0) {

                    cliente = Espectador(nome, cpf, rg, email, true)
                    gerencia.addEspectador(cliente.getCpf(), cliente)
                    sessao.addAssento(sessao.getAssentoPcdAtual(), cliente)

                    println("Pessoa adicionado com sucesso")
                    println("Aperte ENTER para continuar")
                    readLine()

                } else if (sessao.getAssentoAtual() == 0 && sessao.getAssentoPcdAtual() == 0) {
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
                var cadeira: Int
                while (true) {
                    try {
                        cadeira = readLine()!!.toInt()
                        break
                    } catch (e: Exception) {
                        println("Digite o numero da cadeira novamente")
                    }
                }


                if (sessao.consultarCadeiraVazia(cadeira)) {
                    val espec = sessao.consultarEspectador(cadeira)
                    println(espec.apresentar())
                    println("Aperte ENTER para continuar")
                    readLine()
                } else {
                    println("Cadeira Vazia")
                }
            }
            3 -> {
                val lista = sessao.consultarSessao()
                lista.forEach {
                    println(it.toString())
                }
                println("Aperte ENTER para continuar")
                readLine()
            }
            4 -> {
                println("Digite o numero da cadeira a ser atualizada")
                var cadeira: Int
                while (true) {
                    try {
                        cadeira = readLine()!!.toInt()
                        break
                    } catch (e: Exception) {
                        println("Digite o numero da cadeira novamente")
                    }
                }

                if (sessao.consultarCadeiraVazia(cadeira)) {
                    val espec = sessao.consultarEspectador(cadeira)
                    println("${espec.getNome()} esta nesta cadeira")
                    println("Digite os dados da nova pessoa: ")

                    println("Nome:")
                    val nome = readLine()!!

                    var cpf: String
                    var rg: String
                    var email: String
                    val pcd = espec.getPcd()

                    println("CPF:")
                    while (true) {
                        try {
                            cpf = readLine()!!
                            Pessoa.validaCpf(cpf)
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
                            Pessoa.validaRg(rg)
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
                            Pessoa.validaEmail(email)
                            break
                        } catch (e: Exception) {
                            println(e.message)
                            println("Digite o Email novamente:")
                        }

                    }

                    cliente = Espectador(nome, cpf, rg, email, pcd)
                    cliente.setAssento(cadeira)
                    sessao.addAssento(cadeira, cliente)

                    println("Pessoa atualizada com sucesso")
                    println("Aperte ENTER para continuar")
                    readLine()

                }
            }
            5 -> {
                println("Digite o numero da cadeira a ser removido")
                var cadeira: Int
                while (true) {
                    try {
                        cadeira = readLine()!!.toInt()
                        break
                    } catch (e: Exception) {
                        println("Digite o numero da cadeira novamente")
                    }
                }
                if (sessao.consultarCadeiraVazia(cadeira)) {
                    val espec = sessao.consultarEspectador(cadeira)
                    println(espec.apresentar())

                    println("deseja realmente cancelar esse ingresso? [s/n]")
                    val yesOrNot = readLine()!!
                    while (true) {
                        if (yesOrNot.compareTo("s", true) == 0) {
                            sessao.removerAssento(cadeira, espec)
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
            6 -> {


                println("Digite o sue CPF")
                val cpf = readLine()!!
                var opcEdicao = 0
                do {
                    if (gerencia.consultarEspectadorVazio(cpf)) {
                        val espec = gerencia.consultarEspectador(cpf)
                        println(espec.apresentar())

                        println("Digite 1 - Mudar o nome")
                        println("Digite 2 - Mudar CPF")
                        println("Digite 3 - Mudar RG")
                        println("Digite 4 - Mudar Email")
                        println("Digite 5 - Sair do Modo Edição")

                        opcEdicao = readLine()!!.toInt()

                        when (opcEdicao) {
                            1 -> {
                                println("Digite o novo nome")
                                val nome = readLine()!!
                                if (espec.setNome(nome)) {
                                    println("Nome editado com sucesso")
                                    gerencia.atualizarEspectador(cpf, espec)
                                } else {
                                    println("Nome não editado")
                                }
                            }
                            2 -> {
                                println("Digite o novo CPF")
                                val cpfN = readLine()!!
                                if (espec.setCpf(cpfN)) {
                                    println("CPF editado com sucesso")
                                    gerencia.atualizarEspectador(cpf, espec)
                                } else {
                                    println("CPF não editado")
                                }
                            }
                            3 -> {
                                println("Digite o novo RG")
                                val rg = readLine()!!
                                if (espec.setRg(rg)) {
                                    println("RG editado com sucesso")
                                    gerencia.atualizarEspectador(cpf, espec)
                                } else {
                                    println("RG não editado")
                                }
                            }
                            4 -> {
                                println("Digite o novo Email")
                                val email = readLine()!!
                                if (espec.setEmail(email)) {
                                    println("Email editado com sucesso")
                                    gerencia.atualizarEspectador(cpf, espec)
                                } else {
                                    println("Email não editado")
                                }
                            }
                            5 -> println("Saindo do modo Edição")
                        }
                    } else {
                        println("CPF Incorreto ou Não Existe")
                    }
                } while (opcEdicao != 5)
            }

            7 -> {
                println("Programa foi finalizado")
            }

            else -> {
                println("Não foi possível verificar a operação")
                println("Aperte ENTER para continuar")
                readLine()
            }
        }

    } while (opc != 7)

}