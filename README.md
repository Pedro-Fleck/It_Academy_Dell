Descrição: 
Este projeto implementa um sistema de torneio de Startups onde podem participar 4, 6 e até no máximo 8 Startups, onde elas competem em batalhas com rodadas eliminiatórias.
As stratups vao acumulando pontos durante as batalhas até chegar na batalha final, onde somente duas podem participar e somente uma é sagrada campeã.

Funcionalidades:
Cadastro de Startups (nome, slogan e ano de fundação);
Sorteio e organização de batalhas automático;
Aplicação de eventos que afetam os pontos das Startups;
Sistema de rodadas para sobrar somente uma Startup;
Relatorio Final com a Startup vencedora e seu slogan;

Classes Principais:

Tournament:
Gerencia o Torneio, com o cadastro das Startups e a organização das Batalhas;
Métodos Principais:
begginTournament() //inicia o torneio;
drawBattles()//Sorteia as batalhas entre Startups;
nextRound() //Avança para a proxima rodada;
showReport() //Exibe um relatório final sobre a Startup campeã;

Startup:
Representa uma startup participante do torneio;
Recebe atributos private: name, slogan e yearFoundation;
Métodos Principais:
receivedEvents(Event event) //Aplica um evento á uma Startup;
resetEventsRound() //Reseta os eventos para proxima rodada;

Batlle:
Gerencia uma batalha entre duas Startups;
Métodos Principais:
adminBattle(Scanner scanner) //Adiministra a batalha;
getWinner() //Determina o vencedor até mesmo em caso de empate;

Event:
Enumeração dos eventos que podem acontecer em uma batalha;
Cada evento recebe uma descrição e um modificador de pontos;

Main:
Classe Principal que inicia o programa e interage com o usuario que controla as ações;

Requisitos:
Java JDK 8 ou superior.

Exemplo de Uso:
Ao executar o programa, insira o número de startups (4, 6 ou 8);
Cadastre cada startup com nome, slogan e ano de fundação.
O torneio começará automaticamente, e você poderá aplicar eventos às startups durante as batalhas;
Após cada rodada, as vencedoras avançam para a próxima fase;
O programa exibirá um relatório final com a startup campeã;

Observações:
Certifique-se de inserir valores válidos durante o cadastro (por exemplo, ano de fundação entre 1000 e 2026);
O número de startups deve ser par, entre 4 e 8;









