/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegozombies;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author hkiva
 */
public class Persistencia {
    
    public static void guardarJuego(Juego juego) {
    try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("juego");
        doc.appendChild(rootElement);

        Element turnoElement = doc.createElement("turnoJugador");
        turnoElement.appendChild(doc.createTextNode(String.valueOf(juego.getTurnoJugador())));
        rootElement.appendChild(turnoElement);

        Element supervivientesElement = doc.createElement("supervivientes");
        for (Superviviente superviviente : juego.getSupervivientes()) {
            Element supervivienteElement = doc.createElement("superviviente");
            
            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(superviviente.getNombre()));
            supervivienteElement.appendChild(nombreElement);
            
            Element posicionElement = doc.createElement("posicion");
            posicionElement.appendChild(doc.createTextNode(superviviente.devolverCoordenada().toString()));
            supervivienteElement.appendChild(posicionElement);
            
            // Crear método vivotoString()
            Element vivoElement = doc.createElement("vivo");
            vivoElement.appendChild(doc.createTextNode(String.valueOf(superviviente.isVivo())));
            supervivienteElement.appendChild(vivoElement);
            
            Element numAccionesElement = doc.createElement("numAcciones");
            numAccionesElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getNumAcciones())));
            supervivienteElement.appendChild(numAccionesElement);
            
            Element elimZombiesElement = doc.createElement("elimZombies");
            elimZombiesElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getElimZombies())));
            supervivienteElement.appendChild(elimZombiesElement);
            
            Element heridasElement = doc.createElement("heridas");
            heridasElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getHeridas())));
            supervivienteElement.appendChild(heridasElement);
            
            Element inventarioElement = doc.createElement("inventario");
            for (Equipo equipo : superviviente.getInventario()) {
                if (equipo instanceof EArmas) {
                    Element armaElement = doc.createElement("arma");
                    
                    Element nombreArmaElement = doc.createElement("nombre");
                    nombreArmaElement.appendChild(doc.createTextNode(equipo.getNombre()));
                    armaElement.appendChild(nombreArmaElement);
                    
                    Element potenciaElement = doc.createElement("potencia");
                    potenciaElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getPotencia())));
                    armaElement.appendChild(potenciaElement);
                    
                    Element numDadosElement = doc.createElement("numDados");
                    numDadosElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getNumDados())));
                    armaElement.appendChild(numDadosElement);
                    
                    Element valorExitoElement = doc.createElement("valorExito");
                    valorExitoElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getValorExito())));
                    armaElement.appendChild(valorExitoElement);
                    
                    Element armaActivaElement = doc.createElement("armaActiva");
                    armaActivaElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).isArmaActiva())));
                    armaElement.appendChild(armaActivaElement);
                    
                    inventarioElement.appendChild(armaElement);
                } else if (equipo instanceof EProvisiones) {
                    Element provisionElement = doc.createElement("provision");
                    
                    Element nombreProvisionElement = doc.createElement("nombre");
                    nombreProvisionElement.appendChild(doc.createTextNode(equipo.getNombre()));
                    provisionElement.appendChild(nombreProvisionElement);
                    
                    Element valorEnergeticoElement = doc.createElement("valorEnergetico");
                    valorEnergeticoElement.appendChild(doc.createTextNode(String.valueOf(((EProvisiones) equipo).getValorEnergetico())));
                    provisionElement.appendChild(valorEnergeticoElement);
                    
                    Element fechaCaducidadElement = doc.createElement("fechaCaducidad");
                    fechaCaducidadElement.appendChild(doc.createTextNode(String.valueOf(((EProvisiones) equipo).getCaducidad())));
                    provisionElement.appendChild(fechaCaducidadElement);
                    
                    inventarioElement.appendChild(provisionElement);
                }
            }
            supervivienteElement.appendChild(inventarioElement);
            
            Element exitosElement = doc.createElement("exitos");
            exitosElement.appendChild(doc.createTextNode(String.valueOf(superviviente.getExitos())));
            supervivienteElement.appendChild(exitosElement);
            
            supervivientesElement.appendChild(supervivienteElement);
        }
        rootElement.appendChild(supervivientesElement);
        
        Element zombiesElement = doc.createElement("zombies");
        for (Zombi zombi : juego.getZombis()) {
            Element zombiElement = doc.createElement(zombi.obtenerTipo());
            
            Element posicionElement = doc.createElement("posicion");
            posicionElement.appendChild(doc.createTextNode((zombi.devolverCoordenada().toString())));
            zombiElement.appendChild(posicionElement);
            
            Element vivoElement = doc.createElement("vivo");
            vivoElement.appendChild(doc.createTextNode(String.valueOf(zombi.isVivo())));
            zombiElement.appendChild(vivoElement);
            
            Element aguanteElement = doc.createElement("aguante");
            aguanteElement.appendChild(doc.createTextNode(String.valueOf(zombi.getAguante())));
            zombiElement.appendChild(aguanteElement);
            
            Element numAccionesElement = doc.createElement("numAcciones");
            numAccionesElement.appendChild(doc.createTextNode(String.valueOf(zombi.getNumAcciones())));
            zombiElement.appendChild(numAccionesElement);
           
            zombiesElement.appendChild(zombiElement);
        }
        rootElement.appendChild(zombiesElement);
        
        Element objetivoElement = doc.createElement("objetivo");
        objetivoElement.appendChild(doc.createTextNode(juego.getObjetivo().toString()));
        rootElement.appendChild(objetivoElement);
        
        Element tamanoCuadriculaElement = doc.createElement("tamanoCuadricula");
        tamanoCuadriculaElement.appendChild(doc.createTextNode(juego.getTamanoCuadricula().toString()));
        
        Element casillasBuscadasElement = doc.createElement("listCasillasBuscadas");
        for(Punto casilla: juego.getListaCasillasBuscadas()) {
            Element casillaElement = doc.createElement("casilla");
            casillaElement.appendChild(doc.createTextNode(casilla.toString()));
            casillasBuscadasElement.appendChild(casillaElement);
        }
        rootElement.appendChild(casillasBuscadasElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src\\juegozombies\\partidaZombiesGuardada.xml"));
        transformer.transform(source, result);
        
    } catch (ParserConfigurationException | TransformerConfigurationException e) {
        e.printStackTrace();
    } catch (TransformerException e) {
        e.printStackTrace();
    }
    
    }
}
