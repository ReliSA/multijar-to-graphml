package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor on 18.5.2016.
 */

@XmlRootElement(name = "graphml")
@XmlAccessorType(XmlAccessType.FIELD)
public class GraphML {
    @XmlAttribute(name = "xmlns")
    private final String xmlns = "http://graphml.graphdrawing.org/xmlns";
    @XmlAttribute(name = "xmlns:xsi")
    private final String xmlns_si = "http://www.w3.org/2001/XMLSchema-instance";
    @XmlAttribute(name = "xsi:schemaLocation")
    private final String xsi_schemaLocation = "http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd";

    @XmlElement(name = "graph")
    private RootGraph root = new RootGraph();

    @XmlElement(name = "key")
    private HashSet<Key> keys;

    public GraphML()
    {
        keys = new HashSet<Key>();
        Key tmp = new Key();
        tmp.setId("nodeName");
        tmp.setFor("node");
        tmp.setType("string");
        tmp.setName("name");
        keys.add(tmp);
    }


    public HashSet<Key> getKeys() {
        return keys;
    }

    public void setKeys(HashSet<Key> keys) {
        this.keys = keys;
    }

    public RootGraph getRoot() {
        return root;
    }

    public void setRoot(RootGraph root) {
        this.root = root;
    }
}
