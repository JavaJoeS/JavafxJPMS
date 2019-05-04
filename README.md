# MagicalModuleMan
Example of a simple JDK 11 Maven Build using JPMS with JavaFX, Greetings Program

REQUIREMENTS:

UNIX:  any flavor.  ( Windowz implementation TBD )

 OpenJDK 11

 OpenJFX JMod files available.

BUILD:

Invoke maven the first time will load your local repo with both
the latest Jmod and Jlink plugins.

Invoke maven on a second time will subsequently build the javaFX 
with Java openjdk 11 to modules.

RUN:

Upon a successful build;
 1.  cd finalruntime/target/maven-jlink directory
 2.  ./bin/run
