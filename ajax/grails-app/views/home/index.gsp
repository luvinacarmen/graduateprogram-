<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
    <content tag="nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Links <span class="caret"></span></a>
            <ul class="dropdown-menu">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                <li><a href="${createLink(controller:c.name)}">
                    ${c.name}
                </a></li>
                    </g:each>
            </ul>
        </li>
    </content>
    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Pesquisa : <g:formatDate value="${new Date()}" 
              format="dd/MM/yyyy HH:mm:ss"/></h1>
            <p>
            </p>
<form>         

<div class='fieldcontain required'>
  <label for='ano'>Categoria
  </label>
  
 <g:select name="cat.id"  required="" id="cat" from="${ajax.Categoria.list()}"  optionKey="id"  noSelection="['':'']"  onchange="obterSubcategorias();"/>

</div>

  <g:render template="/home/subCategorias"/>

     <g:submitToRemote url="[controller:'json',action: 'pesquisa']" 
     update="conteudo"  class="btn btn-primary mar" value="Pesquisar"/>        
    </form>


  </section>
    </div>

    <div id="conteudo">
        <g:render template="/home/resultados" model="${[lista:ajax.Item.list()]}"/>
    <div>



    <script type="text/javascript">

    
    function obterSubcategorias(){
       var afiliacao =  document.getElementById('cat');

        var parametros = "id="  + afiliacao.value;

          ${
          remoteFunction(controller:'json', action:'subcategorias',update: 'xarmen', 
          params:"parametros")
         }
    }

</script>

</body>
</html>
