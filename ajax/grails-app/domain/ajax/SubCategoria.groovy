package ajax

class SubCategoria {

	static belongsTo = [Categoria]


	Categoria categoria
	String nome

    public String toString()
    {
        return "${nome}"
    }

    static constraints = {
    	nome(unique:true)
    }

}
