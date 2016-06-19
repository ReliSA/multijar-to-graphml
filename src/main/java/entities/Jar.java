package entities;

import javax.xml.bind.annotation.*;
import java.lang.*;
import java.util.HashSet;

/**
 * Created by Viktor on 14.5.2016.
 */
@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Jar extends HierarchyMember {

    @XmlElement(name = "graph")
    private JarContent jarContent = new JarContent();

    public JarContent getJarContent() {
        return jarContent;
    }

    public void setJarContent(JarContent jarContent) {
        this.jarContent = jarContent;
    }

    public HashSet<java.lang.Class> getClasses() {
        return jarContent.getClasses();
    }

    public void setClasses(HashSet<java.lang.Class> classes) {
        jarContent.setClasses(classes);
    }

    public HashSet<Package> getPackages() {
        return jarContent.getPackages();
    }

    public void setPackages(HashSet<Package> packages) {
        jarContent.setPackages(packages);
    }

    @Override
    public void setId(String id) {
        super.setId(id);
        jarContent.setId(id);
    }
}
