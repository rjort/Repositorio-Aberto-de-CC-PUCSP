;sistema computacional
; a) qual o nome e email do prof que chefia um determinado departamento e leciona uma determinada disciplina?
; b) qual nome, numero de metricula, telefone e email de todos os alunos que cursam uma determinada disciplina?


; DOMINIO
;
;| PROF |                       | DEPARTAMENTO |
;| nome |1-----Chefia-----0..1|>| nome         |
;| cel  |
;| email|
;   |
;   |                           | ALUNO    |
;| DISCIPLINA |                 | nome     |
;| nome       |1..*---Cursa----*| matricula|
;                               | fone     |
;                               | email    |

(defrule r-chefiaDpto-LecionaDisc
  (dadoGUI dpto ?nDpto disciplina ?nDisc)
  (object
    (is-a Dpto) ; percorrimento
    (nome ?nDpto) ; imposicao
    (chefiado-por ?prof) ;rel
  )
  (object
    (is-a Disciplina) ; percorrimento
    (nome ?nDisc) ; imposicao
    (lecionado-por ?prof) ;rel
  )
  (object
    (instance-of Professor) ;percorrimento
    (nome ?prof)
    (cel ?cProf) ;recuperacao
    (email ?eProf) ;recuperacao
  )
)
=>
(assert (professor ?nProf email ?email dpto ?nDpto disciplina ?nDisc))

(defrule print-chefiaDpto-lecionaDisc
  (professor ?nProf email ?email dpto?nDpto disciplina ?nDisc)
=>
  (printout t "Professor " ?nProf " com email " ?email " chefia " ?nDpto " e leciona" ?nDisc t)
         )

(defrule r-cursaDisc
  (dadoGUI disc ?nDisc)
  (object
    (is-a Disciplina)
    (nome ?nDisc)
    (cursado-por ?nAluno)
  )
  (object
    (is-a Aluno)
    (nome ?nAluno)
    (matricula ?matricula)
    (fone ?aPhone)
    (email ?aEmail)
    (cursa ?nDisc)
  )
)
=>
(assert (aluno ?nAluno email ?aEmail fone ?aPhone matricula ?matricula))

(defrule print-alunoDisciplina
  (aluno ?nAluno email ?aEmail fone ?aPhone matricula ?matricula)
=>
(print t "Aluno " ?nAluno " do email " ?aEmail " fone " ?aPhone " da matricula " ?matricula " cursa " ?nDisc t)
)
