# Modelo_Eventos02
Ejemplo de implementación del modelo de eventos en Java en creación de componentes.
Este es un proyecto hecho en Netbeans y Java de cómo se implementa el modelo de eventos en la creación de un compomnente.

El componente (C_Provincias) está implementado con un JLabel y un ComboBox sobre un JPanel.
El desencadenate del evento está implementado con un ActionListener de forma que, cuando se hace clic o pulsa una tecla sobre el ComboBox, se desencadena el evento.

El EventObject (EO_Pronvincias) contiene almacena: nombre de la provincia, código de la provincia, código del ministerio del interior de la provincia y la posición que ocupa esta información en la matriz.

La interfaz (IF_Provincias) contiene un solo método, llamado Ejecuta.


Se han creado dos Listeners (LI_Provincias01 y LI_Provincias02) que muestran mensaje por consola. Estos Listeners implementan la interfaz IF_Provincias.

En el JFrame Principal es en dónde se ha creado y añadido el componente (C_Provincias) y se han creado y añadido los dos Listeners.
