#### Conversões 

4Kb = 2^12
4M = 2^22
2048 = 2^11
4 bytes = 2
1 byte = 1 bits

#### Memória cache

Blocos de Memória principal = Tamanho da memória principal / Numero de blocos


 TAG | LINHA | PALAVRA 
------------ | ------------- | -------------
| Tamanho da Memória Principal - Tamanho da Linha - Tamanho da palavra | Tamanho da memória cache / Tamanho do Bloco | Bloco de palavra |

#### Memória Cache - Mapeamento associativo

Memória principal = Conjunto de linhas * Numero de linhas + Blocos
Linhas de cache = Tamanho da memória / Numero de linhas

 TAG | SET | PALAVRA 
------------ | ------------- | -------------
| Tamanho da Memória Principal - Set | Numero de linhas / Numero de conjuntos de linha | Bloco de palavra |


#### Cache

Os circuitos eletrônicos, junto com a memória e dispositivos de
entrada/saída, formam o hardware do computador.
O software consiste em algoritmos e suas representações no
computador – isto é, programas.

CS (Segmento de Código): contém o endereço da área com as
instruções de máquina em execução.
– DS (Segmento de Dados): contém o endereço da área com os
dados do programa. Geralmente aponta para as variáveis globais
do programa.
– SS (Segmento de Pilha): contém o endereço da área com a pilha.
Que armazena informações importantes sobre o estado da
máquina, variáveis locais, endereços de retorno e parâmetros de
subrotinas.
– ES (Segmento Extra): utilizado para ganhar acesso a alguma área
da memória quando não é possível usar os outros registradores de
segmento

Barramento de dados – como o próprio nome já deixa a entender, é por este tipo de barramento que ocorre as trocas de dados no computador, tanto enviados quanto recebidos.
Barramento de endereços – indica o local onde os processos devem ser extraídos e para onde devem ser enviados após o processamento.
Barramento de controle – actua como um regulador das outras funções, podendo limitá-las ou expandi-las em razão de sua demanda.

Quando a CPU precisa buscar uma informação na memória, ela busca primeiro pela cache. Se não
encontrado, busca-se na Memória Principal, então devolve a informação para a CPU e armazena
esta informação na cache.

Cache miss = falha de cache (endereço desejado é
carregado no barramento e os dados são transferidos
através do Buffer de Dados para o Cache + CPU
Pode causar Thrashing (referências contínua a blocos de uma mesma linha)

Unidade aritmetica e logica: Operacoes logicas e aritmeticas
Registrador de instrucao IR: O que esta sendo executado no momento

### Assembler

##### Montador Assembler
● A primeira tarefa do Assembler é montar uma tabela de
símbolos.
● Rótulos representam endereços cujos valores não são
imediatamente óbvios.
● Para calcular seus valores, o Assembler percorre o
programa linha por linha, operação denominada primeira
passagem.
● No início da segunda passagem, o valor numérico de cada
símbolo é conhecido.

##### Arquitetura de Von Neumann
– Dados e instruções são armazenados em uma única
memoria de leitura e escrita
– O conteúdo dessa memória é endereçável por local, sem
considerar o tipo de dado neles contido
– A execução ocorre em um padrão sequencial (a menos que
modificado explicitamente) de uma instrução para a
seguinte

##### Ciclo de Busca
Contador de Programa (PC) mantém endereço da próxima
instrução a buscar.
● Processador busca instrução do local de memória
apontado pelo PC.
●Instrução carregada no Registrador de Instrução (IR).
● Processador interpreta instrução e realiza ações exigidas

##### Ciclo de Execução
Processador-memória:
– Transferência de dados entre CPU e memória principal.
● E/S do processador:
– Transferência de dados entre CPU e módulo de E/S.
● Processamento de dados:
– Alguma operação aritmética ou lógica sobre dados.
● Controle:
– Alteração da sequência de operações.
– Ex: salto.
● Combinação dos itens anteriores

4 primeiros bits determinam a instrução (IR) e o
operando contém o endereço do dado.
3 instruções => 3 ciclos de busca()

##### Interrupção
● Mecanismo pelo qual outros módulos (ex. E/S) podem interromper
a sequência de processamento normal.
● Programa:
– Ex: estouro, divisão por zero.
● Timer:
– Gerado por timer dentro do processo.
– Usado na multitarefa preemptiva.
● E/S:
– Do controlador de E/S.
● Falha de hardware:
– Ex: erro de paridade de memória.

##### Instruções
Instrução JMP: realiza o desvio incondicional no fuxo de execução do
programa.
● Sintaxe: JMP Dest
– Dest: próxima instrução a ser executada.
Instruções J??: realizam desvios condicionais no fuxo de execução do
programa de acordo com os bits de fag.
JZ(pula se é 0)
JA(pula se maior que)

LOOP: realiza desvios p. consrtucao de lacos de repeticao(iteracao)

