; especifique regras de producao p/ listar nome tel e email de pessoas casadas que tem cachorros dalmatas que latem alto
;considere um dominio composto por pessoas com animais domesticos como gatos ou cachorros
;
;
;| PESSOAS |                   | ANIMALDOM |
;| nome    |                   | Nome      |
;| fone    | --Proprietario de | Raca      |
;| estCivil|                        /\
;| email   |                   _____||_____
;                              |           |
;                         | GATO  |    | CACHORRO |
;                                      | intLatido|

; regras gerais e passiveis de encadeamento

(define-class Pessoal nil
  (nome)
  (fone)
  (e-mail)
  (estadoCivil)
)

(define-class AnimalDomestico nil
  (nome)
  (raca)
  (tem-como-proprietario)
)

(define-class Gato AnimalDomestico (intMiado))

(define-class Cachorro AnimalDomestico (intLatido))

(define-instance pete Cachorro
  (raca dalmata)
  (latido forte))

(define-instance pessoa1 Pessoa (nome "Ana") (proprietario pete))

(define-rule r-idDonoCao
  (dadosDeEntrada cachorro raca ?raca intLatido ?iLat pessoa estadoCivil ?ec) ;pact-pattern
  (object
    (instance-of Cachorro)
    (raca ?raca)
    (intLatido ?iLat)
    (tem-como-proprietario ?obj-pessoa)
  )
  (object ?obj-pessoa
    (instance-of Pessoa)
    (estadoCivil ?ec)
    (nome ?nome)
    (fone ?fone)
    (email ?email)
  )
=>
(printout t "Pessoa proprietaria de cachorro " ?raca " que late " ?iLat ": " ?nome " " ?fone " " ?email t))
