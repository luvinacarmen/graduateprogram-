package ajax

class Item {



	Categoria categoria
	SubCategoria subCategoria
	String nome 
	Date dataDeInsercao
	String observacoes

    public String toString()
    {
        return "${nome}"
    }

    static constraints = {
    	categoria()
    	subCategoria()
    	nome()
    	dataDeInsercao()
    	observacoes(nullable:true,widget:"textarea")
    }
}
