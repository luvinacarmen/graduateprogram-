package ajax

class BootStrap {





	Categoria criarCategoria(String nome,String items){

		Categoria c = Categoria.findByNome(nome)
		if (!c){

			c = new Categoria(nome:nome)

			if (!c.save(flush:true)){
				c?.errors?.each{
					println it
				}
				return null
			}
		}

		def listaItems = items?.split(",")

		listaItems?.each{String sub ->

			SubCategoria s = SubCategoria.findByNomeAndCategoria(sub,c)

			if (!s){
				s = new SubCategoria(nome:sub,categoria:c)
				if (!s.save(flush:true)){
					s?.errors?.each{
						println it
					}
				}
			}

		}

		return c
	}


    def init = { servletContext ->

    	Categoria l = criarCategoria("Livro","Romance,Policial,Cientifico")
    	Categoria e = criarCategoria("Empresa","Privada,Publica,Cooperativa")
    	Categoria p = criarCategoria("Produto","Agricola,Consumo,Vegetal")
    	Categoria c = criarCategoria("Classe","Primeira,Segunda,Quinta")


    	Categoria.list()?.each{Categoria cat ->
	    	criarItem("Teraa xxx",cat)
	    	criarItem("Lei Da Selva",cat,new Date()-128)
	    	criarItem("Lei Da Programacao",cat,new Date()-128)
	    	criarItem("Lei Da Chave",cat,new Date()-85)
	    	criarItem("Lei Da Guerra",cat,new Date()-85)
	    	criarItem("Mais Um Da Categoria",cat)

    	}

    }


    def criarItem(String nome,Categoria c,Date data= null,String comentario = null){
    	if (!c){
    		return 
    	}

		Item i = Item.findByNomeAndCategoria(nome,c)

		if (i){
			return i
		}

		i = new Item(nome:nome,categoria:c)

		def subs = SubCategoria.findAllByCategoria(c)
		i.subCategoria = randomFromList(subs)


		i.dataDeInsercao = data ?:new Date()
		i.observacoes = comentario ?: "Observacao Padrao (nao tome em conta a subcategoria)"

		if (!i.save(flush:true)){
			i?.errors?.each{
				println it
			}
		}

    }


    def randomFromList(lista){
        List list = new ArrayList(lista)

        if (!list || list?.size() < 1){
            return null
        }


        Collections.shuffle list
        return list?.first()
    }


    def destroy = {
    }
}
