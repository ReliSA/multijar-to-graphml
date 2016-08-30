# multijar-to-graphml
Simple tool to generate dependency graph data from multiple JAR components.

Result can be visualized or parsed and searched for dependency problems between JAR components.

Tool created as student project on [The Faculty of Applied Sciences](http://fav.zcu.cz) in Pilsen.

## Graph representation
For representation of dependency graph is used [GraphML](http://graphml.graphdrawing.org/primer/graphml-primer.html) format. [GraphML](http://graphml.graphdrawing.org/primer/graphml-primer.html) is XML based format for graph representation with following features:
- directed/undirected graphs
- hierarchical graphs
- hypergraphs
- custom node attributes

### Example
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<graphml xmlns="http://graphml.graphdrawing.org/xmlns" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd">
    <graph id="G" edgeDefault="directed">
        <node id="path/example.jar">
            <data key="nodeName">path/example.jar</data>
            <data key="nodeType">JAR</data>
            <graph edgeDefault="directed" id="path/example.jar">
                <node id="path/example.jar:com">
                    <data key="nodeName">path/example.jar:com</data>
                    <data key="nodeType">PACKAGE</data>
                    <graph edgeDefault="directed" id="path/example.jar:com">
                        <node id="path/example.jar:com.pack">
                            <data key="nodeName">path/example.jar:com.pack</data>
                            <data key="nodeType">PACKAGE</data>
                            <graph edgeDefault="directed" id="path/example.jar:com.pack">
                              <node id="path/example.jar:com.pack.ExampleClass">
                                <data key="nodeName">path/example.jar:com.pack.ExampleClass</data>
                                <data key="nodeType">CLASS</data>
                                  <graph edgeDefault="directed" id="path/example.jar:com.pack.ExampleClass"/>
```

GraphML part for example structure:
- example.jar (JAR)
  - com (PACKAGE)
    - pack (PACKAGE)
      - ExampleClass (CLASS)

### Structure
For nesting purposes all jars, packages and classes are [GraphML subgraphs](http://graphml.graphdrawing.org/primer/graphml-primer.html#NHP). Only methods and fields are simple nodes.

Every member of structure has some attributes:
- **id** - unique identifier for connecting edges
- **nodeName** - name of node for visualization
- **nodeType** - JAR, PACKAGE, CLASS, METHOD, FIELD

Edges are at the end of output. Edge is connects importing (source) with exporting (target) node.

### Structure errors
In every output is created **unknown** JAR. It is used when source or target point of edge is unknown:
- when target is from package like *java.lang* which is not in scanned directory
- when class imports some unknown source


Thanks to XML base there are parsers and tools for visualization of GrapML data. For example [yEd](http://www.yworks.com/products/yed)

## Build
Project is built with maven. To create runnable JAR with dependencies run:
```
mvn install
```
 It creates:
 - **graphml.jar** - only tool sources without dependencies
 - **graphml.jar-with-dependencies.jar** - runnable JAR with all dependencies

Note: access to [ReliSA-JaCC](http://relisa-dev.kiv.zcu.cz/nexus/content/repositories/jacc-releases/) maven repository is required.

## Usage
Program takes only three arguments.
```
java -jar graphml-jar-with-dependencies.jar directory [-classContent] outputFile
```

where:
- **directory** - directory with JAR components, recursively searched for all JARs
- **-classContent** - when used, class methods and fields are also included in graph structure
- **outputFile** - output file where GraphML structure is stored
