Feature: Prencher formulário do campo

Scenario: Acesar campo de treinamento e preencher os formulario
Given que estou no campo de treinamento
When preencho <Nome> <Sobrenome>
And seleciono <Masculino> <Pizza> <Frango>
And depois seleciono <Escolaridade>
And seleciono <Natacao> <Futebol> 
And escrevo <Sugestoes>
Then devo visualizar o dados do cadatro


Examples: 
|Nome		|Sobrenome	|Masculino	|Pizza	 |Frango	 |Escolaridade	|Natacao	 |Futebol   |Sugestoes      |	
|"Caio" |"Augusto"	|"Masculino"|"Pizza" |"Frango" |"mestrado"		|"Natacao" |"Futebol" |"teste,teste"  |
