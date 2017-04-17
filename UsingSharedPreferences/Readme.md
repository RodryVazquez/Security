# Mecanismos de almacenamiento en Android
# Shared Preferences

Android nos proporciona varios mecanismos de almacenamiento uno de ellos son las preferencias, las podemos implementar en una vista de configuracion en la que se espera que el usuario defina una configuracion predeterminada (se puede implementar una subclase de PreferenceActivity) o automaticamente mientras el usuario interactua con el ciclo de vida de la aplicacion en cuestion.

Android nos proporciona una clase SharedPreferences en la que podremos guardar informacion estructurada en tipo llave-valor y solo tipos primitivos:

1. int
2. long
3. Boolean
4. float
5. String

Toda la informacion guardada con preferencias se agregara en un fichero XML dentro del directorio de datos de la aplicacion. Este mecanismo es muy utilizado ya que persiste aun cuando la aplicacion se cierra por cualquier razon y solo es removido al desinstalar la aplicacion.

Cualquier componente puede acceder al objeto SharedPreferences.

## Manejo de las preferencias

Android nos proporciona dos maneras de manejar las preferecias

1. getSharedPreferences()
2. getPreferences()

Utilizaremos getSharedPreferences() cuando necesitemos multiples archivos de preferencias identificados por un nombre que sera el identificador unico, por otro lado utilizaremos getPreferences() cuando necesitemos solo un archivo de preferecias el cual pertenece a la actividad en la que es usado y no es necesario especificar un nombre.

En cualquiera de los dos anteriores es necesario especificar el modo, que no es mas que decirle a Android si las preferencias seran solo para la aplicacion que las esta administrando o si se seran visibles para otras aplicaciones, igualmente Android nos proporciona 3 modos por defecto:

1. MODE_PRIVATE
2. MODE_WORLD_READABLE
3. MODE_WORLD_WRITABLE

Utilizaremos MODE_PRIVATE si las preferencias seran privadas para la aplicacion que las esta administrando, otras aplicaciones pueden escribir y leer los archivos si se asigna MODE_WORLD_READABLE o MODE_WORLD_WRITABLE respectivamente.

Leyendo preferencias de otra aplicacion:
```java

//Referenciamos el contexto de la app de la cual queremos leer las preferencias
Context mContext = getApplicationContext().createPackageContext("package name",Context.MODE_WORLD_READABLE);

SharedPreferences preferences = mContext.getSharedPreferences("MyPref",Context.MODE_WORLD_READABLE);
String value = preference.getString("MyString","");

```

Nota
MODE_WORLD_READABLE y MODE_WORLD_WRITABLE se encuentran obsoletos desde API nivel 17 ya que se consideran inseguros porque proporcionaban huecos de seguridad.

[Android Developers Doc](https://developer.android.com/training/basics/data-storage/shared-preferences.html#GetSharedPreferences)







