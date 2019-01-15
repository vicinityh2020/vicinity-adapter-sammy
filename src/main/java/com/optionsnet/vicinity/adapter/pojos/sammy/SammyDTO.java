package com.optionsnet.vicinity.adapter.pojos.sammy;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "iot",
        "attr"
})
public class SammyDTO {

    @JsonProperty("iot")
    public List<IotDTO> iot = null;

    @JsonProperty("attr")
    public AttrDTO attr;


    public List<IotDTO> getIot() {
        return iot;
    }

    public void setIot(List<IotDTO> iot) {
        this.iot = iot;
    }

    public AttrDTO getAttr() {
        return attr;
    }

    public void setAttr(AttrDTO attr) {
        this.attr = attr;
    }


    @Override
    public String toString() {
        return "SammyDTO{" +
                "iot=" + iot +
                ", attr=" + attr +
                '}';
    }
}
