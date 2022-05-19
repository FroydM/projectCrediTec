
package services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Melanie & Froyd
 */
public class TasaEfectivaDolares {
    
    public static double  conectarTED() throws Exception {
        
        double tipoCambio = 0;
//Obtener la fecha actual   
        LocalDate fecha = LocalDate.parse(LocalDate.now().toString());
        
        String fechaActual= fecha.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
//Conección con la pagina del Banco Central de Costa Rica        

        final String newUrl = "https://gee.bccr.fi.cr/indicadoreseconomicos/Cuadros/frmVerCatCuadro.aspx?CodCuadro=3141&Idioma=1&FecInicial="+fechaActual+"&FecFinal="+fechaActual;
        try{
            final Document doc = Jsoup.connect(newUrl).get();

//Recorer las filas de la tabla            
            for (Element row : doc.select("table tr")){
                               
                if (row.select("td.celda3141:nth-of-type(1)").text().equals("")){
                    
                 continue;
             }else{
                    final String ticket=
                        row.select("td.celda3141:nth-of-type(2)").text();
 
                   tipoCambio = Double.parseDouble(ticket.replace(",", "."));
             }
         }           
   
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return tipoCambio;
    }
}
