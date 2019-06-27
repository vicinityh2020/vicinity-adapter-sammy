/*
 * Copyright © 2019 OptionsNet.
 * All rights reserved.
 *
 * This file is part of SaMMY@VICINITY adapter.
 *
 * SaMMY@VICINITY adapter is free software: you can redistribute it
 * and/or modify it under the terms of GNU GPL.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * See README file for the full disclaimer information and LICENSE file for full license information in the project root.
 */

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
