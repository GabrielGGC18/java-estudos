## ATIVIDADE DE JAVA DE ONDE PARAMOS CONTEXTO JAVA-MENTOR
Montaria aprovado. Próximo: Peao.java.                                                                                                                                                          
                                                                                                                                                                                                  
  Conceitos novos:                                                                                                                                                                                
  1. Composição: Peao TEM Montaria[] (atributo private Montaria[] montarias)                                                                                                                      
  2. Sobrecarga: mesmo nome, params diferentes — exibirInfo() e exibirInfo(boolean resumido)                                                                                                      
  3. this(...): construtor chama outro construtor (primeira linha)                                                                                                                                
  4. Init array: this.montarias = new Montaria[5];                                                                                                                                                
  5. toString() / equals(): sobrescrever Object com @Override                                                                                                                                     
                                                                                                                                                                                                  
  Esqueleto peao/Peao.java:                                                                                                                                                                       
                                                                                                                                                                                                
  public class Peao {                                                                                                                                                                             
      // atributos privados: nome, apelido, categoria, montarias[]                                                                                                                                
                                                                                                                                                                                                
      // construtor default — inicializa new Montaria[5]                                                                                                                                          
      // construtor (nome, apelido, categoria, montarias[])                                                                                                                                     
                                                                                                                                                                                                  
      // getters/setters                                                                                                                                                                        
                                                                                                                                                                                                  
      // exibirInfo()                  → tudo
      // exibirInfo(boolean resumido)  → resumido=true só nome+apelido                                                                                                                            
                                                                                                                                                                                                
      // @Override toString()                                                                                                                                                                     
      // @Override equals(Object o)    → igual se nome+apelido iguais
  }                                                                                                                                                                                               
      49          this.modalidade = modalidade;
      50 -    }m    public void exibirInfo(){                                                                                                                                              
      50 +    }                                                                                                                                                                            
      51 +                                                                                                                                                                                 
      52 +    public void exibirInfo(){                                                                                                                                                    
      53          System.out.println("Animal: " + nomeAnimal);
      54          System.out.println("Peso: "+ peso);
      55          System.out.println("Nivel Braveza: "+nivelBraveza);

● Bash(cd /home/gabriel/java-estudos/peao && javac Modalidade.java Categoria.java Montaria.java 2>&1)
  ⎿  Error: Exit code 127
     /bin/bash: line 1: javac: command not found
    
● javac não instalado aqui. Mas código tá ok agora visualmente. Próximo passo: classe Peao.

● java-mentor(Next step Peao class)
  ⎿  Done (0 tool uses · 12.1k tokens · 22s)
  (ctrl+o to expand)

● Montaria aprovado. Próximo: Peao.java.

  Conceitos novos:
  1. Composição: Peao TEM Montaria[] (atributo private Montaria[] montarias)
  2. Sobrecarga: mesmo nome, params diferentes — exibirInfo() e exibirInfo(boolean resumido)
  3. this(...): construtor chama outro construtor (primeira linha)
  4. Init array: this.montarias = new Montaria[5];
  5. toString() / equals(): sobrescrever Object com @Override

  Esqueleto peao/Peao.java:
  public class Peao {
      // atributos privados: nome, apelido, categoria, montarias[]

      // construtor default — inicializa new Montaria[5]
      // construtor (nome, apelido, categoria) — usa this(...)
      // construtor (nome, apelido, categoria, montarias[])

      // getters/setters

      // exibirInfo()                  → tudo
      // exibirInfo(boolean resumido)  → resumido=true só nome+apelido

      // @Override toString()
      // @Override equals(Object o)    → igual se nome+apelido iguais
  }

  Dicas:
  - exibirInfo() percorrendo montarias[]: trate null (posições vazias).
  - equals: começa com if (this == o) return true; e if (!(o instanceof Peao)) return false;.

  Manda 1ª versão.