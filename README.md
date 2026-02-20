# HeyGatewayBySpring
HeyGatewayBySpring : a Hey's SpringBoot Gateway for integrating local APIs which binds that APIs : User, Movie, Payment and Artist.

https://github.com/dev-houssam/MovieAPI

https://github.com/dev-houssam/HeyGatewayBySpring

https://github.com/dev-houssam/FrontendAPIGestionReservationsFilm

https://github.com/dev-houssam/PaymentAPI

# PORTS (uniquement dédiés au HEY)

Plage de port (HEY) en production(/developpement) : 

12100 - 12119

Répartition par API : 
- GatewayAPI : 12100 -> host : http://localhost:12100
- MovieAPI : 12101   -> host : http://localhost:12101
- Paymentapi : 12102    -> host : http://localhost:12102
- ArtistAPI : 12103  -> host : http://localhost:12103
- UserAPI : 121104   -> host : http://localhost:12104
- Frontend : 12105   -> host : http://localhost:12105


Note : Pour Frontend, possible reverse proxy vers 80.

