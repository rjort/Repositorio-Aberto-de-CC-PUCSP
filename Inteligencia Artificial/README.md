# IA

## SBR
Conhecimento sobre um dominio de problemas que adquire senso comum por meio de experiencia de dominio
- Depende da existencia de uma Base de conhecimento

Metaconhecimento: Expressar de forma algoritmica na MI em um Sistema Baseado em Regras (SBR)

## Sistema baseado em conhecimento SBC
- Motor de inferencia usa base de dados armazenados na Memoria de trabalho(MT) p/ escolher e aplicar regras
- Motor de inferencia aplica regras de inferencia numa base de conhecimento(BC) pra realizar tarefas

- **Base de conhecimento:** Tem regras. Armazena de forma legivel e inspecionavel. A base de conhecimento é definida pelo usuário
- **Motor de inferecia:** Usa pattern matching e resolve conflitos e executa regras.
- **Memoria de trabalho:** Tem dados de fatos

- **Base de dados:** Info em nivel operacional, descreve e opera base em entidades individuais
- **Base de conhecimento:** Info em nivel abstrato, descreve operações com base em fatos, objetos individuais, colecao de dados e classes.


## Conhecimento procedural x declarativo

Procedural descreve como executar uma tarefa, implementada por linguagens como C. *"How to do"*

Declarativo descreve algo que vai resolver uma tarefa, implementada por linguagens com processamento simbolico como Lisp e Prolog. *"What i know"*


## Representação de fatos
triplas OAV, lista consistindo do nome de um *objeto*, o nome de um *atributo* específico do objeto e *valor* do atributo.

OAV caracteriza memória associativa

OAV | Desc | Exemplo
--- | --- | ---
Objeto | Entidade real ou conceitual | carro
Atributo | Propriedade/Caracteristica | cor
Valor | Medida de atributo | branca

```lisp
(organismo forma haste)         ; OAV
(buraco profundida 3000 metros) ; lista
```

Criação de fato:
```lisp
(asset (brasil presidente dilma))
```

```bash
(assert (brasil presidente dilma))

f-0 brasil presidente dilma
```

Remoção de fato:
```lisp
(retract 1)
```

## Regras de produção ou inferencia

Cada regra é: **SE < condições > ENTÃO < ações >**

Pseudocodigo:
```lisp
SE (ceu cor cinzenta) e (vendo velocidade ?v / (> ?v 30))
ENTAO (assert (tempo predicao "chuva"))
```
CLIPS:
```lisp
(defrule r3-farol
    (luzFarol estado acesa)
    (luzFarol alcance fraco)
=>
(printout t "carregue a bateria" t)
)
```

**Programação Baseada em Regras:** Programação que representa conhecimento relativo a um dominio de problemas de forma declarativa com regras independentes

## Pattern Matching

Controla uma sequencia de operações indentificando classificação de objetos. Compara cada condição de uma regra de produção comparando com os fatos e tornando verdadeiro um fato ou instancia comparado.

A resolução de conflutos funciona para caso há multiplas regras que podem ser executadas, nesse caso a prioridade é definida.
TLDR: Quando 1 regra tem fatos que batem com uma regra.

**MT**
```bash
f-11 (projInv retEstimado 34)
...
f-12 (projInv estado recente)
```

**BC**
```bash
(defrule r-projInvest
    (projInv estado novo | recente)
    (projInv retEstiamdo ?roi &: (> ?roi 30))
=>
    ; Match! Condições bateram com os fatos
)
```

## Agenda
Lista priotirizada e revisada a cada ciclo do MI de regras esperando para serem executadas.
Sempre que uma condição de uma regra faz "match" com um fato ou objeto do MT a regra se torna apta para execução e é ativada uma cópia da regra, chamada *ativação* e é colocada na agenda.
Se executada suas ações são executadas e conclusões atingidas

