#Proyecto: Civica Web RQ261-1
#Elaborado por: Luz Yulieth Osorio Tafur - Sofka
#Email: yulieth.osorio@sofka.com.co
# language: es

@RQ261_1-24600
Característica: Registro de transacciones recarga con archivo excel
  Yo como usuario de civica web
  Quiero cargar en el formulario de Registro transaccion Recarga, un archivo excel con lote de transacciones de recarga por concepto de diferencias encontradas en el proceso de conciliación de la red externa de recargas,
  Para poder insertar dichas transacciones en la tabla reporte de auditoria.


  @23520
  Escenario: Registro de transacciones recarga con archivo excel vacio
    Dado que se tiene un archivo excel vacio
    Cuando se carga el archivo excel vacio en el formulario Registro de transacciones recarga
    Entonces en pantalla se visualiza un pop-up con el mensaje de error indicando que el archivo esta vacio

  @23521
  Escenario: Registro de transacciones recarga con archivo excel, con solo la fila de titulos en el orden correcto
    Dado que se tiene el archivo excel insumo con solo la fila con los titulos en el orden correcto (CAR_ID, SESION, VALOR RECARGA, SALDO ANTERIOR, FECHA RECARGA, HORA RECARGA)
    Cuando se carga el archivo excel con solo la fila de titulos en el orden correcto, en el formulario Registro de transacciones recarga
    Entonces en pantalla se visualiza un pop-up con el mensaje de error indicando que el archivo no contiene ningún registro

  @23522
  Escenario: Registro de transacciones recarga con archivo excel, con los titulos de las columnas en el orden incorrecto
    Dado que se tiene el archivo excel insumo en la fila de los titulos, los nombres  en el orden no definido
    Cuando se carga el archivo excel con los titulos de las columnas en el orden incorrecto, en el formulario Registro de transacciones recarga
    Entonces en pantalla se visualiza un pop-up con el mensaje de error indicando que el orden de las columnas es incorrecto

  @24473
  Escenario: Registro de transacciones recarga con archivo excel, con solo la fila con datos, sin fila de titulos
    Dado que se tiene el archivo excel insumo esta sin la fila de los titulos, solo con datos
    Cuando se carga el archivo excel con solo la fila con datos, sin fila de titulos, en el formulario Registro de transacciones recarga
    Entonces en pantalla se visualiza un pop-up con el mensaje de error indicando que el archivo seleccionado tiene una estructura invalida


  @24474
  Escenario: Registro de transacciones recarga con archivo excel, con mas de las columnas definidas
    Dado que se tiene el archivo excel insumo con mas de las columnas definidas, pero con los datos correctos en las columnas CAR_ID, SESION, VALOR RECARGA, SALDO ANTERIOR, FECHA RECARGA, HORA RECARGA
    Cuando se carga el archivo excel con mas de las columnas definidas, en el formulario Registro de transacciones recarga
    Entonces el sistema  muestra en pantalla un grid solo con las siguientes columnas: #, CAR_ID, SESION, VALOR RECARGA, SALDO ANTERIOR, FECHA RECARGA, HORA RECARGA, ESTADO, OBSERVACIÓN, con la información correspondiente
    Y se puede generar un archivo excel Reporte con la informacion contenida en el grid que se ve en pantalla, sin incluir las columnas adicionales contenidas en el archivo excel cargado
    Y se hace la insercion de manera exitosa
    Y se insertan los registros en tablas de auditoria


  @23524
  Escenario: Registro de transacciones recarga con archivo excel, con uno o mas registros con el CAR_ID que no existe en base de datos
    Dado que se tiene el archivo excel insumo con uno o mas registros con todos los datos correctos, solo con CAR_ID que no exista en la BD
    Cuando se carga el archivo excel con uno o mas registros con el CAR_ID que no existe en base de datos, en el formulario Registro de transacciones recarga
    Entonces en el campo ESTADO para los registros con el CAR_ID no existente en la BD debe estar con el texto: Error y en el campo OBSERVACION debe decir: CAR_ID no encontrado
    Y se genera un archivo excel Reporte con la informacion contenida en el grid que se ve en pantalla


  @23527
  Escenario: Registro de transacciones recarga con archivo excel, con uno o mas registros con SESION que no existe en base de datos
    Dado que se tiene el archivo excel insumo con uno o mas registros con todos los datos correctos, solo con SESION que no exista en la BD
    Cuando se carga el archivo excel con uno o mas registros con SESION que no existe en base de datos, en el formulario Registro de transacciones recarga
    Entonces en el campo ESTADO para los registros con el SESION no existente en la BD debe estar con el texto: Error y en el campo OBSERVACION debe decir: SESION no encontrada
    Y se genera un archivo excel Reporte con el contenido en el grid que se ve en pantalla


  @25673
  Escenario: Registro de transacciones recarga con archivo excel, con uno o mas registros que en dos o mas columnas vacias o con caracteres invalidos
    Dado que se tiene el archivo excel insumo con uno o mas registros con dos o mas columnas vacias o con caracteres invalidos
    Cuando se carga el archivo excel con uno o mas registros que en dos o mas columnas vacias o con caracteres invalidos, en el formulario Registro de transacciones recarga
    Entonces en el campo ESTADO para los registros con columnas vacias o con caracteres invalidos debe estar con Error
    Y se genera un archivo excel Reporte con la informacion contenida en el gridView que se ve en pantalla


  @23529
  Escenario: Registro de transacciones recarga con archivo excel, con registros que con Fecha, Hora, Valor de recarga, Sesión y Tipo de movimiento no exista una transacción en estado Activa.
    Dado que se tiene el archivo excel insumo con uno o mas registros con Fecha, Hora, Valor de recarga, Sesión y Tipo de movimiento no exista una transacción en estado Activa.
    Cuando se carga el archivo excel con registros que con Fecha, Hora, Valor de recarga, Sesión y Tipo de movimiento no exista una transacción en estado Activa, en el formulario Registro de transacciones recarga
    Entonces en el campo ESTADO para los registros con el HORA_RECARGA con caracteres no validos debe estar con el texto: Error y en OBSERVACION debe decir: Transacción activa para el registro
    Y se genera un archivo excel con la informacion contenida en el grid que se ve en pantalla


  @24470
  Escenario: Registro de transacciones recarga con archivo excel, ingresando en el campo Observación un texto con mas de doscientos cincuenta y cuatro  caracteres
    Dado que se tiene un archivo excel insumo con registros exitosos
    Cuando se ingresa en el campo OBSERVACION un texto de mas de doscientos cincuenta y cuatro  caracteres
    Entonces  se genera archivo excel Reporte con la informacion cargada al inicio
    Y campo observacion solo tiene 254 caracteres, se habilita el Boton Aprobar Insercion, haciendo exitosa la insercion


  @24471
  Escenario: Registro de transacciones recarga con archivo excel insumo exitoso, ingresando en el campo Observación texto con menos de doscientos cincuenta y cuatro  caracteres
    Dado que se tiene un archivo excel exitoso
    Cuando se ingresa en el campo OBSERVACION un texto con menos de doscientos cincuenta y cuatro  caracteres
    Entonces se habilita el Boton Aprobar Inserción, haciendo exitosa la insercion, campo observacion texto con menos de doscientos cincuenta y cuatro  caracteres

  @25781
  Escenario: Registro de transacciones recarga con archivo excel, sin ingresar texto en el campo Observacion
    Dado que se tiene un archivo excel de carga exitoso
    Cuando no se ingresa en el campo OBSERVACION ningun caracter
    Entonces se habilita el Boton Aprobar Inserción, haciendo exitosa la insercion sin ingresar texto en el campo Observacion

  @23542
  Escenario: Registro de transacciones recarga con archivo excel insumo exitoso, sin seleccionar checkbox confirmacion de insercion
    Dado que se tiene un archivo excel de transacciones recarga exitoso
    Cuando no se selecciona el checkbox de confirmacion de Insercion
    Entonces no se habilita el boton de Aprobar insercion


  @23541
  Escenario:   Registro de transacciones recarga con archivo excel exitoso
    Dado que se tiene un archivo excel insumo con diez mil registros exitosos
    Cuando se selecciona el checkbox de confirmacion de Insercion
    Entonces se habilita el boton de Aprobar insercion
    Y se hace la insercion en las tablas de BD para auditoria

