# VICINITY SaMMY Adapter


## About SaMMY

SaMMy is an IoT, cloud-based platform which provides services for the yachting industry; 
Namely, it enables the marinas to efficiently manage their resources, to attract and serve 
more yachts and support the local markets by linking them with the yachting community. 
SaMMY’s main goal is to simplify marinas’ operational processes, strengthening the yachters’ 
engagement with them as well and also offer easy-to-use online services for the end-users 
(yachters, skippers, crew members).

SaMMY’s architecture involves a sensor grid network, gateways and data collectors, customised 
communication protocols between devices and systems, a unified RESTful-based data model and a 
series of services through web interfaces, plus a mobile application (iOS and Android). 
The sensor readings are processed so as to become suitable for the Marina Management needs 
but also for the yachters/skippers/crew members. The network infrastructure and the low-level 
software components (agents and collectors) are used to transfer the data into the cloud, 
which act as the data storage pool of the various end-user services. The architecture of the 
platform enables interoperability with other IoT providers or systems, using open source 
technologies and application-irrelevant data models (RESTful-JSON).

[SaMMY official website](https://www.sammyacht.com)


## Adopting SaMMY IoT resources to VICINITY things

SaMMY IoT platform includes the following the IoT resources:

1. Environmental sensors

    1.1 Air Temperature
    
    1.2 Humidity
    
    1.3 Water Temperature
    
    1.4 Oxygen Radiation
    
    1.5 PH

2. Berth spaces occupancy/availability

    2.1 11-devices for respective berth spaces, namely spaces 5-15 


14-SaMMY IoT resources (1.1, 1.2, 1.3 and 11-devices from 2.1) have been modelled according to Vicinity adapters ontology and thus 
registered within Vicinity platform, while 2-more sensors, namely the PH and Oxygen radiation, 
are to be integrated when proper adapter models are available in Vicinity adapters ontology.

SaMMY devices from Patras (Greece) port mooring that have been registered in Vicinity platform:

| Resource / PID        | Description / Thing Name      | Adapter Model  | Adapter Monitored Property  |
|:--------------------- |:----------------------------- |:-------------- |:--------------------------- |
| TEMP                  | Air Temperature               | Thermometer    | AmbientTemperature          |
| HUMA                  | Humidity                      | HumiditySensor | RelativeHumidity            |
| IN_TEMP               | Water Temperature             | Thermometer    | AmbientTemperature          |
| BSx  (*)              | Air Temperature               | OccupancySensor| OnOff                       |

_(*) x = 5, 6, ...., 15_ 


## Configuration and Installation of adapter

VICINITY Adapter for SaMMY is configured via [application.properties](src/main/resources/application.properties)
and specifically the properties:

```
sammy.protocol=http
sammy.host=www.sammyacht.com
sammy.port=80
sammy.path=/sammy/web/vicinity
sammy.user=vicinity
sammy.pass=Hx6rsham
sammy.marinaId=1
```

The specified username and password has been enabled by the vendor of SaMMY platform in order to enable 
access and integration with VICINITY Adapter.

VICINITY Adapter for SaMMY is developed in Java 8 and uses Spring Boot Framework 1.5.x, thus it can be 
installed via:

```
mvn install
```


**Stay tuned!**