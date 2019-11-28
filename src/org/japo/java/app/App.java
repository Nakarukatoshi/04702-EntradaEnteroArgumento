/*
 * Copyright 2019 Javier Monterde - javier.monterde.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Javier Monterde - javier.monterde.alum@iescamp.es
 */
public final class App {

    //Constantes de clase
    //  Strings
    public static final String MSG_USR = "Introducir número ....: ";
    public static final String MSG_ERR = "ERROR: Entrada incorrecta";

    //  Objeto Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    //Métodos
    //  Método principal
    public final void launchApp() {

        //Llamamos a la cabecera
        System.out.println("INTRODUCCIÓN ENTERO");
        System.out.println("===================");

        //Salida final
        System.out.printf("Número introducido ...: %d%n",
                (int) obtener(MSG_USR, MSG_ERR));
    }

    //  Método para obtener un número double
    public static final double obtener(String msgUsr, String msgErr) {
        //variables
        double num = 0;
        boolean entradaOK;
        do {
            //Inicializamos la variable
            entradaOK = false;

            //Bloque try catch
            try {
                //Solicitamos el número
                System.out.print(msgUsr);
                num = SCN.nextDouble();

                //Salimos del bucle
                entradaOK = true;
            } catch (Exception e) {
                //Mostramos el mensaje de error
                System.out.println(msgErr);
            } finally {
                //Limipamos el búfer
                SCN.nextLine();

                //Y aprovechamos el finally para no duplicar esta línea
                System.out.println("---");
            }
        } while (!entradaOK);

        //Return
        return num;
    }
}
