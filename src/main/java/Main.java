import cz.zcu.kiv.jacc.javatypes.*;
import cz.zcu.kiv.jacc.javatypes.impl.ImporterTuple;
import cz.zcu.kiv.jacc.loader.JClassLoaderFacade;
import cz.zcu.kiv.jacc.loader.JClassLoaderFactory;
import entities.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        Collection<File> files = Utils.listFiles(new File(args[0]), new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches(".*\\.jar");
            }
        });

        GraphML gml = new GraphML();
        HashMap<String, HashSet<HierarchyMember>> exportDict = new HashMap<String, HashSet<HierarchyMember>>();

        for (File jarFile : files) {
            JClassLoaderFacade facade = JClassLoaderFactory.createVariableDSFacade(null);
            JBlackBoxComponent component = facade.getAPI(jarFile);
            Set<JClass> exports = component.getExports();

            Jar jar = new Jar();
            jar.setId(jarFile.getName());
            gml.getRoot().getJars().add(jar);

            for (JClass c : exports) {
                Utils.insertHierarchy(exportDict, jar, c, false);
            }
        }

        Jar unknownJar = new Jar();
        unknownJar.setId("unknown");
        gml.getRoot().getJars().add(unknownJar);

        for (File jarFile : files) {
            JClassLoaderFacade facade = JClassLoaderFactory.createVariableDSFacade(null);
            JBlackBoxComponent component = facade.getAPI(jarFile);
            Set<JClass> imports = component.getImports();

            int edgeCount = 0;

            for (JClass c : imports) {
                for (ImporterTuple i : c.getImportedBy()) {
                    if (!exportDict.containsKey(i.getImportingClass().getName())) {
                        Utils.insertHierarchy(exportDict, unknownJar, i.getImportingClass(), true);
                    }
                    if (!exportDict.containsKey(c.getName())) {
                        Utils.insertHierarchy(exportDict, unknownJar, c, true);
                    }
                    for (HierarchyMember from : exportDict.get(i.getImportingClass().getName())) {
                        for (HierarchyMember to : exportDict.get(c.getName())) {
                            Edge e = new Edge();
                            if (i.getImportingMethod() != null && exportDict.containsKey(from.getShortName() + "." + i.getImportingMethod().getName()))
                                e.setSource(from.getId() + "." + i.getImportingMethod().getName());
                            else
                                e.setSource(from.getId());
                            e.setTarget(to.getId());
                            e.setId("e" + edgeCount++);
                            gml.getRoot().getEdges().add(e);
                        }
                    }
                }
            }

        }
        try {
            File file = new File("foo2.graphml");
            JAXBContext jaxbContext = JAXBContext.newInstance(GraphML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(gml, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

}
