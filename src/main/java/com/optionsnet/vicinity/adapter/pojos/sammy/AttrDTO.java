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
