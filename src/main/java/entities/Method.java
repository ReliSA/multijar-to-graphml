package entities;

/**
 * Created by Viktor Vašina on 12.6.2016.
 *
 * Class method entity for GraphML serialization.
 */
public class Method extends HierarchyMember {
    public Method()
    {
        super();
        this.type.setValue(NodeTypes.METHOD.name());
    }
}
