#### 1 - Mapeamento direto
Cache de 16kbytes (2^14)
Blocos de 4 palavras (2^2)
Endereço de 32 bits

##### a) index
2^14 / 2^2 = 2^12 = 12
##### b) tag
32 - 12 -2 = 18

#### 2 -
256mb(2^28)
2048 posições de cache(2^11)
8 palavras(2^3)

TAG: 28 - 11 - 3 = 14
LINHAS: 11
PALAVRAS: 3

#### 3 - Associativo p/ conjunto
64 linhas
Conj. de 4 linhas(2^2)
MP 4kb
Blocos de 128 palavras(2^7)

Tamanho da Memória principal : 2^12 + 2^7 = 2^19

TAG= 8
INDEX = 4
WORDS = 7

#### 4 -
32mb de ram(2^25)
cache de 16kb(2^14)
blocos de 4bytes(2^21)

a) 2^25/2^2 = 2^23

b) 2^14 / 2^2 = 2^12 = 4k linhas

c)
TAG= 11
Index = 12
Word = 2
25 bits