; (javVoo codigo-do-voo voo-233)

(defrule indentifica-voo
    (janVoo codigo-do-voo ?cdv)
    (object
        (is-a Voo) 
        (codigo ?cdv) ;imposicao
        (data ?vData) ;rec
        (duracao ?vDur) ;rec
        (origem ?vOrigem) ;rec
        (destino ?vDestino) ;rec
    )
    (object
        (is-a Aeronave) 
        (codigo ?adv) ;imposicao
        (modelo ?aModelo) ;rec
        (horas-voo ?aDur) ;rec
        (total-assentos ?aAcentos) ;rec
        (posicao ?aPos) ;rec
        (alocado-para ?cdv)
    )
    (object
        (is-a Reserva) 
        (data ?rData) ;rel        
        (validado-para ?cdv) ;rel
        (efetuado-para ?nPass)
    )
=>
(assert (voo ?cdv data ?vData duracao ?vDur origem ?vOrigem destino ?vDestino cod-aeronave ?adv nome-passageiro ?nPass)))

(defrule imprime-voo
    (voo ?cdv data ?vData duracao ?vDur origem ?vOrigem ?destino ?vDestino)
=>
    (printout t "voo " ?cdv " data " ?vData " duracao: " ?vDur " origem: " ?vOrigem " destino " ?vDestino)
)

(defrule indentifica-aeronave
    (cod-aeronave ?adv voo ?cdv)
    (object
        (is-a Aeronave) 
        (codigo ?adv) ;imposicao
        (modelo ?aModelo) ;rec
        (horas-voo ?aDur) ;rec
        (total-assentos ?aAcentos) ;rec
        (posicao ?aPos) ;rec
        (alocado-para ?cdv)
    )
=>
(assert (aeronave ?adv modelo ?aModelo horas-voo ?aDur total-assentos ?aAcentos posicao ?aPos)))

(defrule indentifica-passageiro
    (janVoo codigo-do-voo ?cdv nome-passageiro ?nPass )
    (object
        (is-a Passageiro) 
        (nome ?nPass) ;imposicao
        (endereco ?pEnd) ;rec
        (fone ?pFone) ;rec
        (horas-voo ?pHrs) ;rec
    )
=>
(assert (passageiro ?nPass endereco ?pEnd fone ?pFone horas-voo ?pHrs)))

(defrule imprime-passageiro
    (passageiro ?nPass endereco ?pEnd fone ?pFone horas-voo ?pHrs)
=>
    (printout t "Passageiro: " ?nPass ?pEnd ?pFone ?pHrs)
)

(defrule imprime-aeronave
    (aeronave ?adv modelo ?aModelo horas-voo ?aDur total-assentos ?aAcentos posicao ?aPos)
=>
    (printout t "Aeronave: " ?adv ?aModelo ?aDur ?aAcentos ?aPos)
)