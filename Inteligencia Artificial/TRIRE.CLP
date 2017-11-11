;;;+++++++++++++++++++*
;;;  Modelo do Domínio
;;;+++++++++++++++++++*

(defclass Figura
   	(is-a USER)  
	(role abstract) 
   	(slot id (create-accessor write))
)

(defclass Triangulo 
	(is-a  Figura)
   	(role abstract) 
   	(slot a (default 0) (create-accessor write))
   	(slot b (default 0) (create-accessor write))
   	(slot c (default 0) (create-accessor write))
   	(slot alfa (default 0) (create-accessor write))
   	(slot beta (default 0) (create-accessor write))
   	(slot gama (default 0) (create-accessor write))
)

(defclass Trire 
   	(is-a Triangulo)   
	(role concrete)
	(pattern-match reactive)
   	(slot gama (default 90))
)

;;;++++++++* 
;;;  Regras 
;;;++++++++* 

(defrule r1
   ?obj <- (object 
   		(is-a Trire) 
   		(a ?a  &: (> ?a 0))
   		(b ?b  &: (> ?b 0)))
=>
(bind ?c (sqrt (+ (* ?a ?a) (* ?b ?b))))
(modify-instance ?obj (c ?c) )
)

(defrule r2
   ?obj <- (object 
   		(is-a Trire) 
   		(a ?a  &: (> ?a 0))
   		(alfa ?alfa  &: (> ?alfa 0)))
=>
(bind ?c (/ ?a (sin (/ (* 3.14 ?alfa) 180))))
(modify-instance ?obj (c ?c) )
)

(defrule r3
   ?obj <- (object 
   		(is-a Trire) 
   		(b ?b  &: (> ?b 0))
   		(alfa ?alfa  &: (> ?alfa 0)))
=>
(bind ?c (/ ?b (cos (/ (* 3.14 ?alfa) 180))))
(modify-instance ?obj (c ?c) )
)

(defrule r4
   ?obj <- (object 
   		(is-a Trire) 
   		(beta ?beta  &: (> ?beta 0)))
=>
(bind ?alfa (- 90 ?beta))
(modify-instance ?obj (alfa ?alfa) ) 
)

;;;++++++++++++++++++++*
;;;  Instâncias (dados)
;;;++++++++++++++++++++*

(definstances instanciasTrire 
   (t1 of Trire 
	(id t1)
   	(a 50)
   	(b 50) )
   (t2 of Trire 
   	(id t2)
   	(a 30)
   	(beta 30) )
   (t3 of Trire 
   	(id t3)
   	(b 30)
   	(beta 30) )
   (t4 of Trire 
   	(id t4)
   	(a 30)
   	(alfa 30) )
   (t5 of Trire 
   	(id t5)
   	(b 30)
   	(beta 70) )
   (t6 of Trire 
   	(id t6)
   	(a 20)
   	(b 30) )
)


 









