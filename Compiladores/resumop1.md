### Compilers x Interpreters

#### Interpreter
Program and data -> [I] -> Output
Não processe antes de executar, vc invoca o programa e o dado
e o programa imediatamente está correndo.
"Online"
"Em tempo de execucao pois nao foi pre compilador"

#### Compiler

Program -> [C] -> Executavel
Este executavel é outro programa, pode sem um assemblem pode ser bytecode
E esse programa roda com os dados e produz um output
Data -> Executavel -> Out put
"Offline"
Nós pre processamos o programa antes
entao podemos rodar o executavel para qualquer tipo de dado sem precisar reprocessa-lo.

#### Partes do Compilador

Um compilador é composto por varias partes
1. Analise Léxica
2. Parse
3. Analise Semantica
4. Otimizacao
5. Geracao de codigo

A analise lexica e parse lidam como todos os aspectos **sintaticos** da linguagem
Traduz o arquivo fonte em lexemas e tokens

var cachorros = 10

##### var

Expressão regular p/ chegar em VAR
(1)-> v -> (2)-> a -> (3)-> r -> (4)

var cachorros = 10
    id          id

##### [a-z][a-z0-9]*

Expressao regular p/ ID

               -> 0-9 ->
(1)-> a-z ->(2)-> a-z ->(2)

A analise sintatica verifica se uma sentança faz parte da gramatica da linguagem
Recebe lexames e tokens gerados pelo analisador léxico

```
int x = 10, k = 10
int x = y++k
```
A construção é valida?

### Grámatica

S -> S ; S
- Terminais: id print, x ; : = ()
S -> id := E
- Nao terminais(S E L)
S -> print (L)
Sinbolo inicial: S
E -> id
E -> num
- Notacao de producoes
E -> E + E
- a cadeira seguinte pertence a gramatica?
L -> E
- a := 7
L -> L, E
- := c + (c := 5 + 6, d)

a := 7;
b := c + (d := 5 + 6, d)

S
S ; S
S ; id := E
id := num ; id := E
id := num ; id := E + E
id := num ; id := E + (S, E)
id := num ; id := id + (S, E)
id := num ; id := id + (id := E, E)
id := num ; id := id + (id := E + E, E)
id := num ; id := id + (id := E + E, id)
id := num ; id := id + (id := num + E, id)
id := num ; id := id + (id := num + num, id)

Gramatica "Parse tree"

### Parser - LL
- **Left-to-right**: Direção na qual os simbolos serao examinados
- **Leftmost-derivation**: ordem pela qual os simbolos nao-terminais serao expandidos
- **1-symbol lookahead**: nao mais que um simbolo avaliado por vez

#### Recursao a esquerda
E -> E + T
E -> T

Nesse caso o E parecer no inicio do lado direito pode causar problemas.
Para refatorar o correto é a **Recursao a direita**

E -> T E'
E' -> + T E' | Ɛ

### Parse - LR(K)
 - Left-to-right, rightmost-derivation, 1-symbol lookahead
- Usa uma pilha p armazenar simbolos temporarios
- possui *carrega* e *reduz* que move os simbolos pro topo ou escolhe uma regra q coloca na pilha.



A analise semantica lida com aspectos semanticos, como tipos, escopo etc

Otimizacao é uma coleção de transformações que otimizam o codigo, fazendo ele por exemplo, rodar mais rapido ou gastar menos memoria.
Enquanto a geracao de codigo é realmente a tradução para outra linguagem.
Que pode ser pra machine code, bytecode p/ uma marquina virtual ou ate pra outra linguagem de programacao(exemplos)

### Passo a passo
Prog front -> Compilador -> Programa Obj
Prog Fonte -> Pre Processador -> Codigo pre processado -> compilador -> codigo em lig. intermediaria -> montador assemblem -> cod de maquina -> linker(biblioteca estatica/dinamica e executavel)

### Compilador tranaduz o codigo fonte pre processado em programa em linguagem intermediaria(em linguagem de montagem) "assemble"


