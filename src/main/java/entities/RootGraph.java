package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 18.5.2016.
 *
 * Wrapper class for all Jars (2nd level nodes) and Edges.
 */

@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootGraph {

    /**
     * Id of default root graph in GraphML.
     */
    @XmlAttribute(name = "id")
    private final String id = "G";

    /**
     * Sets edges in GraphML as directed.
     */
    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name = "node")
    private HashSet<Jar> jars = new HashSet<Jar>();

    @XmlElement(name = "edge")
    private HashSet<Edge> edges = new HashSet<Edge>();

    /**
     * Returns Set of jars in GraphML structure.
     * @return jars in GraphML structure
     */
    public HashSet<Jar> getJars() {
        return jars;
    }

    /**
     * Set new Jars in GraphML structure
     * @param jars new Jars
     */
    public void setJars(HashSet<Jar> jars) {
        this.jars = jars;
    }

    /**
     * Returns Set of all edges in GraphML structure.
     * @return all edges in GraphML
     */
    public HashSet<Edge> getEdges() {
        return edges;
    }

    /**
     * Set new edges in GraphML structure.
     * @param edges new edges
     */
    public void setEdges(HashSet<Edge> edges) {
        this.edges = edges;
    }
}
