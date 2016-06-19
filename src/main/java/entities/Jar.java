package entities;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

/**
 * Created by Viktor Vašina on 14.5.2016.
 *
 * Jar entity for Graphml serialization.
 */
@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jar extends HierarchyMember {

    @XmlElement(name = "graph")
    private JarContent jarContent = new JarContent();

    /**
     * Returns classes in root of jar.
     * @return classes in jar root
     */
    public HashSet<Class> getClasses() {
        return jarContent.getClasses();
    }

    /**
     * Set new root classes in jar.
     * @param classes new root classes
     */
    public void setClasses(HashSet<Class> classes) {
        jarContent.setClasses(classes);
    }

    /**
     * Returns root packages in jar.
     * @return root jar packages
     */
    public HashSet<Package> getPackages() {
        return jarContent.getPackages();
    }

    /**
     * Set new rooot packages in jar.
     * @param packages new root packages
     */
    public void setPackages(HashSet<Package> packages) {
        jarContent.setPackages(packages);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
        jarContent.setId(id);
    }
}
