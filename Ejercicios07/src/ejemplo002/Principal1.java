/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo002;
/**
 *
 * @author reroes
 */
public class Principal1 {

    public static void main(String[] args) {
        
        String [] nombres = { "Jason", "Jonathan", "Kristen", "Robin", 
                              "Michelle", "Emily", "Noah", "Daniel"};
        String [] apellidos = { "Lynch", "George", "Lang", "Cochran", 
                                "Young", "Fletcher", "Adkins", "Harris"};
        int [][] notas = { {10, 80, 80, 95}, {40, 80, 80, 45}, 
                         {80, 10, 20, 55}, {70, 30, 20, 65}, 
                         {60, 50, 70, 75}, {50, 70, 30, 85},
                         {40, 80, 40, 45}, {30, 90, 50, 95}};
        
        String correo;
        int notaBaja;
        int notaAlta;
        double promedio_paralelo = obtenerPromedioParalelo(notas);
        String nombre;
        String apellido;
        String tipoNotas;
        double promedioEstudiante;
        int numeroNotasArribaPromedio;
        int [] filaNotas;
        String mensajeFinal = "";
        for (int i = 0; i < nombres.length; i++) {
            nombre = nombres[i];
            apellido = apellidos[i];
            filaNotas = notas[i];
            notaBaja = obtenerNotaMasBaja(filaNotas);
            notaAlta = obtenerNotaMasAlta(filaNotas);
            correo = obtenerCorreo(nombre, apellido);
            promedioEstudiante = funcion01(filaNotas);
            numeroNotasArribaPromedio = funcion02(filaNotas, 
                    promedio_paralelo);
            tipoNotas = funcion03(filaNotas);
            mensajeFinal = String.format("%s%s\n", mensajeFinal, 
                    presentarReporte(nombre, apellido, correo,tipoNotas, 
                    promedioEstudiante, numeroNotasArribaPromedio, notaBaja, 
                    notaAlta));
            /*Arriba mandamos dos parametros nomás si nos fiojamos bien dentro 
            del stringformat estamos llamando una funcion y le estamos mandando 
            sus respectivos parametros*/
        }
        CrearArchivoTexto.agregarRegistros(mensajeFinal);
        //aqui llamo a la funcion que etsa en otra clase
    }
    
    public static String presentarReporte(String nom, String ap, String correo,
            String notas, double prom, int numeroNotas, int notaBaja, 
            int notaAlta){
        
        String reporte = String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Username: %s\n"
                + "Con notas: \n"
                + "%s"
                + "Promedio - %2f\n"
                + "Número de notas arriba del promedio: %d\n"
                + "Nota mas baja: %d\n"
                + "Nota mas alta: %d\n\n",
                nom, ap, correo,notas, prom, numeroNotas, notaBaja, notaAlta);
        
        return reporte;
    }

    
    public static double obtenerPromedioParalelo(int [][] n){
        int suma = 0;
        double promedio;
        int contador = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                suma = suma + n[i][j];
                contador = contador + 1;
            }
        }
        
        promedio = (double)suma/ contador;
        return promedio;
    }
    
    public static double funcion01(int [] notas){
        int suma = 0;
        double promedio;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        promedio = (double) suma / notas.length;
        return promedio;
    }
    
    public static int funcion02(int [] notas, double promedio){
        
        int contador = 0;
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota > promedio) {
                contador = contador + 1;
            }
            
        }
        
        return contador;
    }
    
    public static String funcion03(int [] notas){
        String cadena = "";
        
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota >=0 && nota<=20) {
                cadena = String.format("%s%d-%s\n", cadena, nota, "M");
            }else{
                if (nota >20 && nota<=50) {
                    cadena = String.format("%s%d-%s\n", cadena, nota, "MB");
                }else{
                    if (nota > 50) {
                        cadena = String.format("%s%d-%s\n", cadena, nota, "S");
                    }
                }
            }
            
        }
        
        return cadena;
    }
    
    public static String obtenerCorreo(String nom, String ap){
        String correo;
        String inicial;
        String apellidoMinus;
        
        inicial = nom.toLowerCase().substring(0, 1);
        apellidoMinus = ap.toLowerCase();
        correo = String.format("%s.%s@utpl.edu.ec", inicial, apellidoMinus);
        return correo;
    }
    
    public static int obtenerNotaMasBaja(int [] notas){
        int NotaBaja = notas[0];
        int i;
        
        for(i = 1;i<notas.length;i++){
            if(NotaBaja > notas[i]){
                NotaBaja = notas[i];
            }
        }
        return NotaBaja;
    }
    
    public static int obtenerNotaMasAlta(int [] notas){
        int NotaAlta = notas[0];
        int i;
        
        for(i = 1;i<notas.length;i++){
            if(NotaAlta < notas[i]){
                NotaAlta = notas[i];
            }
        }
        return NotaAlta;
    }
}
