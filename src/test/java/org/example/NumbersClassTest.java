package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

     /*
    Cria uma class na pasta main do teu projeto e implementa os seguintes
métodos:
a. isPrime(int number) que verifica se um número é primo. Um número é
primo se for apenas divisível por si próprio e pela unidade, por exemplo:
11 é número primo (visto que é apenas divisível por 11 e por 1),
enquanto 21 não é primo, pois tem os seguintes divisores: 1, 3, 7 e 21.
b. isEven(int number) que verifica se um número é par
c. isMultiple (int number, int divisor) que verifica se um número é
múltiplo de outro

2. Cria a class de teste correspondente.
        a. Utilizando testes com parâmetros, implementa os métodos de teste que
            permita testar vários valores.
        i. Números primos: 3, 23, 311, 487, 653, 947
        ii. Número pares: 32, 64, 2, 20, 30, 26
        iii. Múltiplos de 23: 23, 46, 115, 184, 207, 230
        iv. Testa com outros valores


     */


class NumbersClassTest {
    NumbersClass nc;
    @BeforeEach
    public void setup(){
        nc = new NumbersClass();
    }

    @ParameterizedTest
    @ValueSource( ints={3, 23, 311, 487, 653, 947})
    public void testIsPrime(int val){
        boolean isPrime = nc.isPrime(val);
        assertTrue(isPrime);

    }
    @ParameterizedTest
    @ValueSource(ints = {32, 64, 2, 20, 30, 26})
    public void testIsEven(int val){
        boolean isEven = nc.isEven(val);
        assertTrue(isEven);

    }
    @ParameterizedTest
    @ValueSource(ints = { 23, 46, 115, 184, 207, 230})
    public void isMultiple(int val){
        boolean isMultiple = nc.isMultiple(val,4);
        assertTrue(isMultiple);
    }


}