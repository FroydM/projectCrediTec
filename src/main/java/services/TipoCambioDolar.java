
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
public class TipoCambioDolar {
    
    public static double  conectarTED() throws Exception {
        
        double tipoCambio = 0;
//Obtener la fecha actual   
        LocalDate fecha = LocalDate.parse(LocalDate.now().toString());
        
        String fechaActual= fecha.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
//Conección con la pagina del Banco Central de Costa Rica        
        final String url =
                "https://gee.bccr.fi.cr/indicadoreseconomicos/Cuadros/frmVerCatCuadro.aspx?CodCuadro=400&Idioma=1&FecInicial="+fechaActual+"&FecFinal="+fechaActual+"&Filtro=0";
        try{
            final Document doc = Jsoup.connect(url).get();

//Recorer las filas de la tabla            
            for (Element row : doc.select("table tr")){
                
                if (row.select("td.celda400:nth-of-type(1)").text().equals("")){
                 
                 continue;
             }
             else{
                    
                 final String ticket=
                         row.select("td:nth-of-type(3)").text();

                 tipoCambio = Double.parseDouble(ticket.replace(",", "."));
             }
         }           
   
        }catch(Exception ex){
       
        }

        return tipoCambio;
    }
}
