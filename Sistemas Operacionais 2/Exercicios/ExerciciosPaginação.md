Exercicios SO2

Prof. Carlos Paes

#### Questao 1 - 
Substituição Ideal - Perfeito
LRU - Bom
Second Chance - Mais ou menos
FIFO - Ruim

FIFO sofre do algoritmo de Belady, ou seja número de page faults não diminui com o aumento de frames.

#### Questao 2 - 
##### a)  1 / 2 / 3 / 1 / 4 / 2 / 5 / 3 / 4 / 3 

FIFO - 2 Page faults
                            PF          PF
  1     2     3    1     4      2    5     3     4     3
| 1 | | 1 | | 1 | | 1 | | 4 | | 4 | | 4 | | 4 | | 4 | | 4 | 
| # | | 2 | | 2 | | 2 | | 2 | | 2 | | 5 | | 5 | | 5 | | 5 | 
| # | | # | | 3 | | 3 | | 3 | | 3 | | 3 | | 3 | | 3 | | 3 | 


LRU - 5 Page faults

                            PF    PF  PF  PF  PF  
  1     2     3    1     4      2    5     3     4     3
| 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | 
| # | | 2 | | 2 | | 2 | | 4 | | 4 | | 5 | | 3 | | 3 | | 3 | 
| # | | # | | 3 | | 3 | | 3 | | 2 | | 2 | | 2 | | 4 | | 4 | 

b) 1 / 2 / 3 / 1 / 4 / 1 / 3 / 2 / 3 / 3

FIFO - 4 Page Faults
                             PF  PF         PF   PF
  1     2     3    1     4     1     3     2     3     3
| 1 | | 1 | | 1 | | 1 | | 4 | | 4 | | 4 | | 4 | | 3 | | 3 | 
| # | | 2 | | 2 | | 2 | | 2 | | 1 | | 1 | | 1 | | 1 | | 1 | 
| # | | # | | 3 | | 3 | | 3 | | 3 | | 3 | | 2 | | 2 | | 2 | 

LRU - 2 Page Faults
                             PF                PF
  1     2     3    1     4     1     3     2     3     3
| 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | 
| # | | 2 | | 2 | | 2 | | 4 | | 4 | | 4 | | 2 | | 2 | | 2 | 
| # | | # | | 3 | | 3 | | 3 | | 3 | | 3 | | 3 | | 3 | | 3 | 

#### Questão 3 -
A página do frame 4 pois foi a primeira a ser carregada.
A página do frame 4 pois é a mais antiga e tem bit de referência zerado.
A pagina do frame 0 ou 5 pois ambas tem bits zerados de referência e modificação
 A pagina do frame 0, 4 ou 5 pelo bit de referencia


#### Questão 4 -
[0 0 1 0] 3
[1 0 1 0] 10
[1 1 0 0] 12
[0 0 0 1] 1

#### Questão 5-
                                                 PF
  4     7     0     7    1     0     1     2     1     2     7    1      2
| 4 | | 4 | | 4 | | 4 | | 4 | | 4 | | 4 | | 2 | | 2 | | 2 | | 2 | | 2 | | 2 | 
| # | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | | 7 | 
| # | | # | | 0 | | 0 | | 0 | | 0 | | 0 | | 0 | | 0 | | 0 | | 0 | | 0 | | 0 | 
| # | | # | | # | | # | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | | 1 | 

PILHA

[4, #, #, # ]
[4, 7, #, # ]
[4, 7, 0, # ]
[4, 0, 7, #]
[4, 0, 7, 1]
[4, 7, 1, 0]
[4, 7, 0, 1]
[7, 0, 1, 2]
[7, 0, 2, 1]
[7, 0, 1, 2]
[0, 1, 2, 7]
[0, 2, 7, 1]
[0, 7, 1, 2]


