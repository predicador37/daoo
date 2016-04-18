# Primera parte

## ¿Es útil aplicar el Modelo Vista Controlador en esta	situación? Razone la respuesta.

Sí. El patrón arquitectónico MVC divide una aplicación interactiva como la planteada en tres componentes:

- El modelo, que contiene la funcionalidad principal y los datos.
- Las vistas, que presentan la información al usuario.
- Los controladores, que gestionan la entrada del usuario.

Esta separación permite tener múltiples vistas del mismo modelo que, sincronizadas convenientemente, reflejan cualquier cambio producido en cualquiera de ellas.

La aplicación TPV a desarrollar está compuesta de distintos módulos (gestión de inventario, de ventas, de facturación y clientes) que requieren de distintas vistas (presentaciones de la información) e interacciones sobre los mismos datos, lo que hace apropiado el uso de MVC. Además, una aplicación diseñada con esta arquitectura permite cambiar su interfaz (por otra web, por ejemplo) de forma sencilla, lo que es una ventaja de cara a una posible evolución.

## Haga	un pequeño esquema donde se pueda ver claramente de que	tareas	específicas es responsable cada	componente del MVC.	

### Modelo
- Proporciona encapsulamiento de datos y funcionalidad principal de la aplicación.
- Registra las vistas y controladores dependientes.
- Notifica cambios en los datos a los componentes dependientes.
### Vista
- Crea e inicializa su controlador asociado.
- Muestra información al usuario.
- Implementa el proceso de actualización de dicha información.
- Recupera datos del modelo.
### Controlador
- Acepta la entrada del usuario en forma de eventos.
- Traduce los eventos a llamadas de servicio para el modelo o peticiones de visualización a la vista.
- Implementa el procedimiento de actualización de información, en caso de ser necesario.

##¿Será necesario implementar un patrón Observer para recoger los	eventos	producidos en la interfaz? Razone la respuesta.	

Si el usuario realiza cambios en el modelo a través del controlador de una vista determinada, el resto de vistas dependientes de dichos datos debería reflejar los cambios. El modelo, por tanto, ha de notificar a todas las vistas de dichos cambios. Las vistas, por su parte, deben recuperar las modificaciones del modelo y actualizar la información mostrada. Este mecanismo de propagación de cambios es el llamado publicador/suscriptor o patrón Observer.

Este mecanismo de propagación de cambios mantiene un registro de los componentes dependientes del modelo. Todas las vistas y los controladores necesarios registran su necesidad de ser informados de cualquier cambio. Un cambio en el modelo dispara el mecanismo de propagación, que se convierte en el único enlace entre el modelo y las vistas y los controladores.

Sí es necesario implementar el patrón Observer, puesto que se trata de un mecanismo que permite propagar los cambios del modelo a las vistas en el patrón MVC.


4- Realice un diagrama de clases inicial donde modele los distintos actores de la aplicación, lo que definiría el modelo, e identifique propiedades compartidas entre estos.

# Segunda parte

## ¿Resulta adecuado aplicar Abstract Factory para modelar la incorporación de nuevos productos? Razone su respuesta.

Dada la necesidad de ampliación del inventario del TPV con nuevos productos, es posible afirmar que el patrón *abstract factory* puede ser adecuado si se implementa **utilizando un parámetro en su método de creación** (identificador de clase, entero, cadena, etc.), de manera que dicho parámetro especifique el tipo de objeto a ser creado.

Sin este parámetro, *abstract factory* no facilitaría la extensión del inventario con nuevos productos, ya que la interfaz *AbstractFactory* fija el conjunto de productos que se pueden crear. Permitir nuevos tipos de productos requeriría ampliar la interfaz de la fábrica, lo que a su vez implicaría cambiar la clase *AbstractFactory* y todas sus subclases.

No obstante, aún quedaría un problema subyacente: todos los productos se devolverían al cliente con la misma interfaz abstracta que el tipo de retorno. Es decir, el cliente no podría distinguir o hacer suposiciones seguras sobre la clase de un producto (sí se podría hacer *downcast*, aunque la conversión de tipos podría fallar).

