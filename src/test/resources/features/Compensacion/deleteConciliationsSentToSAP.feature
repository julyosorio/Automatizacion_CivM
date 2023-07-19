#Proyecto: Civica Web RQ261-2
#Elaborado por: Luz Yulieth Osorio Tafur - Sofka
#Email: yulieth.osorio@sofka.com.co
#language: es

Característica: Eliminar Conciliaciones Enviadas a SAP
  Yo como operador de civica web
  Quiero Consultar las conciliaciones enviadas a SAP
  Para eliminar la conciliacion seleccionada


  @29440
  Escenario:Consulta ingresando fecha inicial y fecha final, ademas de seleccionar un item de la lista desplegable en los campos Tipo certificacion, estado y tipo envio del formulario
    Dado que se ingresa al formulario Eliminar Conciliaciones Enviadas a SAP
    Cuando selecciona la fecha inicial, fecha final y un item en las listas desplegables de Tipo certificacion, estado y tipo envio, se pulsa el boton buscar
    Entonces en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, el Tipo certificacion, estado y tipo envio seleccionado e ingresados en el formulario
    Y al pulsar la accion eliminar en alguno de uno de los registros del grid, se debera mostrar una ventana que permita ingresar una observacion
    Y al pulsar el boton de confirmar, se debe eliminar y actualizar el registro en la BD


  @29442
  Escenario:Consulta ingresando fecha inicial y fecha final, ademas de seleccionar varios items de la lista desplegable en los campos Tipo certificacion, estado y tipo envio del formulario
    Dado que se ingresa al formulario Eliminar Conciliaciones Enviadas a SAP
    Cuando selecciona la información en los campos fecha y varios items en las listas desplegables de Tipo certificacion, estado y tipo envio, se pulsa el botón buscar
    Entonces en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, los Tipo certificacion, los estados y tipos envios seleccionados e ingresados en el formulario
    Y al pulsar la accion eliminar en alguno de uno de los registros del grid, se debera mostrar una ventana que permita ingresar una observacion
    Y al pulsar el boton de confirmar, se debe eliminar y actualizar el registro en la BD

  @30844
  Escenario:Consulta ingresando fecha inicial y fecha final, ademas de seleccionar el item todos de la lista desplegable en los campos Tipo certificacion, estado y tipo envio del formulario
    Dado que se ingresa al formulario Eliminar Conciliaciones Enviadas a SAP
    Cuando selecciona la informacion en los campos fecha y el item Todos, en las listas desplegables de Tipo certificacion, estado y tipo envio, se pulsa el boton buscar
    Entonces en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, todos los Tipo certificacion, todos los estados y todos los tipos de envios seleccionados e ingresados en el formulario
    Y al pulsar la accion eliminar en alguno de uno de los registros del grid, se debera mostrar una ventana que permita ingresar una observacion
    Y al pulsar el boton de confirmar, se debe eliminar y actualizar el registro en la BD


  @30845
  Escenario: Consulta ingresando Codigo de conciliacion
    Dado que se ingresa al formulario Eliminar Conciliaciones Enviadas a SAP
    Cuando se ingresa informacion valida en los campos: Fecha inicial, Fecha final, Tipo certificacion, Tipo de envio, Estado y Codigo Conciliacion, luego pulsar el botón buscar
    Entonces en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, el codigo de conciliacion, todos los Tipo certificacion, todos los estados y todos los tipos de envios seleccionados e ingresados en el formulario
    Y al pulsar la accion eliminar en alguno de uno de los registros del grid, se debera mostrar una ventana que permita ingresar una observacion
    Y al pulsar el boton de confirmar, se debe eliminar y actualizar el registro en la BD

  @30846
  Escenario: Consulta ingresando en informacion en el campo Referencia
    Dado que se ingresa al formulario Eliminar Conciliaciones Enviadas a SAP
    Cuando se ingresa informacion valida en los campos: Fecha inicial, Fecha final, Tipo certificacion, Tipo de envio, Estado y Referencia, luego pulsar el boton buscar
    Entonces en la pantalla se visualiza un grid la informacion correspondiente a la fecha inicial y fecha final, el numero de referencia, todos los Tipo certificacion, todos los estados y todos los tipos de envios seleccionados e ingresados en el formulario
    Y al pulsar la accion eliminar en alguno de uno de los registros del grid, se debera mostrar una ventana que permita ingresar una observacion
    Y al pulsar el boton de confirmar, se debe eliminar y actualizar el registro en la BD

  @29443
  Escenario: Consultar Historico de conciliaciones eliminadas ingresando fechas
    Dado que se ingresa al formulario Historico de Conciliaciones Eliminadas
    Cuando selecciona unicamente la informacion en los campos fecha y pulso el boton buscar
    Entonces en la pantalla se visualiza un grid con el resultado de la busqueda al pulsar el boton generar reporte se debera generar y descarga el archivo excel con la informacion encontrada en el grid

