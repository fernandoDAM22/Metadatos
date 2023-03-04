package controller;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.util.HashMap;
import java.io.*;

/**
 * Esta clase contiene los metodos que nos permiten sacar los
 * metadatos de una foto
 * @author Fernando
 */
public class Data {
    /**
     * Este metodo permite extraer los metadatos de una foto
     * @param imagePath es la ruta de la foto de la cual queremos sacar los metadatos
     * @return un HashMap con pares clave valor con el nombre y el valor del metadato
     */
    public static HashMap<String, String> extractImageMetadata(String imagePath) {
        try {
            File file = new File(imagePath);

            // Crea un objeto Metadata para almacenar los metadatos
            Metadata metadata = new Metadata();

            // Crea un objeto BodyContentHandler para manejar el contenido del archivo
            BodyContentHandler handler = new BodyContentHandler();

            // Crea un objeto AutoDetectParser para detectar el tipo de archivo y parsearlo
            Parser parser = new AutoDetectParser();

            // Crea un objeto ParseContext para proporcionar contexto al parseador
            ParseContext context = new ParseContext();

            // Abre un flujo de entrada para la imagen
            FileInputStream inputstream = new FileInputStream(file);

            // Parsea la imagen y extrae los metadatos
            parser.parse(inputstream, handler, metadata, context);

            // Crea un nuevo mapa de metadatos
            HashMap<String, String> metadataMap = new HashMap<>();

            // Agrega cada metadato al mapa
            for (String name : metadata.names()) {
                metadataMap.put(name, metadata.get(name));
            }
            //retornamos los datos
            return metadataMap;
        } catch (Exception ex) {
            return null;
        }
    }






}
