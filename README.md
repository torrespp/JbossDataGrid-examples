JBoss Data Grid Example
=======================


There are 2 modes that we can use DG:
* Library Mode
* Server Mode
```
Library mode
```
1. Download or clone the repository in your desktop
2. Put the correct software in the installs directory
3. Start: init.sh
4. Export your project into a maven project and run as a Java Application
5. Add the maven library or install ``jboss-datagrid-x.x.x-maven-repository`` in ypu local repository
6. Run the application as a Java application

```
Server Mode
```
1. Download or clone the repository in your desktop
2. Put the correct software in the installs directory
3. Start: init.sh
4. When the script is over, try to run the target file shown in he terminal to start the server   
  (example: ./target/jboss-datagrid-*-server/bin/standalone.sh -Djboss.socket.binding.port-offset=100)
5. In a new terminal, run : sh cli.sh -c remoting://localhost:10099 
6. when you see: 
  [standalone@localhost:10099 cache-container=local]=
  type: ``cache default``; in order to go to the default cache report
7. check with: ``stats`` everitime you run the program
8. Export your project into a maven project and run as a Java Application
9. See the results in your log ++ 7. ++
10. To exit the cache type: ``exit``
11. Close the server node to exit JDG 


[Git Hub Repo](https://github.com/torrespp/JbossDataGrid-examples)