No clips a sequencia de operações é um fluxo implicito que não depende do programador. O MT a BC são lidados pelo MI, que aplica conhecimento aos dados e coloca na agenda.
- Agenda funciona como pilha, a regra no topo da agenda é selecionada e a ação é executada


Exemplo:
- 0 r1 f3 f5
- 0 r35 f6 f3
- 0 r16 f1 obj8 obj2

## Processamento de regras:

Fluxo:
- Reconhecimento: Match de condições de regras e dados
- Seleção: Resolução de conflitos(definição de prioridades)
- Ação: Execução da 1 regra da agenda
- Reconhecimento...etc

## CLIPS

Expert system capaz de modelar conhecimento com fatos(MT) e regras(BC)

Regra: Ações IF THEN com condições de fatos que devem ser verdadeiros

```lisp
(está chovendo)

(defrule weather
    (weather raining) ; CONDIÇÃO LHS
=>
    (assert (carry umbrela)) ; AÇÃO RHS
    (printout t "Leva o guarda chuva" t)
)
```

Syntax
```lisp
(+ 1 2 3)
(* 8 ( + 3 (- 2 3) 5))


(defrule weather
    (or (and tempHigh)(valveClosed) not (tempLow))
    (point ?x1 ?x2)
    (exists (a ?x1)(b ?x2))
=>)
```


Variáveis são o unico meio de ligação entre regras já que são independentes entre si.
Após a execução da regra a mesma variavel é religada em subsequentes pattern matchings.

```lisp
(defrule make-quack
    (duck-sound ?sound)
=>
    (printout t "Duck said " ?sound t)
)
```

#### Usando classes

Baseado em CLOS e Smalltalk. Tem SYSTEM CLASSES(USER, OBJECT, PRIMITIVE, ETC) que devem ser herdadas por classes CLIPS. 
Todos menos INITIAL OBJ são abstratos, significando que só podme ser usados p/ herança.

Heranças
```lisp
(defclass A (is-a USER)) ; USER já vem do lisp
(defclass Dog (is-a Animal)) ; herda de Animal
(defclass D (is-a A B C)) ; herança multipla

```

```lisp
(defclass <nome>
    (is-a <superclassname>)
    (<role>)
    (<slots>)*
=>)
```

**Defclass:** Construtor para especificar propriedades(slots) de uma classe
**Role:** Pode ser Abstract ou Concrete.
**Abstract x Concrete:** Abstract tem o intuito apenas de serem herdadas enquanto concrete class pode ter instancias
**patternMatch** Pode ser reativo ou não reativo. Objetivos de uma classe reativa dão match em object pattern de regras. Abstract não pode ser reativo.
**Slots**: Similar a propriedades. São placeholders de valores a serem associados quando o usuário define e instancia

#### Definindo instancias
```lisp 
(defclass Animal
  (is-a USER)
  (role abstract)
  (slot name (create-accessor write))
  (slot raca (create-accessor write))
  (slot tem-como-proprietario (create-accessor write))
)

(definstance
    (object
      (piti of Cachorro)
      (nome Piti)
      (raca dalmata)
      (intLatido forte)
      (tem-como-proprietario [pess1])
    )
)
```

#### Regras lidando com instancias

**Imposição:** Chave para achar dado
**Recuperação:** Dados do objeto sendo recuperados
**Relação:** Chave para ligação com outros dominios

```lisp
(defrule r-idProprietarioCao
  (dadosIU dadosPessoa name ?nome dadosCao raca ?raca intLatido ?iL)
  (object
    (is-a Pessoa)
    (nome ?name)      ; imposição
    (email ?email) )  ; recuperacao
  (object
    (is-a Cachorro)
    (raca ?raca)      ; imposicao
    (intLatido forte) ; imposição
    (idade ?age)      ; recuperação
    (tem-como-proprietario ?name) ;relação
)
=>
(assert (pessoa nome ?nome fone ?fone email ?email)) )
```

