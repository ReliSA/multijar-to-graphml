package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 18.5.2016.
 *
 * GraphML root node entity for serialization.
 */

@XmlRootElement(name = "graphml")
@XmlAccessorType(XmlAccessType.FIELD)
public class GraphML {
    /**
     * XMLNS attribute of GraphML document.
     */
    @XmlAttribute(name = "xmlns")
    private final String xmlns = "http://graphml.graphdrawing.org/xmlns";
    /**
     * XMLNS:SI attribute of GraphML document.
     */
    @XmlAttribute(name = "xmlns:xsi")
    private final String xmlns_si = "http://www.w3.org/2001/XMLSchema-instance";
    /**
     * XSI:SCHEMALOCATION attribute GraphML document
     */
    @XmlAttribute(name = "xsi:schemaLocation")
    private final String xsi_schemaLocation = "http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd";

    @XmlElement(name = "graph")
    private RootGraph root = new RootGraph();

    @XmlElement(name = "key")
    private HashSet<Key> keys;

    /**
     * Default constructor.
     *
     * Automatically creates nodeName and nodeType key in GraphML structure for naming nodes.
     */
    public GraphML()
    {
        keys = new HashSet<Key>();
        Key name = new Key();
        name.setId("nodeName");
        name.setFor("node");
        name.setType("string");
        name.setName("name");

        Key type = new Key();
        type.setId("nodeType");
        type.setFor("node");
        type.setType("string");
        type.setName("type");

        keys.add(name);
        keys.add(type);
    }


    /**
     * Returns Set of GraphML keys definitions (definitions of custom node attributes).
     * @return GraphML keys definitions
     */
    public HashSet<Key> getKeys() {
        return keys;
    }

    /**
     * Set new GraphML keys definitions.
     * @param keys new keys definitions
     */
    public void setKeys(HashSet<Key> keys) {
        this.keys = keys;
    }

    /**
     * Returns GraphML root graph which wraps whole structure.
     * @return root graph
     */
    public RootGraph getRoot() {
        return root;
    }

    /**
     * Set GraphML root graph (wraps whole structure).
     * @param root GraphML root graph
     */
    public void setRoot(RootGraph root) {
        this.root = root;
    }
}
