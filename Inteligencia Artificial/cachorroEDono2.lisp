(defclass Pessoa
  (is-a USER)
  (role concrete)
  (pattern-match reactive)
  (slot nome (create-accessor write))
  (slot fone screate-accessor write))
  (slot e-mail (create-accessor write))
  (slot estadoCivil (create-accessor write))
)

(defclass Animal
  (is-a USER)
  (role abstract)
  (slot name (create-accessor write))
  (slot raca (create-accessor write))
  (slot tem-como-proprietario (create-accessor write) (type INSTANCE-NAME))
)

(defclass Gato
  (is-a AnimalDomestico)
  (role concrete)
  (slot intMiado (create-accessor write))
)

(defclass Cachorro
  (is-a AnimalDomestico)
  (role concrete)
  (pattern-match reactive)
  (slot intLatido (create-accessor write))
)

(definstances caos
  (piti of Cachorro)
    (nome Piti)
    (raca dalmata)
    (intLatido forte)
    (tem-como-proprietario [pess1])
  (piti of Cachorro)
    (nome Sheik)
    (raca dalmata)
    (intLatido forte)
    (tem-como-proprietario [pess2])
  (piti of Cachorro)
    (nome Rub)
    (raca dalmata)
    (intLatido fraco)
    (tem-como-proprietario [pess3])
)


(definstances pessoas 
  (pess1 of Pessoa)
    (nome "Manoel")
    (estadoCivil casado)
    (fone "5555-5555")
    (email "1@pess.com")
  (pess2 of Pessoa)
    (nome "Francisco")
    (estadoCivil casado)
    (fone "4444-4444")
    (email "2@pess.com")
  (pess3 of Pessoa)
    (nome "Maria")
    (fone "3333-3333")
    (estadoCivil casado)
    (email "3@pess.com")
)

(defrule r-idProprietarioCao
  (dadosIU dadosPessoa estCivil ?ec dadosCao raca ?raca intLatido ?iL)
  (object
    (is-a Pessoa)
    (name ?name)
    (estadoCivil ?ec) ;imposição
    (nome ?nome)      ; recuperação
    (fone ?fone)      ; recuperacao
    (email ?email) )  ; recuperacao
  (object
    (is-a Cachorro)
    (raca ?raca)      ; imposicao
    (intLatido forte) ; imposição
    (tem-como-proprietario ?name)
)
=>
(assert (pessoa nome ?nome fone ?fone email ?email)) )

(defrule r-imprime
  (pessoa nome ?nome fone ?fone email ?email)
=>
  (printout t "Pessoa casada proprietaria de dalmata que late forte: " ?nome " " ?fone " " ?email t) )

deffacts dados
  (dadosIU dadosPessoa estCivil casado dadosCao raca dalmata intLatido forte)
