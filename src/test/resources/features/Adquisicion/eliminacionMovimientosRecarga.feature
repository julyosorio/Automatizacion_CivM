#Proyecto: Civica Web RQ261-1
#Elaborado por: Luz Yulieth Osorio Tafur - Sofka
#Email: yulieth.osorio@sofka.com.co
# language: es

@RQ261_1-24614
Característica: Eliminacion de movimientos de recarga con archivo excel
  Yo como usuario de civica web
  Quiero cargar en el formulario de Registro transaccion Recarga, un archivo excel con uno o varios registros con MOS_ID,
  Para realizar el proceso de borrado movimientos de recarga


  @23545
  Escenario: Eliminacion de movimientos recarga con archivo excel vacio
    Dado que se tiene un archivo excel para eliminacion vacio
    Cuando se carga el archivo excel vacio en el formulario de eliminacion de movimientos
    Entonces en pantalla se visualiza un pop-up con el mensaje de error de archivo vacio

  @23546
  Escenario: Eliminacion de movimientos recarga con archivo excel, con solo la fila del titulo
    Dado que se tiene el archivo excel insumo con solo la fila con el titulo
    Cuando se carga el archivo excel solo con los titulos, en el formulario de Eliminacion de movimientos
    Entonces se observa en pantalla un pop-up con el mensaje de error sin registros

  @23548
  Escenario: Eliminacion de movimientos recarga con archivo excel, con uno o mas registros con el MOS_ID que no existe en base de datos
    Dado que se tiene el archivo excel insumo con uno o mas registros con MOS_ID que no exista en la BD
    Cuando se carga el archivo excel con uno o mas registros con el MOS_ID que no existe en base de datos, en el formulario Eliminacion de transacciones recarga
    Entonces el sistema  muestra en pantalla la informacion cargada
    Y en el campo ESTADO para los registros con el MOS_ID no existente en la BD debe estar con el texto: Error y en el campo OBSERVACION debe decir: MOS_ID no encontrado
    Y se crea y descarga un archivo excel Reporte con la informacion cargada en el excel inicial


  @24475
  Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, ingresando en el campo Observación texto con menos de doscientos cincuenta y cuatro  caracteres
    Dado que se tiene un archivo excel insumo para el borrado, exitoso
    Cuando se ingresa en el campo OBSERVACION un texto con menos doscientos cincuenta y cuatro  caracteres
    Entonces se realiza el borrado exitoso
    Y se actualiza las tablas de auditoria con las registros cargados en el excel inicial


  @24476
  Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, ingresando en el campo Observación texto con mas de doscientos cincuenta y cuatro  caracteres
    Dado que se tiene un archivo excel insumo para el borrado de registros
    Cuando se ingresa en el campo OBSERVACION un texto de mas doscientos cincuenta y cuatro  caracteres
    Entonces en el campo Observacion solo permite doscientos cincuenta y cuatro  caracteres
    Y se hace el borrado exitoso
    Y al consultar la tabla auditoria en el campo ARE_OBSERVACION se observa texto doscientos cincuenta y cuatro  caracteres

  @24477
  Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, ingresando en el campo Observación texto con doscientos cincuenta y cuatro  caracteres
    Dado que se tiene un archivo excel insumo para el borrado
    Cuando se ingresa en el campo OBSERVACION un texto de doscientos cincuenta y cuatro  caracteres
    Entonces se hace el borrado exitoso
    Y al consultar la tabla auditoria_recarga_externa en el campo ARE_OBSERVACION se observa texto doscientos cincuenta y cuatro  caracteres

  @24478
  Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, sin ingresar texto en el campo Observación
    Dado que se tiene un archivo excel para el borrado
    Cuando no se ingresa texto en el campo OBSERVACION
    Entonces se hace el borrado exitoso de los registros ingresados
    Y al consultar la tabla auditoria_recarga_externa en el campo ARE_OBSERVACION se observa vacio

  @23550
  Escenario: Eliminacion de movimientos recarga con archivo excel exitoso, Aprobar borrado sin seleccionar casilla de confirmación de borrado
    Dado que se tiene un archivo excel exitoso de borrado
    Cuando se pulsa el boton Aprobar borrado sin seleccionar casilla de confirmación de borrado
    Entonces no se hace el borrado exitoso


