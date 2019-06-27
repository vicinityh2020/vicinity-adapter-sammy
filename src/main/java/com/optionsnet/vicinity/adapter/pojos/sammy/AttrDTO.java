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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "weatherTime",
        "waterTime",
        "lastonline",
        "onlineMinutes",
        "offlineMinutes"
})
public class AttrDTO {

    @JsonProperty("weatherTime")
    public Integer weatherTime;

    @JsonProperty("waterTime")
    public Integer waterTime;

    @JsonProperty("lastonline")
    public Integer lastonline;

    @JsonProperty("onlineMinutes")
    public Integer onlineMinutes;

    @JsonProperty("offlineMinutes")
    public Integer offlineMinutes;


    public Integer getWeatherTime() {
        return weatherTime;
    }

    public void setWeatherTime(Integer weatherTime) {
        this.weatherTime = weatherTime;
    }

    public Integer getWaterTime() {
        return waterTime;
    }

    public void setWaterTime(Integer waterTime) {
        this.waterTime = waterTime;
    }

    public Integer getLastonline() {
        return lastonline;
    }

    public void setLastonline(Integer lastonline) {
        this.lastonline = lastonline;
    }

    public Integer getOnlineMinutes() {
        return onlineMinutes;
    }

    public void setOnlineMinutes(Integer onlineMinutes) {
        this.onlineMinutes = onlineMinutes;
    }

    public Integer getOfflineMinutes() {
        return offlineMinutes;
    }

    public void setOfflineMinutes(Integer offlineMinutes) {
        this.offlineMinutes = offlineMinutes;
    }


    @Override
    public String toString() {
        return "AttrDTO{" +
                "weatherTime=" + weatherTime +
                ", waterTime=" + waterTime +
                ", lastonline=" + lastonline +
                ", onlineMinutes=" + onlineMinutes +
                ", offlineMinutes=" + offlineMinutes +
                '}';
    }
}
