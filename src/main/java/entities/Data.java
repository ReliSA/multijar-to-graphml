package entities;

import javax.xml.bind.annotation.*;

/**
 * Created by Viktor Vašina on 18.5.2016.
 *
 * Entity for adding custom node properties (names etc.) in GraphML.
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    /**
     * Default constructor.
     */
    public Data()
    {}

    /**
     * Parametric constructor.
     * @param key key attribute of &lt;data&gt; element
     * @param value value of &lt;data&gt; element
     */
    public Data(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @XmlAttribute(name = "key")
    private String key;

    @XmlValue
    private String value;

    /**
     * Returns key of &lt;data&gt; element.
     * @return key of data element
     */
    public String getKey() {
        return key;
    }

    /**
     * Set key of &lt;data&gt; element.
     * @param key key attribute of data element
     */
    public void setKey(String key) {
        this.key = key;
    }

    /** Returns value of &lt;data&gt; element.
     * @return valueod data element
     */
    public String getValue() {
        return value;
    }

    /**
     * Set value of &lt;data&gt; element.
     * @param value new value of data element
     */
    public void setValue(String value) {
        this.value = value;
    }
}
