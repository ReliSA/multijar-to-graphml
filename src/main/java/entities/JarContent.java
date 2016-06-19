package entities;

import javax.xml.bind.annotation.*;
import java.lang.*;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 18.5.2016.
 *
 * Helper Class for serializing Jar entity as nested graph in Graphml.
 */

@XmlRootElement(name = "graph")
@XmlAccessorType(XmlAccessType.FIELD)
class JarContent extends HierarchyMember {

    /**
     * Sets edges in GraphML as directed.
     */
    @XmlAttribute(name = "edgeDefault")
    private final String edgeDefault = "directed";

    @XmlElement(name="node")
    private HashSet<Class> classes = new HashSet<Class>();

    @XmlElement(name="node")
    private HashSet<Package> packages = new HashSet<Package>();

    /**
     * Returns Set of root classes of jar.
     * @return root classes
     */
    HashSet<Class> getClasses() {
        return classes;
    }

    /**
     * Set new root classes of jar.
     * @param classes new root classes
     */
    void setClasses(HashSet<Class> classes) {
        this.classes = classes;
    }

    /**
     * Returns Set of jar root packages.
     * @return jar root packages
     */
    HashSet<Package> getPackages() {
        return packages;
    }

    /**
     * Set new jar root packages.
     * @param packages new jar root packages
     */
    void setPackages(HashSet<Package> packages) {
        this.packages = packages;
    }
}
