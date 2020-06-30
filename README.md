![](https://dev.lutece.paris.fr/jenkins/buildStatus/icon?job=franceconnect-module-oauth2-franceconnect-deploy)
[![Alerte](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Amodule-oauth2-franceconnect&metric=alert_status)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Amodule-oauth2-franceconnect)
[![Line of code](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Amodule-oauth2-franceconnect&metric=ncloc)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Amodule-oauth2-franceconnect)
[![Coverage](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Amodule-oauth2-franceconnect&metric=coverage)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Amodule-oauth2-franceconnect)


# Module Oauth2 FranceConnect

![](https://dev.lutece.paris.fr/plugins/module-oauth2-franceconnect/images/franceconnect.png)

## Introduction

Ce module oauth2 FranceConnect permet d'acceder à des ressources via la plate-forme [FranceConnect](http://www.dev-franceconnect.fr) . Grâce à l'authentification par le biais d'un fournisseur d'identités de laplate-forme FranceConnect, un fournisseur de service peut ensuite accéder à des ressources liées à l'utilisateur (et avec son consentement).L'accès à ces ressources se fait via le protocole [OpenID Connect](http://openid.net/specs/openid-connect-core-1_0.html) .

Ce module oauth2 FranceConnect propose aux fournisseurs de service une API Java **DataClient** qui permet de créer des services d'accès aux données. Pour plus d'informations surl'utilisation de cette API, reportez-vous à la documentation du [Wiki](wiki.lutece.paris.fr) .

Ce module oath2 FranceConnect est également utilisé par le Module d'authentification [MyLutece FranceConnect](https://github.com/lutece-platform/lutece-auth-module-mylutece-franceconnect) qui permet de faire une authentification Lutece basée sur lesfournisseurs d'identités de FranceConnect.

# Installation

## Configuration

Configurer le fichier de context du plugin (WEB-INF/conf/plugins/oauth2-franceconnect_context.xml).

Il faut notamment paramétrer :
 
* Les adresses des WebServices la plate-forme FranceConnect (end points)
* Vos identifiants (id, secret) qui vous auront été fournit par FranceConnect
* L'adresse du Callback du plugin (NB : Cette adresse doit être enregistrée et associée à votre ID Client auprès FranceConnect.Tout changement de serveur doit faire l'objet d'un nouvel enregistrement)
doit ensuite être paramétré avec les informationsdu service client (id, secret et callback) :


```
           
     
       <bean id="oauth2-franceconnect.server" class="fr.paris.lutece.plugins.oauth2.business.AuthServerConf" >
         <property name="issuer" value="http://fcp.integ01.dev-franceconnect.fr"/ >
         <property name="authorizationEndpointUri" value="https://fcp.integ01.dev-franceconnect.fr/api/v1/authorize"/ >
         <property name="tokenEndpointUri" value="https://fcp.integ01.dev-franceconnect.fr/api/v1/token"/ >
         <property name="logoutEndpointUri" value="https://fcp.integ01.dev-franceconnect.fr/api/v1/logout"/ >
     </bean > 
    
     <bean id="oauth2-franceconnect.client" class="fr.paris.lutece.plugins.oauth2.business.AuthClientConf" >
         <property name="clientId" value="**** à renseigner **** "/ >
         <property name="clientSecret" value="**** à renseigner **** "/ >
         <property name="redirectUri" value="**** à renseigner **** "/ >
     </bean >       
    
    
       <bean id="oauth2-franceconnect.callbackHandler" class="fr.paris.lutece.plugins.oauth2.web.CallbackHandler"  >
         <property name="handlerName" value="franceConnectHandler"/ >
         <property name="authServerConf" ref="oauth2-franceconnect.server"/ >
         <property name="authClientConf" ref="oauth2-franceconnect.client"/ >
         <property name="jWTParser" ref="oauth2.jwtParser"/ >
     </bean > 
    
     
    
     <bean id="oauth2-franceconnect.userInfoClient" class="fr.paris.lutece.plugins.oauth2.modules.franceconnect.dataclient.UserInfoDataClient" >
         <property name="name" value="userinfo" / >
         <property name="dataServerUri" value="https://fcp.integ01.dev-franceconnect.fr/api/v1/userinfo"/ >
         <property name="tokenMethod" value="HEADER"/ >
         <property name="scope" >
             <set value-type="java.lang.String" >
                 <value >openid </value >
                 <value >profile </value >
                 <value >email </value >
                 <value >address </value >
                 <value >phone </value >
             </set >
         </property >
         <!-- Optional eIDAS management -- >
         <!--
         <property name="acrValuesSet" >
             <set value-type="java.lang.String" >
                 <value >eidas2 </value >
             </set >
         </property >
        -- >
     </bean >

 </beans >


```


## Dépannage


 
* L'activation des logs en mode debug se fait en ajoutant la ligne suivante dans le fichier `WEB-INF/conf/config.properties` dans la rubrique LOGGERS :

```

	log4j.logger.lutece.oauth2=DEBUG, Console

```





[Maven documentation and reports](https://dev.lutece.paris.fr/plugins/module-oauth2-franceconnect/)



 *generated by [xdoc2md](https://github.com/lutece-platform/tools-maven-xdoc2md-plugin) - do not edit directly.*
