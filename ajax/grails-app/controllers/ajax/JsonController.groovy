package ajax

import grails.converters.*


class JsonController {

    def index() { }


    def pesquisa(Categoria cat,SubCategoria sub){

    	println "pesquisando"

        println "Categoria : ${cat}"
        println "Sub Categoria : ${sub}"

        def c = Item.createCriteria()


        def l = c.list{
            if (cat?.id){
                println "Vendo categoria : ${cat}"
                categoria{
                    idEq(cat?.id)
                }
            }
            if (sub?.id){
                println "Vendo subCategoria : ${sub}"
                subCategoria{
                    idEq(sub?.id)
                }
            }
        }


        println l


        render(template: '/home/resultados', model:  [lista: l])
    }

    def subcategorias(Categoria categoria){

        if (!categoria){
            return 
        }

        // def l= ["caren teste"]
        //  render l as JSON

//        render (controller:"home", view: "index")
   	render(template:"/home/subCategorias",model:[lista:categoria?.subCategorias])
		return
   }

}
