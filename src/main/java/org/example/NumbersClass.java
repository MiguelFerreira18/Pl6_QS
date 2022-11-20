package org.example;

public class NumbersClass {
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
Exercício 3
Pretende-se criar

     */
    public boolean isPrime(int number){
        boolean flag = false;
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println(number + " is a prime number.");
        return false;
        }
        else{
            System.out.println(number + " is not a prime number.");
        return true;
        }
    }
    public boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        return false;
    }
    public boolean isMultiple(int number,int divisor){
        return number%divisor==0;
    }


}
