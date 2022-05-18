
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
public class TasaBasicaPasiva {
    
    public static double  conectarTBP() throws Exception{
        
        double tasaBasica = 0;

//Obtener la fecha actual 
        LocalDate fecha = LocalDate.parse(LocalDate.now().toString());
        
        String fechaActual= fecha.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        
//Conección con la pagina del Banco Central de Costa Rica
        final String url =
                "https://gee.bccr.fi.cr/indicadoreseconomicos/cuadros/frmvercatcuadro.aspx?CodCuadro=17&Idioma=1&FecInicial="+fechaActual+"&FecFinal="+fechaActual+"";
        try{
            final Document doc = Jsoup.connect(url).get();
            
//Recorer las filas de la tabla
            for (Element row : doc.select("table tr")){
             
             if (row.select("td.celda17:nth-of-type(1)").text().equals("")){
                 
                 continue;
             }
             else{
                 final String ticket=
                         row.select("td.celda17:nth-of-type(2)").text();
                 
                 tasaBasica = Double.parseDouble(ticket.replace(",", "."));
             }
         }             
        }catch(Exception ex){
            throw ex;
        }
        
        return tasaBasica;
        
    }
}
