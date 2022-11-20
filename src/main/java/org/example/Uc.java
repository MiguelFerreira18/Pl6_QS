package org.example;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

/*

A classe UC com as seguintes variáveis de instância:
• String nomeUC // nome da unidade curricular
• Nota [] notas // array com as notas de cada aluno (pode ser um ArrayList)
• int totalAlunos // nº máximo de alunos na UC

 */
/*
E os seguintes métodos:
    • insereNotaUC(int numAluno, double nota)
    • pesquisaAluno (int numAluno) – pesquisa e devolve a nota de um dado aluno,
        ou -1 se o aluno não existe nessa UC
    • media () – devolve a nota média da UC
    • aprovado(int numAluno) – verifica se um dado aluno teve aprovação na UC
(nota >=9.5), devolvendo true em caso afirmativo e false se reprovou

 */
public class Uc {
    private String nomeUc;
    private Nota[] notas;
    private int totalAlunos;

    public Uc(String nomeUc, int totalAlunos) {
        this.nomeUc = nomeUc;
        this.notas = new Nota[totalAlunos];
        this.totalAlunos = totalAlunos;

    }

    /**
     * Insere uma nota na Uc DE UM DADO ALUNO
     * @param numAluno NUMERO DO ALUNO
     * @param nota nota o aluno
     * @return retorna verdadeiro se tiver sido adicionado e falso se não tiver sido adicionado
     */
    public boolean insereNota(int numAluno, double nota) {
        if (numAluno < 0 || nota < 0)
            return false;
        if (nota > 20)
            return false;
        Nota novaNota = new Nota(numAluno, nota);
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == null) {
                notas[i] = novaNota;
                System.out.println(Arrays.toString(notas));
                return true;
            }
        }
        return false;
    }//end insere notas

    /**
     * Metodo para pesquisa um aluno dado um numero do aluno
     * @param numALuno numero do aluno a procurar
     * @return retorna a nota do aluno a procurar se não encontrou o aluno devolve -1.0
     */
    public double pesquisaAluno(int numALuno) {
        for (Nota n : notas) {
            if (n != null && n.getNumALuno() == numALuno) {
                return n.getNota();
            }

        }
        return -1;
    }

    /**
     * calcula a media da turma na uc
     * @return
     */
    public double media() {
        double total = 0;
        int alunos = 0;
        for (Nota n : notas) {
            if (n != null) {
                alunos++;
                total += n.getNota();
            }
        }
        total /= alunos;
        return round(total, 2);
    }

    /**
     * Metodo de Baeldung
     * @param val
     * @param cases
     * @return
     */
    public double round(double val, int cases) {
        if(cases<0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(val));
        bd = bd.setScale(cases, RoundingMode.HALF_UP);
        return bd.doubleValue();

    }

    /**
     * metodo verifica se um aluno foi aproado ou não
     * @param aluno numero do aluno
     * @return retorna verdadeiro se foi aprovado e falso se reprovou
     */
    public boolean aprovado(int aluno) {
        for (Nota nota : notas) {
            if (nota != null && nota.getNumALuno() == aluno) {
                return nota.getNota() >= 9.5;
            }
        }
        System.out.println("ALuno reprovou");
        return false;
    }

    public Nota[] getNotas() {
        return notas;
    }
}
