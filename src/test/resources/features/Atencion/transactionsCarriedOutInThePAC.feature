#Proyecto: Civica Web RQ261-2
#Elaborado por: Luz Yulieth Osorio Tafur - Sofka
#Email: yulieth.osorio@sofka.com.co
#language: es

Característica: Consultar las Transacciones realizadas en el PAC
  Yo como operador de civica web
  Quiero consultar las transacciones realizadas en el PAC
  Para generar el reporte y visualizar cuales se han actualizados por personalizacion por civica web y cuales por CRM externo

  @29430
  Escenario: Consulta Transacciones realizadas en el PAC, ingresando solo la fecha y sin operador
    Dado que se ingresa al formulario de consulta Transacciones realizadas en el PAC
    Cuando se selecciona únicamente la información en los campos fecha y se pulsa el botón generar reporte
    Entonces se realiza la descarga del archivo Reporte en Excel


  @29432
  Escenario: Consultar seleccionando varias opciones los campos multiselect
    Dado que se ingresa al formulario de consulta Transacciones realizadas en el PAC
    Cuando se seleccionan en los campos multiselect varias opciones y se pulsa el botón generar reporte
    Entonces se realiza la descarga del archivo Reporte en Excel


  @29435
  Escenario: Consultar selccionando una opción en los campos multiselect
    Dado que se ingresa al formulario de consulta Transacciones realizadas en el PAC
    Cuando se seleccionan en los campos multiselect una opción y se pulsa el botón generar reporte
    Entonces se realiza la descarga del archivo Reporte en Excel


  @30112
  Escenario: Consultar sin seleccion tipo de transaccion ni PAC
    Dado que se ingresa al formulario de consulta Transacciones realizadas en el PAC
    Cuando no seleccionan en los campos multiselect ninguna de las opciones en los campos Tipo transaccion y PAC y se pulsa el botón generar reporte
    Entonces se realiza la descarga del archivo Reporte en Excel


  @29436
  Escenario: Validar la búsqueda dinamica del operador y todos los campos opciones tipo transaccion 6 y 7
    Dado que se ingresa al formulario de consulta Transacciones realizadas en el PAC
    Cuando se realiza la consulta por el campo operador dicha consulta se haga de manera dinámica y se pulsa el botón generar reporte
    Entonces se realiza la descarga del archivo Reporte en Excel

  @33416
  Escenario: Validar al ingresar los valores en la formulario que no existan registros en BD, el sistema no genere el archivo excel
    Dado que se ingresa al formulario de consulta Transacciones realizadas en el PAC
    Cuando se realiza la consulta ingresando todos los datos validos en el formulario, pero no existen registros en BD
    Entonces No se realiza la descarga del archivo Reporte en Excel