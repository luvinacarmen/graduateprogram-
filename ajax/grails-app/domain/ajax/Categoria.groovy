package ajax

class Categoria {

	static hasMany = [subCategorias: SubCategoria]

	String nome

    public String toString()
    {
        return "${nome}"
    }

    static constraints = {
    	nome(unique:true)
    }
}
