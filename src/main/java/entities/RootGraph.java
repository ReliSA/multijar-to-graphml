package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor on 18.5.2016.
 */

@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootGraph {

    @XmlAttribute(name = "id")
    private final String id = "G";

    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name = "node")
    private HashSet<Jar> jars = new HashSet<Jar>();

    @XmlElement(name = "edge")
    private HashSet<Edge> edges = new HashSet<Edge>();

    public HashSet<Jar> getJars() {
        return jars;
    }

    public void setJars(HashSet<Jar> jars) {
        this.jars = jars;
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashSet<Edge> edges) {
        this.edges = edges;
    }
}
