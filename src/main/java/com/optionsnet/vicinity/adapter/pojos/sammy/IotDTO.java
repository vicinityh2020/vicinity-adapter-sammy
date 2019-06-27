/*
 * Copyright © 2019 OptionsNet.
 * All rights reserved.
 *
 * This file is part of SaMMY@VICINITY adapter.
 *
 * SaMMY@VICINITY adapter is free software: you can redistribute it
 * and/or modify it under the terms of EPL v2.0.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT ANY WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT, IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * See README file for the full disclaimer information and LICENSE file for full license information in the project root.
 */

package com.optionsnet.vicinity.adapter.pojos.sammy;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "value",
        "location"
})
public class IotDTO {

    @JsonProperty("name")
    public String name;

    @JsonProperty("value")
    public String value;

    @JsonProperty("location")
    private LocationDTO location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "IotDTO{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", location=" + location +
                '}';
    }
}
