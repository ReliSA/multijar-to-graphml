package entities;

import javax.xml.bind.annotation.*;

/**
 * Created by Viktor on 18.5.2016.
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    public Data()
    {}

    public Data(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @XmlAttribute(name = "key")
    private String key;

    @XmlValue
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
