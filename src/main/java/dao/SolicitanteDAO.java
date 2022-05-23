/**
 *
 * @author Melanie & Froyd
 */

package dao;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import model.Solicitante;
import java.util.Arrays;
import model.Credito;
import system.DAOException;


public class SolicitanteDAO {
    static final private String URL = "data/";
    static final private File DIRECTORIO = new File(URL);
    /**
     * Esta funcion se encarga de almacenar la informacion del solicitante dentro de un archivo
     * @param nuevoSolicitante
     * @throws DAOException Si el numero de cedula ya se encuentra registrado
     */
    static public void guardarSolicitante(Solicitante nuevoSolicitante) throws DAOException,IOException {
        
        String cedula = convertirSHA256(String.valueOf(nuevoSolicitante.getCedula()));
        final String NOMBRE_ARCHIVO = URL+ cedula+".dat";
        
        if(existeSolicitiante(cedula+".dat")){
            throw new DAOException("Numero de cedula ya se encuentra registrado");
        }
        OutputStream fileOutput = new FileOutputStream(NOMBRE_ARCHIVO);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(nuevoSolicitante);
        objectOutput.close();
        
    }
    /**
     * Busca al solicitante por su numero de cedula
     * @param cedula Numero de cedula de solicitante a buscar
     * @return El objeto de tipo solicitante con la informacion del mismo
     * @throws DAOException Muestra el error si no existe un solicitante con el numero de cedula ingresado
     * @throws IOException Error al buscar archivo que contiene la informacion
     * @throws ClassNotFoundException Error al convertir la clase 
     */
    static public Solicitante obtenerSolicitanteById(int cedula) throws DAOException, IOException,ClassNotFoundException{
        String cedulaEncriptada = convertirSHA256(String.valueOf(cedula));
        if(!existeSolicitiante(cedulaEncriptada+".dat")) throw new DAOException("El solicitante no existe");
        final String NOMBRE_ARCHIVO = URL+ cedulaEncriptada+".dat";
        InputStream fileInput = new FileInputStream(NOMBRE_ARCHIVO);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        Solicitante datos = (Solicitante)objectInput.readObject();
        objectInput.close();
        return datos;
    }
    /**
     * Es funcion se encarga de recorrer todo los documentos almacendos que contiene la informacion de los solicitantes
     * @return Un listado de todos los solicitantes registrados
     * @throws DAOException Muestra el error si no existe un solicitante con el numero de cedula ingresado
     * @throws IOException Error al buscar archivo que contiene la informacion
     * @throws ClassNotFoundException Error al convertir la clase 
     */
    static public ArrayList<Solicitante> obtenerListadoSolicitantes() throws DAOException, IOException,ClassNotFoundException {
        ArrayList<Solicitante> listado = new ArrayList<>();
        for(String fileName : DIRECTORIO.list()) {
            InputStream fileInput = new FileInputStream(URL+fileName);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            listado.add((Solicitante)objectInput.readObject());
            objectInput.close();
        }
        
        return listado;
    }
    /**
     * Esta funcion se encarga de eliminar el documento que almacena la informacion del solicitante por Id
     * @param cedula Numero de cedula del solicitante que se va a eliminar 
     * @throws DAOException Muestra el error si no existe un solicitante con el numero de cedula ingresado
     * @throws IOException Error al buscar archivo que contiene la informacion
     * @throws ClassNotFoundException Error al convertir la clase 
     */
    static public void eliminarSolicitanteById(int cedula ) throws DAOException, IOException,ClassNotFoundException {
        String cedulaEncriptada = convertirSHA256(String.valueOf(cedula));
        if(!existeSolicitiante(cedulaEncriptada+".dat")) throw new DAOException("El solicitante no existe");
        final String NOMBRE_ARCHIVO = URL+ cedulaEncriptada+".dat";
        File objectDoc = new File(NOMBRE_ARCHIVO);
        objectDoc.delete();
        
    }
    
    static public void actualizarSolicitanteById(Solicitante dataSolicitante) throws DAOException, IOException,ClassNotFoundException {
        eliminarSolicitanteById(dataSolicitante.getCedula());
        guardarSolicitante(dataSolicitante);
    }
    
    /**
     * 
     * @param id
     * @return
     * @throws DAOException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    static public  ArrayList<Credito> obtenerAllCreditosBySolicitante(int id) throws DAOException, IOException,ClassNotFoundException{
        Solicitante currentSolicitante = obtenerSolicitanteById(id);
        return currentSolicitante.creditosSolicitados;
    }
    
    /**
     * Verifica si el numero de cedula ya se encuentra registrado
     * @param docId Numero de cedula encriptado que se verifica
     * @return Valor boolean si existe el numero de cedula
     */
    static public boolean existeSolicitiante(String docId){
        
        return Arrays.binarySearch(DIRECTORIO.list(),docId)>=0;
    }
    
    
    /**
     * Esta funcion se encarga de cifrar el numero de cedula de la persona que se almacena en el documento
     * @param value Valor de la cedula que se va a crifrar
     * @return Numero de cedula cifrado 
     */
    static protected String convertirSHA256(String value) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(value.getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte b: hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException algEx) {
            System.out.println(algEx.getMessage());
            return null;
        }
    }
    
}
