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
                    
                    Element alcanceMaxElement = doc.createElement("alcanceMax");
                    alcanceMaxElement.appendChild(doc.createTextNode(String.valueOf(((EArmas) equipo).getAlcanceMax())));
                    armaElement.appendChild(alcanceMaxElement);
                            
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
    
    public static Juego cargarJuego() {
    Juego juego = new Juego();

    try {
        File archivoXML = new File("src\\juegozombies\\partidaZombiesGuardada.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(archivoXML);
        doc.getDocumentElement().normalize();

        Node turnoNode = doc.getElementsByTagName("turnoJugador").item(0);
        juego.setTurnoJugador(Integer.parseInt(turnoNode.getTextContent()));

        NodeList listaSupervivientes = doc.getElementsByTagName("superviviente");
        for (int i = 0; i < listaSupervivientes.getLength(); i++) {
            Node nodoSuperviviente = listaSupervivientes.item(i);
            if (nodoSuperviviente.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoSuperviviente = (Element) nodoSuperviviente;
                String nombre = elementoSuperviviente.getElementsByTagName("nombre").item(0).getTextContent();
                Punto posicion = new Punto();
                posicion.parsePunto(elementoSuperviviente.getElementsByTagName("posicion").item(0).getTextContent().split(","));
                Superviviente superviviente = new Superviviente(nombre, posicion);
                Boolean vivo = Boolean.parseBoolean(elementoSuperviviente.getElementsByTagName("vivo").item(0).getTextContent());
                superviviente.setVivo(vivo);
                int numAcciones = Integer.parseInt(elementoSuperviviente.getElementsByTagName("numAcciones").item(0).getTextContent());
                superviviente.setNumAcciones(numAcciones);
                int elimZombies = Integer.parseInt(elementoSuperviviente.getElementsByTagName("elimZombies").item(0).getTextContent());
                superviviente.setElimZombies(elimZombies);
                int heridas = Integer.parseInt(elementoSuperviviente.getElementsByTagName("heridas").item(0).getTextContent());
                superviviente.setHeridas(heridas);
                
                Element elementoInventario = (Element) elementoSuperviviente.getElementsByTagName("inventario").item(0);
                NodeList equiposNodeList = elementoInventario.getChildNodes();
                ArrayList<Equipo> inventario = new ArrayList<>();
                
                for(int j = 0; j < equiposNodeList.getLength(); j++) {
                    Node equipoNode = equiposNodeList.item(i);

                if (equipoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element equipoElement = (Element) equipoNode;
                    
                if (equipoElement.getNodeName().equals("arma")) {
                    
                    String nombreArma = equipoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    int potencia = Integer.parseInt(equipoElement.getElementsByTagName("potencia").item(0).getTextContent());
                    int alcanceMax = Integer.parseInt(equipoElement.getElementsByTagName("alcanceMax").item(0).getTextContent());
                    int numDados = Integer.parseInt(equipoElement.getElementsByTagName("numDados").item(0).getTextContent());
                    int valorExito = Integer.parseInt(equipoElement.getElementsByTagName("valorExito").item(0).getTextContent());
                    boolean armaActiva = Boolean.parseBoolean(equipoElement.getElementsByTagName("armaActiva").item(0).getTextContent());

                    EArmas arma = new EArmas(nombreArma, potencia, alcanceMax, numDados, valorExito);
                    arma.setArmaActiva(armaActiva);
                    inventario.add(arma);
                } else if (equipoElement.getNodeName().equals("provision")) {
            
                    String nombreProvision = equipoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    int valorEnergetico = Integer.parseInt(equipoElement.getElementsByTagName("valorEnergetico").item(0).getTextContent());
                    String fechaCaducidad = equipoElement.getElementsByTagName("fechaCaducidad").item(0).getTextContent();

                    EProvisiones provision = new EProvisiones(nombreProvision, valorEnergetico);
                    provision.setCaducidad(fechaCaducidad);
                    inventario.add(provision);
                }
            }
        }
                superviviente.setInventario(inventario);
        
                int exitos = Integer.parseInt(elementoSuperviviente.getElementsByTagName("exitos").item(0).getTextContent());
                superviviente.setExitos(exitos);
                juego.getSupervivientes().add(superviviente);
            }
        }

        NodeList listaZombies = doc.getElementsByTagName("zombi");
        for (int i = 0; i < listaZombies.getLength(); i++) {
            Node nodoZombi = listaZombies.item(i);
            if (nodoZombi.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoZombi = (Element) nodoZombi;
                
                
                //juego.getZombis().add();
            }
        }

        // Resto de atributos de juego

    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }

    return juego;
}
}
