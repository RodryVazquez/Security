# Crear aplicacion que implemente el BackupAgent de Android

En esta practica vamos a crear una aplicación que implemente el BackupAgent de Android el cual es muy util para guardar informacion que despues necesitamos recuperar ya sea en caso de desinstalar la app o hacer un reset de fabrica.

Android nos provee dos clases Helper para llevar a cabo la tarea:

1. SharedPreferencesBackupHelper (en forma de preferencias)
2. FileBackupHelper (en forma de archivo)

Cuando utilizarlo:

1. Guardar preferencias del usuario
2. Guardar Scores en juegos
3. Antes de aplicar un reset a fabrica en el dispositivo

[Documentación Android Developers](https://developer.android.com/guide/topics/data/testingbackup.html#HowBackupWorks)
