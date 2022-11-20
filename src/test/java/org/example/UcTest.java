package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UcTest {
    Uc u;

    @BeforeEach
    public void setup() {
        u = new Uc("QA", 26);
        u.insereNota(1, 17);
        u.insereNota(-1, -1);
        u.insereNota(2012, 20);
        u.insereNota(14, 2);
        u.insereNota(2011, 20);
        u.insereNota(13, 13);
        u.insereNota(2330, 20);
    }


    @ParameterizedTest
    @DisplayName("Deve criar uma nota")
    @CsvSource(textBlock = """
            43563,50
            4221,20
            12441,-90
            3521,-10
            """)
    void shouldTestInsereNota(int aluno, int nota) {
        boolean added = u.insereNota(aluno, nota);
        if (aluno < 0 || nota < 0)
            assertFalse(added);
        else if (nota > 20)
            assertFalse(added);
        else
            assertTrue(added);
    }

    @ParameterizedTest
    @DisplayName("Deve verificar os limites das notas")
    @CsvSource(textBlock = """
            43563,50
            4221,56
            12441,-90
            3521,-10
            """)
    void shouldTestInsereNotaLimits(int aluno, int nota) {
        u.insereNota(aluno, nota);
        int i = 0;
        for (Nota n : u.getNotas()) {
            if (n != null) {
                i++;
                assertTrue(n.getNota() >= 0 && n.getNota() <= 20);
            }
        }
        assertNotEquals(0, i);
    }

    @ParameterizedTest
    @DisplayName("Deve verificar se a nota foi realmente adicionada")
    @CsvSource(textBlock = """
            43563,9
            4221,20
            1244,10
            3521,0
            """)
    void shouldTestInsereNotaSize(int aluno, double nota) {
        int k = 0;
        for (Nota n : u.getNotas()) {
            if (n != null)
                k++;
        }
        u.insereNota(aluno, nota);
        int i = 0;
        for (Nota n : u.getNotas()) {
            if (n != null)
                i++;
        }
        assertEquals(k+1, i);
    }

    @ParameterizedTest
    @DisplayName("Deve pesquisar a nota do aluno se encontrar devolve a nota se não devolve -1")
    @ValueSource(ints = {-1, 2012, 14, 13, 2330, 2011, 1})
    void testPesquisaAluno(int al) {
        double nota = u.pesquisaAluno(al);
        if (al < 0) {
            assertEquals(-1.0, nota);
        } else if (nota < 0) {
            assertEquals(-1.0, nota);
        } else {
            assertTrue(nota >= 0 && nota <= 20);
        }
    }
    @Test
    @DisplayName("Deve testar se o valor da media está dentro dos limites possiveis(entre 0 e 20)")
    void testMediaBounds() {
        double media = u.media();
        assertNotEquals(null, media);
        assertTrue(media >= 0 && media <= 20);
    }

    @Test
    @DisplayName("Deve testar o valor da média com os valores já pré inseridos")
    void testMediavalue() {
        double media = u.media();
        System.out.println(media);
        assertEquals(15.33, media);
    }

    @ParameterizedTest
    @DisplayName("Deve testar as notas que foram reprovadas")
    @ValueSource(ints = { 2012, 13, 2330, 2011, 1})
    void testAprovado(int aluno) {
        boolean isAproved = u.aprovado(aluno);
        assertTrue(isAproved);
    }
    @ParameterizedTest
    @DisplayName("Deve testar as notas que foram reprovadas")
    @ValueSource(ints = {-1,14})
    void testAprovadoFalse(int aluno) {
        boolean isAproved = u.aprovado(aluno);
        assertFalse(isAproved);
    }
}