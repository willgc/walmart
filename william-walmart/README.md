: Entregando mercadorias

O Walmart esta desenvolvendo um novo sistema de logística e sua ajuda é muito importante neste momento. Sua tarefa será desenvolver o novo sistema de entregas visando sempre o menor custo. Para popular sua base de dados o sistema precisa expor um Webservices que aceite o formato de malha logística (exemplo abaixo), nesta mesma requisição o requisitante deverá informar um nome para este mapa. É importante que os mapas sejam persistidos para evitar que a cada novo deploy todas as informações desapareçam. O formato de malha logística é bastante simples, cada linha mostra uma rota: ponto de origem, ponto de destino e distância entre os pontos em quilômetros.

A B 10

B D 15

A C 20

C D 30

B E 50

D E 30

Com os mapas carregados o requisitante irá procurar o menor valor de entrega e seu caminho, para isso ele passará o mapa, nome do ponto de origem, nome do ponto de destino, autonomia do caminhão (km/l) e o valor do litro do combustível, agora sua tarefa é criar este Webservices. Um exemplo de entrada seria, mapa SP, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B D com custo de 6,25.

Você está livre para definir a melhor arquitetura e tecnologias para solucionar este desafio, mas não se esqueça de contar sua motivação no arquivo README que deve acompanhar sua solução, junto com os detalhes de como executar seu programa. Documentação e testes serão avaliados também

=) Lembre-se de que iremos executar seu código com malhas bem mais complexas, por isso é importante pensar em requisitos não funcionais também!!

Também gostaríamos de acompanhar o desenvolvimento da sua aplicação através do código fonte. Por isso, solicitamos a criação de um repositório que seja compartilhado com a gente. Para o desenvolvimento desse sistema, nós solicitamos que você utilize a sua (ou as suas) linguagem de programação principal. Pode ser Java, JavaScript ou Ruby.

 

SoluÃ§Ã£o
-------

**Arquitetura**

O projeto foi desenvolvido usando a Plataforma JEE 7 - Java Enterprise Edition, empregando APIs robustas para persistencia, como a Java Persistence API (JPA),SOAP para Web Services, Além dessas, também foi utilizado o Simple Logging Facade for Java (SL4J), como facade para o Log4j, renomado framework para logging de aplicações. Para criação de testes unitários foi utilizado o JUnit, na versÃ£o 4.11.


**Softwares necessários**

  * Oracle JDK 8u25


**Execução**

  * Cadastrar Malha
  oding of the parameter value marcado e Post QueryString marcado.  

  * Calcular Rota de Menor Custo
  


**Premissas**

  1. Não existe duas malhas com mesmo nome.
  1. Não existe dois pontos com mesmo nome na mesma malha.
  1. Não existe uma e apenas uma distÃ¢ncia entre um ponto de origem A e um ponto de destino B pertencentes a uma malha.
  1. O calulo da rota de menor custo é realizado apenas se e somente se o ponto de origem e o ponto de destino pertencem a mesma malha.



