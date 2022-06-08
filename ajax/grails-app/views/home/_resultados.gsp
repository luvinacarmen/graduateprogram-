

Listagem : <g:formatDate value="${new Date()}" 
format="dd/MM/yyyy HH:mm:ss"/> : ${lista?.size()}

<f:table collection="${lista}" order="nome,categoria,subCategoria,dataDeInsercao"/>